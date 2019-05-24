import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Story {	//Dummy Story Class
	private static String question;
	private static JSONArray level_question_set;
	private static ArrayList<String> answers;
	private static final int NUMBEROFQUESTIONS = 1;
	
	private Story() {
		
	}
	
	public static void get_level_Questions(int level) {
		JSONParser parser = new JSONParser();
		try {     
			Object obj = parser.parse(new FileReader("C:\\Users\\Orestes\\Desktop\\questions.json"));
	
			JSONObject json_questions = (JSONObject) obj;

			JSONArray questions = (JSONArray) json_questions.get("level_"+level);
			
			level_question_set=questions;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
	
	public static void findQuestion(int level) {
		Random randomGenerator = new Random();
		int random_int= randomGenerator.nextInt(NUMBEROFQUESTIONS);
		get_level_Questions(level);
		System.out.println(level_question_set.get(random_int));
		HashMap<String, ArrayList<String>> question_and_ans_struct = (HashMap) level_question_set.get(random_int);
		
		question = (String) question_and_ans_struct.keySet().toArray()[0];
		answers = (ArrayList<String>) question_and_ans_struct.get(question);
	}
	
	public static String getQuestion() {
		return question;
	}
	
	public static ArrayList<String> getAnswers() {
		return answers;
	}
	
	public static String get_right_answer() {
		return answers.get(0);
	}
}
