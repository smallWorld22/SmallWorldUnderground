package specialPlaces;

import main.Ammy;
import player.Player;

public abstract class SpecialPlace
{
	protected String name;
	protected String traitText;
	protected boolean active;
	protected Player activePlayer;

	public SpecialPlace()
	{
	};

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public boolean getActive()
	{
		return active;
	}

	public abstract void processSpecialPlace(Ammy ammy);
}

