package abilities;

import player.Player;

public class Reborn extends Ability
{
	public Reborn()
	{
		amountOfTokens = 5;
		type = "Reborn";
		traitText = "When in decline, can replace 1 or 2 regions with a single new active race token";
	}

	@Override
	public void calculateAbility(Player activePlayer) {
		// TODO Auto-generated method stub

	}
}
