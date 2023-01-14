package guneta.two.closet.Enums;

import guneta.two.closet.ClothingItem;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public enum Size {
	XS, S, M, L, XL, NULL;

	// overrides toString
	@Override public String toString() {
		switch (ClothingItem.getSize()) {
		case XS:
			return "XS";
		case S:
			return "S";
		case M:
			return "M";
		case L:
			return "L";
		case XL:
			return "XL";
		case NULL:
			return "Size not set.";
		default:
			return "Size not set.";
		}
	}
}
