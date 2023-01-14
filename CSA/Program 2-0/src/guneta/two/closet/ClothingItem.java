package guneta.two.closet;

import guneta.two.closet.Enums.ClothType;
import guneta.two.closet.Enums.Size;

/*
APCS-A PSET 2-1
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public class ClothingItem {

	// Size and Type are enums with toString
	// field variables
	private String brand;    // brand of clothing
	private String color;    // primary color
	private static Size size;    // size XS, S, M, L, XL
	private static ClothType type;    // type SHORTS, DRESS SHORTS, BELT, TSHIRT, SHIRT, JACKET, SWEATSHIRT, SWEATER
	private double cost;    // estimated cost	[read only]
	private String temp1, temp2;

	// full constructor
	public ClothingItem(String brand, String color, Size size, ClothType type, double cost) {
		setBrand(brand);
		setColor(color);
		setSize(size);
		setType(type);
		this.cost = cost;
	}

	public ClothingItem() {
		this("Brand was not set.", "Color was not set.", Size.NULL, ClothType.NULL, -9);
	}

	public ClothingItem(String brand, String color, Size size, ClothType type) {
		this(brand, color, size, type, -9);
	}

	// overrides toString to print object specific information
	@Override public String toString() {
		return "\n\n***************************** CLOTH *******************************\n"
				+ "*******************************************************************\n" + "\nBrand: " + getBrand()
				+ "\n" + "Color: " + getColor() + "\n";
	}

	// prints full cloth report
	public void printCloth() {
		System.out.println(this.toString());
		if (getCost() != -9) {
			System.out.println("Size: " + temp1 + "\nType: " + temp2 + "\n" + "_______________________________________________"
					+ "\n" + "\nCost: $" + getCost() + "\n"
					+ "_______________________________________________" + "\n\n");
		} else {
			System.out.println("Size: " + temp1 + "\nType: " + temp2 + "\n" + "_______________________________________________"
					+ "\n" + "\nCost: Not set.\n"
					+ "_______________________________________________" + "\n\n");		}
	}

	// getters and setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
		temp1 = this.size.toString();
	}

	public static ClothType getType() {
		return type;
	}

	public void setType(ClothType type) {
		this.type = type;
		temp2 = this.type.toString();

	}

	// read only
	public double getCost() {
		return cost;
	}

}
