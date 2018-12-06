

public class Interval{

	int start;
	int end;

	String encode;

	public Interval(int s, int e){
		start = s;
		end = e;

		encode = String.format("%d-%d", start, end);
	}


	/**
		10AM - 11：30AM  
		11：00AM to 1PM 怎么存。

	*/

	public Interval(String input){

		// validate

		// process

		String[] data = null;

		if(input.indexOf("-") != -1){

			data = input.split("-");

		} else if(input.indexOf("to") != -1){

			data = input.split("to");

		}

		this.start = getTime(data[0]);

		this.end = getTime(data[1]);

		
		// check invalid start, end


		encode = String.format("%d-%d", start, end);

	}

	public void print(){

		System.out.println(encode);

	}

	private static final String[] ams = {"am", "AM", "Am", "aM"};

	private static final String[] pms = {"pm", "PM", "Pm", "pM"};


	// return the hour*60 + minute
	private int getTime(String s){
		/**
		10AM 
		11：00AM
		1PM 
		*/

		// validate


		s = s.trim();

		int hour = 0;

		int minute = 0;

		if(s.indexOf(":") == -1){

			hour = getNumeric(s);

		} else {

			String[] data = s.split(":");

			hour = getNumeric(data[0]);

			minute = getNumeric(data[1]);

		}

		
		boolean isAm = true;

		for(String am : ams){

			if(s.indexOf(am) != -1){
				isAm = true;
				break;
			}

		}

		for(String pm : pms){

			if(s.indexOf(pm) != -1){
				isAm = false;
				break;
			}

		}

		if(!isAm){
			if(hour < 12){
				hour += 12;
			} else if(hour > 12){
				throw new IllegalArgumentException("Invalid Hours");
			}
		}



		return hour*60 + minute;

	}


	private int getNumeric(String s){

		s = s.trim();

		int result = 0;

		for(char c : s.toCharArray()){

			if(Character.isDigit(c)){
				result = result*10 + c-'0';
			} else {
				break;
			}

		}

		return result;

	}
	


	public static void main(String[] args) {
		

		Interval i = new Interval(" 10:10 PM - 2:20 pm");

		i.print();

	}

}


