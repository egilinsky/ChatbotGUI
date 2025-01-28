package chatbot.infra;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import chatbot.component.DialogueManager;
import chatbot.component.DomainClassifier;
import chatbot.component.GymIntentClassifier;
import chatbot.component.SlotFiller;
import chatbot.component.WeatherIntentClassifier;

public class Chatbot {
	
	private String userName = "YOUR NAME HERE";
	private String botName = "BOT NAME HERE";
	private DomainClassifier nowDomainClassifier;
	private WeatherIntentClassifier weatherIntentClassifier;
	private GymIntentClassifier gymIntentClassifier;
	private SlotFiller nowSlotFiller;
	private DialogueManager nowDialogueManager;
	
	
	public Chatbot(String userName, String botName) {
		
		this.userName = userName;
		this.botName = botName;
		
		this.nowDomainClassifier = new DomainClassifier();
		this.weatherIntentClassifier = new WeatherIntentClassifier();
		this.gymIntentClassifier = new GymIntentClassifier();
		
		this.nowSlotFiller = new SlotFiller();
		
		this.nowDialogueManager = new DialogueManager();
		
	}
	
	/*
	 * Task 3: Add a response in Chatbot.java to respond to user message
	 * 
	 * Please modify the getResponse() method in the Chatbot class to respond
	 * to three or more different user messages meaningfully. I provided one
	 * example in the getResponse().
	 */
	
	public String getResponse(String nowInputText) {

	    System.out.println("--------------");
	    System.out.println("User Message: "+nowInputText);
	    String nowDomain = nowDomainClassifier.getLabel(nowInputText);
	    System.out.println("Domain: "+nowDomain);
	    String nowIntent = "";
	    
	    Hashtable<String, String> extractedSlotValues = nowSlotFiller.extractSlotValues(nowInputText);
	    
	    if(!nowDomain.equals("Other")) {//in-domain message
	    	if(nowDomain.equals("Gym")) {//Food domain
	        	nowIntent = gymIntentClassifier.getLabel(nowInputText);
	        //}else if(nowDomain.equals("Weather")) {//Weather domain
	        	//nowIntent = weatherIntentClassifier.getLabel(nowInputText);
	        }else {//this shouldn't happen
	        	System.err.println("Domain name is incorrect!");
	        	System.exit(1);
	        	return null;
	        }
	    }else {//out-of-domain message.
	        //return "This message is out of the domains of the chatbot.";
	    }
	    
	    System.out.println("Intent: "+nowIntent);
	    String nowLoggingData = "Domain = "+nowDomain+"; Intent = "+nowIntent;
	    nowLoggingData += slotTableToString(extractedSlotValues);
	    System.out.println(nowLoggingData);
	    
	    String nextState = nowDialogueManager.getNextState(nowDomain, nowIntent, extractedSlotValues);
	    System.out.println("nextState: "+nextState);
	    String nowResponse = nowDialogueManager.executeStateAndGetResponse(nextState);
	    System.out.println("nowResponse: "+nowResponse);
	    
	    return nowResponse;
	    
	}
	
	/*
	 * Method slotTableToString() is added for Assignment 1-3
	 * 
	 * [Input]
	 * A Hashtable returned by extractSlotValues() in
	 * SlotFiller.java
	 * 
	 * [Output]
	 * A string that list all the extracted slot values
	 * 
	 */
	private String slotTableToString(Hashtable<String, String> extractedSlotValues) {
	    String result = " (";		
	    for(String nowKey: extractedSlotValues.keySet()) {
	        String nowValue = extractedSlotValues.get(nowKey);
	        System.out.println(nowKey+"="+nowValue);
	        result += nowKey+"="+nowValue+"; ";
	    }
	    result += ")";
	    return result;	
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBotName() {
		return botName;
	}

	public void setBotName(String botName) {
		this.botName = botName;
	}
}
