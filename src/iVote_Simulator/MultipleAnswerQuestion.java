package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Multiple answer questions (MAQ) poll questions
 */

public class MultipleAnswerQuestion implements Question{
	
	private String maqQuestion;
	private String[] maqChoices;
	
	public MultipleAnswerQuestion(String saqQuestion, String[] saqChoices)
	{
		this.maqQuestion = saqQuestion;
		this.maqChoices = saqChoices;
	}

	public String getQuestion() {
		return maqQuestion;
	}

	public String[] getChoices() {
		return maqChoices;
	}

	public boolean isSaq() {
		return false;
	}
}
