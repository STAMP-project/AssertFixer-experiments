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
package uk.ac.ebi.eva.accession.dbsnp.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ebi.ampt2d.commons.accession.core.models.EventType;
import uk.ac.ebi.ampt2d.commons.accession.hashing.SHA1HashingFunction;

import uk.ac.ebi.eva.accession.core.ClusteredVariant;
import uk.ac.ebi.eva.accession.core.IClusteredVariant;
import uk.ac.ebi.eva.accession.core.ISubmittedVariant;
import uk.ac.ebi.eva.accession.core.SubmittedVariant;
import uk.ac.ebi.eva.accession.core.SubmittedVariantAccessioningService;
import uk.ac.ebi.eva.accession.core.configuration.MongoConfiguration;
import uk.ac.ebi.eva.accession.core.configuration.SubmittedVariantAccessioningConfiguration;
import uk.ac.ebi.eva.accession.core.persistence.DbsnpSubmittedVariantEntity;
import uk.ac.ebi.eva.accession.core.persistence.DbsnpSubmittedVariantOperationEntity;
import uk.ac.ebi.eva.accession.core.summary.DbsnpClusteredVariantSummaryFunction;
import uk.ac.ebi.eva.accession.core.summary.DbsnpSubmittedVariantSummaryFunction;
import uk.ac.ebi.eva.accession.dbsnp.persistence.DbsnpClusteredVariantEntity;
import uk.ac.ebi.eva.accession.dbsnp.persistence.DbsnpVariantsWrapper;
import uk.ac.ebi.eva.accession.dbsnp.test.MongoTestConfiguration;
import uk.ac.ebi.eva.commons.core.models.VariantType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:test-variants-writer.properties")
@ContextConfiguration(classes = {MongoConfiguration.class, MongoTestConfiguration.class,
        SubmittedVariantAccessioningConfiguration.class})
public class DbsnpVariantsWriterTest {

    private static final int TAXONOMY_1 = 3880;

    private static final int TAXONOMY_2 = 3882;

    private static final long EXPECTED_ACCESSION = 10000000000L;

    private static final int START_1 = 100;

    private static final Long CLUSTERED_VARIANT = 12L;

    private static final VariantType VARIANT_TYPE = VariantType.SNV;

    private static final Long SUBMITTED_VARIANT = 15L;

    private static final Boolean SUPPORTED_BY_EVIDENCE = true;

    private static final Boolean MATCHES_ASSEMBLY = false;

    private static final Boolean ALLELES_MATCH = true;

    private static final Boolean VALIDATED = false;

    private DbsnpVariantsWriter dbsnpVariantsWriter;

    private Function<ISubmittedVariant, String> hashingFunctionSubmitted;

    private Function<IClusteredVariant, String> hashingFunctionClustered;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SubmittedVariantAccessioningService service;

    @Before
    public void setUp() throws Exception {
        dbsnpVariantsWriter = new DbsnpVariantsWriter(mongoTemplate, service);
        hashingFunctionSubmitted = new DbsnpSubmittedVariantSummaryFunction().andThen(new SHA1HashingFunction());
        hashingFunctionClustered = new DbsnpClusteredVariantSummaryFunction().andThen(new SHA1HashingFunction());
        mongoTemplate.dropCollection(DbsnpSubmittedVariantEntity.class);
        mongoTemplate.dropCollection(DbsnpClusteredVariantEntity.class);
        mongoTemplate.dropCollection(DbsnpSubmittedVariantOperationEntity.class);
    }

    @Test
    public void writeBasicVariant() throws Exception {
        DbsnpVariantsWrapper wrapper = buildSimpleWrapper();

        dbsnpVariantsWriter.write(Collections.singletonList(wrapper));

        List<DbsnpSubmittedVariantEntity> ssEntities = mongoTemplate.find(new Query(),
                                                                          DbsnpSubmittedVariantEntity.class);
        assertEquals(1, ssEntities.size());
        assertEquals(wrapper.getSubmittedVariants().get(0), ssEntities.get(0));

        assertRsWasStored(wrapper);
    }

    private DbsnpVariantsWrapper buildSimpleWrapper() {
        SubmittedVariant submittedVariant = new SubmittedVariant("assembly", TAXONOMY_1, "project", "contig", START_1,
                                                                 "reference", "alternate", CLUSTERED_VARIANT,
                                                                 SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH,
                                                                 VALIDATED);
        DbsnpSubmittedVariantEntity submittedVariantEntity = new DbsnpSubmittedVariantEntity(
                SUBMITTED_VARIANT, hashingFunctionSubmitted.apply(submittedVariant), submittedVariant);

        ClusteredVariant clusteredVariant = new ClusteredVariant("assembly", TAXONOMY_1, "contig", START_1,
                                                                 VARIANT_TYPE, VALIDATED);
        DbsnpClusteredVariantEntity clusteredVariantEntity = new DbsnpClusteredVariantEntity(
                EXPECTED_ACCESSION, hashingFunctionClustered.apply(clusteredVariant), clusteredVariant);

        DbsnpVariantsWrapper wrapper = new DbsnpVariantsWrapper();
        wrapper.setSubmittedVariants(Collections.singletonList(submittedVariantEntity));
        wrapper.setClusteredVariant(clusteredVariantEntity);
        return wrapper;
    }

    private void assertRsWasStored(DbsnpVariantsWrapper wrapper) {
        List<DbsnpClusteredVariantEntity> rsEntities = mongoTemplate.find(new Query(),
                                                                          DbsnpClusteredVariantEntity.class);
        assertEquals(1, rsEntities.size());
        assertEquals(wrapper.getClusteredVariant(), rsEntities.get(0));
    }

    @Test
    public void writeComplexVariant() throws Exception {
        SubmittedVariant submittedVariant_1 = new SubmittedVariant("assembly", TAXONOMY_1, "project", "contig", START_1,
                                                                 "reference", "alternate", CLUSTERED_VARIANT,
                                                                 SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH,
                                                                 VALIDATED);
        SubmittedVariant submittedVariant_2 = new SubmittedVariant("assembly", TAXONOMY_1, "project", "contig", START_1,
                                                                 "reference", "alternate_2", CLUSTERED_VARIANT,
                                                                 SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY, ALLELES_MATCH,
                                                                 VALIDATED);
        DbsnpVariantsWrapper wrapper = buildSimpleWrapper();
        wrapper.setSubmittedVariants(Arrays.asList(
                new DbsnpSubmittedVariantEntity(SUBMITTED_VARIANT,
                                                hashingFunctionSubmitted.apply(submittedVariant_1),
                                                submittedVariant_1),
                new DbsnpSubmittedVariantEntity(SUBMITTED_VARIANT,
                                                hashingFunctionSubmitted.apply(submittedVariant_2),
                                                submittedVariant_2)));

        dbsnpVariantsWriter.write(Collections.singletonList(wrapper));

        List<DbsnpSubmittedVariantEntity> ssEntities = mongoTemplate.find(new Query(),
                                                                          DbsnpSubmittedVariantEntity.class);
        assertEquals(2, ssEntities.size());
        assertEquals(wrapper.getSubmittedVariants().get(0), ssEntities.get(0));
        assertEquals(wrapper.getSubmittedVariants().get(1), ssEntities.get(1));

        assertRsWasStored(wrapper);
    }

    @Test
    public void declusterVariantWithMismatchingAlleles() throws Exception {
        boolean allelesMatch = false;
        SubmittedVariant submittedVariant_1 = new SubmittedVariant("assembly", TAXONOMY_1, "project", "contig", START_1,
                                                                   "reference", "alternate", CLUSTERED_VARIANT,
                                                                   SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY,
                                                                   allelesMatch, VALIDATED);
        DbsnpVariantsWrapper wrapper = buildSimpleWrapper();
        wrapper.setSubmittedVariants(Collections.singletonList(
                new DbsnpSubmittedVariantEntity(SUBMITTED_VARIANT,
                                                hashingFunctionSubmitted.apply(submittedVariant_1),
                                                submittedVariant_1)));

        dbsnpVariantsWriter.write(Collections.singletonList(wrapper));

        List<DbsnpSubmittedVariantEntity> ssEntities = mongoTemplate.find(new Query(),
                                                                          DbsnpSubmittedVariantEntity.class);
        assertSubmittedVariantWasDeclustered(wrapper, ssEntities);
        assertRsWasStored(wrapper);
        assertDeclusteringHistoryWasStored(wrapper, ssEntities);
    }

    private void assertSubmittedVariantWasDeclustered(DbsnpVariantsWrapper wrapper,
                                                      List<DbsnpSubmittedVariantEntity> ssEntities) {
        assertEquals(1, ssEntities.size());
        assertEquals(1, wrapper.getSubmittedVariants().size());
        assertNotEquals(wrapper.getSubmittedVariants().get(0), ssEntities.get(0));
        assertNull(ssEntities.get(0).getClusteredVariantAccession());
    }

    private void assertDeclusteringHistoryWasStored(DbsnpVariantsWrapper wrapper,
                                                    List<DbsnpSubmittedVariantEntity> ssEntities) {
        List<DbsnpSubmittedVariantOperationEntity> operationEntities = mongoTemplate.find(
                new Query(), DbsnpSubmittedVariantOperationEntity.class);
        assertEquals(1, operationEntities.size());
        assertEquals(EventType.UPDATED, operationEntities.get(0).getEventType());
        assertEquals(1, operationEntities.get(0).getInactiveObjects().size());
        assertEquals(wrapper.getSubmittedVariants().get(0).getClusteredVariantAccession(),
                     operationEntities.get(0).getInactiveObjects().get(0).getClusteredVariantAccession());
        assertEquals(ssEntities.get(0).getAccession(), operationEntities.get(0).getAccession());
    }

    @Test
    public void repeatedClusteredVariants() throws Exception {
        boolean allelesMatch = false;
        SubmittedVariant submittedVariant_1 = new SubmittedVariant("assembly", TAXONOMY_2, "project", "contig", START_1,
                                                                   "reference", "alternate", CLUSTERED_VARIANT,
                                                                   SUPPORTED_BY_EVIDENCE, MATCHES_ASSEMBLY,
                                                                   allelesMatch, VALIDATED);
        DbsnpVariantsWrapper firstWrapper = buildSimpleWrapper();
        firstWrapper.setSubmittedVariants(Collections.singletonList(
                new DbsnpSubmittedVariantEntity(SUBMITTED_VARIANT,
                                                hashingFunctionSubmitted.apply(submittedVariant_1),
                                                submittedVariant_1)));
        DbsnpVariantsWrapper secondWrapper = buildSimpleWrapper();

        dbsnpVariantsWriter.write(Arrays.asList(firstWrapper, secondWrapper));

        assertRsWasStored(firstWrapper);
    }
}
