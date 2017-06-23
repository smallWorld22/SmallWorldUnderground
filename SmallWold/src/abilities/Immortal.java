package abilities;

import main.Ammy;
import playBoard.Map;
import player.Player;
/**
 * Klasse die de ability bijhoudt met bijbehorende effecten.
 * @author Marinus van den Oever
 */
public class Immortal extends Ability implements CalculatableIncome
{
	Map map;
	private int returnTokens;

	public Immortal()
	{
		amountOfTokens = 4;
		name = "Immortal";
		traitText = "Keep all conquered tokens in your hand to redeploy at the end of the turn.";
	}

	/**
	 * Zorgt ervoor dat het ras geen verliezen lijdt, maar alle tokens terugkrijgt na een verlies.
	 */
	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
		this.map = ammy.getMap();

			for(int terrainCounter=0;terrainCounter<map.getTerrains().size();terrainCounter++)		//As long as there are terrains
			{
				if (activePlayer.getActiveSet().getRace().equals(map.getTerrains().get(terrainCounter).getRace()))
				{
					returnTokens = returnTokens + map.getTerrains().get(terrainCounter).getAmountOfTokens();
					activePlayer.getHand().setCurrentTokens(activePlayer.getHand().getCurrentTokens() + returnTokens);
				}
			}
	}

	public int getreturnTokens() {
		return returnTokens;
	}

	public void setreturnTokens(int returnTokens) {
		this.returnTokens = returnTokens;
	}
}
