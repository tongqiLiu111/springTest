package com.example.demo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
class SpringbootsTestApplicationTests {

	@Autowired
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;



	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new Controller()).build();
	}

	@Test
	void getreverse() throws Exception{
		mvc.perform(MockMvcRequestBuilders
						.get("/reverse")
				.param("string","word"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("drow"))
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	void getENV() throws Exception{

		mvc.perform(MockMvcRequestBuilders
						.get("/display")
				).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("aDefaultMessage"))
				.andDo(MockMvcResultHandlers.print());
	}



}
