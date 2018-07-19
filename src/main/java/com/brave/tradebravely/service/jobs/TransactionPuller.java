package com.brave.tradebravely.service.jobs;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.service.EsiTokenService;
import com.brave.tradebravely.service.TransactionService;
import com.brave.tradebravely.service.esi.CharacterTransactionsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionPuller {

    private final Logger log = LoggerFactory.getLogger(TransactionPuller.class);

    private final EsiTokenService tokenService;
    private final CharacterTransactionsClient transactionsClient;
    private final EsiProperties esiProperties;
    private final TransactionService transactionService;

    public TransactionPuller(EsiTokenService tokenService, CharacterTransactionsClient transactionsClient, EsiProperties esiProperties, TransactionService transactionService) {
        this.tokenService = tokenService;
        this.transactionsClient = transactionsClient;
        this.esiProperties = esiProperties;
        this.transactionService = transactionService;
    }

    // transactions may be cached for up to 60 minutes, but we want to have the initial pull rather fast
    // the transactionsClient will only retry if the Expires header's date has passed
    @Scheduled(cron = "0 */5 * * * *")
    @Async
    public void pullTransactions() {
        final List<Integer> characterIds = tokenService.findCharacterIdsForClientId(esiProperties.getTradingClientId());

        log.info("Pulling transactions for {} characters.", characterIds.size());

        characterIds.forEach(characterId -> {
            final List<Transaction> transactions = transactionsClient.get(characterId);
            transactions.forEach(t -> t.setCharacterId(characterId));
            transactionService.persistIfNew(transactions);
        });
    }
}
