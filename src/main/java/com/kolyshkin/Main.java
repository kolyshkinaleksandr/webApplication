package com.kolyshkin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@SessionScoped
@ManagedBean(name= "mBean",eager= true)
public class Main implements Serializable{
	private int id;
    private String userName;
    private String email;
    private String password;
    private Timestamp timeStamp;
    private Part file;

	private boolean isEnglish= true;
    private boolean isUkrainian= true;
    private static final Locale ENGLISH= new Locale("En");
    private static final Locale UKRAINIAN= new Locale("Ua");
    private static final Locale DEUTSCH= new Locale("De");
    private Locale locale= ENGLISH;
    private String language= locale.getLanguage();
    private static final Map<String, String> languagesMap= new LinkedHashMap<>();

    public Main(){}

	static{
    	languagesMap.put("English", "En");
    	languagesMap.put("Українська", "Ua");
    	languagesMap.put("Deutsch", "De");
    }

	public void swapLocale(ActionEvent action){
		isEnglish= !isEnglish;
		isUkrainian= !isUkrainian;
		if(isEnglish){
			locale= ENGLISH;
		}else if(isUkrainian){
			locale= UKRAINIAN;
		}else {
			locale= DEUTSCH;
		}
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Timestamp getTimeStamp() {
	return timeStamp;
}

public void setTimeStamp(Timestamp timeStamp) {
	this.timeStamp = timeStamp;
}

public Part getFile() {
    return file;
}

public void setFile(Part file) {
    this.file = file;
}
public Locale getLocale() {
	return locale;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
	locale= new Locale(language);
}

public Map<String, String> getLanguages() {
	return languagesMap;
}

public boolean isUkrainian() {
	return isUkrainian;
}

public void setUkrainian(boolean isUkrainian) {
	this.isUkrainian = isUkrainian;
}

public ArrayList<Main> getAllUsers(){
	return Logic.getUserList();
}
public String checkUser(String name, String password, Main check){
	return Logic.checkUser(name, password, check);
}
public String insertUser(Main newUser){
	return Logic.insertNewData(newUser);
}
public String addUser(Main newUser){
	return Logic.insertNewUser(newUser);
}
public String editUser(int userId){
	return Logic.editUserRecord(userId);
}
public String updateUser(Main newUser){
	return Logic.updateUserRecord(newUser);
}
public String deleteUser(int userId){
	return Logic.deleteUser(userId);
}

public String signUp(){
	return "signUp";
}
public String logIn(){
	return "logIn";
}

}
