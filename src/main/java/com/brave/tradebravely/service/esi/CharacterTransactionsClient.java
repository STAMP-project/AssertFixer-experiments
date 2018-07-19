package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.domain.esi.CharacterWalletTransaction;
import com.brave.tradebravely.service.AccessTokenService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.brave.tradebravely.service.util.RequestUtil.authorizedRequest;

@Service
public class CharacterTransactionsClient extends CacheableClient<CharacterWalletTransaction[], List<Transaction>> {

    private final EsiProperties esiProperties;
    private final RestTemplate restTemplate;
    private final UniverseNamesClient namesClient;

    CharacterTransactionsClient(AccessTokenService tokenService, EsiProperties esiProperties, RestTemplate restTemplate, UniverseNamesClient namesClient) {
        super(tokenService);
        this.esiProperties = esiProperties;
        this.restTemplate = restTemplate;
        this.namesClient = namesClient;
    }

    @Override
    List<Transaction> mapToInternalEntity(CharacterWalletTransaction[] body) {
        final Map<Integer, String> typeNames = getTypeNames(body);

        return Arrays.stream(body).map(t -> {
            Transaction mappingResult = new Transaction();
            mappingResult.setAmount(t.getQuantity());
            // we don't know the characterId here, it has to be set outside of the client
            mappingResult.setCharacterId(null);
            mappingResult.setContractId(null);
            mappingResult.setDate(Instant.parse(t.getDate()));
            mappingResult.setLocationId(t.getLocationId());
            mappingResult.setOtherParty(t.getClientId());
            mappingResult.setPricePerUnit(t.getUnitPrice());
            mappingResult.setTransactionId(t.getTransactionId());
            mappingResult.setTypeId(t.getTypeId());
            mappingResult.setTypeName(typeNames.get(t.getTypeId()));
            return mappingResult;
        }).collect(Collectors.toList());
    }

    Map<Integer, String> getTypeNames(CharacterWalletTransaction[] body) {
        final List<Integer> typeIds = Arrays.stream(body).map(CharacterWalletTransaction::getTypeId).collect(Collectors.toList());
        return namesClient.get(typeIds);
    }

    @Override
    protected String getClientId() {
        return esiProperties.getTradingClientId();
    }

    @Override
    ResponseEntity doCall(int characterId, String eTag, String accessToken) {
        final String implantsUrl = esiProperties.getBaseUrl() + "v1/characters/" + characterId + "/wallet/transactions/";
        return restTemplate.exchange(implantsUrl, HttpMethod.GET, authorizedRequest(eTag, accessToken), CharacterWalletTransaction[].class);
    }
}
