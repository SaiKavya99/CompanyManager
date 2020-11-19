package com.gg.tradingservice.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.tradingservice.entities.Stock;
import com.gg.tradingservice.exception.ResourceNotFoundException;
import com.gg.tradingservice.serviceimpl.CompanyManagerServiceImpl;
@RestController
@RequestMapping("/api/v2")
public class CompanyManagerController {
	@Autowired
	private CompanyManagerServiceImpl companyManagerService;

	@GetMapping("/Stock")
	public List<Stock> getAllStock() {
		return companyManagerService.getAllStock();
}
	@PostMapping("/CreateStock")
	public Stock createStock( @RequestBody Stock stock) {
		return companyManagerService.createStock(stock);
	} 
	@GetMapping("/Stock/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") Integer companyId) throws ResourceNotFoundException {
		Stock stock = companyManagerService.getStockById(companyId);
		return  ResponseEntity.ok(stock);
	}
	@PutMapping("/Stock/{id}")
	public ResponseEntity<Stock> updateStock(@PathVariable(value = "id") Integer companyId,
			 @RequestBody Stock stockDetails) throws ResourceNotFoundException {
		Stock stock = companyManagerService.updateStock(companyId, stockDetails);
		return  ResponseEntity.ok(stock);
	} 

	@DeleteMapping("/Stock/{id}")	
	public ResponseEntity<Boolean> deleteCompanyManager(@PathVariable(value = "id") Integer companyId,
			 @RequestBody Stock stockDetails) throws ResourceNotFoundException	{
		 Boolean stock = companyManagerService.deleteStock(companyId);
		return  ResponseEntity.ok(stock);
	}	
}