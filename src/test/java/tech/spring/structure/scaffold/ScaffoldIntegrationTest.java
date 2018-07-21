package tech.spring.structure.scaffold;

import static org.junit.Assert.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;

import tech.spring.structure.scaffold.model.Scaffold;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ScaffoldIntegrationTest extends ScaffoldIntegrationHelper {

    private final static String TEXT_PLAIN_VALUE_UTF8 = TEXT_PLAIN_VALUE + ";charset=UTF-8";

    @Test
    public void testGetScaffolding() throws Exception {
        // @formatter:off
        MvcResult result = mockMvc.perform(get("/scaffolding"))
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andReturn();
        Map<String, Scaffold> scaffolding = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<Map<String , Scaffold>>() {});
        // @formatter:on

        for (Map.Entry<String, Scaffold> entry : getMockScaffolding().entrySet()) {
            String name = entry.getKey();
            Scaffold mockScaffold = entry.getValue();
            assertTrue("Scaffolding does not have expected scaffold!", scaffolding.containsKey(name));
            assertScaffold(mockScaffold, scaffolding.get(name));
        }
    }

    @Test
    public void testGetLoginRequestScaffold() throws Exception {
        // @formatter:off
        MvcResult result = mockMvc.perform(get("/scaffold").param("model", "LoginRequest"))
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andReturn();
        // @formatter:on
        Scaffold loginRequestScaffold = objectMapper.readValue(result.getResponse().getContentAsString(), Scaffold.class);

        assertScaffold(getMockScaffold("LoginRequest"), loginRequestScaffold);
    }

    @Test
    public void testGetUnknownScaffold() throws Exception {
        // @formatter:off
        mockMvc.perform(get("/scaffold").param("model", "Unknown"))
            .andDo(print())
            .andExpect(content().contentType(TEXT_PLAIN_VALUE_UTF8))
            .andExpect(content().string("Scaffold for Unknown not found!"))
            .andExpect(status().isNotFound());
        // @formatter:on
    }

}
