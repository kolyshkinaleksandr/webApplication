package com.kolyshkin.quiz;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name= "Quiz", eager= true)
@SessionScoped
@SuppressWarnings("serial")
public class Test implements Serializable, Quiz {

	private int currentQuestion= 0;
	private int tries;
	private int score;
	private int mistake= 0;
	private String response;
	private String correctAnswer;
	private boolean tryAgain;
	private boolean badAnswer;

	public Test() {
		currentQuestion= 0;
		tries= 0;
		score= 0;
		mistake= 0;
		response= "";
		System.out.println("CurrentQuestion in constructor: "+currentQuestion);
	}

	public boolean isBadAnswer() {
		return badAnswer;
	}

	public void setBadAnswer(boolean badAnswer) {
		this.badAnswer = badAnswer;
	}

	public boolean isTryAgain() {
		return tryAgain;
	}

	public void setTryAgain(boolean tryAgain) {
		this.tryAgain = tryAgain;
	}

	private Question[] questions= {new Question("What trademarked slogan describes Java development? Write once, ...", "Run anywhere"),
			                       new Question("Calculate: 12 * 11= ", "132"),
			                       new Question("What was the original name of the Java programming language?", "Oak"),
			                       new Question("Is Java object oriented language? (Yes/no)", "Yes"),
			                       new Question("Which java.util class describes a point in time?", "Date"),
			                       new Question("Calculate: 5% from 100", "5"),
			                       new Question("Is String immutable or no? (Yes/no)", "Yes")};

	public String getQuestion(){
		System.out.println("currentQuestion in getQuestion(): "+currentQuestion);
		return questions[currentQuestion].getQuestion();
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getScore() {
		return score;
	}
	public int getMistake() {
		return mistake;
	}

	public void setMistake(int mistake) {
		this.mistake = mistake;
	}

	public void startOver(){
		currentQuestion= 0;
		tries= 0;
		score= 0;
		mistake= 0;
		response= "";
	}

	public String Start(){
		currentQuestion= 0;
		tries= 0;
		score= 0;
		response= "";
		return "show";
	}

	private void nextQuestion(){
		correctAnswer= questions[currentQuestion].getAnswer();
       System.out.println("Answer:  "+correctAnswer);
		currentQuestion ++;
		tries= 0;
		response= "";
		System.out.println("CurrentQuestion in nextQuestion: "+currentQuestion);
	}

	public String getNumberofQuestions(){
		int quantity= questions.length - currentQuestion;
		StringBuilder builder= new StringBuilder();
		switch (quantity) {
		case 1:
			builder.append("Last question!");
			break;

		default: builder.append(String.valueOf(quantity));
			break;
		}
		return builder.toString();
	}
	@Override
	public String Answer() {
		// TODO Auto-generated method stub
		tries ++;
		System.out.println("CurrentQuestion in answer(1): "+currentQuestion);
		if(questions[currentQuestion].isCorrect(response)){
		score++;
		nextQuestion();
		if(currentQuestion== questions.length) {
			return "done";
		} else {
			return "success";
		}
		}
		else if (tries== 1) {
			mistake ++;
			score --;
			response= "";
			tryAgain= true;
			FacesContext context= FacesContext.getCurrentInstance();
			context.addMessage("mistake: input", new FacesMessage(FacesMessage.SEVERITY_ERROR, "You have 1 chance to reply correctly!" , "Mistake!"));
			FacesContext.getCurrentInstance().addMessage("Mistake: input", new FacesMessage ("You can make only 1 mistake, be carefull!"));
			return "again";
		}
		else {
			nextQuestion();
			System.out.println("Index of question in error/done block: "+questions[currentQuestion]);
			if(currentQuestion== questions.length) {
				return "done";
			} else {
				badAnswer= true;
				return "error";
			}
		}
	}
}
