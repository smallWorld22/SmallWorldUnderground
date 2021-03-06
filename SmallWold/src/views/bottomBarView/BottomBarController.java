package views.bottomBarView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import player.Player;


/**
 * Deze klasse verzorgt de input en updates van de bottombarview.
 * @author Reza Naser, Bas Dorresteijn, Jeroen Zandvliet
 */

public class BottomBarController {


	private boolean visible;
	private boolean firstTime = true;

	private Player selfPlayer;

	@FXML
	private ImageView activeRace;

	@FXML
	private ImageView declineAbility;

	@FXML
	private ImageView declineRace;

	@FXML
	private ImageView activeAbility;

	@FXML
	private Label currentTokens;

	@FXML
	private Label declineTokens;

	@FXML
	private Label ownCoins;

	@FXML
	private HBox abilityTextFieldHBox;

	@FXML
	private Label abilityTextField;

	@FXML
	private HBox raceTextFieldHBox;

	@FXML
	private Label raceTextField;

	@FXML
	private HBox declineAbilityTextFieldHBox;

	@FXML
	private Label declineAbilityTextField;

	@FXML
	private HBox declineRaceTextFieldHBox;

	@FXML
	private Label declineRaceTextField;



	@FXML
	private HBox relicOneHBox;

	@FXML
	private Label relicOne;

	@FXML
	private HBox relicTwoHBox;

	@FXML
	private Label relicTwo;

	@FXML
	private Label specialPlaceOne;

	@FXML
	private HBox specialPlaceOneHBox;

	@FXML
	private Label specialPlaceTwo;

	@FXML
	private HBox specialPlaceTwoHBox;




	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

	/**
	 * Update de actieve set van de speler in de bottombarview.
	 */

	public void setActiveSet() {
		if(selfPlayer.getActiveSet() != null)
		{
			activeRace.setImage(new Image("/images/races/active/"+selfPlayer.getActiveSet().getRace().getName()+".png"));
			activeAbility.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getAbility().getName()+".png"));
		}
		else
		{
			activeRace.setImage(new Image("/images/races/placeHolder.png"));
			activeAbility.setImage(new Image("/images/abilitys/placeHolder.png"));
		}

	}

	/**
	 * Update de declien set van de speler in de bottombarview.
	 */
	public void setDeclineSet() {
		declineRace.setImage(new Image("/images/races/decline/"+selfPlayer.getDeclineSet().getRace().getName()+".png"));
		declineAbility.setImage(new Image("/images/abilitys/decline/"+selfPlayer.getDeclineSet().getAbility().getName()+".png"));

	}


	/**
	 * Update het textveld welke laat zien hoeveel actieve tokens de speler op dit moment heeft.
	 */
	@FXML
	public void updateCurrentTokens()
	{
		currentTokens.setText(String.valueOf(selfPlayer.getHand().getCurrentTokens()));

	}
	/**
	 * Update het textveld welke laat zien hoeveel decline tokens de speler op dit moment heeft.
	 */

	public void updateDeclineTokens()
	{

		selfPlayer.getHand().setDeclineTokens(selfPlayer.getHand().getDeclineTokens() + 1);


		declineTokens.setText(String.valueOf(selfPlayer.getHand().getDeclineTokens()));
	}

	/**
	 * Update het textveld welke laat zien hoe de actieve ability van de speler gebruikt kan worden.
	 */

	@FXML
	public void showAbilityTraitText()
	{
		if(abilityTextFieldHBox.isVisible() == false && selfPlayer.getActiveSet() != null)
		{


			abilityTextField.setText(selfPlayer.getActiveSet().getAbility().getTraitText());
			abilityTextFieldHBox.setVisible(true);
		}

		else
		{
			abilityTextFieldHBox.setVisible(false);
		}
	}

	/**
	 * Update het textveld welke laat zien hoe het actieve ras van de speler gebruikt kan worden.
	 */
	@FXML
	public void showRaceTraitText()
	{
		if(raceTextFieldHBox.isVisible() == false && selfPlayer.getActiveSet() != null)
		{
			raceTextField.setText(selfPlayer.getActiveSet().getRace().getTraitText());
			raceTextFieldHBox.setVisible(true);
		}

		else
		{
			raceTextFieldHBox.setVisible(false);
		}
	}


	/**
	 * Update het textveld welke laat zien hoe de decline ability van de speler gebruikt kan worden.
	 */
	@FXML
	public void showDeclineRaceTraitText()
	{
		if(declineRaceTextFieldHBox.isVisible() == false && selfPlayer.getDeclineSet() != null)
		{

			declineRaceTextField.setText(selfPlayer.getDeclineSet().getRace().getDeclineTraitText());
			declineRaceTextFieldHBox.setVisible(true);
		}

		else
		{
			declineRaceTextFieldHBox.setVisible(false);
		}
	}

	/**
	 * Update het textveld welke laat zien hoe de decline ability van de speler gebruikt kan worden.
	 */

	@FXML
	public void showDeclineAbilityTraitText()
	{
		if(declineAbilityTextFieldHBox.isVisible() == false)
		{

			declineAbilityTextField.setText(selfPlayer.getDeclineSet().getAbility().getDeclineTraitText());
			declineAbilityTextFieldHBox.setVisible(true);
		}

		else
		{
			declineAbilityTextFieldHBox.setVisible(false);
		}
	}

/*
	public void showRelicOneTraitText()
	{
		if(relicOneHBox.isVisible() == false)
		{
			relicOne.setText(new FlyingDoormat().getTraitText());
			relicOneHBox.setVisible(true);
		}

		else
		{
			relicOneHBox.setVisible(false);
		}
	}

	public void showRelicTwoTraitText()
	{
		if(relicTwoHBox.isVisible() == false)
		{
			relicTwo.setText(new KillerRabbitSword().getTraitText());
			relicTwoHBox.setVisible(true);
		}

		else
		{
			relicTwoHBox.setVisible(false);
		}
	}

	public void showSpecialPlaceOneTraitText()
	{
		if(specialPlaceOneHBox.isVisible() == false)
		{
			specialPlaceOne.setText(new DiamondFields().getTraitText());
			specialPlaceOneHBox.setVisible(true);
		}

		else
		{
			specialPlaceOneHBox.setVisible(false);
		}
	}

	public void showSpecialPlaceTwoTraitText()
	{
		if(specialPlaceTwoHBox.isVisible() == false)
		{
			specialPlaceTwo.setText(new MineOfTheLostDwarf().getTraitText());
			specialPlaceTwoHBox.setVisible(true);
		}

		else
		{
			specialPlaceTwoHBox.setVisible(false);
		}
	}
	*/


	/**
	 * Deze methode bind het textveld welke de speler zijn totaal munten en het aantal tokens die
	 * de speler op dit moment heeft laat zien aan de variabelen van het Playerobject.
	 */
	public void bindPlayer() {
		ownCoins.textProperty().bind(selfPlayer.getCoinLabel());
		currentTokens.textProperty().bind(selfPlayer.getHand().getCurrentTokensLabel());

	}



}
