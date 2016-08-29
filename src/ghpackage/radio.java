package ghpackage;
import java.util.*;

public class radio {
private String question;
private int numOfAnswers;
private List<String> answers; 
private int answerSign;

public radio(){
	question=null;
	answerSign=0;
	answers=new ArrayList<String>();
	numOfAnswers=0;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}

public int getAnswerSign(){
	return answerSign;
}
public void addAnswers(String answer){
	numOfAnswers++;
	answers.add(answer);
}//把答案加入到该数组中

public String getAnswer(){
	answerSign++;
	String s=answers.get(getAnswerSign()-1);
	
	return s;
}
public int getNumOfAnswers(){
	return numOfAnswers;
}
public void getRadioQuestion(){
	
	System.out.println("Q:"+getQuestion());
	String alphabetic[]={"A","B","C","D","E","F","G","H","I","J","k","L","M","N","O","P","Q",
			"R","S","T","U","V","W","X","Y","Z"};
	int alphabeticSign=0;
	for(String tmp:answers){
		System.out.println(alphabetic[alphabeticSign]+"."+tmp);
		alphabeticSign++;
	}
}//把题目打印在控制台上

}
