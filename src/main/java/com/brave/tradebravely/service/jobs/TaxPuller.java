package com.brave.tradebravely.service.jobs;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Journal;
import com.brave.tradebravely.domain.Tax;
import com.brave.tradebravely.service.EsiTokenService;
import com.brave.tradebravely.service.TaxService;
import com.brave.tradebravely.service.esi.CharacterJournalClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxPuller {

    private final Logger log = LoggerFactory.getLogger(TransactionPuller.class);

    private static final String[] TAX_REF_TYPES = {"broker_fee", "transaction_tax", "reprocessing_tax",
        "planetary_import_tax", "planetary_export_tax", "industry_job_tax", "asset_safety_recovery_tax",
        "contract_brokers_fee", "contract_brokers_fee_corp", "contract_deposit_sales_tax", "contract_sales_tax"};
    private final EsiTokenService tokenService;
    private final EsiProperties esiProperties;
    private final TaxService taxService;
    private final CharacterJournalClient journalClient;

    public TaxPuller(EsiTokenService tokenService, EsiProperties esiProperties, TaxService taxService, CharacterJournalClient journalClient) {
        this.tokenService = tokenService;
        this.esiProperties = esiProperties;
        this.taxService = taxService;
        this.journalClient = journalClient;
    }

    @Scheduled(cron = "0 */5 * * * *")
    @Async
    public void pullTaxes() {
        final List<Integer> characterIds = tokenService.findCharacterIdsForClientId(esiProperties.getTradingClientId());

        characterIds.forEach(characterId -> {
            final List<Journal> journals = journalClient.get(characterId);
            logMinutesBetweenFirstAndLastJournal(journals);
            final List<Tax> taxes = journals.stream().filter(this::isTax).map(this::mapToTax).collect(Collectors.toList());
            taxes.forEach(t -> t.setCharacterId(characterId));
            taxService.persistIfNew(taxes);
        });
    }

    private void logMinutesBetweenFirstAndLastJournal(List<Journal> journals) {
        final Journal first = journals.get(0);
        final Journal last = journals.get(journals.size() - 1);
        final long minutesBetween = ChronoUnit.MINUTES.between(last.getDate(), first.getDate());
        log.info("There were {} minutes between the first and last journal.", minutesBetween);
    }

    private Tax mapToTax(final Journal journal) {
        final Tax tax = new Tax();
        tax.setCharacterId(null);
        tax.setJournalId(journal.getId());
        tax.setAmount(journal.getAmount());
        tax.setDate(journal.getDate());
        tax.setDescription(journal.getDescription());
        tax.setTax(journal.getTax());
        tax.setTaxReceiverId(journal.getTaxReceiverId());
        return tax;
    }

    boolean isTax(final Journal journal) {
        return Arrays.asList(TAX_REF_TYPES).contains(journal.getRefType());
    }
}
