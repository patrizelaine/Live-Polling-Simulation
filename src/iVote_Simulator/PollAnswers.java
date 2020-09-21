package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Interface to hold all types of poll answers
 */

import java.util.ArrayList;

public interface PollAnswers {
	
	public ArrayList<String> getPollAnswers(Question question);
	
}

