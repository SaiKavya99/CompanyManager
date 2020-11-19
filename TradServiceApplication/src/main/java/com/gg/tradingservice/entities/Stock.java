package com.gg.tradingservice.entities;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

		@Entity
		@Table(name="Stock")
		public class Stock {
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="company_id")
		private Integer companyId;
		@Column(name="company_name",nullable = false)
		private String companyName;
		@Column(name="stock_price",nullable = false)
		private Integer stockPrice;
		@Column(name="stock_quantity",nullable = false)
		private Integer stockQuantity;
		@Column(name="stock_ordertype",nullable = false)
		private String stockOrderType;
		
		public Integer getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}
		
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public Integer getStockPrice() {
			return stockPrice;
		}
		public void setStockPrice(Integer stockPrice) {
			this.stockPrice = stockPrice;
		}
		public Integer getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(Integer stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
		public String getStockOrderType() {
			return stockOrderType;
		}
		public void setStockOrderType(String stockOrderType) {
			this.stockOrderType = stockOrderType;
		}
		public Stock(Integer companyId, String companyName, Integer stockPrice, Integer stockQuantity,
				String stockOrderType) {
			super();
			this.companyId = companyId;
			this.companyName = companyName;
			this.stockPrice = stockPrice;
			this.stockQuantity = stockQuantity;
			this.stockOrderType = stockOrderType;
		}
		public Stock() {
			super();
		}
		@Override
		public String toString() {
			return "Stock [companyId=" + companyId + ", companyName=" + companyName + ", stockPrice=" + stockPrice
					+ ", stockQuantity=" + stockQuantity + ", stockOrderType=" + stockOrderType + "]";
		}
		
		
		
}
