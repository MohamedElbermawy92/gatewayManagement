package com.backend_challenge.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starter.Main;
import com.starter.services.GatewayService;

import static org.hamcrest.Matchers.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerTest {

	
	@Autowired
	private MockMvc moc;
	
	@MockBean
	private GatewayService gatewayService;
	

	
	
	@Test
	public void whenAddEmp_ThenCreateEmployee() throws Exception{
		
		//Employee employee1 = new Employee(1,"Mohamed",28,States.A);
		//BDDMockito.given(service.addEmployee(Mockito.any(Employee.class))).willReturn(employee1);
		
	//	ObjectMapper mapper = new ObjectMapper();
	//	moc.perform(post("/api/add/").contentType(MediaType.APPLICATION_JSON).
	//			content(mapper.writeValueAsString(employee1)))
	//	.andExpect(status().isCreated())
	//	.andExpect(jsonPath("$.name", equalTo("Mohamed")));

		
	}
	
	@Test
	public void whenChangeState_ThenRetuenStatusOk() throws Exception{
		
	//	Employee employee1 = new Employee(1,"Mohamed",28,States.A);
		
	//	BDDMockito.given(service.changeStatus(Mockito.anyString(), Mockito.anyString())).willReturn(true);
		
	//	ObjectMapper mapper = new ObjectMapper();
	//	moc.perform(put("/api/change/").contentType(MediaType.APPLICATION_JSON).
	//			content(mapper.writeValueAsString(employee1)))
	//	.andExpect(status().isOk());

		
	}
	
	@Test
	public void whenGetAllEmployeed_ThenRetuenEmployeesList() throws Exception{
		
	//	Employee employee1 = new Employee(1,"Mohamed",28,States.A);
	//	Employee employee2 = new Employee(2,"Ahmed",30,States.A);
		
	//	List<Employee> list = Arrays.asList(employee1,employee2);

	//	BDDMockito.given(service.getAllEmployee()).willReturn(list);
		
		 moc.perform(get("/api/getAll/").contentType(MediaType.APPLICATION_JSON))		
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].name", equalTo("Mohamed")));

		
	}
	

	
}
