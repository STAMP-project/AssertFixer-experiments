package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.esi.UniverseName;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UniverseNamesClient {

    private final RestTemplate restTemplate;
    private final EsiProperties esiProperties;

    UniverseNamesClient(RestTemplate restTemplate, EsiProperties esiProperties) {
        this.restTemplate = restTemplate;
        this.esiProperties = esiProperties;
    }

    /**
     * Id/name association for an ID. All IDs must resolve to a name, or a 404 will be thrown.
     *
     * @param id
     * @return
     */
    public String get(Integer id) {
        return get(Collections.singletonList(id)).get(id);
    }

    /**
     * List of id/name associations for a set of IDs. All IDs must resolve to a name, or a 404 will be thrown.
     *
     * @param ids
     * @return
     */
    public Map<Integer, String> get(List<Integer> ids) {
        Map<Integer, String> result = new HashMap<>();

        // remove duplicates
        ids = ids.stream().distinct().collect(Collectors.toList());
        addNames(ids, result);

        return result;
    }

    void addNames(List<Integer> ids, Map<Integer, String> result) {
        for (int i = 0; i < ids.size(); i += 1000) {
            int chunkSize = getNextChunkSize(ids.size(), i, 1000);
            final List<Integer> chunk = ids.subList(i, i + chunkSize);
            final UniverseName[] body = doCall(chunk).getBody();
            Arrays.stream(Objects.requireNonNull(body))
                .forEach(el -> result.put(el.getId(), el.getName()));
        }
    }

    int getNextChunkSize(int size, int current, int maxChunkSize) {
        boolean isEnd = current + maxChunkSize > size;
        return isEnd ? size - current : maxChunkSize;
    }

    ResponseEntity<UniverseName[]> doCall(List<Integer> ids) {
        final String url = esiProperties.getBaseUrl() + "v2/universe/names/";
        final HttpEntity<Integer[]> request = new HttpEntity(ids, null);
        return restTemplate.exchange(url, HttpMethod.POST, request, UniverseName[].class);
    }
}
