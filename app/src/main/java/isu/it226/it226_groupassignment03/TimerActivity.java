package isu.it226.it226_groupassignment03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TimerActivity extends AppCompatActivity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
	}
	
	public void exit(View view)
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
