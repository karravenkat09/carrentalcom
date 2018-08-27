package com.rental.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rental.car.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarControllerTest {
	private MockMvc mockMvc;
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void verifyGetAllCars() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/cars").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(11))).andDo(print());
	}
	
	@Test
	public void verifyGetCarsByMakeAndColor() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/red/Jaguar").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	
	@Test
	public void verifyInvalidArgumentGetCarsByMakeAndColor() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/red/abc").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.errorCode").value(404))
			.andExpect(jsonPath("$.message").value("No cars exist with the given criteria, color : red, make : abc"))
			.andDo(print());
	}
	
	@Test
	public void verifyInvalidCriteriaGetCarsByMakeAndColor() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/red/Tesla").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errorCode").value(404))
		.andExpect(jsonPath("$.message").value("No cars exist with the given criteria, color : red, make : Tesla"))
		.andDo(print());
	}
}
