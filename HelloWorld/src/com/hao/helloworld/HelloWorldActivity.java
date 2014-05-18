package com.hao.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {

	private TextView title;
	private TextView summary;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hello_world);
		
		title = (TextView) findViewById(R.id.title);
		summary = (TextView) findViewById(R.id.summary);
		
		Resources resource = getResources();
		String applesSummary = resource.getString(R.string.apples_summary, 5, 24.449);
		
		summary.setText(applesSummary);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_world, menu);
		return true;
	}

}
