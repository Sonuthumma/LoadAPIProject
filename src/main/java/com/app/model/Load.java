package com.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "loadAPI")
public class Load {

	@Column(name = "LoadingPoint")
	private String loadingPoint;

	@Column(name = "UnloadingPoint")
	private String unloadingPoint;

	@Column(name = "ProductType")
	private String productType;

	@Column(name = "TruckType")
	private String truckType;

	@Column(name = "NoOfTrucks")
	private String noOfTrucks;

	@Column(name = "Weight")
	private String weight;

	@Column(name = "Comment")
	private String comment;

	@Id
	@Column(name = "ShipperId")
	private String shipperId;

	@Column(name = "Date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	public String getLoadingPoint() {
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}

	public String getUnloadingPoint() {
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getNoOfTrucks() {
		return noOfTrucks;
	}

	public void setNoOfTrucks(String noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Load() {
		super();
		
	}

}

