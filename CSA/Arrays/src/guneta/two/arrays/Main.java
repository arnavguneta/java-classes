package guneta.two.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
APCS-A PSET 0-0
Arnav Guneta
Period 2
Johns Creek High School
8/28/17 
 */
public class Main {

	public static void main(String[] args) {

		int grades[];
		grades = new int[12];

		int grades2[] = {100, 98, 95, 92, 100, 32, 45, 89, 69, 100, 99};

		System.out.println(grades2[3]);
		System.out.println(Arrays.stream(grades2).average().getAsDouble());

		/*for (int grade : grades2) {

		}*/

	}

}
