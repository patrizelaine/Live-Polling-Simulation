package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Single answer question (SAQ) poll type.
 * This class creates randomly generated answers for Student submissions to the poll.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SaqPollAnswers implements PollAnswers{
	
	private String[] studentAnswer;
	private ArrayList<String> saqPollAnswers = new ArrayList<String>();

	// Simulates student answer by shuffling potential answers and submitting the value in index 0
	public ArrayList<String> getPollAnswers(Question saq) {
		studentAnswer = saq.getChoices();									// Populates array with all potential answer choices
		List<String> saqToList = Arrays.asList(studentAnswer);				// Changes array to a List to prepare for shuffling
		Collections.shuffle(saqToList);										// Shuffles the array
		saqToList.toArray(studentAnswer);									// Returns shuffled list to array
		
		// Grabs the value from the first index of the shuffled array
		saqPollAnswers.add(studentAnswer[0]);								// Selected student answer is index 0 of the array
		return saqPollAnswers;
	}
}