package relics;

import main.Ammy;

public class ScepterOfAvarice extends Relic {
	
	public ScepterOfAvarice(){
		
		name = "Scepter of Avarice";
		traitText = "At turn's end, place the Scepter in one of your Regions to double the number"
				+ " of coins you recieve from it(except from other players).";
	}

	@Override
	public void processRelic(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
}
