package isu.it226.it226_groupassignment03.previousAssignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class ReminderSystem
{
	public static LinkedList<Reminder> reminders = new LinkedList<Reminder>();
	
	public static void addReminder(Reminder reminder)
	{
		if (reminders.size() > 0)
		{
			int i;
			for (i = 0; i < reminders.size(); ++i)
				if (reminders.get(i).getDate() >= reminder.getDate())
					break;
			reminders.add(i, reminder);
		}
		else
			reminders.add(reminder);
	}
	
	public static boolean isLeapYear(int year)	//If true -> add 1 to Feb.days
	{
		if (year % 4 == 0)
			if (year % 100 > 0)
				return true;
			else if (year % 400 == 0)
				return true;
		
		return false;
	}
	
	public static boolean isValidDate(int day, int month, int year, int hour, int min)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try
		{
			Date date = sdf.parse(String.format("%04d-%02d-%02d %02d:%02d", year, month + 1, day, hour, min));
			
			if (date.getTime() > (System.currentTimeMillis() / 1000) * 1000)
				return true;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return false;					//year entered is less than current year
	}
	
	public static boolean isValidTime(int hour, int minute)
	{
		int currHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int currMinute = Calendar.getInstance().get(Calendar.MINUTE);
		
		if (hour < currHour)
			return false;
		else if (hour == currHour)
			if (minute < currMinute)
				return false;
		
		return true;
	}
	
	public static boolean isEmpty()
	{
		return (reminders.size() > 0);
	}
	
	public static void removeReminder(int reminder)
	{
		reminders.remove(reminder);
	}
	
	public static void removeFirst()
	{
		reminders.removeFirst();
	}
	
	public static Reminder getFirst()
	{
		if (reminders.size() > 0)
			return reminders.getFirst();
		return null;
	}
	
	public static Reminder pop()
	{
		return reminders.pop();
	}
}