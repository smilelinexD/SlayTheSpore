package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Role.Battle;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MenuController extends Main implements Initializable {
	@FXML
	public Label Stage;
	public Label Gold;
	public ImageView Background;
	public Button Start;
	public Text Win;
	
	@SuppressWarnings("static-access")
	@FXML
	public void onStartPressed() throws IOException {	
		super.Stage++;

		if (super.Stage <= 3) {
			this.setBattle();
		} else if (super.Stage <= 8) {
			int roll = ran.nextInt(100);
			if (roll < 65) {
				this.setBattle();
			} else if (roll < 77) {
				this.setEliteBattle();
			} else if (roll < 94) {
				this.setRestSite();
			} else {
				this.setShop();
			}

		} else if (super.Stage == 9) {
			this.setRestSite();
		} else if (super.Stage == 10) {
			this.setBattle();
		}
	}

	@FXML
	public void onExitPressed() {
		Main.currentStage.close();
	}

	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(super.Stage == 10) {
			this.Win.setVisible(true);
			this.Stage.setVisible(false);
			this.Gold.setVisible(false);
			this.Start.setVisible(false);
			return;
			
		}
		this.Background.setStyle("-fx-opacity: 0.75;");
		this.Stage.setText("Stage: " + String.valueOf(super.Stage));
		this.Stage.setTextFill(Color.WHITE);
		this.Gold.setText("Gold: " + String.valueOf(super.hero.getGold()));
		this.Gold.setTextFill(Color.WHITE);

	}

	@SuppressWarnings("static-access")
	private void setBattle() throws IOException {
		tmpBattle = new Battle();
		tmpBattle.hero = super.hero;
		hero.setBattle(tmpBattle);
		imain.generateEnemy(false, super.Stage);
		Parent combat = FXMLLoader.load(getClass().getResource("Combat.fxml"));
		combatScene = new Scene(combat);
		combatScene.getRoot().requestFocus();
		Main.currentStage.setScene(combatScene);
	}

	@SuppressWarnings("static-access")
	private void setEliteBattle() throws IOException {
		tmpBattle = new Battle();
		tmpBattle.DropGold = 35 - ran.nextInt(11);
		tmpBattle.hero = super.hero;
		hero.setBattle(tmpBattle);
		imain.generateEnemy(true, super.Stage);
		Parent combat = FXMLLoader.load(getClass().getResource("Combat.fxml"));
		combatScene = new Scene(combat);
		combatScene.getRoot().requestFocus();
		Main.currentStage.setScene(combatScene);
	}

	private void setRestSite() throws IOException {
		Parent restsite = FXMLLoader.load(getClass().getResource("RestSite.fxml"));
		restsiteScene = new Scene(restsite);
		restsiteScene.getRoot().requestFocus();
		Main.currentStage.setScene(restsiteScene);
	}
	
	private void setShop() throws IOException {
		Parent shop = FXMLLoader.load(getClass().getResource("Shop.fxml"));
		shopScene = new Scene(shop);
		shopScene.getRoot().requestFocus();
		Main.currentStage.setScene(shopScene);
	}
	
	private Random ran = new Random();
	private IMain imain = new MainFunctions();
	
	public static Scene combatScene = null;
	public static Scene restsiteScene = null;
	public static Scene shopScene = null;

}