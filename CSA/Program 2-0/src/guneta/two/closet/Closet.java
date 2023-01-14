package guneta.two.closet;

import guneta.two.closet.Enums.ClosetType;

/*
APCS-A PSET 2-1
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public class Closet {
	private static ClosetType type; // WALKIN or BUILTIN
	// type is an enum
	// field variables
	private ClothingItem clothes[] = new ClothingItem[5];    // array of clothes
	private Book books[] = new Book[5];            // array of book objects
	private String location;        // room location
	private int shelves;            // amount of shelves
	private String temp;

	// full constructor
	public Closet(ClothingItem clothes[], Book books[], String location, ClosetType type, int shelves) {
		setClothes(clothes);
		setBooks(books);
		setLocation(location);
		setType(type);
		setShelves(shelves);
	}

	// empty constructor
	public Closet() {
		for (ClothingItem c : clothes) {
			c = new ClothingItem();
		}
		for (Book b : books) {
			b = new Book();
		}
		setLocation("Location not set.");
		setType(ClosetType.NULL);
		setShelves(-9);
	}

	// partial constructor
	public Closet(ClothingItem clothes[], Book books[], ClosetType type) {
		setClothes(clothes);
		setBooks(books);
		setLocation("Location not set.");
		setType(type);
		setShelves(-9);
	}

	public static ClosetType getType() {
		return type;
	}

	public void setType(ClosetType type) {
		this.type = type;
		temp = type.toString();
	}

	// getters and setters

	// overrides toString to print object specific information
	@Override public String toString() {
		return "\n\n****************************** CLOSET *****************************\n"
				+ "*******************************************************************\n" + "\nLocation: "
				+ getLocation() + "\n" + "Type: " + temp + "\n";
	}

	// prints full closet report
	public void printCloset() {
		System.out.println(this.toString());
		if (getShelves() != -9) {
			System.out.println("Number of Shelves: " + getShelves());
			for (ClothingItem c : clothes) {
				c.printCloth();
			}
			for (Book b : books) {
				b.printBook();
			}
		} else {
			for (ClothingItem c : clothes) {
				c.printCloth();
			}
			for (Book b : books) {
				b.printBook();
			}
		}
	}

	public ClothingItem[] getClothes() {
		return clothes;
	}

	public void setClothes(ClothingItem[] clothes) {
		this.clothes = clothes;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getShelves() {
		return shelves;
	}

	public void setShelves(int shelves) {
		this.shelves = shelves;
	}
}
