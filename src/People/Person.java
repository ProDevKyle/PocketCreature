package People;
/**
 * Person represents the player as they move through the game.
 */

public class Person
{
	String firstName;
	String familyName;
	int xLoc, yLoc;
	int health = 3;
	int damage = 1;

	public int getxLoc()
	{
		return xLoc;
	}
	public void setxLoc(int xLoc)
	{
		this.xLoc = xLoc;
	}
	public int getyLoc()
	{
		return yLoc;
	}
	public int getHealth()
	{
		return health;
	}
	public int gainHealth()
	{
		health = health + 1;
		return health;
	}
	public int loseHealth()
	{
		health = health - 1;
		return health;
	}
	public int getDamage()
	{
		return damage;
	}
	public int gainDamage()
	{
		damage = damage + 1;
		return damage;
	}
	public int loseDamage()
	{
		damage = damage - 1;
		return damage;
	}
	public void setyLoc(int yLoc)
	{
		this.yLoc = yLoc;
	}
	public Person(String firstName, String familyName, int xLoc, int yLoc)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
}