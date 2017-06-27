package races;

import playBoard.Map;
import player.Player;
/**
 * Deze klasse is verantwoordelijk voor het bijhouden van gegevens en de ability van het ras.
 * @author Jeroen Zandvliet
 */
public class Monster extends Race
{
	public Monster()
	{
		amountOfTokens = 2;
		maxTokens = 14;
		name = "Monsters";
		traitText = "When conquered, take a special event thingie thing thing";
	}

	@Override
	public void processAbility(Player selfPlayer, Map map) {
		// TODO Auto-generated method stub

	}
}
