package com.brave.tradebravely.web.rest;

import com.brave.tradebravely.TradebravelyApp;

import com.brave.tradebravely.domain.Tax;
import com.brave.tradebravely.repository.TaxRepository;
import com.brave.tradebravely.service.TaxService;
import com.brave.tradebravely.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


import static com.brave.tradebravely.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TaxResource REST controller.
 *
 * @see TaxResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradebravelyApp.class)
public class TaxResourceIntTest {

    private static final Integer DEFAULT_CHARACTER_ID = 1;
    private static final Integer UPDATED_CHARACTER_ID = 2;

    private static final Instant DEFAULT_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Double DEFAULT_AMOUNT = 1D;
    private static final Double UPDATED_AMOUNT = 2D;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Long DEFAULT_JOURNAL_ID = 1L;
    private static final Long UPDATED_JOURNAL_ID = 2L;

    private static final Double DEFAULT_TAX = 1D;
    private static final Double UPDATED_TAX = 2D;

    private static final Integer DEFAULT_TAX_RECEIVED_ID = 1;
    private static final Integer UPDATED_TAX_RECEIVED_ID = 2;

    @Autowired
    private TaxRepository taxRepository;



    @Autowired
    private TaxService taxService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restTaxMockMvc;

    private Tax tax;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TaxResource taxResource = new TaxResource(taxService);
        this.restTaxMockMvc = MockMvcBuilders.standaloneSetup(taxResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Tax createEntity() {
        Tax tax = new Tax()
            .characterId(DEFAULT_CHARACTER_ID)
            .date(DEFAULT_DATE)
            .amount(DEFAULT_AMOUNT)
            .description(DEFAULT_DESCRIPTION)
            .journalId(DEFAULT_JOURNAL_ID)
            .tax(DEFAULT_TAX)
            .taxReceivedId(DEFAULT_TAX_RECEIVED_ID);
        return tax;
    }

    @Before
    public void initTest() {
        taxRepository.deleteAll();
        tax = createEntity();
    }

    @Test
    public void createTax() throws Exception {
        int databaseSizeBeforeCreate = taxRepository.findAll().size();

        // Create the Tax
        restTaxMockMvc.perform(post("/api/taxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tax)))
            .andExpect(status().isCreated());

        // Validate the Tax in the database
        List<Tax> taxList = taxRepository.findAll();
        assertThat(taxList).hasSize(databaseSizeBeforeCreate + 1);
        Tax testTax = taxList.get(taxList.size() - 1);
        assertThat(testTax.getCharacterId()).isEqualTo(DEFAULT_CHARACTER_ID);
        assertThat(testTax.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testTax.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testTax.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testTax.getJournalId()).isEqualTo(DEFAULT_JOURNAL_ID);
        assertThat(testTax.getTax()).isEqualTo(DEFAULT_TAX);
        assertThat(testTax.getTaxReceiverId()).isEqualTo(DEFAULT_TAX_RECEIVED_ID);
    }

    @Test
    public void createTaxWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = taxRepository.findAll().size();

        // Create the Tax with an existing ID
        tax.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restTaxMockMvc.perform(post("/api/taxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tax)))
            .andExpect(status().isBadRequest());

        // Validate the Tax in the database
        List<Tax> taxList = taxRepository.findAll();
        assertThat(taxList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void getAllTaxes() throws Exception {
        // Initialize the database
        taxRepository.save(tax);

        // Get all the taxList
        restTaxMockMvc.perform(get("/api/taxes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tax.getId())))
            .andExpect(jsonPath("$.[*].characterId").value(hasItem(DEFAULT_CHARACTER_ID)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT.doubleValue())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].journalId").value(hasItem(DEFAULT_JOURNAL_ID.intValue())))
            .andExpect(jsonPath("$.[*].tax").value(hasItem(DEFAULT_TAX.doubleValue())))
            .andExpect(jsonPath("$.[*].taxReceiverId").value(hasItem(DEFAULT_TAX_RECEIVED_ID)));
    }


    @Test
    public void getTax() throws Exception {
        // Initialize the database
        taxRepository.save(tax);

        // Get the tax
        restTaxMockMvc.perform(get("/api/taxes/{id}", tax.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(tax.getId()))
            .andExpect(jsonPath("$.characterId").value(DEFAULT_CHARACTER_ID))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT.doubleValue()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.journalId").value(DEFAULT_JOURNAL_ID.intValue()))
            .andExpect(jsonPath("$.tax").value(DEFAULT_TAX.doubleValue()))
            .andExpect(jsonPath("$.taxReceiverId").value(DEFAULT_TAX_RECEIVED_ID));
    }
    @Test
    public void getNonExistingTax() throws Exception {
        // Get the tax
        restTaxMockMvc.perform(get("/api/taxes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateTax() throws Exception {
        // Initialize the database
        taxService.save(tax);

        int databaseSizeBeforeUpdate = taxRepository.findAll().size();

        // Update the tax
        Tax updatedTax = taxRepository.findById(tax.getId()).get();
        updatedTax
            .characterId(UPDATED_CHARACTER_ID)
            .date(UPDATED_DATE)
            .amount(UPDATED_AMOUNT)
            .description(UPDATED_DESCRIPTION)
            .journalId(UPDATED_JOURNAL_ID)
            .tax(UPDATED_TAX)
            .taxReceivedId(UPDATED_TAX_RECEIVED_ID);

        restTaxMockMvc.perform(put("/api/taxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTax)))
            .andExpect(status().isOk());

        // Validate the Tax in the database
        List<Tax> taxList = taxRepository.findAll();
        assertThat(taxList).hasSize(databaseSizeBeforeUpdate);
        Tax testTax = taxList.get(taxList.size() - 1);
        assertThat(testTax.getCharacterId()).isEqualTo(UPDATED_CHARACTER_ID);
        assertThat(testTax.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testTax.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testTax.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testTax.getJournalId()).isEqualTo(UPDATED_JOURNAL_ID);
        assertThat(testTax.getTax()).isEqualTo(UPDATED_TAX);
        assertThat(testTax.getTaxReceiverId()).isEqualTo(UPDATED_TAX_RECEIVED_ID);
    }

    @Test
    public void updateNonExistingTax() throws Exception {
        int databaseSizeBeforeUpdate = taxRepository.findAll().size();

        // Create the Tax

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restTaxMockMvc.perform(put("/api/taxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tax)))
            .andExpect(status().isBadRequest());

        // Validate the Tax in the database
        List<Tax> taxList = taxRepository.findAll();
        assertThat(taxList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteTax() throws Exception {
        // Initialize the database
        taxService.save(tax);

        int databaseSizeBeforeDelete = taxRepository.findAll().size();

        // Get the tax
        restTaxMockMvc.perform(delete("/api/taxes/{id}", tax.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Tax> taxList = taxRepository.findAll();
        assertThat(taxList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Tax.class);
        Tax tax1 = new Tax();
        tax1.setId("id1");
        Tax tax2 = new Tax();
        tax2.setId(tax1.getId());
        assertThat(tax1).isEqualTo(tax2);
        tax2.setId("id2");
        assertThat(tax1).isNotEqualTo(tax2);
        tax1.setId(null);
        assertThat(tax1).isNotEqualTo(tax2);
    }
}
