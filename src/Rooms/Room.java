package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class Room
{
	Person occupant;
	int xLoc, yLoc;
	String[] stuff = {"zombie", "poison", "drain", "zombie", "sword", "potion", "zombie", "drain", "poison", "zombie"};
	int act;

	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}

	/**
	 * Method controls the results when a person enters this room.
	 *
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("Player Status: " + x.getHealth() + " health " + x.getDamage() + " damage");
		act = (int) (Math.random() * stuff.length);
		if (stuff[act].equals("poison"))
		{
			x.loseHealth();
			if (x.getHealth() == 0)
			{
				System.out.println("You lose.");
				System.exit(1);
			}
			else
				System.out.println("There is a " + stuff[act] + " pool." + "\n" + "You have been poisoned. You have " + x.getHealth() + " health.");
		}
		else if (stuff[act].equals("drain"))
			System.out.println("There is a " + stuff[act] + " pool." + "\n" + "You have been drained. You have " + x.loseDamage() + " damage.");
		else
		{
			Scanner user = new Scanner(System.in);
			if (stuff[act].equals("zombie"))
				System.out.println("There is a " + stuff[act] + "." + "\n" + "Would you like to attack?");
			else if (stuff[act].equals("sword"))
				System.out.println("There is a " + stuff[act] + "." + "\n" + "Would you like to use the " + stuff[act] + "?");
			else if (stuff[act].equals("potion"))
				System.out.println("There is a " + stuff[act] + "." + "\n" + "Would you like to use the " + stuff[act] + "?");
			String choice = user.nextLine();
			if (choice.equals("yes"))
			{
				if (stuff[act].equals("zombie"))
				{
					if (x.getDamage() <= 0)
					{
						if (x.getHealth() == 0)
						{
							System.out.println("You lose.");
							System.exit(1);
						}
						else
							System.out.println("You lost one health. Now you have " + x.loseHealth() + " health.");
					}
					else
						System.out.println("You killed a " + stuff[act] + ".");
				}
				else if (stuff[act].equals("sword"))
					System.out.println("You received a boost. Now you have " + x.gainDamage() + " damage.");
				else if (stuff[act].equals("potion"))
					System.out.println("You received a boost. Now you have " + x.gainHealth() + " health.");
			}
			else
			{
				if (stuff[act].equals("zombie"))
				{
					if (x.getHealth() == 0)
					{
						System.out.println("You lose.");
						System.exit(1);
					}
					else
						System.out.println("You lost one health. Now you have " + x.loseHealth() + " health.");
				}
			}
		}
		Runner.gameOn();
	}
	/**
	 * Removes the player from the room.
	 * @param x
	 */
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
}