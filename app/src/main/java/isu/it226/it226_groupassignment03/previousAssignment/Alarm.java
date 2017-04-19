package isu.it226.it226_groupassignment03.previousAssignment;

import java.io.File;
import java.util.Date;

public class Alarm
{
	private long alarmTime; // Time alarm was started
	private String msg;     // Message displayed on alarm
	private int snoozeNum;  // Number of times alarm has been snoozed
	private boolean markedForDeath;
	
	Thread soundLoopThread;
	
	private Runnable soundLoop = new Runnable()
	{
		public void run()
		{
			while (!markedForDeath)
			{
				try
				{
					try
					{
						Thread.sleep(500);
						Thread.sleep(500);
					}
					catch (Exception e)
					{
						System.out.println("Failed to play sound");
						Thread.sleep(1000);
					}
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	};
	
	//================================ CONSTRUCTORS ================================
	
	public Alarm(long alarmTime, String msg)
	{
		this.alarmTime = alarmTime;
		this.msg = msg;
		this.snoozeNum = 0;
		
		soundLoopThread = new Thread(soundLoop);
		soundLoopThread.start();
		
		this.markedForDeath = false;
	}
	
	public Alarm(long alarmTime, String msg, int snoozeNum)
	{
		this.alarmTime = alarmTime;
		this.msg = msg;
		this.snoozeNum = snoozeNum;
		
		soundLoopThread = new Thread(soundLoop);
		soundLoopThread.start();
		
		this.markedForDeath = false;
	}
	
	//================================== METHODS  ==================================
	
	public void snooze()
	{
		ReminderSystem.addReminder(new Reminder(System.currentTimeMillis() + 60000, msg, ++snoozeNum));
		dismiss();
	}
	
	public void dismiss()
	{
		try
		{
			markedForDeath = true;
			soundLoopThread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	//==================================== GETS ====================================
	
	public int getSnoozeNum()
	{
		return snoozeNum;
	}
	
	public boolean isMarkedForDeath()
	{
		return markedForDeath;
	}
	
	public String getMsg()
	{
		return msg;
	}
	
	public long getAlarmTime()
	{
		return alarmTime;
	}
	
	//==================================== SETS ====================================
	
	public void setSnoozeNum(int snoozeNum)
	{
		this.snoozeNum = snoozeNum;
	}
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
	public void setAlarmTime(long alarmTime)
	{
		this.alarmTime = alarmTime;
	}
}