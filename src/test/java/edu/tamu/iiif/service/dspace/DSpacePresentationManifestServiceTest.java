package edu.tamu.iiif.service.dspace;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.util.ReflectionTestUtils;

import com.fasterxml.jackson.databind.JsonNode;

public class DSpacePresentationManifestServiceTest extends AbstractDSpaceManifestServiceTest {

    @InjectMocks
    private DSpacePresentationManifestService dSpacePresentationManifestService;

    @Value("classpath:mock/dspace/rdf/item.rdf")
    private Resource rdf;

    @Value("classpath:mock/dspace/json/image.json")
    private Resource image;

    @Value("classpath:mock/dspace/json/presentation.json")
    private Resource presentation;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(dSpacePresentationManifestService, "iiifServiceUrl", IIIF_SERVICE_URL);
        ReflectionTestUtils.setField(dSpacePresentationManifestService, "imageServerUrl", IMAGE_SERVICE_URL);
        ReflectionTestUtils.setField(dSpacePresentationManifestService, "logoUrl", LOGO_URL);

        ReflectionTestUtils.setField(dSpacePresentationManifestService, "dspaceUrl", DSPACE_URL);
        ReflectionTestUtils.setField(dSpacePresentationManifestService, "dspaceWebapp", DSPACE_WEBAPP);
    }

    @Test
    public void testGetManifest() throws IOException, URISyntaxException {
        when(httpService.get(eq(DSPACE_URL + "/rdf/handle/123456789/158308"))).thenReturn(FileUtils.readFileToString(rdf.getFile(), "UTF-8"));
        when(httpService.get(eq(DSPACE_URL + "/rdf/handle/123456789/158308/1/sports-car-146873_960_720.png"))).thenReturn(FileUtils.readFileToString(rdf.getFile(), "UTF-8"));
        when(httpService.get(eq(IMAGE_SERVICE_URL + "/ZHNwYWNlOnhtbHVpL2JpdHN0cmVhbS8xMjM0NTY3ODkvMTU4MzA4LzEvc3BvcnRzLWNhci0xNDY4NzNfOTYwXzcyMC5wbmc=/info.json"))).thenReturn(FileUtils.readFileToString(image.getFile(), "UTF-8"));
        String manifest = dSpacePresentationManifestService.getManifest("123456789/158308", false);

        Assert.assertEquals(objectMapper.readValue(presentation.getFile(), JsonNode.class), objectMapper.readValue(manifest, JsonNode.class));
    }

}
