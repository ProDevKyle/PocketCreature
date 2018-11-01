package Rooms;

import People.Person;

public class Room
{
	Person occupant;
	int xLoc,yLoc;
	String[] stuff = {"sword", "shield", "health potion"};
	int act;

	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}
	/**
	 * Method controls the results when a person enters this room.
	 * @param x the Person entering
	 */
	public void enterRoom(Person x)
	{
		System.out.println("You enter a plain old room.");
		System.out.println("You have " + x.getHealth() + " health " + x.getDamage() + " damage " + x.getProtection() + " shield.");
		act = (int)(Math.random()*stuff.length);
		System.out.println("There is a " + stuff[act] + "\n" + "What would you like to do?");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
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
