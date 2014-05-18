/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.codeherenow.sicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SICalculatorActivity extends Activity implements OnClickListener, OnSeekBarChangeListener {
	
	private Button button_calculate;
	
	private EditText text_principal;
	private EditText text_interest;
	
	private TextView text_term;
	private TextView text_results;
	
	private SeekBar bar_term;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sicalculator);
		
		button_calculate = (Button) findViewById(R.id.button_calculate);
		text_principal = (EditText) findViewById(R.id.box_principal);
		text_interest = (EditText) findViewById(R.id.box_interest);
		text_term = (TextView) findViewById(R.id.text_term);
		text_results = (TextView) findViewById(R.id.text_results);
		bar_term = (SeekBar) findViewById(R.id.bar_term);
		
		text_results.setText("");
		text_term.setText("0 Year(s)");
		
		button_calculate.setOnClickListener(this);
		bar_term.setOnSeekBarChangeListener(this);
		
	}
	
	public double calculateInterest(double principal, double interest, double term) {
		return (principal*interest/100*term);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		double result;
		double principal;
		double interest;
		double term;
		
		if (v == button_calculate) {
			principal = Double.parseDouble(text_principal.getText().toString());
			interest = Double.parseDouble(text_interest.getText().toString());
			term = (double) (bar_term.getProgress());
			
			result = calculateInterest(principal, interest, term);
			
			text_results.setText("The interest for $" + String.format("%.0f", principal) + 
								" at a rate of " + String.format("%.2f", interest) + "% " +
								"for " + String.format("%.0f", term) + " years is $" + String.format("%.2f", result));
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		text_term.setText(String.valueOf(progress) + " " + " Year(s)");
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		text_term.setText("onStartTrackingTouch");
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		if (seekBar == bar_term) {
			text_term.setText(String.valueOf(bar_term.getProgress()) + " Year(s)");
		}		
	}

}

