package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Role.Battle;
import cards.Cards;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class WinPageController extends Main implements Initializable {
	@FXML
	public Text Stage;
	public Text Gold;
	public Text Message;
	public AnchorPane Card;
	public Text Card_Energy;
	public Text Card_Name;
	public ImageView Card_Image;
	public Text Card_Description;
	public Button Yes;
	public Button No;

	@SuppressWarnings("static-access")
	@FXML
	public void onYesPressed() throws IOException {
		hero.addCardToDeck(false, tmpcard);
		
		Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Scene menuScene = new Scene(menu);
		menuScene.getRoot().requestFocus();
		Main.currentStage.setScene(menuScene);
	}

	@FXML
	public void onNoPressed() throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Scene menuScene = new Scene(menu);
		menuScene.getRoot().requestFocus();
		Main.currentStage.setScene(menuScene);
	}

	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.Stage.setText("Stage: " + String.valueOf(super.Stage));
		this.Gold.setText("Gold: " + String.valueOf(super.hero.getGold()));
		this.Message.setText("You've got " + tmpBattle.DropGold + " Gold and");
		tmpBattle = null;

		tmpcard = imain.generateCard();
		//System.out.println(tmpcard.getName());
		Card_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card_Name.setText(tmpcard.getName());
		Card_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card_Description.setText(tmpcard.getDescription());
	}
	private Cards tmpcard = null;
	private Random ran = new Random();
	private IMain imain = new MainFunctions();
}