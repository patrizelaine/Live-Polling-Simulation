package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Driver class to trigger the Vote Simulation
 */


public class SimulationDriver {
	
	private final static int NUM_POLLERS = 10;							// Number of Students
	private static Student[] students = new Student[NUM_POLLERS];		// Array of Students being polled
	private static Question saQuestion, maQuestion;						// SAQ and MAQ poll question
	private static int questionType;			
	
	public static void main(String[] args)
	{
		// Creating poll question types and answer choices
		saQuestion = createSaq();
		maQuestion = createMaq();
		
		// Generating students and respective IDs
		generateStudentList();
		
		// Creating new instance of the Voting Service
		VotingService votingService = new VotingService();
		
		// Opens polling submissions for students and displays results
		acceptStudentResponses(votingService);
		
		// Displays polling results (individual and summary report)
		displayStudentResponses(votingService);		
	}
	
	public static Question createSaq() {
		String saqQuestion = "Are you a Computer Science major?";
		String[] saqChoices = {"Yes", "No"};
		SingleAnswerQuestion saq = new SingleAnswerQuestion(saqQuestion, saqChoices);
		return saq;
	}
	
	public static Question createMaq() {
		String maqQuestion = "What are your favorite ice cream flavors?";
		String[] maqChoices = {"Chocolate", "Vanilla", "Strawberry", "Cookie Dough", "Cheesecake"};
		MultipleAnswerQuestion maq = new MultipleAnswerQuestion(maqQuestion, maqChoices);
		return maq;
	}
	
	// Generates IDs for total number of Students being polled
	public static Student[] generateStudentList()
	{
		for(int i=0; i<NUM_POLLERS; i++)
		{
			students[i] = new Student(i+100);
		}
		return students;
	}
	
	// Asks host for type of poll question and generates the Student responses
	public static void acceptStudentResponses(VotingService vs)
	{
		questionType = (int)(Math.random() * (2) + 1);		// Randomly chooses a question type 1 (SAQ) or type 2 (MAQ)

		if(questionType == 1)	// Single answer questions
		{			
			System.out.println("SINGLE ANSWER QUESTION: " + saQuestion.getQuestion() + "\n"); 
			vs.generateStudentResponses(students, NUM_POLLERS, saQuestion);		// Polls SAQ question against Students
		}
					
		if(questionType == 2)	// Multiple answer questions
		{	
			System.out.println("MULTIPLE ANSWER QUESTION: " + maQuestion.getQuestion() + "\n");
			vs.generateStudentResponses(students, NUM_POLLERS, maQuestion);		// Polls MAQ question against Students
		}
	}
	
	public static void displayStudentResponses(VotingService vs)
	{
		if(questionType==1) {
			vs.displaySaqResults();
		}
		else {
			vs.displayMaqResults();
		}
	}
}