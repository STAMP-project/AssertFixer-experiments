package com.brave.tradebravely.web.rest;

import com.brave.tradebravely.TradebravelyApp;

import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.repository.TransactionRepository;
import com.brave.tradebravely.service.TransactionService;
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
 * Test class for the TransactionResource REST controller.
 *
 * @see TransactionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradebravelyApp.class)
public class TransactionResourceIntTest {

    private static final Integer DEFAULT_CHARACTER_ID = 1;
    private static final Integer UPDATED_CHARACTER_ID = 2;

    private static final Instant DEFAULT_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_TRANSACTION_ID = 1L;
    private static final Long UPDATED_TRANSACTION_ID = 2L;

    private static final Long DEFAULT_CONTRACT_ID = 1L;
    private static final Long UPDATED_CONTRACT_ID = 2L;

    private static final Integer DEFAULT_TYPE_ID = 1;
    private static final Integer UPDATED_TYPE_ID = 2;

    private static final String DEFAULT_TYPE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_AMOUNT = 1;
    private static final Integer UPDATED_AMOUNT = 2;

    private static final Double DEFAULT_PRICE_PER_UNIT = 1D;
    private static final Double UPDATED_PRICE_PER_UNIT = 2D;

    private static final Integer DEFAULT_OTHER_PARTY = 1;
    private static final Integer UPDATED_OTHER_PARTY = 2;

    private static final Long DEFAULT_LOCATION_ID = 1L;
    private static final Long UPDATED_LOCATION_ID = 2L;

    @Autowired
    private TransactionRepository transactionRepository;

    

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restTransactionMockMvc;

    private Transaction transaction;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TransactionResource transactionResource = new TransactionResource(transactionService);
        this.restTransactionMockMvc = MockMvcBuilders.standaloneSetup(transactionResource)
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
    public static Transaction createEntity() {
        Transaction transaction = new Transaction()
            .characterId(DEFAULT_CHARACTER_ID)
            .date(DEFAULT_DATE)
            .transactionId(DEFAULT_TRANSACTION_ID)
            .contractId(DEFAULT_CONTRACT_ID)
            .typeId(DEFAULT_TYPE_ID)
            .typeName(DEFAULT_TYPE_NAME)
            .amount(DEFAULT_AMOUNT)
            .pricePerUnit(DEFAULT_PRICE_PER_UNIT)
            .otherParty(DEFAULT_OTHER_PARTY)
            .locationId(DEFAULT_LOCATION_ID);
        return transaction;
    }

    @Before
    public void initTest() {
        transactionRepository.deleteAll();
        transaction = createEntity();
    }

    @Test
    public void createTransaction() throws Exception {
        int databaseSizeBeforeCreate = transactionRepository.findAll().size();

        // Create the Transaction
        restTransactionMockMvc.perform(post("/api/transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(transaction)))
            .andExpect(status().isCreated());

        // Validate the Transaction in the database
        List<Transaction> transactionList = transactionRepository.findAll();
        assertThat(transactionList).hasSize(databaseSizeBeforeCreate + 1);
        Transaction testTransaction = transactionList.get(transactionList.size() - 1);
        assertThat(testTransaction.getCharacterId()).isEqualTo(DEFAULT_CHARACTER_ID);
        assertThat(testTransaction.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testTransaction.getTransactionId()).isEqualTo(DEFAULT_TRANSACTION_ID);
        assertThat(testTransaction.getContractId()).isEqualTo(DEFAULT_CONTRACT_ID);
        assertThat(testTransaction.getTypeId()).isEqualTo(DEFAULT_TYPE_ID);
        assertThat(testTransaction.getTypeName()).isEqualTo(DEFAULT_TYPE_NAME);
        assertThat(testTransaction.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testTransaction.getPricePerUnit()).isEqualTo(DEFAULT_PRICE_PER_UNIT);
        assertThat(testTransaction.getOtherParty()).isEqualTo(DEFAULT_OTHER_PARTY);
        assertThat(testTransaction.getLocationId()).isEqualTo(DEFAULT_LOCATION_ID);
    }

    @Test
    public void createTransactionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = transactionRepository.findAll().size();

        // Create the Transaction with an existing ID
        transaction.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restTransactionMockMvc.perform(post("/api/transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(transaction)))
            .andExpect(status().isBadRequest());

        // Validate the Transaction in the database
        List<Transaction> transactionList = transactionRepository.findAll();
        assertThat(transactionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void getAllTransactions() throws Exception {
        // Initialize the database
        transactionRepository.save(transaction);

        // Get all the transactionList
        restTransactionMockMvc.perform(get("/api/transactions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(transaction.getId())))
            .andExpect(jsonPath("$.[*].characterId").value(hasItem(DEFAULT_CHARACTER_ID)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].transactionId").value(hasItem(DEFAULT_TRANSACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].contractId").value(hasItem(DEFAULT_CONTRACT_ID.intValue())))
            .andExpect(jsonPath("$.[*].typeId").value(hasItem(DEFAULT_TYPE_ID)))
            .andExpect(jsonPath("$.[*].typeName").value(hasItem(DEFAULT_TYPE_NAME.toString())))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.[*].pricePerUnit").value(hasItem(DEFAULT_PRICE_PER_UNIT.doubleValue())))
            .andExpect(jsonPath("$.[*].otherParty").value(hasItem(DEFAULT_OTHER_PARTY)))
            .andExpect(jsonPath("$.[*].locationId").value(hasItem(DEFAULT_LOCATION_ID.intValue())));
    }
    

    @Test
    public void getTransaction() throws Exception {
        // Initialize the database
        transactionRepository.save(transaction);

        // Get the transaction
        restTransactionMockMvc.perform(get("/api/transactions/{id}", transaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(transaction.getId()))
            .andExpect(jsonPath("$.characterId").value(DEFAULT_CHARACTER_ID))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.transactionId").value(DEFAULT_TRANSACTION_ID.intValue()))
            .andExpect(jsonPath("$.contractId").value(DEFAULT_CONTRACT_ID.intValue()))
            .andExpect(jsonPath("$.typeId").value(DEFAULT_TYPE_ID))
            .andExpect(jsonPath("$.typeName").value(DEFAULT_TYPE_NAME.toString()))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT))
            .andExpect(jsonPath("$.pricePerUnit").value(DEFAULT_PRICE_PER_UNIT.doubleValue()))
            .andExpect(jsonPath("$.otherParty").value(DEFAULT_OTHER_PARTY))
            .andExpect(jsonPath("$.locationId").value(DEFAULT_LOCATION_ID.intValue()));
    }
    @Test
    public void getNonExistingTransaction() throws Exception {
        // Get the transaction
        restTransactionMockMvc.perform(get("/api/transactions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateTransaction() throws Exception {
        // Initialize the database
        transactionService.save(transaction);

        int databaseSizeBeforeUpdate = transactionRepository.findAll().size();

        // Update the transaction
        Transaction updatedTransaction = transactionRepository.findById(transaction.getId()).get();
        updatedTransaction
            .characterId(UPDATED_CHARACTER_ID)
            .date(UPDATED_DATE)
            .transactionId(UPDATED_TRANSACTION_ID)
            .contractId(UPDATED_CONTRACT_ID)
            .typeId(UPDATED_TYPE_ID)
            .typeName(UPDATED_TYPE_NAME)
            .amount(UPDATED_AMOUNT)
            .pricePerUnit(UPDATED_PRICE_PER_UNIT)
            .otherParty(UPDATED_OTHER_PARTY)
            .locationId(UPDATED_LOCATION_ID);

        restTransactionMockMvc.perform(put("/api/transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTransaction)))
            .andExpect(status().isOk());

        // Validate the Transaction in the database
        List<Transaction> transactionList = transactionRepository.findAll();
        assertThat(transactionList).hasSize(databaseSizeBeforeUpdate);
        Transaction testTransaction = transactionList.get(transactionList.size() - 1);
        assertThat(testTransaction.getCharacterId()).isEqualTo(UPDATED_CHARACTER_ID);
        assertThat(testTransaction.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testTransaction.getTransactionId()).isEqualTo(UPDATED_TRANSACTION_ID);
        assertThat(testTransaction.getContractId()).isEqualTo(UPDATED_CONTRACT_ID);
        assertThat(testTransaction.getTypeId()).isEqualTo(UPDATED_TYPE_ID);
        assertThat(testTransaction.getTypeName()).isEqualTo(UPDATED_TYPE_NAME);
        assertThat(testTransaction.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testTransaction.getPricePerUnit()).isEqualTo(UPDATED_PRICE_PER_UNIT);
        assertThat(testTransaction.getOtherParty()).isEqualTo(UPDATED_OTHER_PARTY);
        assertThat(testTransaction.getLocationId()).isEqualTo(UPDATED_LOCATION_ID);
    }

    @Test
    public void updateNonExistingTransaction() throws Exception {
        int databaseSizeBeforeUpdate = transactionRepository.findAll().size();

        // Create the Transaction

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restTransactionMockMvc.perform(put("/api/transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(transaction)))
            .andExpect(status().isBadRequest());

        // Validate the Transaction in the database
        List<Transaction> transactionList = transactionRepository.findAll();
        assertThat(transactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteTransaction() throws Exception {
        // Initialize the database
        transactionService.save(transaction);

        int databaseSizeBeforeDelete = transactionRepository.findAll().size();

        // Get the transaction
        restTransactionMockMvc.perform(delete("/api/transactions/{id}", transaction.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Transaction> transactionList = transactionRepository.findAll();
        assertThat(transactionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Transaction.class);
        Transaction transaction1 = new Transaction();
        transaction1.setId("id1");
        Transaction transaction2 = new Transaction();
        transaction2.setId(transaction1.getId());
        assertThat(transaction1).isEqualTo(transaction2);
        transaction2.setId("id2");
        assertThat(transaction1).isNotEqualTo(transaction2);
        transaction1.setId(null);
        assertThat(transaction1).isNotEqualTo(transaction2);
    }
}
