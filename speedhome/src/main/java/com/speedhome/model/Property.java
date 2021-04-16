package com.speedhome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int propertyType = 0;
	private boolean approve = false;
	private String propertyNumber = "";
	private String ownerName = "";
	private double carpetArea = 0;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyNumber() {
		return propertyNumber;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public double getCarpetArea() {
		return carpetArea;
	}
	public void setCarpetArea(double carpetArea) {
		this.carpetArea = carpetArea;
	}
	
	public Property() {
		super();
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", propertyType=" + propertyType + ", propertyNumber=" + propertyNumber
				+ ", ownerName=" + ownerName + ", carpetArea=" + carpetArea + "]";
	}
	
}
