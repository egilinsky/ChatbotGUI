package chatbot.component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class DialogueManager {
	
	private List<String> dialogueStateHistory;
	
	private List<String> domainHistory;
	private List<String> intentHistory;
	private List<Hashtable<String, String>> slotHistory;
	
	public DialogueManager() {
		
		this.dialogueStateHistory = new ArrayList<String>();
		dialogueStateHistory.add("START-STATE");
		
		this.domainHistory = new ArrayList<String>();
		domainHistory.add("StartDomain");
		
		this.intentHistory = new ArrayList<String>();
		intentHistory.add("StartIntent");
		
		this.slotHistory = new ArrayList<Hashtable<String, String>>();
		slotHistory.add(new Hashtable<String, String>());
		
		
	}
	
	public String getNextState(String nowDomain, String nowIntent, Hashtable<String, String> extractedSlotValues) {
		
		System.out.println("------------ Dialogue Management Log ---------------------");
		System.out.println("Dialogue State BEFORE Message: "+dialogueStateHistory.get(dialogueStateHistory.size()-1));
		
		//keep track of domain, intent, slot values
		domainHistory.add(nowDomain);
		//System.out.println("Size of domainHistory: "+domainHistory.size());
		
		if(nowIntent==null||nowIntent.length()==0) {
			intentHistory.add("Other");
		}else {
			intentHistory.add(nowIntent);
		}
		//System.out.println("Size of intentHistory: "+intentHistory.size());
		//}
		
		slotHistory.add(extractedSlotValues);
		//System.out.println("Size of slotHistory: "+slotHistory.size());
		
		String nowNextStateLabel = calculateNextState(); 
		dialogueStateHistory.add(nowNextStateLabel);
		//System.out.println("Size of dialogueStateHistory: "+dialogueStateHistory.size());
		
		String latestState = dialogueStateHistory.get(dialogueStateHistory.size()-1);
		//System.out.println("Dialogue State AFTER Message: "+latestState);
		
		return latestState;
		
	}

	/*
	 * Task: Use all the information (including dialogueStateHistory, domainHistory,
	 * intentHistory, and slotHistory) to decide the next dialogue state.  
	 * 
	 */
	private String calculateNextState() {
		
		String latestState = dialogueStateHistory.get(dialogueStateHistory.size()-1);
		
		
		String latestIntent = intentHistory.get(intentHistory.size()-1);
		//String latestDomain = domainHistory.get(domainHistory.size()-1);
		
		
		String latestNonNullIntent = getLatestNonNullIntent();
		//System.out.println("latestNonNullIntent: "+latestNonNullIntent);
				
		switch (latestNonNullIntent) {
			case "gym":
				if(hasSlotValue("Type of Gym")) {
					return "ASK-GYM";
				}else {
					return "ASK-GYM";
				}
			
			case "exercise":
				if(hasSlotValue("Type of Muscle")) {
					return "ANSWER-Exercise";
				}else {
					return "ASK-MUSCLE-GROUP";
				}
			//break;
			
			case "muscle":
				if(hasSlotValue("Type of Exercise")) {
					return "ANSWER-Muscle";
				}else {
					return "ASK-EXERCISE-GROUP";
				}
				
			case "location":
				if(hasSlotValue("Type of Location")) {
					return "ANSWER-LOCATION";
				}else {
					return "ASK-LOCATION";
				}
				
			case "time":
				if(hasSlotValue("Type of Time")) {
					if(hasSlotValue("Type of Exercise")) {
						return "ANSWER-TIME";
					}else {
						return "ASK-EXERCISE-GROUP";
					}
					
				}else {
					return "ASK-TIME";
				}
			case "reps":
				if(hasSlotValue("Type of Reps")) {
					return "ANSWER-REPS";
				}else {
					return "ASK-REPS";
				}
			case "sets":
				if(hasSlotValue("Type of Sets")) {
					return "ANSWER-SETS";
				}else {
					return "ASK-SETS";
				}
			//break;
			
			case "Other":
				return "What would you like to know about the gym? (Location, Exercises, Muscles, Time, Reps, Sets)";
		
			case "StartIntent":
				if(dialogueStateHistory.size()>1) {
					return "CHIT-CHAT";
				}
				return "GREETING";
			
			default:
				System.err.println("Invalid latestNonNullIntent: " + latestNonNullIntent);
				System.exit(1);
		}
		
		return null;
		
	}

	private boolean hasSlotValue(String key) {
		for(Hashtable<String, String> nowSlotValues: slotHistory) {
			if(nowSlotValues.get(key)!=null) {
				if(nowSlotValues.get(key).length()>0) {
					return true;
				}
			}
		}
//		System.out.println("FALSE");
		return false;
	}

	private String getLatestNonNullIntent() {
		
		for(int i=intentHistory.size()-1;i>=0;i--) {
			if(intentHistory.get(i)!=null&&!intentHistory.get(i).equals("Other")) {
				return intentHistory.get(i);
			}
		
		}
		
		return "Other";
	}

	public String executeStateAndGetResponse(String nextState) {
		return DialogueStateTable.execute(nextState, slotHistory);
	}
	
	
	
	
	

}

