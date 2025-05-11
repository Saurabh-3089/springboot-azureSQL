package com.pca.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_Catalogue_Info")
public class PCA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column
	private String productName;
	@Column
	private float price;
	@Column
	private int qty;
	@Column
	private String description;
	
	public PCA() {
		
	}

	public PCA(String productName, float price, int qty, String description) {
		super();
		this.productName = productName;
		this.price = price;
		this.qty = qty;
		this.description = description;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PCA [pid=" + pid + ", productName=" + productName + ", price=" + price + ", qty=" + qty
				+ ", description=" + description + "]";
	}
	
	
}
