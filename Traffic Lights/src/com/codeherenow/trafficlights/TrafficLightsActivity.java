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

package com.codeherenow.trafficlights;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class TrafficLightsActivity extends Activity implements OnClickListener {
	
	private ImageView redLight;
	private ImageView yellowLight;
	private ImageView greenLight;

	private Button redButton;
	private Button yellowButton;
	private Button greenButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.traffic_lights);
		
		redLight = (ImageView) findViewById(R.id.red_light);
		yellowLight = (ImageView) findViewById(R.id.yellow_light);
		greenLight = (ImageView) findViewById(R.id.green_light);
		
		redButton = (Button) findViewById(R.id.red_button);
		yellowButton = (Button) findViewById(R.id.yellow_button);
		greenButton = (Button) findViewById(R.id.green_button);
		
		redButton.setOnClickListener(this);
		yellowButton.setOnClickListener(this);
		greenButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		turnLightOff();
		if(v == redButton) {
			turnOnRedLight();
		} else if (v == yellowButton) {
			turnOnYellowLight();
		} else if (v == greenButton) {
			turnOnGreenLight();
		}
	}

	private void turnOnGreenLight() {
		// TODO Auto-generated method stub
		greenLight.setImageResource(R.drawable.green_on);
	}

	private void turnOnYellowLight() {
		// TODO Auto-generated method stub
		yellowLight.setImageResource(R.drawable.yellow_on);
	}

	private void turnOnRedLight() {
		// TODO Auto-generated method stub
		redLight.setImageResource(R.drawable.red_on);
	}
	
	private void turnLightOff() {
		yellowLight.setImageResource(R.drawable.light_off);
		redLight.setImageResource(R.drawable.light_off);
		greenLight.setImageResource(R.drawable.light_off);
	}

}
