package guneta.two.closet;

import guneta.two.closet.Enums.BookType;
import guneta.two.closet.Enums.ClosetType;
import guneta.two.closet.Enums.ClothType;
import guneta.two.closet.Enums.Size;

/*
APCS-A PSET 2-1
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public class Main {

	public static void main(String args[]) {

		// books
		// one empty, 2 partial, 2 complete
		Book books[] = new Book[5];

		books[0] = new Book();
		books[1] = new Book("Biology", "A textbook for AP Biology- 10th Edition", "Jane", "Reece", BookType.HARDBACK);
		books[2] = new Book("AP Calculus BC Exam", "A review book for AP Calculus BC- 2018 Edition", "David", "Kahn", BookType.PAPERBACK);
		books[3] = new Book("CORE Java", "A textbook book for CORE Java- Volume 1, 10th Edition [FUNDAMENTALS]", "Cay", "Horstmann", BookType.PAPERBACK, 33.57, 1007);
		books[4] = new Book("AP Statistics", "A review book for AP Statistics- 9th Edition", "Martin", "Sternstein", BookType.PAPERBACK, 12.91, 633);

		// clothes
		// one empty, 2 partial, 2 complete
		ClothingItem clothes[] = new ClothingItem[5];

		clothes[0] = new ClothingItem();
		clothes[1] = new ClothingItem("Aeropostale", "Navy Blue", Size.L, ClothType.SHIRT);
		clothes[2] = new ClothingItem("Lacoste", "Black", Size.L, ClothType.TSHIRT);
		clothes[3] = new ClothingItem("Adidas", "Black and White Stripes", Size.M, ClothType.SHORTS, 15.99);
		clothes[4] = new ClothingItem("Xersion", "Black and Gray", Size.L, ClothType.SWEATSHIRT, 39.99);

		// closet

		Closet closet = new Closet(clothes, books, "Arnav's Room- Near Door", ClosetType.BUILTIN, 4);

		// print everything
		closet.printCloset();


	}

}
