package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Single answer questions (SAQ) poll questions
 */

public class SingleAnswerQuestion implements Question{
	
	private String saqQuestion;
	private String[] saqChoices;
	
	public SingleAnswerQuestion(String saqQuestion, String[] saqChoices)
	{
		this.saqQuestion = saqQuestion;
		this.saqChoices = saqChoices;
	}

	public String getQuestion() {
		return saqQuestion;
	}

	public String[] getChoices() {
		return saqChoices;
	}

	public boolean isSaq() {
		return true;
	}
}
