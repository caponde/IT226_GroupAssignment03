package isu.it226.it226_groupassignment03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void createAlarm(View view)
	{
		Intent intent = new Intent(this, CreateAlarmActivity.class);
		startActivity(intent);
	}
}
