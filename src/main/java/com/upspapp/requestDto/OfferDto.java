package com.upspapp.requestDto;

public class OfferDto {

	private Long offer;
	private Long productId;
	private Long sellerId;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOffer() {
		return offer;
	}

	public void setOffer(Long offer) {
		this.offer = offer;
	}

}
