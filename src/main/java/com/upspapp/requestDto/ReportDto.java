package com.upspapp.requestDto;

public class ReportDto {
	private String query;
	private Long buyerId;
	private Long productId;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
