package abilities;

import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Jeroen Zandvliet
 */
public class Magic extends Ability
{

	public Magic()
	{
		amountOfTokens = 5;
		name = "Magic";
		traitText = "Copy 1 relic that's currently in play for the entire turn.";
	}

	@Override
	public void processAbility(Player selfPlayer, Map map) {
		this.selfPlayer = selfPlayer;
		this.map = map;
	}
}
