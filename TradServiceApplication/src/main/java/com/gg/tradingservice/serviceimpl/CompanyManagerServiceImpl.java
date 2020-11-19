package com.gg.tradingservice.serviceimpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.gg.tradingservice.entities.Stock;
import com.gg.tradingservice.exception.ResourceNotFoundException;
import com.gg.tradingservice.repository.CompanyManagerRepository;
import com.gg.tradingservice.service.CompanyManagerService;
 
@Service
@Transactional
public class CompanyManagerServiceImpl implements CompanyManagerService{
  @Autowired
  private CompanyManagerRepository companyManagerRepository;
  
  public List<Stock> getAllStock() {
		return companyManagerRepository.findAll();
	}
  public Stock createStock(Stock stock) {
		return  companyManagerRepository.save(stock);
		
	}
  public Stock getStockById(Integer companyId)
			throws ResourceNotFoundException {
	  Stock stock = companyManagerRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + companyId));
		return stock;
}
  public Stock updateStock(Integer companyId, Stock stockDetails) throws ResourceNotFoundException {
	  Stock stock =  companyManagerRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + companyId));
	  stock.setCompanyId(stockDetails.getCompanyId());
	  stock.setCompanyName(stockDetails.getCompanyName());
	  stock.setStockPrice(stockDetails.getStockPrice());
	  stock.setStockQuantity(stockDetails.getStockQuantity());
	  stock.setStockOrderType(stockDetails.getStockOrderType());
		final Stock updatedStock = companyManagerRepository.save(stock);
		return updatedStock; 
	
	}
  
  public boolean deleteStock(Integer companyId)
			throws ResourceNotFoundException {
	  
	  Stock stock = companyManagerRepository.findById(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + companyId));

		companyManagerRepository.delete(stock);
		//Map<String, Boolean> response = new HashMap<>();
		//response.put("deleted", Boolean.TRUE);
		//return response;
        if(null == stock){
            return true;
        }
        return false;
}
}
