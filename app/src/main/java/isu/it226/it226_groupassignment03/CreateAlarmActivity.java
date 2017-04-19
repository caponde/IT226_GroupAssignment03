package isu.it226.it226_groupassignment03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
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
	EditText editTime;
	EditText editDate;
	boolean validTime = false;
	boolean validDate = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_alarm);
		
		editTime = (EditText) findViewById(R.id.timeText);
		editTime.addTextChangedListener(new TextWatcher()
		{
			int length = 0;
			
			@Override public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				String str = editTime.getText().toString();
				length = str.length();
			}
			
			@Override public void onTextChanged(CharSequence s, int start, int before, int count)
			{
			}
			
			@Override public void afterTextChanged(Editable s)
			{
				String str = editTime.getText().toString();
				if (str.length() == 2 && length < str.length())
					editTime.append(":");
				
				if(s.length() == 5)
				{
					TextView invalidTime = (TextView) findViewById(R.id.timeError);
					if(!isValidTime(str))
					{
						invalidTime.setVisibility(View.VISIBLE);
						validTime = false;
					}
					else
					{
						invalidTime.setVisibility(View.GONE);
						validTime = true;
					}
				}
			}
		});
		editTime.setOnKeyListener(new View.OnKeyListener()
		{
			@Override public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				String str = editTime.getText().toString();
				if(keyCode == KeyEvent.KEYCODE_DEL && str.length() == 3)
				{
					str = str.substring(0);
					editTime.setText(str);
				}
					
				return false;
			}
		});
		
		editDate = (EditText) findViewById(R.id.dateText);
		editDate.addTextChangedListener(new TextWatcher()
		{
			int length = 0;
			
			@Override public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				String str = editDate.getText().toString();
				length = str.length();
			}
			
			@Override public void onTextChanged(CharSequence s, int start, int before, int count)
			{
			}
			
			@Override public void afterTextChanged(Editable s)
			{
				String str = editDate.getText().toString();
				if((str.length() == 2 || str.length() == 5) && length < str.length())
					editDate.append("/");
				
				if(s.length() == 10)
				{
					TextView invalidDate = (TextView) findViewById(R.id.dateError);
					if(!isValidDate(str))
					{
						invalidDate.setVisibility(View.VISIBLE);
						validDate = false;
					}
					else
					{
						invalidDate.setVisibility(View.GONE);
						validDate = true;
					}
				}
			}
		});
	}
	
	public void createAlarm(View view)
	{
		if(validTime && validDate)
		{
//			TextView dateView = (TextView) findViewById(R.id.dateText);
//			TextView timeView = (TextView) findViewById(R.id.timeText);
//			TextView message = (TextView) findViewById(R.id.msgText);
			Toast.makeText(this, "Created alarm", Toast.LENGTH_SHORT).show();
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//			String date_s = dateView.getText().toString();
//			String time_s = timeView.getText().toString();
//			String msg = message.getText().toString();
//			Date date = new Date(sdf.format(date_s + " " + time_s));
//			Reminder reminder = new Reminder(date.getTime(), msg, 0);
//
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
		else
		{
			Toast.makeText(this, "Cannot create alarm", Toast.LENGTH_SHORT).show();
			Toast.makeText(this, "Time is: " + String.valueOf(validTime), Toast.LENGTH_SHORT).show();
			Toast.makeText(this, "Date is: " + String.valueOf(validDate), Toast.LENGTH_SHORT).show();
		}
	}
	
	public void exit(View view)
	{
		Toast.makeText(this, "Canceled alarm", Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	private boolean isValidTime(String time)
	{
		try
		{
			int hour = Integer.parseInt(time.substring(0, 2));
			int min = Integer.parseInt(time.substring(3, time.length()));
			
			if(hour > 23 || min > 59)
				return false;
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
		
		return true;
	}
	
	private boolean isValidDate(String date)
	{
		try
		{
			String day = date.substring(0, 2);
			String month = date.substring(3, 5);
			String year = date.substring(6, date.length());
			
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			
			if(cal.getTime().getTime() < Calendar.getInstance().getTime().getTime())
				return false;
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
		
		return true;
	}
}
