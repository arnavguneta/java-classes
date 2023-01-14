package guneta.two.closet;

import guneta.two.closet.Enums.BookType;

/*
APCS-A PSET 2-1
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public class Book {
	// type is an enum
	// field variables
	private double cost;		// cost of the book 	[read only]
	private int pages;			// number of pages
	private String name;		// name of the book
	private String description;
	private String authorFirst;	// authors first name
	private String authorLast;	// authors last name
	private static BookType type;		// hardback or paperback
	private String temp;

	// full constructor
	public Book(String name, String description, String authorFirst, String authorLast, BookType type, double cost,
			int pages) {
		this.cost = cost;
		setPages(pages);
		setName(name);
		setDescription(description);
		setAuthorFirst(authorFirst);
		setAuthorLast(authorLast);
		setType(type);
	}

	//empty constructor
	public Book() {
		this("Name was not set.", "Description was not set.", "None",
				"None", BookType.NULL, -9, -9);
	}

	// partial constructor
	public Book(String name, String description, String authorFirst, String authorLast, BookType type) {
		this(name, description, authorFirst, authorLast, type, -9, -9);
	}

	// getter and setters

	// read only
	public double getCost() {
		return cost;
	}


	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorFirst() {
		return authorFirst;
	}

	public void setAuthorFirst(String authorFirst) {
		this.authorFirst = authorFirst;
	}

	public String getAuthorLast() {
		return authorLast;
	}

	public void setAuthorLast(String authorLast) {
		this.authorLast = authorLast;
	}

	public static BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
		temp = type.toString();
	}

	// overrides toString to print object specific information
	@Override public String toString() {
		return "\n\n******************************* BOOK ******************************\n"
				+ "*******************************************************************\n" + "\nBook Name: " + getName()
				+ "\n" + "Description: " + getDescription() + "\n" + "_______________________________________________"
				+ "\n" + "\nAuthor's Name: " + getAuthorLast() + ", " + getAuthorFirst() + "\n"
				+ "_______________________________________________" + "\n";
	}

	// prints full book report
	public void printBook() {
		System.out.println(this.toString());
		if (getPages() != -9 && getCost() != -9) {
			System.out.println("Type: " + temp + "\n\n" + "Pages: " + getPages() + "\nCost: $" + getCost() + "\n\n");
		} else {
			System.out.println("Type: " + temp + "\n\n");
		}
	}

}
