package com.gg.tradingservice.service;

import java.util.List;

import com.gg.tradingservice.entities.Stock;
import com.gg.tradingservice.exception.ResourceNotFoundException;

public interface CompanyManagerService {
	public List<Stock> getAllStock();
	public Stock createStock(Stock stock);
	 public Stock getStockById(Integer companyId) throws ResourceNotFoundException;
	 public Stock updateStock(Integer companyId, Stock stockDetails) throws ResourceNotFoundException;
	 public boolean deleteStock(Integer companyId) throws ResourceNotFoundException;
}
