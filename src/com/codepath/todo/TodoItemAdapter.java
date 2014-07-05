package com.codepath.todo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class TodoItemAdapter extends ArrayAdapter<TodoItem> {
	
	public TodoItemAdapter(Context context, int resource, ArrayList<TodoItem> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
		}
		
		TodoItem item = getItem(position);
		TextView name = (TextView) convertView.findViewById(R.id.name);
		CheckBox status = (CheckBox) convertView.findViewById(R.id.done);
		
		name.setText(item.getName());
		status.setChecked(item.isDone());
		
		return convertView;
	}
}
