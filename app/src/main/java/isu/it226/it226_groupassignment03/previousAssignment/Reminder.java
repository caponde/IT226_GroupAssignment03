package isu.it226.it226_groupassignment03.previousAssignment;

import java.util.Date;

public class Reminder
{
	private long date;		// Date (in milliseconds) when reminder will trigger the alarm
	private String msg;		// Message to be reminded of
	private int snoozeNum;
	
	//================================ CONSTRUCTORS ================================
	
	public Reminder(long date, String msg)
	{
		this.date = date;
		this.msg = msg;
		
		snoozeNum = 0;
	}
	
	public Reminder(long date, String msg, int snoozeNum)
	{
		this.date = date;
		this.msg = msg;
		this.snoozeNum = snoozeNum;
	}
	
	//================================== METHODS ===================================
	
	public boolean check()
	{
		if (date <= System.currentTimeMillis())
			return true;
		
		return false;
	}
	
	public String toString()
	{
		return new Date(date).toString();
	}
	
	//==================================== GETS ====================================
	
	public int getSnoozeNum()
	{
		return snoozeNum;
	}
	
	public long getDate()
	{
		return date;
	}
	
	public String getMsg()
	{
		return msg;
	}
	
	//==================================== SETS ====================================
	
	public void setSnoozeNum(int snoozeNum)
	{
		this.snoozeNum = snoozeNum;
	}
	
	public void setDate(long date)
	{
		this.date = date;
	}
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}