package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Multiple answer question (MAQ) poll type.
 * This class creates randomly generated answers for Student submissions to the poll.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaqPollAnswers implements PollAnswers{
	
	private String[] studentAnswer;
	private ArrayList<String> maqPollAnswers = new ArrayList<String>();

	// Simulates student answer by shuffling potential answers and selecting a random number of answers
	public ArrayList<String> getPollAnswers(Question maq) {
		studentAnswer = maq.getChoices();										// Populates array with all potential answer choices
		List<String> maqToList = Arrays.asList(studentAnswer);					// Changes array to a List to prepare for shuffling
		Collections.shuffle(maqToList);											// Shuffles the array
		maqToList.toArray(studentAnswer);										// Returns shuffled list to array
		
		// Randomly generate a number of options to be chosen by Student
		int numOfMaqChoices = (int)(Math.random() * (5) + 1);
		for(int i=0; i<numOfMaqChoices; i++)									// Loops through shuffled array
		{
			maqPollAnswers.add(studentAnswer[i]);								// Selected student answer are the first numOfMaqChoices of the shuffled array
		}
		return maqPollAnswers;
	}	
}