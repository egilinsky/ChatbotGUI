package chatbot.component;

import java.util.Hashtable;
import java.util.List;

public class DialogueStateTable {

	public DialogueStateTable() {
		
	}
	
	public static String execute(String dialogueStateName, List<Hashtable<String, String>> slotHistory) {
		
		String response = "I am not sure. Could you say more?";
		
		switch (dialogueStateName) {
			case "ANSWER-GYM":
				response = "Let's go to the gym!";
			break;
			case "ASK-GYM":
				response = "What would you like to know about the gym? (Location, Exercises, Muscles, Time)";
			break;
			
		 	case "ANSWER-LOCATION":
	            response = "There are 3 gyms in [LOCATION]";
	        break;
	        
	        case "ASK-LOCATION":
	            response = "Where are you located?";
	        break;
			case "ANSWER-Exercise":
				response = "You need to do [EXERCISE]";
			break;
			
			case "ASK-EXERCISE-GROUP":
				response = "What exercise do you want to do?";
			break;
			
			case "ANSWER-Muscle":
				response = "You need to use [MUSCLE]";
			break;

			case "ASK-MUSCLE-GROUP":
				response = "What muscle do you want to use?";
			break;
			
			case "ANSWER-TIME":
	            response = "You need to do this exercise for [TIME]";
	        break;
	        
	        case "ASK-TIME":
	            response = "How long do you want to do this for? (Please provide the duration in minutes)";
	        break;
	        case "ANSWER-REPS":
				response = "You need to do 10-15 reps for [EXERCISE]";
			break;
			
			case "ASK-REPS":
				response = "How many reps do you want to do for [EXERCISE]";
			break;
			
			case "ANSWER-SETS":
				response = "You need to do 3-5 sets for [EXERCISE]";
			break;
			
			case "ASK-SETS":
				response = "How many sets do you want to do for [EXERCISE]";
			break;
			case "CHIT-CHAT":
				response = "What would you like to know about the gym? (Location, Exercises, Muscles, Time)";
			break;
			
			
			case "GREETING":
				response = "Hello! How can I help you?";
			break;
			
        	default:
        		System.err.println("Invalid dialogueStateName: " + dialogueStateName);
        		System.exit(1);
        		//throw new IllegalArgumentException("Invalid dialogueStateName: " + dialogueStateName);
        		
		}
		
		return response;
		
	}
	
	
	
}
