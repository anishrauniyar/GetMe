package org.getme.project;

import org.getme.project.dbConnection.SQLiteHelper;

import android.support.v7.app.ActionBarActivity;
import android.database.sqlite.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	SQLiteHelper sqliteHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sqliteHelper = new SQLiteHelper(MainActivity.this);
		
		final Button register = (Button) findViewById(R.id.register);
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_register);
				final Button submit = (Button) findViewById(R.id.button1);
				submit.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String firstname = findViewById(R.id.editText1).toString();
						String fn = v.
						String lastname = findViewById(R.id.editText2).toString();
						String email = findViewById(R.id.editText3).toString();
						String username = findViewById(R.id.editText4).toString();
						String password = findViewById(R.id.editText5).toString();
						String confirmPassword = findViewById(R.id.editText6).toString();
						System.out.println("The username is: " + username);
					}
				});
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
