



import java.util.*;

public class DateTransfer{


	/**
		June 3th 2014 9:32:24
		
	*/

	private static Map<String, Integer> monthMap = new HashMap<>();

	public DateTransfer(){

		monthMap.put("Jan.", 1);
		monthMap.put("Feb.", 2);
		monthMap.put("Mar.", 3);
		monthMap.put("Apr.", 4);

	}


	public Date stod(String input){

		Date output = null;

		try{

			// "Jan. 3th 2014 22:18:02"

			String[] data = input.split(" ");

			Integer month = monthMap.get(data[0]);

			int year = Integer.valueOf(data[2]);

			int day = getDay(data[1]);

			// process time 

			String time = data[3];

			String[] hms = time.split(":");

			int hour = Integer.valueOf(hms[0]);

			int minute = Integer.valueOf(hms[1]);

			int second = Integer.valueOf(hms[2]);

			// processing PM or AM

			if(data.length > 4){

				String aOrP = data[4];

				if(aOrP.equals("PM") || aOrP.equals("P.M.") || aOrP.equals("pm")){

					if(hour < 12){
						hour += 12;
					} else if(hour > 12){
						throw new IllegalArgumentException("Invalid input time, PM");
					}

				}

			}

			if(month == null || 
				day > 31 || hour >= 24 || minute >= 60 || second >= 60){

				throw new IllegalArgumentException("Invalid input time");

			}
			
			output = new Date(year, month, day, hour, minute, second);

		} catch(Exception e){

			System.out.println("CATCH!!!");
			System.out.println(e.getMessage());

		}

		return output;
		
	}


	private int getDay(String day){

		int result = 0;

		for(char c : day.toCharArray()){

			if(Character.isDigit(c)){
				result = result*10 + (c-'0');
			} else {
				break;
			}

		}

		return result;

	}


	public void printDate(Date d){
		if(d == null){
			return;
		}
		System.out.println(d.encode);
	}

	public static void main(String[] args) {

		String[] input = new String[5];

		input[0] = "Jan. 3th 2014 11:18:02 PM";

     	input[1] = "Mar. 3th 2014 11:18:02 PM";

		input[2] = "Jan. 13th 2014 11:18:02 PM";

		input[3] = "Jan. 3th 2004 11:18:02 PM";

		input[4] = "Jan. 3th 2014 12:00:00 PM";

		List<Date> dates = new ArrayList<>();

		DateTransfer dt = new DateTransfer();


		for(int i = 0; i < input.length; i ++){

			dates.add(dt.stod(input[i]));

		}

		dt.sort(dates);

		for(Date d: dates){
			dt.printDate(d);
		}


	}


	private class Date{

		public int year;

		public int day;

		public int month;

		public int hour;

		public int minute;

		public int second;

		public String encode;

		public Date(int y, int m, int d, int h, int min, int s){

			year = y;

			month = m;

			day = d;

			hour = h;

			minute = min;

			second = s;

			encode = String.format("%04d, %02d, %02d, %02d:%02d:%02d", 
				year, month, day, hour, minute, second);
		}

	}

	private void sort(List<Date> list){
		Collections.sort(list, new DateComparator());
	}

	private class DateComparator implements Comparator<Date>{

		@Override
		public int compare(Date d1, Date d2){
			return d1.encode.compareTo(d2.encode);
		}

	}



}