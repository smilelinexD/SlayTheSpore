package Main;

import java.net.URL;
import java.util.ResourceBundle;

import cards.Cards;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DiscardController extends Main implements Initializable {
	
	private int ammount;
	private int Max_page;
	private int page = 0;
	
	@FXML
	public void onNext_pagePressed() {
		if(page + 2 <= Max_page) {
			page ++;

			Next_page.setVisible(page != Max_page - 1);
			Last_page.setVisible(true);
				
			Card_leftbound.setText(String.valueOf(page * 6));
			if(ammount - page * 6 >= 6) {
				Card0_refresh();
				Card1_refresh();
				Card2_refresh();
				Card3_refresh();
				Card4_refresh();
				Card5_refresh();
				Card_rightbound.setText(String.valueOf(page * 6 + 5));
			}
			else {
				switch(ammount - page * 6) {
				case 0:
					Card0.setVisible(false);
					Card1.setVisible(false);
					Card2.setVisible(false);
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_leftbound.setText("--");
					Card_rightbound.setText("--");
					break;
				case 1:
					Card0_refresh();
					Card1.setVisible(false);
					Card2.setVisible(false);
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6));
					break;
				case 2:
					Card0_refresh();
					Card1_refresh();
					Card2.setVisible(false);
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 1));
					break;
				case 3:
					Card0_refresh();
					Card1_refresh();
					Card2_refresh();
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 2));
					break;
				case 4:
					Card0_refresh();
					Card1_refresh();
					Card2_refresh();
					Card3_refresh();
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 3));
					break;
				case 5:
					Card0_refresh();
					Card1_refresh();
					Card2_refresh();
					Card3_refresh();
					Card4_refresh();
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 4));
					break;
				}
			}
		}
	}
	
	@FXML
	public void onLast_pagePressed() {
		if(page - 1 >= 0) {
			page --;
			
			Next_page.setVisible(true);
			Last_page.setVisible(page != 0);
			
			Card_leftbound.setText(String.valueOf(page * 6));
			if(ammount - page * 6 >= 6) {
				Card0_refresh();
				Card1_refresh();
				Card2_refresh();
				Card3_refresh();
				Card4_refresh();
				Card5_refresh();
				Card_rightbound.setText(String.valueOf(page * 6 + 5));
			}
			else {
				switch(ammount - page * 6) {
				case 0:
					Card0.setVisible(false);
					Card1.setVisible(false);
					Card2.setVisible(false);
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_leftbound.setText("--");
					Card_rightbound.setText("--");
					break;
				case 1:
					Card0_refresh();
					Card1.setVisible(false);
					Card2.setVisible(false);
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6));
					break;
				case 2:
					Card0_refresh();
					Card1_refresh();
					Card2.setVisible(false);
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 1));
					break;
				case 3:
					Card0_refresh();
					Card1_refresh();
					Card2_refresh();
					Card3.setVisible(false);
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 2));
					break;
				case 4:
					Card0_refresh();
					Card1_refresh();
					Card2_refresh();
					Card3_refresh();
					Card4.setVisible(false);
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 3));
					break;
				case 5:
					Card0_refresh();
					Card1_refresh();
					Card2_refresh();
					Card3_refresh();
					Card4_refresh();
					Card5.setVisible(false);
					Card_rightbound.setText(String.valueOf(page * 6 + 4));
					break;
				}
			}
		}
	}
	
	@FXML
	public void onBackPressed() {
		Main.currentStage.setScene(MenuController.combatScene);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ammount = hero.getDiscard().size();
		Max_page = ((ammount % 6 == 0) ? (ammount / 6) : (ammount / 6 + 1));
		Last_page.setVisible(false);
		if(Max_page <= 1) {
			Next_page.setVisible(false);
		}
		
		Card_leftbound.setText("0");
		if(this.ammount >= 6) {
			Card0_refresh();
			Card1_refresh();
			Card2_refresh();
			Card3_refresh();
			Card4_refresh();
			Card5_refresh();
			Card_rightbound.setText("5");
		}
		else {
			switch(this.ammount) {
			case 0:
				Card0.setVisible(false);
				Card1.setVisible(false);
				Card2.setVisible(false);
				Card3.setVisible(false);
				Card4.setVisible(false);
				Card5.setVisible(false);
				Card_leftbound.setText("--");
				Card_rightbound.setText("--");
				break;
			case 1:
				Card0_refresh();
				Card1.setVisible(false);
				Card2.setVisible(false);
				Card3.setVisible(false);
				Card4.setVisible(false);
				Card5.setVisible(false);
				Card_rightbound.setText("0");
				break;
			case 2:
				Card0_refresh();
				Card1_refresh();
				Card2.setVisible(false);
				Card3.setVisible(false);
				Card4.setVisible(false);
				Card5.setVisible(false);
				Card_rightbound.setText("1");
				break;
			case 3:
				Card0_refresh();
				Card1_refresh();
				Card2_refresh();
				Card3.setVisible(false);
				Card4.setVisible(false);
				Card5.setVisible(false);
				Card_rightbound.setText("2");
				break;
			case 4:
				Card0_refresh();
				Card1_refresh();
				Card2_refresh();
				Card3_refresh();
				Card4.setVisible(false);
				Card5.setVisible(false);
				Card_rightbound.setText("3");
				break;
			case 5:
				Card0_refresh();
				Card1_refresh();
				Card2_refresh();
				Card3_refresh();
				Card4_refresh();
				Card5.setVisible(false);
				Card_rightbound.setText("4");
				break;
			}
		}
	}
	
	private void Card0_refresh() {
		Cards tmpcard = hero.getDiscard().get(page * 6);
		Card0_Name.setText(tmpcard.getName());
		Card0_Description.setText(tmpcard.getDescription());
		Card0_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card0_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card0.setVisible(true);
		tmpcard = null;
	}
	
	private void Card1_refresh() {
		Cards tmpcard = hero.getDiscard().get(page * 6 + 1);
		Card1_Name.setText(tmpcard.getName());
		Card1_Description.setText(tmpcard.getDescription());
		Card1_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card1_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card1.setVisible(true);
		tmpcard = null;
	}
	
	private void Card2_refresh() {
		Cards tmpcard = hero.getDiscard().get(page * 6 + 2);
		Card2_Name.setText(tmpcard.getName());
		Card2_Description.setText(tmpcard.getDescription());
		Card2_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card2_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card2.setVisible(true);
		tmpcard = null;
	}
	
	private void Card3_refresh() {
		Cards tmpcard = hero.getDiscard().get(page * 6 + 3);
		Card3_Name.setText(tmpcard.getName());
		Card3_Description.setText(tmpcard.getDescription());
		Card3_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card3_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card3.setVisible(true);
		tmpcard = null;
	}
	
	private void Card4_refresh() {
		Cards tmpcard = hero.getDiscard().get(page * 6 + 4);
		Card4_Name.setText(tmpcard.getName());
		Card4_Description.setText(tmpcard.getDescription());
		Card4_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card4_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card4.setVisible(true);
		tmpcard = null;
	}
	
	private void Card5_refresh() {
		Cards tmpcard = hero.getDiscard().get(page * 6 + 5);
		Card5_Name.setText(tmpcard.getName());
		Card5_Description.setText(tmpcard.getDescription());
		Card5_Energy.setText(String.valueOf(tmpcard.getEnergy()));
		Card5_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
		Card5.setVisible(true);
	}
	
	@FXML
	public Button Back;
	public Button Last_page;
	public Button Next_page;
	public Text Card_leftbound;
	public Text Card_rightbound;
	public AnchorPane Card0;
	public Text Card0_Name;
	public Text Card0_Description;
	public Text Card0_Energy;
	public ImageView Card0_Image;
	public AnchorPane Card1;
	public Text Card1_Name;
	public Text Card1_Description;
	public Text Card1_Energy;
	public ImageView Card1_Image;
	public AnchorPane Card2;
	public Text Card2_Name;
	public Text Card2_Description;
	public Text Card2_Energy;
	public ImageView Card2_Image;
	public AnchorPane Card3;
	public Text Card3_Name;
	public Text Card3_Description;
	public Text Card3_Energy;
	public ImageView Card3_Image;
	public AnchorPane Card4;
	public Text Card4_Name;
	public Text Card4_Description;
	public Text Card4_Energy;
	public ImageView Card4_Image;
	public AnchorPane Card5;
	public Text Card5_Name;
	public Text Card5_Description;
	public Text Card5_Energy;
	public ImageView Card5_Image;
}