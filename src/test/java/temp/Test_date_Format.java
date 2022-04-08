package temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_date_Format {

	public static void main(String[] args) {
		Date d= new Date();
		System.out.println(d.toString());
		String Select_date = "12-04-2020";
		System.out.println(Select_date);
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date tobeselected = sf.parse(Select_date);
			String day = new SimpleDateFormat("dd").format(tobeselected);
			System.out.println(day);
			
			String month = new SimpleDateFormat("MMMM").format(tobeselected);
			System.out.println(month);
			
			String year = new SimpleDateFormat("yyyy").format(tobeselected);
			System.out.println(year);
			
			System.out.println(day +"   " +month +"   "+year);
		} catch (ParseException e) {	
			e.printStackTrace();
		}
		

	}

}
