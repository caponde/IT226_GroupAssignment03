package isu.it226.it226_groupassignment03.previousAssignment;

public enum Month
{
	JANUARY(31), FEBUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(
		30), DECEMBER(31);
	
	int days;
	
	Month(int days)
	{
		this.days = days;
	}
	
	public int getDays()
	{
		return days;
	}
}