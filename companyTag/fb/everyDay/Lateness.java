import java.util.*;

public class Lateness{


	public String maxLatenessStudent(List<List<String>> data){

		Collections.sort(data, new ListComparator());



		Map<String, Integer> dateToAve = new HashMap<>();
		setUpDateToAve(data, dateToAve);



		int maxRelLateness = 0;
		String maxRelLatenessName = "";


		Map<String, Integer> studentToRel = new HashMap<>();

		for(List<String> list : data){
			// calc the rel lateness of that student, put into map
			String studentName = list.get(1);
			int relLateness = getRelLateness(list, dateToAve);

			int updatedRelLateness = studentToRel.getOrDefault(studentName, 0) + relLateness;

			studentToRel.put(studentName, updatedRelLateness);

			if(updatedRelLateness == maxRelLateness){
				if(maxRelLatenessName.compareTo(studentName) > 0){
					maxRelLatenessName = studentName;
				}
			} else if(updatedRelLateness > maxRelLatenessName){
				maxRelLatenessName = studentName;
			}
		}

		return maxRelLatenessName;
	}

	public void setUpDateToAve(List<List<String>> data, Map<String, Integer> dateToAve){
		for(int i = 0; i < data.size(); i++){

			List<String> cur = data.get(i);

			String curDate = cur.get(0);
			
			int numOfToday = 1;

			int totalLateness = getLateness(cur);

			while(i != data.size()-1 && curDate.equals(data.get(i+1).get(0))){
				totalLateness += getLateness(data.get(i+1));
				numOfToday ++;
				i ++;	
			}

			dateToAve.put(curDate, totalLateness / numOfToday);
		}
	}


	public int getLateness(List<String> list){

		int start = Integer.valueOf(list.get(2));
		int arrive = Integer.valueOf(list.get(3));

		if(arrive < start){
			return 0;
		}

		return arrive - start;
	}

	public int getRelLateness(List<String> list, Map<String, Integer> dateToAve){
		int aveLateness = dateToAve.get(list.get(0));
		int curLateness = getLateness(list);

		if(curLateness < aveLateness){
			return 0;
		}
		return curLateness - aveLateness;
	}

	private static class ListComparator implements Comparator<List<String>>{
		@Override
		public int compare(List<String> l1, List<String> l2){
			return l1.get(0).compareTo(l2.get(0));
		}
	}


	public static void main(String[] args) {
		

	}
}
