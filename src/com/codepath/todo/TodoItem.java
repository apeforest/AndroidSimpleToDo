package com.codepath.todo;

public class TodoItem {
	String _name;
	boolean _isDone;
	
	public TodoItem(String name) {
		// TODO Auto-generated constructor stub
		_name = name;
		_isDone = false;
	}
	
	public String getName() {
		return _name;
	}
	
	public boolean isDone() {
		return _isDone;
	}
}
