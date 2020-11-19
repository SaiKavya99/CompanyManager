package com.gg.tradingservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gg.tradingservice.entities.Stock;
import com.gg.tradingservice.serviceimpl.CompanyManagerServiceImpl;



@RunWith(SpringRunner.class)
@WebMvcTest(value = CompanyManagerController.class)
public class CompanyManagerControllerTest {
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private CompanyManagerServiceImpl companyManagerService;
	@Test
	public void testCreateStock() throws Exception {
		 String URI = "/api/v2/CreateStock";
	        Stock stock = new Stock();
	        stock.setCompanyName("act");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(786);
	        stock.setStockQuantity(7);

	        String jsonInput = this.converttoJson(stock);

	        Mockito.when(companyManagerService.createStock(Mockito.any(Stock.class))).thenReturn(stock);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }
	private String converttoJson(Object stock) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(stock);
	    }
	 @Test
	    public void testGetStockById() throws Exception{
	        String URI= "/api/v2/Stock/{id}";
	        Stock stock = new Stock();
	        stock.setCompanyName("airtel");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(300);
	        stock.setStockQuantity(5);
	        String jsonInput = this.converttoJson(stock);

	        Mockito.when(companyManagerService.getStockById(Mockito.any())).thenReturn(stock);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
    }
	 @Test
	    public void testGetAllStock() throws Exception{
		  String URI = "/api/v2/Stock";
		  Stock stock = new Stock();
	        stock.setCompanyName("dell");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(600);
	        stock.setStockQuantity(9);

	        Stock stock1 = new Stock();
	        stock1.setCompanyName("lenovo");
	        stock1.setStockOrderType("market");
	        stock1.setStockPrice(806);
	        stock1.setStockQuantity(7);
	    	 List<Stock> stockList=new ArrayList<>();
	    	 stockList.add(stock);
	    	 stockList.add(stock1);
	    	 
	    	 String jsonInput = this.converttoJson(stockList);

	         Mockito.when(companyManagerService.getAllStock()).thenReturn(stockList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	 @Test
	    public void testDeleteStockById() throws Exception{
	        String URI = "/api/v2/Stock/{id}";
	        Stock stock = new Stock();
	        stock.setCompanyId(105);
	        stock.setCompanyName("ace");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(200);
	        stock.setStockQuantity(9);

	        Mockito.when(companyManagerService.getStockById(Mockito.any())).thenReturn(stock);
	        Mockito.when(companyManagerService.deleteStock(Mockito.any())).thenReturn(true);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

	        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }
	 @Test
	    public void testUpdateStock() throws Exception{

	        String URI = "/api/v2/Stock/{id}";
	        Stock stock = new Stock();
	        stock.setCompanyName("cadbury");
	        stock.setStockOrderType("market");
	        stock.setStockPrice(600);
	        stock.setStockQuantity(9);
	        String jsonInput = this.converttoJson(stock);

	        Mockito.when(companyManagerService.updateStock(Mockito.any(),Mockito.any())).thenReturn(stock);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	 }
	}


