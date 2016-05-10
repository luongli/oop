package li.com;
import java.io.Serializable;
public class Date implements Serializable {
	public static final String Jan = "Jan";
	public static final String Feb = "Feb";
	public static final String Mar = "Mar";
	public static final String Apr = "Apr";
	public static final String May = "May";
	public static final String June = "June";
	public static final String July = "July";
	public static final String Aug = "Aug";
	public static final String Sept = "Sept";
	public static final String Oct = "Oct";
	public static final String Nov = "Nov";
	public static final String Dec = "Dec";
	
	private int day;
	private int month;
	private int year;
	// days in each month
	private static final int[] daysPerMonth =
		{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	// constructor using number
	public Date(int day, int month, int year){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	// constructor using abbreviation for month
	public Date(String month, int day, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	// getter for day
	public int getDay() {
		return day;
	}
	
	// setter for day
	public void setDay(int day) {
		if(checkDay(day)){
			this.day = day;
		}else{
			throw new IllegalArgumentException(
					"day out-of-range for the specified month and year" );
		}
	}
	
	// getter for month
	public int getMonth() {
		return month;
	}
	
	// setter for month
	public void setMonth(int month) {
		if(month > 0 && month < 13)
			this.month = month;
		else
			throw new IllegalArgumentException(
					"day out-of-range for the specified month and year" );
	}
	
	// set a month using abbreviation string
	public void setMonth(String month) {
		switch(month){
		case Date.Jan: setMonth(1); break;
		case Date.Feb: setMonth(2); break;
		case Date.Mar: setMonth(3); break;
		case Date.Apr: setMonth(4); break;
		case Date.May: setMonth(5); break;
		case Date.June: setMonth(6); break;
		case Date.July: setMonth(7); break;
		case Date.Aug: setMonth(8); break;
		case Date.Sept: setMonth(9); break;
		case Date.Oct: setMonth(10); break;
		case Date.Nov: setMonth(11); break;
		case Date.Dec: setMonth(12); break;
		default: 
			throw new IllegalArgumentException(
					"day out-of-range for the specified month and year" );
		}
	}
	
	// getter for year
	public int getYear() {
		return year;
	}
	
	// setter for year
	public void setYear(int year) {
		this.year = year;
	}
	
	private boolean checkDay(int testDay) {
		// check if day in range for month
		if (testDay > 0 && testDay <= daysPerMonth[month])
			return true;
		// check for leap year
		if (month == 2 && testDay == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			return true;
		return false;
	} // end method checkDay
	
	@Override
	public String toString(){
		return day + "/" + month + "/" + year;
	}
}
