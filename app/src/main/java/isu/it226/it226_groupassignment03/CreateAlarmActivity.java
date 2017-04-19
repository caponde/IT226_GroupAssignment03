package isu.it226.it226_groupassignment03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static isu.it226.it226_groupassignment03.R.id.dateText;
import static isu.it226.it226_groupassignment03.R.id.time;

public class CreateAlarmActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_alarm);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(cal.getTime());
		
		TextView textView = (TextView) findViewById(R.id.dateText);
		textView.setText(formattedDate);
		
		sdf = new SimpleDateFormat("HH:mm");
		formattedDate = sdf.format(cal.getTime());
		
		textView = (TextView) findViewById(R.id.timeText);
		textView.setText(formattedDate);
	}
	public void createAlarm(View view)
	{
		TextView dateView = (TextView) findViewById(R.id.dateText);
		TextView timeView = (TextView) findViewById(R.id.timeText);
		TextView message = (TextView) findViewById(R.id.msgText);
		Toast.makeText(this, "Created alarm", Toast.LENGTH_SHORT).show();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date_s = dateView.getText().toString();
		String time_s = timeView.getText().toString();
		String msg = message.getText().toString();
		Date date = new Date(sdf.format(date_s + " " + time_s));
		Reminder reminder = new Reminder(date.getTime(), msg, 0);
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void exit(View view)
	{
		Toast.makeText(this, "Canceled alarm", Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
