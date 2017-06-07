package controllers;

import java.util.Scanner;

import main.Ammy;
import playBoard.Map;
import player.Player;

public class TerrainsController
{
	private int terrainCounter;
	private Player activePlayer;
	private Map map;
	private int elementCounter = 0;
	private int terrain = 0;
	private int value = 0;
	private boolean validChoice;
	private int areaPicked;
	private int returnedTokens;
	Scanner input = new Scanner(System.in);

	public TerrainsController(Ammy ammy)
	{
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();
	}

	public void checkIfAttackable()
	{
		while(validChoice == false)														//As long as a valid choice has not been picked
		{
			areaPicked = input.nextInt() - 1;										//Let the player pick an area to attack
			input.nextLine();
			if(areaPicked >= map.getAllTerrains().size() || areaPicked < 0		//If an invalid area is chosen (number too big
					|| map.getTerrain(areaPicked).getIsAttackable() == false)		//or isn't currently attackable)
			{
				System.out.println("A: Nope, that one isn't on the list! Please pick a different one.");
			}
			else
			{
				validChoice = true;
			}
		}
	}

	public void checkIfReinforcable()
	{
		while(validChoice == false)														//As long as a valid choice has not been picked
		{
			areaPicked = input.nextInt() - 1;										//Let the player pick an area to attack
			input.nextLine();
			if(areaPicked >= map.getAllTerrains().size() || areaPicked < 0		//If an invalid area is chosen (number too big
					|| map.getTerrain(areaPicked).getIsReinforcable() == false)		//or isn't currently attackable)
			{
				System.out.println("A: Nope, that one isn't on the list! Please pick a different one.");
			}
			else
			{
				validChoice = true;
			}
		}
	}

	public void setAllAdjacentAreas(Player activePlayer)
	{
		setNotAdjacent();
		System.out.println("A: Setting all adjacent terrains for " + activePlayer.getName() + "\n");
		this.activePlayer = activePlayer;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace())) //For every land that's the current player's
			{
				changeAllAdjacentAreas(map.getTerrain(terrainCounter).getElement(0));
			}
		}
	}

	private void changeAllAdjacentAreas(int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)	//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getElement(value) == code)
				{
					map.getTerrain(terrain).setIsAdjacent(true);			//If the idCode is found, set isAttackable to true
				}
				value++;											//Look at the next value in the terrain's array, "eye"
				elementCounter++;									//Keep track of which number in the array we're at
			}
			value = 0;												//"Eye" back at number 0 in the array
			elementCounter = 0;										//Back at number 0 in a fresh terrain
			terrainCounter++;										//Keep track of which terrain we're at
			terrain++;												//Look at the next terrain, "eye"
		}
	}



	public void setAllAttackableAreas(Player activePlayer)
	{
		setNotAttackable();
		System.out.println("A: Setting all attackable terrains for " + activePlayer.getName() + "\n");
		this.activePlayer = activePlayer;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				changeAllAttackableAreas(map.getTerrain(terrainCounter).getElement(0));
			}
		}
	}

	private void changeAllAttackableAreas(int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)	//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getElement(value) == code && !map.getTerrain(terrain).getRace().equals(
						activePlayer.getActiveSet().getRace()))
				{
					map.getTerrain(terrain).setIsAttackable(true);			//If the idCode is found, set isAttackable to true
				}
				value++;											//Look at the next value in the terrain's array, "eye"
				elementCounter++;									//Keep track of which number in the array we're at
			}
			value = 0;												//"Eye" back at number 0 in the array
			elementCounter = 0;										//Back at number 0 in a fresh terrain
			terrainCounter++;										//Keep track of which terrain we're at
			terrain++;												//Look at the next terrain, "eye"
		}
	}

	public void setAllReinforcableAreas(Player activePlayer)
	{
		setNotReinforcable();
		System.out.println("A: Setting all reinforcable terrains for " + activePlayer.getName() + "\n");
		this.activePlayer = activePlayer;
		for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
			{
				changeAllReinforcableAreas(map.getTerrain(terrainCounter).getElement(0));
			}
		}

	}

	private void changeAllReinforcableAreas(int code)
	{
		terrainCounter = 0;
		elementCounter = 0;
		terrain = 0;
		value = 0;

		while(terrainCounter<map.getAllTerrains().size())				//While there's still terrains left
		{
			while(elementCounter<map.getTerrain(terrain).getIdArray().length)	//While there's still numbers in the terrain's array
			{
				if(map.getTerrain(terrain).getElement(value) == code && map.getTerrain(terrain).getRace().equals(
						activePlayer.getActiveSet().getRace()))
				{
					map.getTerrain(terrain).setIsReinforcable(true);			//If the idCode is found, set isAttackable to true
				}
				value++;											//Look at the next value in the terrain's array, "eye"
				elementCounter++;									//Keep track of which number in the array we're at
			}
			value = 0;												//"Eye" back at number 0 in the array
			elementCounter = 0;										//Back at number 0 in a fresh terrain
			terrainCounter++;										//Keep track of which terrain we're at
			terrain++;												//Look at the next terrain, "eye"
		}
	}


	public void setNotAdjacent()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setIsAdjacent(false);		//Set it to false
		}
	}

	public void setNotAttackable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setIsAttackable(false);		//Set it to false
		}
	}

	public void setNotReinforcable()					//Set all the "isAttackable" booleans to false again
	{
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)				//As long as there are terrains
		{
			map.getTerrain(terrainCounter).setIsReinforcable(false);		//Set it to false
		}
	}

	public void calculateReturnedTokens()
	{
		returnedTokens = 0;
		for(terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
		{
			if(map.getTerrain(terrainCounter).getIsReinforcable() == true)						//If isAttackable is true
			{
				this.returnedTokens = returnedTokens + map.getTerrain(terrainCounter).getAmountOfTokens() - 1;
				map.getTerrain(terrainCounter).setToOne();
			}
		}
	}




	public int getReturnedTokens() {
		return returnedTokens;
	}

	public void setReturnedTokens(int returnedTokens) {
		this.returnedTokens = returnedTokens;
	}

	public int getAreaPicked() {
		return areaPicked;
	}

	public void setAreaPicked(int areaPicked) {
		this.areaPicked = areaPicked;
	}
}