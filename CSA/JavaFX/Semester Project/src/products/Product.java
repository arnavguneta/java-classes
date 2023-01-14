package products;

/*
APCS-A FINAL PROJECT
Arnav Guneta
Period 2
Johns Creek High School
12/1/2017
 */

public class Product {

	// class fields
	private static ListController lc;
	private String name;
	private String model;
	private String os;
	private String color;
	private double cost;
	private double size;
	private int cap;
	private int stock;
	private int weight;
	private boolean used;

	// empty constructor
	public Product() {
		this("Not Available", "Not Available", "Not Available", "Not Available", -9, -9, -9, -9, -9, false);
	}
	// full constructor
	public Product(String name, String model, String os, String color, double cost, double size, int cap, int stock,
			int weight, boolean used) {
		this.name = name;
		this.model = model;
		this.os = os;
		this.color = color;
		this.cost = cost;
		this.size = size;
		this.cap = cap;
		this.stock = stock;
		this.weight = weight;
		this.used = used;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}
