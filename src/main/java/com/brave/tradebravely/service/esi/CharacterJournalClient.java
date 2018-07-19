package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Journal;
import com.brave.tradebravely.domain.esi.CharacterWalletJournal;
import com.brave.tradebravely.service.AccessTokenService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.brave.tradebravely.service.util.RequestUtil.authorizedRequest;

@Service
public class CharacterJournalClient extends CacheableClient<CharacterWalletJournal[], List<Journal>> {

    private final EsiProperties esiProperties;
    private final RestTemplate restTemplate;

    CharacterJournalClient(AccessTokenService tokenService, EsiProperties esiProperties, RestTemplate restTemplate) {
        super(tokenService);
        this.esiProperties = esiProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    List<Journal> mapToInternalEntity(CharacterWalletJournal[] body) {
        return Arrays.stream(body).map(j -> {
            Journal mappingResult = new Journal();
            mappingResult.setRefType(j.getRefType());
            mappingResult.setAmount(j.getAmount());
            mappingResult.setBalance(j.getBalance());
            mappingResult.setContextId(j.getContextId());
            mappingResult.setContextIdType(j.getContextIdType());
            mappingResult.setDate(Instant.parse(j.getDate()));
            mappingResult.setDescription(j.getDescription());
            mappingResult.setFirstPartyId(j.getFirstPartyId());
            mappingResult.setSecondPartyId(j.getSecondPartyId());
            mappingResult.setId(j.getId());
            mappingResult.setReason(j.getReason());
            mappingResult.setTax(j.getTax());
            mappingResult.setTaxReceiverId(j.getTaxReceiverId());
            return mappingResult;
        }).collect(Collectors.toList());
    }

    @Override
    protected String getClientId() {
        return esiProperties.getTradingClientId();
    }

    @Override
    ResponseEntity doCall(int characterId, String eTag, String accessToken) {
        final String implantsUrl = esiProperties.getBaseUrl() + "v4/characters/" + characterId + "/wallet/journal/";
        return restTemplate.exchange(implantsUrl, HttpMethod.GET, authorizedRequest(eTag, accessToken), CharacterWalletJournal[].class);
    }
}
