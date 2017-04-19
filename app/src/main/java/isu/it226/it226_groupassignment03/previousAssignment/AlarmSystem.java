package isu.it226.it226_groupassignment03.previousAssignment;

import java.util.LinkedList;

import isu.it226.it226_groupassignment03.previousAssignment.Alarm;

public class AlarmSystem implements Runnable
{
	private boolean running = true;
	
	private final int frameCap = 100;
	
	private static LinkedList<Alarm> alarms;
	
	@Override
	public void run()
	{
		alarms = new LinkedList<Alarm>();
		
		while (running)
		{
			if (ReminderSystem.isEmpty())
			{
				if (ReminderSystem.getFirst().check())
				{
					Reminder rmdr = ReminderSystem.pop();
					//if (MainFrame.getReminderList().getItemCount() > 0)
					//    MainFrame.getReminderList().remove(0);
					alarms.add(new Alarm(rmdr.getDate(), rmdr.getMsg(), rmdr.getSnoozeNum()));
				}
			}
			
			if (alarms.size() > 0)
				if (alarms.getFirst().isMarkedForDeath())
					alarms.pop();
			
			try
			{
				Thread.sleep(frameCap);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void stop()
	{
		running = false;
	}
}