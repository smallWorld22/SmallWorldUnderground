package races;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Ammy;
import playBoard.Map;
import controllers.CombatController;
import controllers.MapTester;
import controllers.TerrainController;
import player.Player;
import setup.DeclareCombat;
import setup.PickRegions;
import setup.RedeployAreas;

public class Spiderines extends Race
{
	TerrainController tc;
	MapTester test;
	PickRegions pickRegions;
	Scanner scanner = new Scanner(System.in);
	private int nr;
	private String yesOrNo = "";
	CombatController cc;
	Map map;
	DeclareCombat dc;
	RedeployAreas ra;
	public Spiderines()
	{
		amountOfTokens = 7;
		maxTokens = 12;
		name = "Spiderines";
		traitText = "Can attack through Chasms";
	}

	@Override
	public void processAbility(Ammy ammy) 
	{
		this.activePlayer = ammy.getActivePlayer();
		this.tc = ammy.getTc();
		this.test = ammy.getTest();
		this.map = ammy.getMap();
		this.cc = ammy.getCc();
		this.pickRegions = ammy.getPickRegions();
		tc.checkAdjacentToTerrainType("Chasm");
		//test.whichAreAdjacent();
		
		for(int x=0;x<map.getAllTerrains().size();x++)
		{
			if(map.getTerrain(x).getIsAdjacent() == true)
			{
				map.getTerrain(x).setIsAttackable(true);//This changes all area adjacent to chasm to attackable
			}
		}
		//ammy.setPickRegions(pickRegions);
//		test.whichAreAdjacent();
//		System.out.println("Do you want conquer a terrain adjacent to chasm? ");
//		do
//		{
//			yesOrNo = scanner.nextLine();
//			if(yesOrNo.equals("yes"))
//			{
//				tc.checkAdjacentToTerrainType("Chasm");
//				test.whichAreAdjacent();
//				map.getTerrain(nr).setIsAttackable(true);
//				System.out.println("Choose a terrain nr: ");
//				nr = scanner.nextInt();
//				cc.calculateCombat(map.getAllTerrains().get(nr-1), activePlayer);
//				System.out.println(map.getTerrain(nr-1).getRace().getName());
//				break;
//			}
//			if(yesOrNo.equals("no"))
//			{
//				System.out.println("Continue");
//				break;
//			}
//		}while(yesOrNo.equals("yes") || yesOrNo.equals("no"));
	}
}
