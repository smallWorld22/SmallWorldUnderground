package playBoard;

import java.util.Random;

public class Die
{
	private int numberOfSides = 6;
	private int result;
	Random diceThrower = new Random();
	
	public Die() {
	}
	
	public Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public int getNumberOfSides() {
		return numberOfSides;
	}
	public void setNumberOfSides(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}

	public void throwDie()
	{
		result = diceThrower.nextInt(numberOfSides) + 1;
		if(result == 1 || result == 2 || result == 3)
		{
			result = 0;
		}
		else if(result == 4)
		{
			result = 1;
		}
		else if(result == 5)
		{
			result = 2;
		}
		else
		{
			result = 3;
		}
	}

}
