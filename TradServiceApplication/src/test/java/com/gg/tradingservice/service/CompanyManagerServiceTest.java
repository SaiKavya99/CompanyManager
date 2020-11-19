package com.gg.tradingservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gg.tradingservice.entities.Stock;
import com.gg.tradingservice.repository.CompanyManagerRepository;
import com.gg.tradingservice.serviceimpl.CompanyManagerServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class CompanyManagerServiceTest {

	 @MockBean
	    private CompanyManagerRepository companyManagerRepository;

	    @Autowired
	    private CompanyManagerServiceImpl companyManagerService;
       
	    
	       
	@Test
     public void testGetAllStock() throws Exception{
		Stock stock = new Stock();
        stock.setCompanyName("samsung");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);

        Stock stock1 = new Stock();
        stock1.setCompanyName("hp");
        stock1.setStockOrderType("market");
        stock1.setStockPrice(600);
        stock1.setStockQuantity(9);

        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        stockList.add(stock1);

        Mockito.when(companyManagerRepository.findAll()).thenReturn(stockList);
        assertThat(companyManagerService.getAllStock()).isEqualTo(stockList);

}

	@Test
	public void testCreateStock() {
		Stock stock = new Stock();
		stock.setCompanyId(40);
        stock.setCompanyName("Lg");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);

        Mockito.when(companyManagerRepository.save(stock)).thenReturn(stock);
        assertThat(companyManagerService.createStock(stock)).isEqualTo(stock);
    }
		

	@Test
	void testGetStockById() throws Exception {
		Stock stock = new Stock();
		stock.setCompanyId(501);
        stock.setCompanyName("acer");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);
           Mockito.when(companyManagerRepository.findById(501).get()).thenReturn(stock);   
        assertThat(companyManagerService.getStockById(40)).isEqualTo(stock);
    
		 
    }
		

	@Test
	public void testUpdateStock() throws Exception {

		Stock stock = new Stock();
		stock.setCompanyId(50);
        stock.setCompanyName("acer");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);


		        Mockito.when(companyManagerRepository.findById(50).get()).thenReturn(stock);
		        stock.setStockPrice(800);
		        Mockito.when(companyManagerRepository.save(stock)).thenReturn(stock);
		        System.out.println(stock.getStockPrice());
		        assertThat(companyManagerService.updateStock(50, stock)).isEqualTo(stock);
		    }

	@Test
	void testDeleteStock() throws Exception {
		Stock stock = new Stock();
		stock.setCompanyId(105);
        stock.setCompanyName("hcl");
        stock.setStockOrderType("market");
        stock.setStockPrice(600);
        stock.setStockQuantity(9);
        companyManagerRepository.deleteById(stock.getCompanyId());
        System.out.println(companyManagerRepository.findById(105));
        Assert.assertTrue(companyManagerRepository.findById(105).isEmpty());
    }
		

}
