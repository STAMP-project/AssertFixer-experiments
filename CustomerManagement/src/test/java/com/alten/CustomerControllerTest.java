package com.alten;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alten.datatranssferobject.AddressDTO;
import com.alten.datatranssferobject.CustomerDTO;
import com.alten.domainvalue.CustomerType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void retrieveAllExistingCustomers() throws Exception {
		this.mockMvc.perform(get("/v1/customers/")).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void retrieveExistingCustomerbyIdGetSuccess() throws Exception {
		this.mockMvc.perform(get("/v1/customers/2")).andExpect(status().is2xxSuccessful());
	}


	@Test
	public void retrieveCustomerbyWrongIdGetSuccess() throws Exception {
		this.mockMvc.perform(get("/v1/customers/0")).andExpect(status().isBadRequest());
	}

	@Test
	public void retrieveNonExistingCustomerbyIdGetFailure() throws Exception {
		this.mockMvc.perform(get("/v1/customers/55555")).andExpect(status().isNotFound());
	}

	@Test
	public void deleteExistingCustomerGetSuccess() throws Exception {
		this.mockMvc.perform(delete("/v1/customers/1")).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void deleteExistingCustomerGetFailure() throws Exception {
		this.mockMvc.perform(delete("/v1/customers/55555")).andExpect(status().isNotFound());
	}

	@Test
	public void postCarGetSuccess() throws Exception {
		AddressDTO address = new AddressDTO("gardens st. 5", null, "Stockholm", "state", "Sweden", "22 222");
		CustomerDTO customer = new CustomerDTO(null, "Jack Petterson", CustomerType.INDIVIDUAL, address);

		this.mockMvc.perform(post("/v1/customers/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(customer))).andExpect(status().isCreated());
	}

}
