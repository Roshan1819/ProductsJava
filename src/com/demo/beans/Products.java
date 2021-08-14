package com.demo.beans;

public class Products {
	private int pid;
    private String name;
    private int quantity;
    private double price;
    public Products() {
 		super();
 		this.pid=0;
 		this.name = null;
 		this.quantity = 0;
 		this.price = 0;
 	}
    public Products(String name, double price, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
    
    public Products(int pid,String name, double price, int quantity) {
		super();
		this.pid=pid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
    
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
	

    
}
