package views.manualView;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ManualController {
	@FXML
	private ImageView manualPage;
	
	@FXML
	private StackPane mainPane;
	
	private int count= 1;
	
	public void next()
	{
		if(count > 15)
		{
			count = 0;
		}
		count++;
		this.manualPage.setImage(new Image("/images/manual/manual"+count+".png"));
	}
	public void previous()
	{
		if(count < 2)
		{
			count = 17;
		}
		count--;
		this.manualPage.setImage(new Image("/images/manual/manual"+count+".png"));
	}
	public void zoomIn()
	{
		this.manualPage.setFitHeight(manualPage.getFitHeight()*1.1);
		this.manualPage.setFitWidth(manualPage.getFitWidth()*1.1);
		if(manualPage.getFitWidth() > 1250.0 && manualPage.getFitHeight() > 1250.0)
		{
			this.manualPage.setFitHeight(1250.0);
			this.manualPage.setFitWidth(1250.0);
		}
	}
	public void zoomOut()
	{
		this.manualPage.setFitHeight(manualPage.getFitHeight()/1.1);
		this.manualPage.setFitWidth(manualPage.getFitWidth()/1.1);
		if(manualPage.getFitWidth() < 753.0 && manualPage.getFitHeight() < 785.0)
		{
			this.manualPage.setFitHeight(785.0);
			this.manualPage.setFitWidth(753.0);
		}
	}
	
	public void openManual()
	{
		if(mainPane.isVisible())
		{
			this.mainPane.setVisible(false);
		}
		else
		{
			this.mainPane.setVisible(true);
		}
		//this.manualPage.setImage(new Image("/images/manual/manual1.jpg"));
	}

}