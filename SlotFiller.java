/*
 * SlotFiller.java is added for Assignment 1-3 (Language Understanding)
 */

package chatbot.component;

import java.util.Hashtable;

public class SlotFiller {

	/*
	 * Task 1: Build the Slot Filler (extractSlotValues() in SlotFiller.java)
	 * 
	 * [Input] 
	 * One user message (e.g., "What's the weather in State College?")
	 * 
	 * [Output]
	 * A hash table that contains a set of (key, value) tuples, where the "key"
	 * is the name of the slot (e.g., "location") and "value" is the extracted
	 * value (e.g., "State College").
	 * 
	 */
	public Hashtable<String, String> extractSlotValues(String nowInputText) {
		
		//initialize the hash table. You do not need to change this line of code.
		Hashtable<String, String> result = new Hashtable<String, String>();
		
		//-------------- Modify Code Here (Assignment 1-3) Begins ---------------
		
		//modify the following code to implement your own slot extractor
		/*String[] dayOfWeekList = new String[] {"FRIDAY", "MONDAY", "SATURDAY", "SUNDAY", "THURSDAY", "TUESDAY", "WEDNESDAY"};
		for(String nowDayOfWeek: dayOfWeekList) {
			if(nowInputText.toUpperCase().contains(nowDayOfWeek)) {
				//adding value to the result hash table
				result.put("DayOfWeek", nowDayOfWeek);
			}
		}
		
		//modify the following code to implement your own slot extractor
		String[] relativeDateList = new String[] {"TODAY", "TOMORROW", "YESTERDAY"};
		for(String nowRelativeDate: relativeDateList) {
			if(nowInputText.toUpperCase().contains(nowRelativeDate)) {
				//adding value to the result hash table
				result.put("RelativeDate", nowRelativeDate);
			}
		}
		
		String[] cityName = new String[] {"STATE COLLEGE", "NEW YORK CITY", "TOKYO", "LOS ANGELOS", "PARIS", "CHICAGO", "NEW ORLEANS"};
		for(String thisCity: cityName) {
			if(nowInputText.toUpperCase().contains(thisCity)) {
				//adding value to the result hash table
				result.put("City", thisCity);
			}
		}
		
		String[] timeOfDay = new String[] {"12:00PM", "1:00PM", "2:00PM", "3:00PM", "4:00PM", "5:00PM", "6:00PM"};
		for(String thisTime: timeOfDay) {
			if(nowInputText.toUpperCase().contains(thisTime)) {
				//adding value to the result hash table
				result.put("Time", thisTime);
			}
		}
		*/
		String[] gymGroupList = new String[] {"GYM"};
		for(String nowGymGroup: gymGroupList) {
			if(nowInputText.toUpperCase().contains(nowGymGroup)) {
				//adding value to the result hash table
				result.put("Type of Gym", nowGymGroup);
			}
		}
		String[] muscleGroupList = new String[] {"BICEP", "TRICEP", "HAMSTRING", "GLUTE"};
		for(String nowMuscleGroup: muscleGroupList) {
			if(nowInputText.toUpperCase().contains(nowMuscleGroup)) {
				//adding value to the result hash table
				result.put("Type of Muscle", nowMuscleGroup);
			}
		}
		
		String[] exerciseList = new String[] {"CURL", "OVERHEAD", "SQUAT", "LEG"};
		for(String nowExerciseList: exerciseList) {
			if(nowInputText.toUpperCase().contains(nowExerciseList)) {
				//adding value to the result hash table
				result.put("Type of Exercise", nowExerciseList);
			}
		}
		
		String[] timeList = new String[] {"SECOND", "MINUTE", "HOUR"};
		for(String nowTimeList: timeList) {
			if(nowInputText.toUpperCase().contains(nowTimeList)) {
				//adding value to the result hash table
				result.put("Type of Time", nowTimeList);
			}
		}
		
		String[] locationGroupList = new String[] {"PENN STATE", "STATE COLLEGE", "NEW YORK CITY", "TOKYO"};
		for(String nowLocationGroup: locationGroupList) {
			if(nowInputText.toUpperCase().contains(nowLocationGroup)) {
				//adding value to the result hash table
				result.put("Type of Location", nowLocationGroup);
			}
		}
		
		String[] repsGroupList = new String[] {"REPS"};
		for(String nowRepsGroup: repsGroupList) {
			if(nowInputText.toUpperCase().contains(nowRepsGroup)) {
				//adding value to the result hash table
				result.put("Type of Reps", nowRepsGroup);
			}
		}
		
		String[] setsGroupList = new String[] {"SETS"};
		for(String nowSetsGroup: setsGroupList) {
			if(nowInputText.toUpperCase().contains(nowSetsGroup)) {
				//adding value to the result hash table
				result.put("Type of Sets", nowSetsGroup);
			}
		}
		//-------------- Modify Code Here (Assignment 1-3) Ends ---------------
		
		//return the result hash table. You do not need to change this part of code.
		return result;
		
	}

}
