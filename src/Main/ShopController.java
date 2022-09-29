package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cards.Cards;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ShopController extends Main implements Initializable {
	private int SelectedCard = -1;
	private int[] price = new int[6];
	private String[] name = new String[6];
	private boolean[] sold = new boolean[6];
	private boolean Removed = false;
	private IMain imain = new MainFunctions();

	@FXML
	public void onContinuePressed() throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Scene menuScene = new Scene(menu);
		menuScene.getRoot().requestFocus();
		Main.currentStage.setScene(menuScene);
	}

	@FXML
	public void onDeckPressed() throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("ShopDeck.fxml"));
		Scene menuScene = new Scene(menu);
		menuScene.getRoot().requestFocus();
		Main.currentStage.setScene(menuScene);
	}

	@FXML
	public void onRemove_SendPressed() {
		if(Remove_Ind.getText().equals("") || this.Removed) {
			return;
		}
		int ind = Integer.valueOf(Remove_Ind.getText());
		if (ind >= 0 && ind < hero.getDeck().size()) {
			this.SelectedCard = 100 + Integer.valueOf(Remove_Ind.getText());
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onCard0_Clicked() {
		if (sold[0] == false) {
			this.SelectedCard = 0;
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onCard1_Clicked() {
		if (sold[1] == false) {
			this.SelectedCard = 1;
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onCard2_Clicked() {
		if (sold[2] == false) {
			this.SelectedCard = 2;
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onCard3_Clicked() {
		if (sold[3] == false) {
			this.SelectedCard = 3;
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onCard4_Clicked() {
		if (sold[4] == false) {
			this.SelectedCard = 4;
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onCard5_Clicked() {
		if (sold[5] == false) {
			this.SelectedCard = 5;
			ConfirmPage.setVisible(true);
		}
	}

	@FXML
	public void onConfirmPage_YesPressed() {
		if (this.SelectedCard >= 100) { // Remove
			if (hero.spendGold(75 + hero.removeCards * 25) != -1) {
				hero.removeCardFromDeck(SelectedCard - 100);
				Gold.setText(String.valueOf(hero.getGold()));
				this.Removed = true;
			}
		} else {
			if (hero.spendGold(price[this.SelectedCard]) != -1) {
				hero.addCardToDeck(false, new Cards(name[this.SelectedCard]));
				sold[this.SelectedCard] = true;
				Gold.setText(String.valueOf(hero.getGold()));
			}
		}
		ConfirmPage.setVisible(false);
	}

	@FXML
	public void onConfirmPage_NoPressed() {
		this.SelectedCard = -1;
		ConfirmPage.setVisible(false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Gold.setText("Gold: " + String.valueOf(hero.getGold()));

		Remove_Price.setText(String.valueOf(75 + hero.removeCards * 25));

		Cards tmpcard;
		int tmpprice;
		String tmpname;
		tmpcard = imain.generateCard();
		tmpname = tmpcard.getName();
		Card0_Name.setText(tmpname);
		name[0] = tmpname;
		Card0_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card0_Description.setText(tmpcard.getDescription());
		Card0_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		tmpprice = (tmpcard.getRarity().equals("Common")) ? (50)
				: (tmpcard.getRarity().equals("Uncommon")) ? (75) : (150);
		tmpprice += (tmpprice * (ran.nextInt(21) - 10) / 100);
		Card0_Price.setText(String.valueOf(tmpprice));
		price[0] = tmpprice;

		tmpcard = imain.generateCard();
		tmpname = tmpcard.getName();
		Card1_Name.setText(tmpname);
		name[1] = tmpname;
		Card1_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card1_Description.setText(tmpcard.getDescription());
		Card1_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		tmpprice = (tmpcard.getRarity().equals("Common")) ? (50)
				: (tmpcard.getRarity().equals("Uncommon")) ? (75) : (150);
		tmpprice += (tmpprice * (ran.nextInt(21) - 10) / 100);
		Card1_Price.setText(String.valueOf(tmpprice));
		price[1] = tmpprice;

		tmpcard = imain.generateCard();
		tmpname = tmpcard.getName();
		Card2_Name.setText(tmpname);
		name[2] = tmpname;
		Card2_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card2_Description.setText(tmpcard.getDescription());
		Card2_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		tmpprice = (tmpcard.getRarity().equals("Common")) ? (50)
				: (tmpcard.getRarity().equals("Uncommon")) ? (75) : (150);
		tmpprice += (tmpprice * (ran.nextInt(21) - 10) / 100);
		Card2_Price.setText(String.valueOf(tmpprice));
		price[2] = tmpprice;

		tmpcard = imain.generateCard();
		tmpname = tmpcard.getName();
		Card3_Name.setText(tmpname);
		name[3] = tmpname;
		Card3_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card3_Description.setText(tmpcard.getDescription());
		Card3_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		tmpprice = (tmpcard.getRarity().equals("Common")) ? (50)
				: (tmpcard.getRarity().equals("Uncommon")) ? (75) : (150);
		tmpprice += (tmpprice * (ran.nextInt(21) - 10) / 100);
		Card3_Price.setText(String.valueOf(tmpprice));
		price[3] = tmpprice;

		tmpcard = imain.generateCard();
		tmpname = tmpcard.getName();
		Card4_Name.setText(tmpname);
		name[4] = tmpname;
		Card4_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card4_Description.setText(tmpcard.getDescription());
		Card4_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		tmpprice = (tmpcard.getRarity().equals("Common")) ? (50)
				: (tmpcard.getRarity().equals("Uncommon")) ? (75) : (150);
		tmpprice += (tmpprice * (ran.nextInt(21) - 10) / 100);
		Card4_Price.setText(String.valueOf(tmpprice));
		price[4] = tmpprice;

		tmpcard = imain.generateCard();
		tmpname = tmpcard.getName();
		Card5_Name.setText(tmpname);
		name[5] = tmpname;
		Card5_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card5_Description.setText(tmpcard.getDescription());
		Card5_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		tmpprice = (tmpcard.getRarity().equals("Common")) ? (50)
				: (tmpcard.getRarity().equals("Uncommon")) ? (75) : (150);
		tmpprice += (tmpprice * (ran.nextInt(21) - 10) / 100);
		Card5_Price.setText(String.valueOf(tmpprice));
		price[5] = tmpprice;
	}

	@FXML
	public Text Gold;
	public AnchorPane Card0;
	public Text Card0_Name;
	public Text Card0_Energy;
	public Text Card0_Description;
	public ImageView Card0_Image;
	public Text Card0_Price;
	public AnchorPane Card1;
	public Text Card1_Name;
	public Text Card1_Energy;
	public Text Card1_Description;
	public ImageView Card1_Image;
	public Text Card1_Price;
	public AnchorPane Card2;
	public Text Card2_Name;
	public Text Card2_Energy;
	public Text Card2_Description;
	public ImageView Card2_Image;
	public Text Card2_Price;
	public AnchorPane Card3;
	public Text Card3_Name;
	public Text Card3_Energy;
	public Text Card3_Description;
	public ImageView Card3_Image;
	public Text Card3_Price;
	public AnchorPane Card4;
	public Text Card4_Name;
	public Text Card4_Energy;
	public Text Card4_Description;
	public ImageView Card4_Image;
	public Text Card4_Price;
	public AnchorPane Card5;
	public Text Card5_Name;
	public Text Card5_Energy;
	public Text Card5_Description;
	public ImageView Card5_Image;
	public Text Card5_Price;
	public AnchorPane CardRemovalService;
	public TextField Remove_Ind;
	public Button Remove_Send;
	public Text Remove_Price;
	public AnchorPane ConfirmPage;
	public Button ConfirmPage_Yes;
	public Button ConfirmPage_No;
	public Button Continue;
	public Button Deck;

	private Random ran = new Random();
}