package edu.tamu.iiif.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.tamu.iiif.model.ManifestType;
import edu.tamu.iiif.model.RepositoryType;
import edu.tamu.iiif.model.repo.RedisManifestRepo;

@RunWith(SpringRunner.class)
public abstract class AbstractManifestServiceTest implements ManifestServiceTest {

    protected static final String IIIF_SERVICE_URL = "http://localhost:9003";

    protected static final String IMAGE_SERVICE_URL = "http://localhost:8182/iiif/2";

    protected static final String LOGO_URL = "https://brandguide.tamu.edu/assets/downloads/logos/TAM-Logo.png";

    @Spy
    protected ObjectMapper objectMapper;

    @Mock
    protected HttpService httpService;

    @Mock
    private RedisManifestRepo redisManifestRepo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(redisManifestRepo.findByPathAndTypeAndRepository(any(String.class), any(ManifestType.class), any(RepositoryType.class))).thenReturn(Optional.empty());
    }

}
