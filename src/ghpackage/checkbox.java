package ghpackage;

import java.util.ArrayList;
import java.util.List;

public class checkbox {
	private String question;
	private int answerSign;
	private List<String> answers;
	private int numOfAnswers;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public void addAnswers(String answer){
		numOfAnswers++;
		answers.add(answer);
	}//把答案加入到该数组中
	public checkbox() {
		super();
		question=null;
		answerSign=0;
		answers=new ArrayList<String>();
		numOfAnswers=0;
	}
	public int getAnswerSign(){
		return answerSign;
	}
	public String getAnswer(){
		answerSign++;
		return answers.get(getAnswerSign()-1);
	}
	public int getNumOfAnswers(){
		return numOfAnswers;
	}
	
		
}
