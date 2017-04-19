package isu.it226.it226_groupassignment03.previousAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import isu.it226.it226_groupassignment03.Reminder;

public class FileIO
{
	private static Scanner scanner = null;
	
	public static boolean load(String filename)
	{
		try
		{
			scanner = new Scanner(new File(filename));
			if (scanner.hasNextLine())
			{
				scanner.nextLine();
				
				while (scanner.hasNextLine())
				{
					String vals = scanner.nextLine();
					int splitPoint = vals.indexOf(',');
					
					String date = vals.substring(0, splitPoint);
					String msg = vals.substring(splitPoint + 2, vals.length() - 1);
					
					try
					{
						isu.it226.it226_groupassignment03.previousAssignment.Reminder reminder = new isu.it226.it226_groupassignment03.previousAssignment.Reminder(Long.parseLong(date), msg);
						ReminderSystem.addReminder(reminder);
						//if (reminder.getMsg().length() > 0)
						//    MainFrame.addReminder(reminder.getMsg());
						//else
						//    MainFrame.addReminder(new Date(reminder.getDate()).toString());
					}
					catch (NumberFormatException e)
					{
						System.out.println("Format not readable");
					}
				}
			}
			
			scanner.close();
			scanner = null;
			
			return true;
		}
		catch (FileNotFoundException e)
		{
		}
		
		return false;
	}
	
	public static boolean save(LinkedList<Reminder> reminder)
	{
		try
		{
			FileWriter fw = new FileWriter("alarmData.csv", false);
			fw.append("Alarm Date,Alarm Message\n");
			for (isu.it226.it226_groupassignment03.previousAssignment.Reminder r : ReminderSystem.reminders)
				fw.append(r.getDate() + ",\"" + r.getMsg() + "\"\n");
			
			fw.close();
			
			return true;
		}
		catch (IOException e)
		{
			System.out.println("Failed to save file");
		}
		return false;
	}
}