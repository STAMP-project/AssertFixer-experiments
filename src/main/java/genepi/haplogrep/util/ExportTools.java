package genepi.haplogrep.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import core.Polymorphism;
import core.SampleRanges;
import core.TestSample;
import genepi.haplogrep.Session;
import search.SearchResultTreeNode;
import search.ranking.results.RankedResult;

public class ExportTools {
	
	public static void createReport(Session session, String outFilename, boolean extended) throws IOException {

		StringBuffer result = new StringBuffer();

		Collection<TestSample> sampleCollection = null;

		sampleCollection = session.getCurrentSampleFile().getTestSamples();

		Collections.sort((List<TestSample>) sampleCollection);

		if (!extended) {

			result.append("SampleID\tRange\tHaplogroup\tOverall_Rank\n");

		} else {

			result.append(
					"SampleID\tRange\tHaplogroup\tOverall_Rank\tNot_Found_Polys\tFound_Polys\tRemaining_Polys\tAAC_In_Remainings\t Input_Sample\n");
		}

		if (sampleCollection != null) {

			for (TestSample sample : sampleCollection) {

				result.append(sample.getSampleID() + "\t");

				TestSample currentSample = session.getCurrentSampleFile().getTestSample(sample.getSampleID());

				for (RankedResult currentResult : currentSample.getResults()) {

					SampleRanges range = sample.getSample().getSampleRanges();

					ArrayList<Integer> startRange = range.getStarts();

					ArrayList<Integer> endRange = range.getEnds();

					String resultRange = "";

					for (int i = 0; i < startRange.size(); i++) {
						if (startRange.get(i).equals(endRange.get(i))) {
							resultRange += startRange.get(i) + ";";
						} else {
							resultRange += startRange.get(i) + "-" + endRange.get(i) + ";";
						}
					}
					result.append(resultRange);

					result.append("\t" + currentResult.getHaplogroup());

					result.append("\t" + String.format(Locale.ROOT, "%.4f", currentResult.getDistance()));

					if (extended) {

						result.append("\t");

						ArrayList<Polymorphism> found = currentResult.getSearchResult().getDetailedResult()
								.getFoundPolys();

						ArrayList<Polymorphism> expected = currentResult.getSearchResult().getDetailedResult()
								.getExpectedPolys();

						Collections.sort(found);

						Collections.sort(expected);

						for (Polymorphism currentPoly : expected) {
							if (!found.contains(currentPoly))
								result.append(currentPoly);
						}

						result.append("\t");

						for (Polymorphism currentPoly : found) {
							result.append(" " + currentPoly);

						}

						result.append("\t");
						ArrayList<Polymorphism> allChecked = currentResult.getSearchResult().getDetailedResult()
								.getRemainingPolysInSample();
						Collections.sort(allChecked);

						for (Polymorphism currentPoly : allChecked) {
							result.append(" " + currentPoly);
						}

						result.append("\t");

						ArrayList<Polymorphism> aac = currentResult.getSearchResult().getDetailedResult()
								.getRemainingPolysInSample();
						Collections.sort(aac);

						for (Polymorphism currentPoly : aac) {
							if (currentPoly.getAnnotation() != null)
								result.append(
										" " + currentPoly + " [" + currentPoly.getAnnotation().getAminoAcidChange()
												+ "| Codon " + currentPoly.getAnnotation().getCodon() + " | "
												+ currentPoly.getAnnotation().getGene() + " ]");
						}

						result.append("\t");

						ArrayList<Polymorphism> input = sample.getSample().getPolymorphisms();

						Collections.sort(input);

						for (Polymorphism currentPoly : input) {
							result.append(" " + currentPoly);
						}
					}
					result.append("\n");

				}
			}
		}

		FileWriter fileWriter = new FileWriter(outFilename);
		//GH issue #11
		fileWriter.write(result.toString().replace("\t ", "\t"));

		fileWriter.close();

	}

	public static void calcLineage(Session session, String out) throws IOException {

		StringBuilder build = new StringBuilder();

		StringBuilder graphViz = new StringBuilder();
		
		build.append("#Tab-delimited columns: From_HG,WITH_POLYS,To_HG\n");

		for (TestSample sample : session.getCurrentSampleFile().getTestSamples()) {

			build.append(sample.getSampleID() + " (HG: "+ sample.getResults().get(0).getHaplogroup() +  ") \n");

			graphViz.append("digraph {  label=\"SampleID: "+ sample.getSampleID() + "\"\n");

			TestSample currentSample = session.getCurrentSampleFile().getTestSample(sample.getSampleID());

			for (RankedResult currentResult : currentSample.getResults()) {

				ArrayList<SearchResultTreeNode> currentPath = currentResult.getSearchResult().getDetailedResult()
						.getPhyloTreePath();

				for (int i = 0; i < currentPath.size(); i++) {

					if (i == 0) {
						build.append(currentPath.get(i).getHaplogroup() + "\t");
						graphViz.append("\"" + currentPath.get(i).getHaplogroup() + "\" -> ");
					}

					else {

						StringBuilder polys = new StringBuilder();
						if (currentPath.get(i).getExpectedPolys().size() == 0) {
							polys.append("-");
						} else {

							for (Polymorphism currentPoly : currentPath.get(i).getExpectedPolys()) {

								if (currentPath.get(i).getFoundPolys().contains(currentPoly)) {
									polys.append(currentPoly + " ");
								}
							}
						}

						//add polys
						build.append(polys.toString().trim());
						
						build.append("\t" + currentPath.get(i).getHaplogroup() + "\n");

						graphViz.append("\"" + currentPath.get(i).getHaplogroup() + "\"[label=\""+ polys.toString().trim() + "\"];\n");

						
						// dont do this for last element
						if (i != (currentPath.size()-1)) {

							graphViz.append("\"" + currentPath.get(i).getHaplogroup() + "\" -> ");

							build.append(currentPath.get(i).getHaplogroup() + "\t");

						}
					}

				}

				build.append("\n");
				graphViz.append("}");
				graphViz.append("\n");
				graphViz.append("\n");
			}

		}
		//issue #10 
		if (out.contains("\\.")) {
			out= out.substring(0, out.lastIndexOf("."));
		}
		FileWriter fileWriter = new FileWriter(out + "_lineage.txt");

		fileWriter.write(build.toString());

		FileWriter fileWriter2 = new FileWriter(out + "_graphviz.txt");

		fileWriter2.write(graphViz.toString());

		fileWriter.close();

		fileWriter2.close();

	}
	

}
