import java.util.ArrayList;
import java.util.Random;

public class Story {	//Dummy Story Class
	private static ArrayList<String> questions = new ArrayList<>();
	private static ArrayList<String> answers = new ArrayList<>();
	private static ArrayList<Integer> nextQuestion = new ArrayList<>();
	private static final int NUMBEROFQUESTIONS = 2;
	
	private Story() {
	}
	
	public static String getQuestion(int questionPos) {
		return questions.get(questionPos);
	}
	
	public static void setQuestions(String question) {
		questions.add(question);
	}
	
	public static String getAnswer(int AnswerPos) {
		return answers.get(AnswerPos);
	}
	
	public static void setAnswers(String answer) {
		answers.add(answer);
	}
	
	public static ArrayList<Integer> getNextQuestion() {
		return nextQuestion;
	}
	
	private static int findQuestion() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(NUMBEROFQUESTIONS);
	}
	
	private static int findAnswer(int n) {
		return n + 2*n;
	}
	
	public static void updateNextQuestion() {
		int q = findQuestion();
		int a = findAnswer(q);
		nextQuestion.clear();
		nextQuestion.add(q);
		nextQuestion.add(a);
		nextQuestion.add(a + 1);
		nextQuestion.add(a + 2);
	}
	
	public static void fillQuestionsAnswers() {
		setQuestions("Τι χρώμα ρούχα θα διαλέξεις? ");	//Need to decide how to import the data!
		setQuestions("Τι θα φροντίσεις να πάρεις μαζί σου?");
		setAnswers("Γαλάζιο");
		setAnswers("Πράσινο");
		setAnswers("Κόκκινο");
		setAnswers("Κατσαρίδες");
		setAnswers("Μύγες");
		setAnswers("Μπανάνες");
	}
}
