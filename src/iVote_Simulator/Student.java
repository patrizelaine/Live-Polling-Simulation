package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Student class that holds a Student ID and Student poll responses
 */

import java.util.ArrayList;

public class Student {
	
	private int id;
	
	// Holds the student's poll answer
	private ArrayList<String> finalPollAnswer = new ArrayList<String>();
	
	// Student constructor
	public Student(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public ArrayList<String> getPollResponse()
	{
		return finalPollAnswer;
	}
	
	// Provides answer poll questions to the Student based on question type
	public void answerPoll(Question q)
	{		
		if(q.isSaq())
		{
			PollAnswers saqPollAnswers = new SaqPollAnswers();
			finalPollAnswer = saqPollAnswers.getPollAnswers(q);			// Assigns final student's SAQ poll answer to Student
		}
		else
		{
			PollAnswers maqPollAnswers = new MaqPollAnswers();
			finalPollAnswer = maqPollAnswers.getPollAnswers(q);			// Assigns final student's MAQ poll answer to Student
		}	
	}
}