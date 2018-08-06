package bean;

import java.sql.Date;

public class Product {
	private String name;
	private String category;
	private double price;
	private double cost;
	private int count;
	private Date expiration;
	private String source;
	private String source_contact;
	private int ID;
	
	public Product() {
		super();
	}
	
	public Product(String name, String category, double price, double cost, 
			int count, Date expiration, String source, String source_contact, int ID) {
		super();
		this.name =name;
		this.category = category;
		this.price = price;
		this.cost = cost;
		this.count = count;
		this.expiration = expiration;
		this.source = source;
		this.source_contact = source_contact;
		this.ID = ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	public Date getExpiration() {
		return expiration;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource_contact(String source_contact) {
		this.source_contact = source_contact;
	}
	
	public String getSource_contact() {
		return source_contact;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
}
