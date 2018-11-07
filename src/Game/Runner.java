package Game;

import People.Person;
import Rooms.Room;
import Rooms.WinningRoom;

import java.awt.*;
import java.util.Scanner;

public class Runner
{
	private static boolean gameOn = false;
	public static int total = 0;

	public static void main(String[] args)
	{
		//Fill the building with normal rooms
		Room[][] building = new Room[5][5];
		for(int x = 0; x < building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}
		//Create three random legendary item rooms
		int a = (int)(Math.random()*building.length);
		while (a == 0)
			a = (int)(Math.random()*building.length);
		int b = (int)(Math.random()*building.length);
		while (b == 0)
			b = (int)(Math.random()*building.length);
		building[a][b] = new WinningRoom(a,b);
		int c = (int)(Math.random()*building.length);
		while (c == a)
			c = (int)(Math.random()*building.length);
		int d = (int)(Math.random()*building.length);
		while (d == b)
			d = (int)(Math.random()*building.length);
		building[c][d] = new WinningRoom(c,d);
		int e = (int)(Math.random()*building.length);
		while (e == a || e == c)
			e = (int)(Math.random()*building.length);
		int f = (int)(Math.random()*building.length);
		while (f == b || f == d)
			f = (int)(Math.random()*building.length);
		building[e][f] = new WinningRoom(e,f);
		//Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0,0);
		building[0][0].enterRoom(player1);
		for(int x = 0; x < building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
				if(x == 0 && y == 0)
					System.out.print("[*]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}
		System.out.println("* is you on the board.");
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				for(int x = 0; x < building.length; x++)
				{
					for (int y = 0; y < building[x].length; y++)
					{
						building[x][y] = new Room(x,y);
						if(x == player1.getxLoc() && y == player1.getyLoc())
							System.out.print("[*]");
						else
							System.out.print("[ ]");
					}
					System.out.println();
				}
			}
			else
				System.out.println("Please choose a valid move.");
		}
	}
	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch(move)
		{
			case "n":
				if(p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if(p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "s":
				if(p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "w":
				if(p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
		}
		return true;
	}
	public static void gameOn()
	{
		gameOn = true;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
}