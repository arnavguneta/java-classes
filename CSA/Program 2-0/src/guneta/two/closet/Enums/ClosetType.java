package guneta.two.closet.Enums;

import guneta.two.closet.Closet;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
9/24/17 
 */
public enum ClosetType {
	WALKIN, BUILTIN, NULL;

	// overrides toString
	@Override public String toString() {
		switch (Closet.getType()) {
		case WALKIN:
			return "Walk in closet";
		case BUILTIN:
			return "Built into the wall";
		case NULL:
			return "Type not set.";
		default:
			return "Type not set.";
		}
	}
}
