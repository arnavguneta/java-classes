package guneta.two.closet.Enums;

import guneta.two.closet.ClothingItem;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public enum ClothType {
	SHORTS, DSHORTS, BELT, TSHIRT, SHIRT, JACKET, SWEATSHIRT, SWEATER, NULL;

	// overriding toString
	@Override public String toString() {
		switch (ClothingItem.getType()) {
		case SHORTS:
			return "Shorts";
		case DSHORTS:
			return "Dress Shorts";
		case BELT:
			return "Belt";
		case TSHIRT:
			return "TShirt";
		case SHIRT:
			return "Shirt";
		case JACKET:
			return "Jacket";
		case SWEATSHIRT:
			return "Sweatshirt";
		case SWEATER:
			return "Sweater";
		case NULL:
			return "Type not set.";
		default:
			return "Type not set.";
		}
	}
}
