import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TimeTravel 
{
	public static void main(String[] args)
	{
		double earthT, youT, v;
		String m,d,y;
		int m1,d1,y1;
		int option;
		Scanner input = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		SimpleDateFormat year = new SimpleDateFormat("YYYY");
		m=month.format(cal.getTime());
		d=day.format(cal.getTime());
		y=year.format(cal.getTime());
		m1=Integer.parseInt(m);
		d1=Integer.parseInt(d);
		y1=Integer.parseInt(y);
		DateChange dc = new DateChange(m1,d1,y1);

		String choice;
		System.out.println("Welcome you have just entered a time machine. Sadly it is only capable of moving"
				+ " forward in time and you move forward as well and you can't go back to your own time");
		do
		{	
			System.out.print("Would you like to continue? (y/n)");
			choice = input.next();
			if(!choice.equals("y")&&!choice.equals("n"))
			{
				System.out.println("Invalid choice try again");
			}
		}while(!choice.equals("y")&&!choice.equals("n"));

		if(choice.equals("y"))
		{
			System.out.println("How would you like to time travel?");
			System.out.println("1. Give destination time and time traveled?");
			System.out.println("2. Give destination time and speed");
			System.out.println("3. Give time traveled and speed");
			System.out.print("Select one of the following options: ");
			option = input.nextInt();
			switch(option)
			{
			case 1:
				System.out.print("How many years into the future would you like to travel? ");
				earthT = input.nextDouble();
				System.out.print("How many years do you want to travel for? ");
				youT = input.nextDouble();
				System.out.println("");
				dc.setYouTime(youT);

				if(youT==0)
				{
					do
					{	
						System.out.print("You are about to travel at the speed of light, are you ready? (y/n) ");
						choice = input.next();
						if(!choice.equals("y")&&!choice.equals("n"))
						{
							System.out.println("Invalid choice try again");
						}
					}while(!choice.equals("y")&&!choice.equals("n"));
					if(choice.equals("n"))
					{
						System.out.println("Very well, good day");
						System.exit(0);
					}
					else
					{
						System.out.println("The date is currently "+m1+"/"+d1+"/"+y1+" we will now make travel "+earthT
								+" years into the future");
						do
						{	
							System.out.print("Type \"go\" whenever you are ready ");
							choice = input.next();
							if(!choice.equals("go"))
							{
								System.out.println("Invalid choice try again");
							}
						}while(!choice.equals("go"));
						dc.changeDate(earthT);
						for(int clear=0;clear<15;clear++)
						{
							System.out.println("\n");
						}
						System.out.println("We have arrived, welcome to the year "+dc.getYear()+" and the date is "
								+dc.getDate());
					}
				}
				else
				{
					dc.travelNoSpeed(earthT, youT);
					do
					{	
						System.out.print("You are about to travel at "+dc.getSpeed()+"% of the speed of light, are you ready? (y/n)");
						choice = input.next();
						if(!choice.equals("y")&&!choice.equals("n"))
						{
							System.out.println("Invalid choice try again");
						}
					}while(!choice.equals("y")&&!choice.equals("n"));
					if(choice.equals("n"))
					{
						System.out.println("Very well, good day");
						System.exit(0);
					}
					else
					{
						System.out.println("The date is currently "+m1+"/"+d1+"/"+y1+" we will now make travel "+earthT
								+" years into the future\n");
						System.out.println("We will now enter a hibernation period so the trip seems instant"
								+ " however you will age "+dc.getYouTime()+" years");
						do
						{	
							System.out.print("Are you sure you would like to continue? (y/n)");
							choice = input.next();
							if(!choice.equals("y")&&!choice.equals("n"))
							{
								System.out.println("Invalid choice try again");
							}
						}while(!choice.equals("y")&&!choice.equals("n"));
						if(choice.equals("n"))
						{
							System.out.println("Very well, good day");
							System.exit(0);
						}
						dc.changeDate(earthT);
						for(int clear=0;clear<15;clear++)
						{
							System.out.println("\n");
						}
						System.out.println("We have arrived, welcome to the year "+dc.getYear()+" and the date is "
								+dc.getDate());
					}
				}
				break;
			case 2:
				System.out.print("How many years into the future would you like to travel? ");
				earthT = input.nextDouble();
				System.out.print("What precent of the speed of light are you going (0-1) ");
				v = input.nextDouble();
				System.out.println("");
				dc.setSpeed(v);

				if(v==1)
				{
					do
					{	
						System.out.print("Your journey will be instant and you will be travel at the speed of light, "
								+ "are you ready? (y/n) ");
						choice = input.next();
						if(!choice.equals("y")&&!choice.equals("n"))
						{
							System.out.println("Invalid choice try again");
						}
					}while(!choice.equals("y")&&!choice.equals("n"));
					if(choice.equals("n"))
					{
						System.out.println("Very well, good day");
						System.exit(0);
					}
					else
					{
						System.out.println();
						System.out.println("The date is currently "+m1+"/"+d1+"/"+y1+" we will now make travel "+earthT
								+" years into the future");
						do
						{	
							System.out.print("Type \"go\" whenever you are ready ");
							choice = input.next();
							if(!choice.equals("go"))
							{
								System.out.println("Invalid choice try again");
							}
						}while(!choice.equals("go"));
						dc.changeDate(earthT);
						for(int clear=0;clear<15;clear++)
						{
							System.out.println("\n");
						}
						System.out.println("We have arrived, welcome to the year "+dc.getYear()+" and the date is "
								+dc.getDate());
					}
				}
				else
				{
					dc.travelNoYouTime(v, earthT);
					do
					{	
						System.out.print("The journey will take "+dc.getYouTime()+" years and you are about to travel at "
								+dc.getSpeed()+"% of the speed of light, are you ready? (y/n)");
						choice = input.next();
						if(!choice.equals("y")&&!choice.equals("n"))
						{
							System.out.println("Invalid choice try again");
						}
					}while(!choice.equals("y")&&!choice.equals("n"));
					if(choice.equals("n"))
					{
						System.out.println("Very well, good day");
						System.exit(0);
					}
					else
					{
						System.out.println("The date is currently "+m1+"/"+d1+"/"+y1+" we will now make travel "+earthT
								+" years into the future\n");
						System.out.println("We will now enter a hibernation period so the trip seems instant"
								+ " however you will age "+dc.getYouTime()+" years");
						do
						{	
							System.out.print("Are you sure you would like to continue? (y/n)");
							choice = input.next();
							if(!choice.equals("y")&&!choice.equals("n"))
							{
								System.out.println("Invalid choice try again");
							}
						}while(!choice.equals("y")&&!choice.equals("n"));
						if(choice.equals("n"))
						{
							System.out.println("Very well, good day");
							System.exit(0);
						}
						dc.changeDate(earthT);
						for(int clear=0;clear<15;clear++)
						{
							System.out.println("\n");
						}
						System.out.println("We have arrived, welcome to the year "+dc.getYear()+" and the date is "
								+dc.getDate());
					}
				}
				break;
			case 3:
				System.out.print("How many years would you like to travel for? ");
				youT = input.nextDouble();
				System.out.print("What precent of the speed of light are you going (0-.99999...) ");
				v = input.nextDouble();
				System.out.println("");
				dc.travelNoEarthTime(v, youT);
				do
				{	
					System.out.print("The journey will take you "+dc.getEarthTime()+" years into the future and you'll travel at "
							+v+"% of the speed of light, are you ready? (y/n)");
					choice = input.next();
					if(!choice.equals("y")&&!choice.equals("n"))
					{
						System.out.println("Invalid choice try again");
					}
				}while(!choice.equals("y")&&!choice.equals("n"));
				if(choice.equals("n"))
				{
					System.out.println("Very well, good day");
					System.exit(0);
				}
				else
				{
					System.out.println("The date is currently "+m1+"/"+d1+"/"+y1+" we will now make travel "+dc.getEarthTime()
							+" years into the future\n");
					System.out.println("We will now enter a hibernation period so the trip seems instant"
							+ " however you will age "+youT+" years");
					do
					{	
						System.out.print("Are you sure you would like to continue? (y/n)");
						choice = input.next();
						if(!choice.equals("y")&&!choice.equals("n"))
						{
							System.out.println("Invalid choice try again");
						}
					}while(!choice.equals("y")&&!choice.equals("n"));
					if(choice.equals("n"))
					{
						System.out.println("Very well, good day");
						System.exit(0);
					}
					dc.changeDate(dc.getEarthTime());
					for(int clear=0;clear<15;clear++)
					{
						System.out.println("\n");
					}
					System.out.println("We have arrived, welcome to the year "+dc.getYear()+" and the date is "
							+dc.getDate());
				}
			}
		}
		else if(choice.equals("n"))
		{
			System.out.println("Very well, good day");
			System.exit(0);
		}

	}

}
