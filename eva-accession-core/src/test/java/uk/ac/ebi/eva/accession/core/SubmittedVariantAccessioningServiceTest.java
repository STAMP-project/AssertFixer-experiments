/*
 * Copyright 2018 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.ebi.eva.accession.core;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbConfigurationBuilder;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ebi.ampt2d.commons.accession.core.AccessionWrapper;
import uk.ac.ebi.ampt2d.commons.accession.core.OperationType;
import uk.ac.ebi.ampt2d.commons.accession.core.exceptions.AccessionCouldNotBeGeneratedException;
import uk.ac.ebi.ampt2d.commons.accession.core.exceptions.AccessionDeprecatedException;
import uk.ac.ebi.ampt2d.commons.accession.core.exceptions.AccessionDoesNotExistException;
import uk.ac.ebi.ampt2d.commons.accession.core.exceptions.AccessionMergedException;
import uk.ac.ebi.ampt2d.commons.accession.core.exceptions.HashAlreadyExistsException;
import uk.ac.ebi.ampt2d.commons.accession.persistence.IOperation;

import uk.ac.ebi.eva.accession.core.configuration.SubmittedVariantAccessioningConfiguration;
import uk.ac.ebi.eva.accession.core.service.DbsnpSubmittedVariantInactiveService;
import uk.ac.ebi.eva.accession.core.service.SubmittedVariantInactiveService;
import uk.ac.ebi.eva.accession.core.test.configuration.MongoTestConfiguration;
import uk.ac.ebi.eva.accession.core.test.rule.FixSpringMongoDbRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:ss-accession-test.properties")
@ContextConfiguration(classes = {SubmittedVariantAccessioningConfiguration.class, MongoTestConfiguration.class})
public class SubmittedVariantAccessioningServiceTest {

    private static final Long CLUSTERED_VARIANT = null;

    private static final Boolean SUPPORTED_BY_EVIDENCE = true;

    private static final Boolean MATCHES_ASSEMBLY = true;

    private static final Boolean ALLELES_MATCH = false;

    private static final Boolean VALIDATED = false;

    private static final String PROJECT = "PRJEB21794";

    private static final String PROJECT_DBSNP = "DBSNP999";

    private static final long ACCESSION = 5000000000L;

    private static final long ACCESSION_TO_DEPRECATE = 5000000002L;

    private static final long ACCESSION_TO_MERGE_1 = 5000000004L;

    private static final long ACCESSION_TO_MERGE_2 = 5000000005L;

    private static final long ACCESSION_DBSNP_1 = 2200000000L;

    private static final long ACCESSION_DBSNP_2 = 2200000001L;

    private SubmittedVariant submittedVariant;

    private SubmittedVariant newSubmittedVariant;

    private SubmittedVariant dbsnpSubmittedVariant;

    private SubmittedVariant submittedVariantModified;

    @Rule
    public MongoDbRule mongoDbRule = new FixSpringMongoDbRule(
            MongoDbConfigurationBuilder.mongoDb().databaseName("submitted-variants-test").build());

    @Autowired
    private SubmittedVariantAccessioningService service;

    @Autowired
    private SubmittedVariantInactiveService inactiveService;

    @Autowired
    private DbsnpSubmittedVariantInactiveService dbsnpInactiveService;

    @Autowired
    private Long accessioningMonotonicInitSs;

    //Required by nosql-unit
    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        submittedVariant = new SubmittedVariant("GCA_000003055.3", 9913, PROJECT, "21", 20800319, "C", "T",
                                                CLUSTERED_VARIANT, SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, true,
                                                VALIDATED);

        newSubmittedVariant = new SubmittedVariant("assembly", 1111, "project", "contig_2", 100, "ref", "alt",
                                                   CLUSTERED_VARIANT, SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, true,
                                                   VALIDATED);

        dbsnpSubmittedVariant = new SubmittedVariant("GCA_000009999.3", 9999, PROJECT_DBSNP, "21", 20849999, "", "GG",
                                                     CLUSTERED_VARIANT, SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, true,
                                                     VALIDATED);

        submittedVariantModified = new SubmittedVariant("GCA_000003055.3", 9913, PROJECT, "21", 20800319,
                                                        "C", "TCTC", CLUSTERED_VARIANT, SUPPORTED_BY_EVIDENCE,
                                                        MATCHES_ASSEMBLY, true, VALIDATED);
    }

    @UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
    @Test
    public void sameAccessionsAreReturnedForIdenticalVariants() throws AccessionCouldNotBeGeneratedException {
        List<SubmittedVariant> variants = Arrays.asList(
                new SubmittedVariant("assembly", 1111, "project", "contig_1", 100, "ref", "alt", CLUSTERED_VARIANT,
                                     SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH, VALIDATED),
                newSubmittedVariant);

        List<AccessionWrapper<ISubmittedVariant, String, Long>> generatedAccessions = service.getOrCreate(variants);
        List<AccessionWrapper<ISubmittedVariant, String, Long>> retrievedAccessions = service.getOrCreate(variants);

        assertEquals(new HashSet<>(generatedAccessions), new HashSet<>(retrievedAccessions));
    }

    @UsingDataSet(loadStrategy = LoadStrategyEnum.DELETE_ALL)
    @Test
    public void sameAccessionsAreReturnedForEquivalentVariants() throws AccessionCouldNotBeGeneratedException {
        List<SubmittedVariant> originalVariants = Arrays.asList(
                new SubmittedVariant("assembly", 1111, "project", "contig_1", 100, "ref", "alt", CLUSTERED_VARIANT,
                                     SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH, VALIDATED),
                newSubmittedVariant);
        List<SubmittedVariant> requestedVariants = Arrays.asList(
                new SubmittedVariant("assembly", 1111, "project", "contig_1", 100, "ref", "alt", null,
                                     SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH, VALIDATED),
                new SubmittedVariant("assembly", 1111, "project", "contig_2", 100, "ref", "alt", null,
                                     SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH, VALIDATED));
        List<AccessionWrapper<ISubmittedVariant, String, Long>> generatedAccessions = service.getOrCreate(
                originalVariants);
        List<AccessionWrapper<ISubmittedVariant, String, Long>> retrievedAccessions = service.getOrCreate(
                requestedVariants);

        assertEquals(new HashSet<>(generatedAccessions), new HashSet<>(retrievedAccessions));
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json", "/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void getOrCreateAccessionsInBothRepositories() throws AccessionCouldNotBeGeneratedException {
        List<SubmittedVariant> variants = Arrays.asList(submittedVariant, newSubmittedVariant, dbsnpSubmittedVariant);
        List<AccessionWrapper<ISubmittedVariant, String, Long>> submittedVariants = service.getOrCreate(variants);

        long accession = submittedVariants.stream()
                                          .filter(x -> x.getData().getProjectAccession().equals(PROJECT))
                                          .collect(Collectors.toList())
                                          .get(0).getAccession();
        assertEquals(ACCESSION, accession);

        long accessionDbsnp = submittedVariants.stream()
                                               .filter(x -> x.getData().getProjectAccession().equals(PROJECT_DBSNP))
                                               .collect(Collectors.toList())
                                               .get(0).getAccession();
        assertEquals(ACCESSION_DBSNP_1, accessionDbsnp);

        assertEquals(3, submittedVariants.size());
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json", "/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void getFromBothRepositories() {
        List<SubmittedVariant> variants = Arrays.asList(submittedVariant, newSubmittedVariant, dbsnpSubmittedVariant);
        List<AccessionWrapper<ISubmittedVariant, String, Long>> accessions = service.get(variants);
        assertEquals(2, accessions.size());
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json", "/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void getByAccessionsFromBothRepositories() {
        List<Long> accessions = Arrays.asList(ACCESSION, ACCESSION_DBSNP_1);
        List<AccessionWrapper<ISubmittedVariant, String, Long>> submittedVariants = service.getByAccessions(accessions);
        assertEquals(2, submittedVariants.size());
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json", "/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void getByAccessionAndVersionFromBothRepositories() throws AccessionMergedException,
            AccessionDoesNotExistException, AccessionDeprecatedException {
        AccessionWrapper<ISubmittedVariant, String, Long> submittedVariant = service.getByAccessionAndVersion(
                ACCESSION, 1);
        assertEquals(this.submittedVariant, submittedVariant.getData());

        AccessionWrapper<ISubmittedVariant, String, Long> dbsnpSubmittedVariant = service.getByAccessionAndVersion(
                ACCESSION_DBSNP_1, 1);
        assertEquals(this.dbsnpSubmittedVariant, dbsnpSubmittedVariant.getData());
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json"})
    @Test
    public void updateSubmittedVariant() throws AccessionDeprecatedException, AccessionDoesNotExistException,
            AccessionMergedException, HashAlreadyExistsException {
        assertUpdate(ACCESSION, submittedVariantModified);
    }

    private void assertUpdate(long accession, ISubmittedVariant modifiedVariant)
            throws AccessionDeprecatedException, AccessionDoesNotExistException, AccessionMergedException,
            HashAlreadyExistsException {
        service.update(accession, 1, modifiedVariant);
        assertEquals(modifiedVariant, service.getByAccessionAndVersion(accession, 1).getData());

        IOperation<Long> lastOperation;
        if (accession >= accessioningMonotonicInitSs) {
            lastOperation = inactiveService.getLastOperation(accession);
        } else {
            lastOperation = dbsnpInactiveService.getLastOperation(accession);
        }
        assertEquals(OperationType.UPDATED, lastOperation.getOperationType());
        assertEquals(accession, lastOperation.getAccessionIdOrigin().longValue());
        assertNull(lastOperation.getAccessionIdDestination());
    }

    @UsingDataSet(locations = {"/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void updateDbsnpSubmittedVariant() throws AccessionDeprecatedException, AccessionDoesNotExistException,
            AccessionMergedException, HashAlreadyExistsException {
        assertUpdate(ACCESSION_DBSNP_1, submittedVariantModified);
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json"})
    @Test
    public void patchSubmittedVariant() throws AccessionDeprecatedException, AccessionDoesNotExistException,
            AccessionMergedException, HashAlreadyExistsException {
        assertPatch(ACCESSION, submittedVariantModified);
    }

    private void assertPatch(long accession, ISubmittedVariant modifiedVariant) throws AccessionDeprecatedException,
            AccessionDoesNotExistException, AccessionMergedException, HashAlreadyExistsException {
        service.patch(accession, modifiedVariant);
        ISubmittedVariant variantFromDb = service.getByAccessions(Collections.singletonList(accession)).get(0)
                                                 .getData();
        assertEquals(modifiedVariant, variantFromDb);
    }

    @UsingDataSet(locations = {"/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void patchDbsnpSubmittedVariant() throws AccessionDeprecatedException, AccessionDoesNotExistException,
            AccessionMergedException, HashAlreadyExistsException {
        assertPatch(ACCESSION_DBSNP_1, submittedVariantModified);
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json"})
    @Test
    public void deprecateSubmittedVariant() throws AccessionMergedException, AccessionDoesNotExistException,
            AccessionDeprecatedException {
        assertDeprecate(ACCESSION_TO_DEPRECATE, "Test deprecate");
    }

    private void assertDeprecate(long accession, String reason) throws AccessionMergedException,
            AccessionDoesNotExistException, AccessionDeprecatedException {
        assertFalse(service.getByAccessions(Collections.singletonList(accession)).isEmpty());
        service.deprecate(accession, reason);
        assertTrue(service.getByAccessions(Collections.singletonList(accession)).isEmpty());

        IOperation<Long> lastOperation;
        if (accession >= accessioningMonotonicInitSs) {
            lastOperation = inactiveService.getLastOperation(accession);
        } else {
            lastOperation = dbsnpInactiveService.getLastOperation(accession);
        }
        assertEquals(OperationType.DEPRECATED, lastOperation.getOperationType());
        assertEquals(accession, lastOperation.getAccessionIdOrigin().longValue());
        assertNull(lastOperation.getAccessionIdDestination());
        assertEquals(reason, lastOperation.getReason());
    }

    @UsingDataSet(locations = {"/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void deprecateDnsnpSubmittedVariant() throws AccessionMergedException, AccessionDoesNotExistException,
            AccessionDeprecatedException {
        assertDeprecate(ACCESSION_DBSNP_1, "Test deprecate");
    }

    @UsingDataSet(locations = {"/test-data/submittedVariantEntity.json"})
    @Test
    public void mergeSubmittedVariant() throws AccessionMergedException, AccessionDoesNotExistException,
            AccessionDeprecatedException {
        assertMerge(ACCESSION_TO_MERGE_1, ACCESSION_TO_MERGE_2, "Test merge");
    }

    private void assertMerge(long accessionOrigin, long accessionDestination, String reason) throws
            AccessionMergedException, AccessionDoesNotExistException, AccessionDeprecatedException {
        assertFalse(service.getByAccessions(Collections.singletonList(accessionOrigin)).isEmpty());
        assertFalse(service.getByAccessions(Collections.singletonList(accessionDestination)).isEmpty());
        service.merge(accessionOrigin, accessionDestination, reason);
        assertTrue(service.getByAccessions(Collections.singletonList(accessionOrigin)).isEmpty());
        assertFalse(service.getByAccessions(Collections.singletonList(accessionDestination)).isEmpty());

        IOperation<Long> lastOperation;
        if (accessionOrigin >= accessioningMonotonicInitSs) {
            lastOperation = inactiveService.getLastOperation(accessionOrigin);
        } else {
            lastOperation = dbsnpInactiveService.getLastOperation(accessionOrigin);
        }
        assertEquals(OperationType.MERGED_INTO, lastOperation.getOperationType());
        assertEquals(accessionOrigin, lastOperation.getAccessionIdOrigin().longValue());
        assertEquals(accessionDestination, lastOperation.getAccessionIdDestination().longValue());
        assertEquals("Test merge", lastOperation.getReason());
    }

    @UsingDataSet(locations = {"/test-data/dbsnpSubmittedVariantEntity.json"})
    @Test
    public void mergeDbsnpSubmittedVariant() throws AccessionMergedException, AccessionDoesNotExistException,
            AccessionDeprecatedException {
        assertMerge(ACCESSION_DBSNP_1, ACCESSION_DBSNP_2, "Test merge");
    }

}
