package guneta.two.closet.Enums;

import guneta.two.closet.Book;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public enum BookType {
	HARDBACK, PAPERBACK, NULL;

	// overrides toString
	@Override public String toString() {
		switch (Book.getType()) {
		case HARDBACK:
			return "Hardback";
		case PAPERBACK:
			return "Paperback";
		case NULL:
			return "Type not set.";
		default:
			return "Type not set.";
		}
	}
}
