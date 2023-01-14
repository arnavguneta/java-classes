package guneta.two.dateSwitch;

/*
APCS-A PSET 1-0
Arnav Guneta
Period 2
Johns Creek High School
8/25/17 
 */
public class Switch {

	public static void main(String[] args) {

		// intializes month, year, and days
		int month = 2;
		int year = 1804;
		int days = 0;

		// if month equals
		switch (month) {

		// january, february, march, april ... etc
		case 1:
			days = 31;
			break;
		case 2:
			// leap year
			if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
				days = 29;
			} else {
				days = 28;
			}
			break;
		case 3:
			days = 31;
			break;
		case 4:
			days = 30;
			break;
		case 5:
			days = 31;
			break;
		case 6:
			days = 30;
			break;
		case 7:
			days = 31;
			break;
		case 8:
			days = 31;
			break;
		case 9:
			days = 30;
			break;
		case 10:
			days = 31;
			break;
		case 11:
			days = 30;
			break;
		case 12:
			days = 31;
			break;
		default:
			break;
		}

		// if the number of days has been changed then the month was valid, else give an error
		if (days != 0) {
			System.out.println("Number of days = " + days);
		} else {
			System.out.println("Month does not exist.");
		}
	}

}
