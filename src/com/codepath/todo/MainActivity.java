package com.codepath.todo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ArrayList<TodoItem> itemList;
	private TodoItemAdapter itemAdapter;
	private ListView lvItems;
	private EditText etNewItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvItems = (ListView) findViewById(R.id.todoList);
		etNewItem = (EditText) findViewById(R.id.todoItem);
		initialize();
		
		itemAdapter = new TodoItemAdapter(this, R.layout.item, itemList);
				
//		itemAdapter = new ArrayAdapter<String>(this, R.layout.item, itemList);
//		itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
		lvItems.setAdapter(itemAdapter);
		setupListViewListener();
	}
	
	private void setupListViewListener() {
		lvItems.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				TodoItem item = (TodoItem) itemAdapter.getItem(position);
				itemAdapter.remove(item);
				itemAdapter.notifyDataSetChanged();
				return false;
			}
			
		});
	}

	public void OnAddedItem(View v) {
		String name = etNewItem.getText().toString();
		TodoItem item = new TodoItem(name);
		itemAdapter.add(item);
		etNewItem.setText("");
	}
	
	private void initialize () {
		itemList = new ArrayList<TodoItem>();
//		itemList.add("test1");
//		itemList.add("test2");		
	}	
	
//	private void loadItem() {
//		File filesDir = getFilesDir();
//		File todoFile = new File(filesDir, "todo.txt");
//		try {
//			itemList = new ArrayList<String>(FileUtils.readLines(todoFile));
//		} catch (IOException e) {
//			itemList = new ArrayList<String>();
//		}
//	}
//	
//	private void saveItem() {
//		File filesDir = getFilesDir();
//		File todoFile = new File(filesDir, "todo.txt");
//		try {
//			FileUtils.writeLines(todoFile, itemList);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.todo, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}
}
