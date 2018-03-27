package com.kolyshkin.quiz;

public class Question {

	private String question;
	private String answer;

    public Question(String question, String answer) {
    	this.question= question;
    	this.answer= answer;
	}
	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public boolean isCorrect(String response){
		return response.trim().equalsIgnoreCase(answer);
	}
}
