package relics;

import main.Ammy;

public class StinkyTrollSocks extends Relic {
	
	public StinkyTrollSocks(){
		
		name = "Stinky Troll's Socks";
		traitText = "Once per turn, use it to conquer 1 Region as if it was empty. Your opponent loses"
					+ "	no token though, redeploying them all at turn's end.";
	}

	@Override
	public void processRelic(Ammy ammy) {
		// TODO Auto-generated method stub
		
	}
}
