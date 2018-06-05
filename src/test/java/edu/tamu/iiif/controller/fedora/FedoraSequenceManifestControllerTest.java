package edu.tamu.iiif.controller.fedora;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.tamu.iiif.controller.AbstractManifestControllerTest;
import edu.tamu.iiif.service.fedora.FedoraSequenceManifestService;

@WebMvcTest(value = FedoraSequenceManifestController.class, secure = false)
public class FedoraSequenceManifestControllerTest extends AbstractManifestControllerTest {

    @MockBean
    private FedoraSequenceManifestService fedaorSequenceManifestService;

    @Value("classpath:mock/fedora/json/sequence.json")
    private Resource json;

    @Test
    public void testGetManifest() throws Exception {
        String expected = FileUtils.readFileToString(json.getFile(), "UTF-8");
        when(fedaorSequenceManifestService.getManifest(any(String.class), any(Boolean.class))).thenReturn(expected);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fedora/sequence?context=cars_pcdm_objects/chevy").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
