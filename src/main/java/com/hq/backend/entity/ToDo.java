package com.hq.backend.entity;

public class ToDo {
	
	long id;
	String text;
	boolean isDone;
	
	public ToDo(long id, String text, boolean isDone) {
		super();
		this.id = id;
		this.text = text;
		this.isDone = isDone;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}	

}
