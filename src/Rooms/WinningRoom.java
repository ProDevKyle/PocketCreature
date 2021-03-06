package Rooms;

import Game.Runner;
import People.Person;

public class WinningRoom extends Room
{
	int itemLocx1 = -1;
	int itemLocy1 = -1;
	int itemLocx2 = -1;
	int itemLocy2 = -1;
	int itemLocx3 = -1;
	int itemLocy3 = -1;

	public WinningRoom(int x, int y)
	{
		super(x,y);
	}
	/**
	 * Triggers the game ending conditions.
	 * @param x the Person entering
	 */
	@Override
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		if(Runner.total == 0)
		{
			if(itemLocx1 != x.getxLoc() && itemLocy1 != x.getyLoc())
			{
				itemLocx1 = x.getxLoc();
				itemLocy1 = x.getyLoc();
				Runner.total++;
				System.out.println("You found a legendary item! There are 2 more legendary items to find!");
			}
			else
				System.out.println("You entered this legendary item room already. Go find the other legendary item(s).");
		}
		else if(Runner.total == 1)
		{
			if(itemLocx1 != x.getxLoc() && itemLocy1 != x.getyLoc())
			{
				itemLocx2 = x.getxLoc();
				itemLocy2 = x.getyLoc();
				Runner.total++;
				System.out.println("You found another legendary item! There is 1 more legendary item to find!");
			}
			else
				System.out.println("You entered this legendary item room already. Go find the other legendary item(s).");
		}
		else
		{
			if(itemLocx1 != x.getxLoc() && itemLocy1 != x.getyLoc() && itemLocx2 != x.getxLoc() && itemLocy2 != x.getyLoc())
			{
				itemLocx3 = x.getxLoc();
				itemLocy3 = x.getyLoc();
				Runner.total++;
				System.out.println("You found all 3 legendary item! Congrats!");
				Runner.gameOff();
				System.exit(1);
			}
		}
		Runner.gameOn();
	}
}