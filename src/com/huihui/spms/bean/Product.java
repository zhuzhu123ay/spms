package com.huihui.spms.bean;

public class Product {

	//私有属性
	private Long productId;//产品编号
	private String productDate;//产品生产日期
	private String productName;//产品名称
	private Double productPrice;//产品价格
	
	private String productUse;//产品用途
	
	//构造函数
	public Product(){}

	public Long getProductId() {
		return productId;
	}

	
	
	

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Product(Long productId, String productDate, String productName, Double productPrice, String productUse) {
		super();
		this.productId = productId;
		this.productDate = productDate;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productUse = productUse;
	}

	//setter,getter
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	
	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	

	public String getProductUse() {
		return productUse;
	}

	public void setProductUse(String productUse) {
		this.productUse = productUse;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDate=" + productDate + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productUse=" + productUse + "]";
	}

}
