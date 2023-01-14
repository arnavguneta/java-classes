package guneta.two.arrays;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
8/29/17 
 */
public class ObjArrays {

	public static void main(String[] args) {

		Widget w = new Widget();

		System.out.println(w.toString());

		Widget inventory[] = new Widget[5];
		inventory[0] = w;
		inventory[1] = new Widget();

	}
}
