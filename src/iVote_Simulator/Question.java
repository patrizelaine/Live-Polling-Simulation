package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Interface for all types of poll questions
 */

public interface Question {
	
	// Poll question
	public String getQuestion();
	
	// Poll question choices
	public String[] getChoices();
	
	// Flag if question is a single answer question
	public boolean isSaq();
	
}

