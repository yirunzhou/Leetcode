/**

	SimpleDate
*/

import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.Arrays;  


public class SimpleDate {  

	public static void main(String[] args)throws Exception {  

	    String sDate1="31/12/1998";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);  


	    SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");

	    Date date2 = format2.parse("8-10-2001 at 20:20:20");
	    Date date3 = format2.parse("9-2-2001 at 18:00: 09");

	    Date[] dates = new Date[3];

	    dates[0] = date2;
	    dates[1] = date1;
	    dates[2] = date3;

	    Arrays.sort(dates);

	    for(Date d : dates){
	    	System.out.println(d);
	    }

	}  
}  


