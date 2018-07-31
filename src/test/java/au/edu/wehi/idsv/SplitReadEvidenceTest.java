package au.edu.wehi.idsv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import au.edu.wehi.idsv.picard.InMemoryReferenceSequenceFile;
import au.edu.wehi.idsv.picard.SynchronousReferenceLookupAdapter;
import au.edu.wehi.idsv.sam.ChimericAlignment;
import au.edu.wehi.idsv.sam.SAMRecordUtil;
import au.edu.wehi.idsv.sam.SamTags;
import htsjdk.samtools.SAMFileHeader;
import htsjdk.samtools.SAMRecord;
import htsjdk.samtools.metrics.Header;
import htsjdk.samtools.reference.IndexedFastaSequenceFile;


public class SplitReadEvidenceTest extends TestHelper {
	@Test
	public void should_use_SA_tag_for_split_read() {
		SAMRecord r = Read(2, 1, "3S2M5S");
		//                    rrXmm-----
		r.setReadBases(    B("ACCTAGAGGG"));
		r.setBaseQualities(B("1234567890"));
		r.setMappingQuality(40);
		r.setAttribute("SA", "polyA,100,+,2M8S,10,0");
		SplitReadEvidence e = SplitReadEvidence.create(SES(), r).get(0);
		assertEquals(new BreakpointSummary(2, BWD, 1, 0, FWD, 101), e.getBreakendSummary());
		assertEquals("ACC", S(e.getBreakendSequence()));
		assertEquals("123", S(e.getBreakendQuality()));
		assertEquals("TA", S(e.getAnchorSequence()));
		assertEquals("45", S(e.getAnchorQuality()));
		assertEquals("C", e.getUntemplatedSequence());
		assertEquals(40, e.getLocalMapq());
		assertEquals(10, e.getRemoteMapq());
	}
	@Test
	public void should_return_adjacent_alignments() {
		SAMRecord r = Read(2, 1, "3S2M5S");
		//                    AB-mm-CDDD
		r.setReadBases(    B("ACCTAGAGGG"));
		r.setBaseQualities(B("1234567890"));
		r.setMappingQuality(40);
		r.setAttribute("SA", "polyA,300,+,6S1M3S,30,0;polyA,200,+,1S1M8S,20,0;polyA,400,+,7S3M,40,0;polyA,100,+,1M9S,10,0;");
		//                                C                  B                     D                  A
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(2, list.size());
		assertEquals(new BreakpointSummary(2, BWD, 1, 0, FWD, 200), list.get(0).getBreakendSummary());
		assertEquals("TA", S(list.get(0).getAnchorSequence()));
		assertEquals("ACC", S(list.get(0).getBreakendSequence()));
		assertEquals("C", list.get(0).getUntemplatedSequence());
		assertEquals(new BreakpointSummary(2, FWD, 2, 0, BWD, 300), list.get(1).getBreakendSummary());
		assertEquals("TA", S(list.get(1).getAnchorSequence()));
		assertEquals("GAGGG", S(list.get(1).getBreakendSequence()));
		assertEquals("G", list.get(1).getUntemplatedSequence());
	}
	@Test
	public void should_handle_negative_strand_remote() {
		SAMRecord r = Read(2, 1, "3S2M5S");
		//                    -BBmm-CC--
		r.setReadBases(    B("ACCNAGAGGG"));
		r.setBaseQualities(B("1234567890"));
		r.setMappingQuality(40);
		r.setAttribute("SA", "polyA,100,-,7S2M1S,0,0;polyA,200,-,2S2M6S,0,0");
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(new BreakpointSummary(2, BWD, 1, 0, BWD, 100), list.get(0).getBreakendSummary());
		assertEquals("NA", S(list.get(0).getAnchorSequence()));
		assertEquals("ACC", S(list.get(0).getBreakendSequence()));
		assertEquals("", list.get(0).getUntemplatedSequence());
		assertEquals(new BreakpointSummary(2, FWD, 2, 0, FWD, 201), list.get(1).getBreakendSummary());
		assertEquals("NA", S(list.get(1).getAnchorSequence()));
		assertEquals("GAGGG", S(list.get(1).getBreakendSequence()));
		assertEquals("G", list.get(1).getUntemplatedSequence());
	}
	@Test
	public void should_handle_negative_strand_local() {
		SAMRecord r = Read(2, 1, "5S2M3S");
		//                    --CC-mmBB-
		r.setReadBases(    B("ACCTAGAGGG"));
		r.setBaseQualities(B("1234567890"));
		r.setMappingQuality(40);
		r.setReadNegativeStrandFlag(true);
		r.setAttribute("SA", "polyA,100,+,1S2M7S,0,0;polyA,200,+,6S2M2S,0,0");
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(new BreakpointSummary(2, FWD, 2, 0, FWD, 101), list.get(0).getBreakendSummary());
		assertEquals("GA", S(list.get(0).getAnchorSequence()));
		assertEquals("GGG", S(list.get(0).getBreakendSequence()));
		assertEquals("", list.get(0).getUntemplatedSequence());
		assertEquals(new BreakpointSummary(2, BWD, 1, 0, BWD, 200), list.get(1).getBreakendSummary());
		assertEquals("GA", S(list.get(1).getAnchorSequence()));
		assertEquals("ACCTA", S(list.get(1).getBreakendSequence()));
		assertEquals("A", list.get(1).getUntemplatedSequence());
	}
	@Test
	public void should_consider_overlapping_alignments_as_microhomology() {
		SAMRecord r = Read(2, 1, "7M3S");
		// 1234567890
		//  |>   |>
		// MMMMMMMSSS
		// SSMMMMMMMM
		//   ^---^ homology
		//  10
		//   01234567
		//  <|   <|
		//
		r.setReadBases(    B("ACCTAGAGGG"));
		r.setBaseQualities(B("1234567890"));
		r.setMappingQuality(40);
		r.setAttribute("SA", "polyA,100,+,2S8M,0,0");
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(new BreakpointSummary(2, FWD, 7, 2, 7, 0, BWD, 105, 100, 105), list.get(0).getBreakendSummary());
		assertEquals("ACCTAGA", S(list.get(0).getAnchorSequence()));
		assertEquals("GGG", S(list.get(0).getBreakendSequence()));
		assertEquals("", list.get(0).getUntemplatedSequence());
	}
	@Test
	public void should_recognise_XNX_as_unanchored_breakend_interval() {
		// 1
		// 01234567
		// N--NATG
		// |--|     <- sequence expected to be placed somewhere in the N interval
		//      1
		//      0
		// 567890123456
		//     ATG  <- actually was placed
		//     SMM
		//   |--|   <- so we expect the breakpoint somewhere here
		// the soft clipping of A does not push out the expected breakend
		// position at the remote side - it could be soft clipped because
		// that is were the breakend actually is and we just haven't got
		// a good enough anchor in the contig to place it locally
		SAMRecord r = withSequence("NNATG", Read(1, 10, "1X2N1X3S"))[0];
		r.setAttribute("SA", "polyA,100,+,3S2M,0,0");
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(1, list.size());
		SplitReadEvidence e = list.get(0);
		assertFalse(e.isBreakendExact());
		assertEquals(new BreakpointSummary(1, FWD, 12, 10, 13, 0, BWD, 99, 97, 100), e.getBreakendSummary());
		assertEquals("ATG", S(e.getBreakendSequence()));
		assertEquals("", S(e.getAnchorSequence()));
		assertEquals("A", e.getUntemplatedSequence());
	}
	@Test
	public void should_recogise_XNX_on_both_sides() {
		// supp alignment for should_recognise_XNX_as_unanchored_breakend_interval()
		SAMRecord r = withSequence("NNATG", Read(0, 100, "3S2M"))[0];
		r.setAttribute("SA", "polyACGT,10,+,1X2N1X3S,0,0");
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(1, list.size());
		SplitReadEvidence e = list.get(0);
		assertFalse(e.isBreakendExact());
		assertEquals(new BreakpointSummary(0, BWD, 99, 97, 100, 1, FWD, 12, 10, 13), e.getBreakendSummary());
		assertEquals("A", S(e.getBreakendSequence()));
		assertEquals("TG", S(e.getAnchorSequence()));
		assertEquals("A", e.getUntemplatedSequence());
	}
	@Test
	public void should_consider_strand_for_XNX() {
		SAMRecord r = withSequence("NATG", Read(1, 10, "1X3S"))[0];
		r.setAttribute("SA", "polyA,100,-,3M1S,0,0");
		List<SplitReadEvidence> list = SplitReadEvidence.create(SES(), r);
		assertEquals(1, list.size());
		SplitReadEvidence e = list.get(0);
		assertFalse(e.isBreakendExact());
		assertEquals("ATG", S(e.getBreakendSequence()));
		assertEquals("", S(e.getAnchorSequence()));
		assertEquals(new BreakpointSummary(1, FWD, 10, 0, FWD, 102), e.getBreakendSummary());
	}
	@Test
	public void should_return_untemplated_sequence() {
		SAMRecord r = withSequence("ACTG", Read(0, 1, "1M3S"))[0];
		r.setAttribute("SA", "polyA,100,+,2S2M,10,0");
		SplitReadEvidence e = SplitReadEvidence.create(SES(), r).get(0);
		assertEquals("C", e.getUntemplatedSequence());
	}
	@Test
	public void should_return_untemplated_sequence_remote_bwd() {
		SAMRecord r = withSequence("ACTG", Read(0, 1, "1M3S"))[0];
		r.setAttribute("SA", "polyA,100,-,2M2S,10,0");
		SplitReadEvidence e = SplitReadEvidence.create(SES(), r).get(0);
		assertEquals("C", e.getUntemplatedSequence());
	}
	@Test
	public void should_return_remote_unanchored() {
		SAMRecord r = withSequence("ACN", Read(0, 1, "1M1D1M1S"))[0];
		r.setAttribute("SA", "polyA,10,+,2S1X,39,1");
		SplitReadEvidence e = SplitReadEvidence.create(SES(), r).get(0);
		assertNotNull(e);
	}
	@Test
	public void unanchored_should_handle_no_untemplated() {
		BiConsumer<String, String> go = (r1, r2) -> {
			SplitReadEvidence e1 = SplitReadEvidence.create(SES(), withAttr("SA", r1, Read(r2))[0]).get(0);
			SplitReadEvidence e2 = SplitReadEvidence.create(SES(), withAttr("SA", r2, Read(r1))[0]).get(0);
			assertEquals("", e1.getUntemplatedSequence());
			assertEquals("", e1.getUntemplatedSequence());
			assertFalse(e1.isBreakendExact());
			assertFalse(e2.isBreakendExact());
			assertEquals(3, e1.getAnchorSequence().length + e2.getAnchorSequence().length);
			assertEquals(3, e1.getBreakendSequence().length + e2.getBreakendSequence().length);
			assertEquals("", e1.getHomologySequence());
			assertEquals("", e2.getHomologySequence());
			assertEquals(0, e1.getHomologyAnchoredBaseCount());
			assertEquals(0, e2.getHomologyAnchoredBaseCount());
		};
		// fwd
		go.accept("polyA,10,+,3S1X,0,0", "polyA,10,+,3M1S,0,0");
		go.accept("polyA,10,+,3S1X,0,0", "polyA,10,-,1S3M,0,0");
		go.accept("polyA,10,+,3S2X,0,0", "polyA,10,+,3M2S,0,0");
		go.accept("polyA,10,+,3S2X,0,0", "polyA,10,-,2S3M,0,0");
		go.accept("polyA,10,+,1X3S,0,0", "polyA,10,+,1S3M,0,0");
		go.accept("polyA,10,+,1X3S,0,0", "polyA,10,-,3M1S,0,0");
		go.accept("polyA,10,+,2X3S,0,0", "polyA,10,+,2S3M,0,0");
		go.accept("polyA,10,+,2X3S,0,0", "polyA,10,-,3M2S,0,0");
	}
	@Test
	public void should_remove_split_reads_that_fully_align_to_either_side() {
		String refStr = "TAAATTGGAACACTATACCAAAACATTAACCAGCATAGCAGTATATAAGGTTAAACATTAAATAACCCCTGGCTTAACTAACTCTCCAATTGCACTTTCTATAAGTAATTGTTGTTTAGACTTTATTAATTCAGATGTTTCAGACATGTCTTATATACACAAGAGAATTTCATTTCTCTTT";
		String readStr = "AAATTGGAACACTATACCAAAACATTAACCAGCATAGCAGTATATAAGGTTAAACATTAAATAACCCCTGGCTTAACTAACTCTCCAATTGCACTTTCTATAAGTAATTGTTGTTTAGACTTTATTAATTC";
		//               1234567890123456
		//               MMMMMSSSSSSSSSS
		//                sssssMMMMMMMMMM
		InMemoryReferenceSequenceFile ref = new InMemoryReferenceSequenceFile(new String[] { "Contig" }, new byte[][] { B(refStr) });
		SAMRecord r = new SAMRecord(new SAMFileHeader());
		r.getHeader().setSequenceDictionary(ref.getSequenceDictionary());
		r.setReferenceIndex(0);
		r.setCigarString("97M34S");
		r.setAlignmentStart(1);
		r.setReadNegativeStrandFlag(false);
		r.setReadBases(B(readStr));
		r.setBaseQualities(B(refStr));
		SAMRecord r2 = SAMRecordUtil.realign(ref, r, 10, true);
		assertEquals(2, r2.getAlignmentStart());
		assertEquals("131M", r2.getCigarString());
	}
	@Test
	@Category(Hg19Tests.class)
	public void indel_mismapping_false_positive_assembly_should_not_throw_homology_error() throws IOException {
		File ref = Hg19Tests.findHg19Reference();
		IndexedFastaSequenceFile indexed = new IndexedFastaSequenceFile(ref);
		TemporaryFolder folder = new TemporaryFolder();
		folder.create();
		ProcessingContext pc = new ProcessingContext(
				new FileSystemContext(folder.getRoot(), folder.getRoot(), 500000), ref, new SynchronousReferenceLookupAdapter(indexed), new ArrayList<Header>(),
				getConfig());
		//File bam = new File(folder.getRoot(), "input.bam");
		//Files.copy(new File("src/test/resources/indel_mismapping_false_positive_assembly.sv.bam"), bam);
		SAMEvidenceSource ses = new MockSAMEvidenceSource(pc);
		List<SAMRecord> records = IntermediateFilesTest.getRecords(new File("src/test/resources/indel_mismapping_false_positive_assembly.sv.bam"));
		for (SAMRecord r : records) {
			if ("asm5".equals(r.getReadName())) {
				for (SplitReadEvidence e : SplitReadEvidence.create(ses, r)) {
					assertTrue(e.isReference());
				}
			}
		}
		folder.delete();
	}
	@Test
	public void score_should_be_symmetrical_even_if_anchors_overlap() {
		SAMRecord primary = Read(0, 100, "6M4S");
		primary.setReadBases(B("NNNNNNNNNN"));
		primary.setBaseQualities(B("1234567890"));
		primary.setMappingQuality(40);
		
		SAMRecord supp = Read(0, 200, "3S7M");
		supp.setSupplementaryAlignmentFlag(true);
		supp.setReadBases(B("NNNNNNNNNN"));
		supp.setBaseQualities(B("1234567890"));
		supp.setMappingQuality(20);
		
		primary.setAttribute("SA", new ChimericAlignment(supp).toString());
		supp.setAttribute("SA", new ChimericAlignment(primary).toString());
		
		StubSAMEvidenceSource ses = new StubSAMEvidenceSource(getContext(), null, 0, 0, 100);
		SplitReadEvidence ep = SplitReadEvidence.create(ses, primary).get(0);
		SplitReadEvidence es = SplitReadEvidence.create(ses, supp).get(0);
		assertEquals(ep.getBreakpointQual(), es.getBreakpointQual(), 0);
	}
	@Test
	public void involvesPrimaryReadAlignment_should_allow_primary_local() {
		List<SingleReadEvidence> list;
		SAMRecord r = Read(0, 1, "10M10S");
		r.setAttribute("SA", new ChimericAlignment(Read(0, 10, "10S10M")).toString());
		
		list = SingleReadEvidence.createEvidence(SES(), 0, r);
		assertTrue(list.stream().allMatch(e -> e.involvesPrimaryReadAlignment()));
	}
	@Test
	public void involvesPrimaryReadAlignment_should_allow_primary_remote() {
		List<SingleReadEvidence> list;
		SAMRecord r = Read(0, 1, "10M10S");
		r.setSupplementaryAlignmentFlag(true);
		r.setAttribute("SA", new ChimericAlignment(Read(0, 10, "10S10M")).toString());
		
		list = SingleReadEvidence.createEvidence(SES(), 0, r);
		assertTrue(list.stream().allMatch(e -> e.involvesPrimaryReadAlignment()));
	}
	@Test
	public void involvesPrimaryReadAlignment_should_require_either_primary() {
		List<SingleReadEvidence> list;
		SAMRecord r = Read(0, 1, "10M10S");
		r.setSupplementaryAlignmentFlag(true);
		r.setAttribute("SA", "polyA,20,+,15S5M,39,1;polyA,10,+,10S5M5S,39,1");
		// primary alignment is 15S5M at polyA:20 which does not involve this read
		
		list = SingleReadEvidence.createEvidence(SES(), 0, r);
		assertTrue(list.stream().allMatch(e -> !e.involvesPrimaryReadAlignment()));
	}
	@Test
	public void isReference_should_be_true_if_either_alignment_could_be_moved_to_the_other_breakend() {
		SAMRecord r1 = withSequence("TTTAACAA", Read(0, 10, "3M5S"))[0];
		SAMRecord r2 = withSequence("TTTAACAA", Read(0, 20, "3S2M3S"))[0];
		r1.setAttribute("SA", new ChimericAlignment(r2).toString());
		r2.setAttribute("SA", new ChimericAlignment(r1).toString());
		
		SplitReadEvidence e1 = SplitReadEvidence.create(SES(), r1).get(0);
		SplitReadEvidence e2 = SplitReadEvidence.create(SES(), r2).get(0);
		
		Assert.assertTrue(e2.isReference());
		Assert.assertTrue(e1.isReference());
	}
	@Test
	public void isReference_should_require_entire_aligned_region_to_match() {
		SAMRecord r1 = withSequence("TAAATAAA", Read(0, 10, "3M5S"))[0];
		SAMRecord r2 = withSequence("TAAATAAA", Read(0, 20, "3S2M3S"))[0];
		r1.setAttribute("SA", new ChimericAlignment(r2).toString());
		r2.setAttribute("SA", new ChimericAlignment(r1).toString());
		
		SplitReadEvidence e1 = SplitReadEvidence.create(SES(), r1).get(0);
		SplitReadEvidence e2 = SplitReadEvidence.create(SES(), r2).get(0);
		
		Assert.assertFalse(e2.isReference());
		Assert.assertFalse(e1.isReference());
	}
	@Test
	public void getBreakpointQual_should_be_symmetrical() {
		SAMRecord r = withMapq(4, Read(0, 100, "1S2M3S"))[0];
		SAMRecord left = withMapq(5, Read(0, 100, "1M5S"))[0];
		SAMRecord right = withMapq(6, Read(0, 100, "3S3M"))[0];
		left.setSupplementaryAlignmentFlag(true);
		right.setSupplementaryAlignmentFlag(true);
		SAMRecordUtil.calculateTemplateTags(ImmutableList.of(r, left, right), ImmutableSet.of("SA"), false, false, false, false);
		
		List<SingleReadEvidence> re = SingleReadEvidence.createEvidence(SES(), 0, r);
		List<SingleReadEvidence> lefte = SingleReadEvidence.createEvidence(SES(), 0, left);
		List<SingleReadEvidence> righte = SingleReadEvidence.createEvidence(SES(), 0, right);
		Assert.assertEquals(re.get(0).getBreakendQual(), lefte.get(0).getBreakendQual(), 0);
		Assert.assertEquals(re.get(1).getBreakendQual(), righte.get(0).getBreakendQual(), 0);
	}
	@Test
	public void overaligned_breakpoints_should_be_symmetrical() {
		// 12345
		// MMMM
		//   MMM
		// overlap = 2
		SAMRecord r1 = withSequence("NNNNN", Read(0, 100, "4M1S"))[0];
		SAMRecord r2 = withSequence("NNNNN", Read(0, 200, "2S3M"))[0];
		r1.setAttribute("SA", new ChimericAlignment(r2).toString());
		r2.setAttribute("SA", new ChimericAlignment(r1).toString());
		SplitReadEvidence e1 = (SplitReadEvidence)SingleReadEvidence.createEvidence(SES(), 0, r1).get(0);
		SplitReadEvidence e2 = (SplitReadEvidence)SingleReadEvidence.createEvidence(SES(), 0, r2).get(0);
		Assert.assertEquals(2, e2.getBreakendSummary().end - e2.getBreakendSummary().start);
		Assert.assertEquals(2, e1.getBreakendSummary().end - e1.getBreakendSummary().start);
		Assert.assertEquals(e1.getBreakendSummary(), e2.getBreakendSummary().remoteBreakpoint());
		Assert.assertEquals(e2.getBreakendSummary(), e1.getBreakendSummary().remoteBreakpoint());
	}
	@Test
	public void should_handle_multiple_overlapping_fragments() {
		SAMRecord r1 = Read(0, 100, "48M52S");
		SAMRecord r2 = Read(0, 100, "32S48M20S");
		SAMRecord r3 = Read(0, 100, "64S36M");
		r1.setReadName("R");
		r2.setReadName("R");
		r3.setReadName("R");
		r1.setAttribute("SA", new ChimericAlignment(r2).toString() + ";" + new ChimericAlignment(r3).toString());
		r2.setAttribute("SA", new ChimericAlignment(r1).toString() + ";" + new ChimericAlignment(r3).toString());
		r3.setAttribute("SA", new ChimericAlignment(r1).toString() + ";" + new ChimericAlignment(r2).toString());
		
		List<SplitReadEvidence> e1 = SplitReadEvidence.create(SES(), r1);
		List<SplitReadEvidence> e2 = SplitReadEvidence.create(SES(), r2);
		List<SplitReadEvidence> e3 = SplitReadEvidence.create(SES(), r3);
		Assert.assertEquals(1, e1.size());
		Assert.assertEquals(2, e2.size());
		Assert.assertEquals(1, e3.size());
		Assert.assertEquals(e1.get(0).getEvidenceID(), e2.get(0).getRemoteEvidenceID());
		Assert.assertEquals(e2.get(0).getEvidenceID(), e1.get(0).getRemoteEvidenceID());
		Assert.assertEquals(e2.get(1).getEvidenceID(), e3.get(0).getRemoteEvidenceID());
		Assert.assertEquals(e3.get(0).getEvidenceID(), e2.get(1).getRemoteEvidenceID());
	}
	@Test
	public void should_pro_rata_assembly_support() {
		SAMRecord primary = withSequence("NNNN", Read(1, 200, "1M3S"))[0];
		primary.setMappingQuality(100);
		SAMRecord r = Read(1, 100, "2M4S");
		r.setMappingQuality(100);
		r.setReadNegativeStrandFlag(true);
		r.setAttribute("SA", new ChimericAlignment(primary).toString());
		r.setAttribute(SamTags.IS_ASSEMBLY, 1);
		r.setAttribute(SamTags.ASSEMBLY_DIRECTION, "f");
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_TYPE, new byte[] { 0, 1, 1});
        r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_CATEGORY, new int[] { 0, 0, 1});
        r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_START, new int[] { 3, 2, 3});
        r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_END, new int[] { 4, 3, 5});
        r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_QUAL, new float[] { 10, 20, 5});
        r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_EVIDENCEID, "1 2 3");
        r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_FRAGMENTID, "1 2 3");
		AssemblyEvidenceSource aes = new MockAssemblyEvidenceSource(getContext(), ImmutableList.of(SES(0), SES(1)), new File("test.bam"));
		SplitReadEvidence e = SplitReadEvidence.create(aes, r).get(0);
		Assert.assertEquals(15, e.getBreakpointQual(), 0);
	}
	@Test
	public void FWD_unanchored_assembly_should_pro_rata_support_to_start_of_contig() {
		SAMRecord r = withSequence("NNACTG", Read(1, 100, "1X10N1X4S"))[0];
		SAMRecord realigned = Read(2, 100, "2S4M");
		r.setMappingQuality(60);
		realigned.setMappingQuality(60);
		r.setAttribute("SA", new ChimericAlignment(realigned).toString());
		realigned.setAttribute("SA", new ChimericAlignment(r).toString());
		r.setAttribute(SamTags.IS_ASSEMBLY, 1);
		r.setAttribute(SamTags.ASSEMBLY_DIRECTION, 'f');
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_TYPE, new byte[] { 1 });
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_CATEGORY, new int[] { 0});
		// 0 1 2 3 4 5 6
		//  N N A C T G
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_START, new int[] { 2 });
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_END, new int[] { 5 });
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_QUAL, new float[] { 10});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_EVIDENCEID, "e");
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_FRAGMENTID, "e");
		r.setAttribute(SamTags.UNANCHORED, 1);
		copyAssemblyAttributes(r, realigned);
		AssemblyEvidenceSource aes = new MockAssemblyEvidenceSource(getContext(), ImmutableList.of(SES(0), SES(1)), new File("test.bam"));
		SplitReadEvidence local = SplitReadEvidence.create(aes, r).get(0);
		SplitReadEvidence remote = SplitReadEvidence.create(aes, realigned).get(0);
		Assert.assertEquals(10, local.getBreakpointQual(), 0);
		Assert.assertEquals(10, remote.getBreakpointQual(), 0);
	}
	@Test
	public void BWD_unanchored_assembly_should_pro_rata_support_to_start_of_contig() {
		SAMRecord r = withSequence("ACTGNN", Read(1, 100, "4S1X10N1X"))[0];
		SAMRecord realigned = Read(2, 100, "4M2S");
		r.setMappingQuality(60);
		realigned.setMappingQuality(60);
		r.setAttribute("SA", new ChimericAlignment(realigned).toString());
		realigned.setAttribute("SA", new ChimericAlignment(r).toString());
		r.setAttribute(SamTags.IS_ASSEMBLY, 1);
		r.setAttribute(SamTags.ASSEMBLY_DIRECTION, 'b');
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_TYPE, new byte[] { 1 });
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_CATEGORY, new int[] { 0});
		// 0 1 2 3 4 5 6
		//  A C T G N N
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_START, new int[] { 1 });
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_END, new int[] { 4 });
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_QUAL, new float[] { 10});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_EVIDENCEID, "e");
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_FRAGMENTID, "e");
		r.setAttribute(SamTags.UNANCHORED, 1);
		copyAssemblyAttributes(r, realigned);
		AssemblyEvidenceSource aes = new MockAssemblyEvidenceSource(getContext(), ImmutableList.of(SES(0), SES(1)), new File("test.bam"));
		SplitReadEvidence local = SplitReadEvidence.create(aes, r).get(0);
		SplitReadEvidence remote = SplitReadEvidence.create(aes, realigned).get(0);
		Assert.assertEquals(10, local.getBreakpointQual(), 0);
		Assert.assertEquals(10, remote.getBreakpointQual(), 0);
	}
	@Test
	public void assembly_prorata_with_inserted_sequence_should_be_symmetrical() {

		SAMRecord r = Read(2, 300, "10S5M");
		SAMRecord r2 = Read(2, 200, "5M10S");
		r.setMappingQuality(100);
		r2.setMappingQuality(100);
		r.setAttribute("SA", new ChimericAlignment(r2).toString());
		r2.setAttribute("SA", new ChimericAlignment(r).toString());
		r.setAttribute(SamTags.IS_ASSEMBLY, 1);
		r.setAttribute(SamTags.ASSEMBLY_DIRECTION, "f");
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_TYPE, new byte[] { 0,0, 0});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_CATEGORY, new int[] { 0, 0, 0});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_START, new int[] { 2, 6, 0});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_END, new int[] { 7, 15, 15});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_QUAL, new float[] { 1, 2, 3});
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_EVIDENCEID, "1 2 3");
		r.setAttribute(SamTags.ASSEMBLY_EVIDENCE_FRAGMENTID, "1 2 3");
		copyAssemblyAttributes(r, r2);
		AssemblyEvidenceSource aes = new MockAssemblyEvidenceSource(getContext(), ImmutableList.of(SES(0), SES(1)), new File("test.bam"));
		SplitReadEvidence elocal = SplitReadEvidence.create(aes, r2).get(0);
		SplitReadEvidence eremote = SplitReadEvidence.create(aes, r).get(0);
		Assert.assertEquals(elocal.getBreakpointQual(), eremote.getBreakpointQual(), 0);
	}
	public void copyAssemblyAttributes(SAMRecord source, SAMRecord dest) {
		dest.setAttribute(SamTags.IS_ASSEMBLY, source.getAttribute(SamTags.IS_ASSEMBLY));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_TYPE, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_TYPE));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_CATEGORY, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_CATEGORY));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_START, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_START));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_END, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_OFFSET_END));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_QUAL, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_QUAL));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_EVIDENCEID, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_EVIDENCEID));
		dest.setAttribute(SamTags.ASSEMBLY_EVIDENCE_FRAGMENTID, source.getAttribute(SamTags.ASSEMBLY_EVIDENCE_FRAGMENTID));
		dest.setAttribute(SamTags.UNANCHORED, source.getAttribute(SamTags.UNANCHORED));
	}
}
