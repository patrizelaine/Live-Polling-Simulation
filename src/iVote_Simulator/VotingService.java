package iVote_Simulator;

/*
 * Patriz Elaine Daroy
 * CS3650.01 A1
 * 
 * Voting Service that hosts poll questions and generates poll results
 */

public class VotingService {
	
	// Single answer question choices
	private int y, n = 0;
	
	// Multiple answer question choices
	private int a, b, c, d, e = 0;
	
	// Loops through the students to submit answers to the poll
	public void generateStudentResponses(Student[] students, int numPollers, Question q)
	{
		System.out.println("INDIVIDUAL STUDENT RESPONSES");
		
		// Results of initial submission
		for(int i=0; i<numPollers; i++)
		{
			students[i].answerPoll(q);
			System.out.println("Student ID: " + students[i].getId() + " | Answer: " + students[i].getPollResponse());
		}
		
		// Results of any duplicate submissions
		int duplicateSubmissions = (int)(Math.random() * (numPollers) + 0);			// Randomly chooses number of students who submitted more than once
		for(int i=0; i<duplicateSubmissions; i++)									// Loops through number of duplicates
		{
			int studentOfDoubleSub = (int)(Math.random() * (numPollers-1) + 0);		// Randomly chooses the index of a Student who has submitted a duplicate response
			students[studentOfDoubleSub].answerPoll(q);								// Student answers the poll
			System.out.println("Resubmission -- Student ID: " + students[studentOfDoubleSub].getId() + " | Answer: " + students[studentOfDoubleSub].getPollResponse());
		}
		
		// Generates responses based on question type
		if(q.isSaq()) {
			finalSaqResult(students, numPollers);
		}
		else {
			finalMaqResult(students, numPollers);
		}
	}
	
	// Loops through SAQ poll results
	public void finalSaqResult(Student[] students, int numPollers)
	{
		for(int i=0; i<numPollers; i++) {
			if(students[i].getPollResponse().get(0).equals("Yes")) {
				y++;
			}
			if(students[i].getPollResponse().get(0).equals("No")) {
				n++;
			}
		}
	}

	// Loops through MAQ poll results
	public void finalMaqResult(Student[] students, int numPollers) {
		for(int i=0; i<numPollers; i++) {
			for(int j=0; j<students[i].getPollResponse().size(); j++)
			{
				if(students[i].getPollResponse().get(j).equals("Chocolate"))
				{
					a++;
				}
				if(students[i].getPollResponse().get(j).equals("Vanilla"))
				{
					b++;
				}
				if(students[i].getPollResponse().get(j).equals("Strawberry"))
				{
					c++;
				}
				if(students[i].getPollResponse().get(j).equals("Cookie Dough"))
				{
					d++;
				}
				if(students[i].getPollResponse().get(j).equals("Cheesecake"))
				{
					e++;
				}
			}
		}
	}
	
	// Displays results of SAQ poll
	public void displaySaqResults()
	{
		System.out.println("\nPOLL RESULTS");
		System.out.println("Yes: " + y);
		System.out.println("No: " + n);
	}
	
	// Displays results of MAQ poll
	public void displayMaqResults()
	{
		System.out.println("\nPOLL RESULTS");
		System.out.println("Chocolate: " + a);
		System.out.println("Vanilla: " + b);
		System.out.println("Strawberry: " + c);
		System.out.println("Cookie Dough: " + d);
		System.out.println("Cheesecake: " + e);
	}
}