package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import Role.Enemy;
import cards.Cards;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CombatController extends Main implements Initializable {
	
	private int cardInd = -1;
	private int page = 0;
	private int Max_Page;
	private int enemyAmmount = tmpBattle.Enemies.size();
	private IMain imain = new MainFunctions();

	@FXML
	public void onCard0Click() {	// Select Card 0
		cardInd = 0;
		Card0.setStyle("-fx-border-color: red;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: black;-fx-background-color: gray;");
	}

	@FXML
	public void onCard1Click() {	// Select Card 1
		cardInd = 1;
		Card0.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: red;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: black;-fx-background-color: gray;");
	}

	@FXML
	public void onCard2Click() {	// Select Card 2
		cardInd = 2;
		Card0.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: red;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: black;-fx-background-color: gray;");
	}

	@FXML
	public void onCard3Click() {	// Select Card 3
		cardInd = 3;
		Card0.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: red;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: black;-fx-background-color: gray;");
	}

	@FXML
	public void onCard4Click() {	// Select Card 4
		cardInd = 4;
		Card0.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: red;-fx-background-color: gray;");
	}

	@FXML
	public void onBuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getBuffContents(hero));
	}

	@FXML
	public void onDebuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getDebuffContents(hero));
	}
	
	@FXML
	public void onBuff_Debuff_BackPressed() {
		Buff_Debuff_Pane.setVisible(false);
	}

	@FXML
	public void onEnemy0Click() {
		Enemy tmpenemy = tmpBattle.Enemies.get(0);
		if (!tmpenemy.checkDead()) {
			if (cardInd != -1) {	// Try to use selected card
				tmpBattle.hero.UseCard(page * 5 + cardInd, tmpenemy);
				dataRefresh();
				if (tmpBattle.checkEnd()) {
					if (tmpBattle.hero.checkDead()) {
						try {
							Lose();
							return;
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						try {
							Win();
							return;
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				if (tmpenemy.checkDead()) {
					Enemy0.setVisible(false);
					Enemy0_Buff.setVisible(false);
					Enemy0_Debuff.setVisible(false);
				}
				if (tmpBattle.Enemies.size() >= 2) {
					if (tmpBattle.Enemies.get(1).checkDead()) {
						Enemy1.setVisible(false);
						Enemy1_Buff.setVisible(false);
						Enemy1_Debuff.setVisible(false);
					}
				}
				if (tmpBattle.Enemies.size() >= 3) {
					if (tmpBattle.Enemies.get(2).checkDead()) {
						Enemy2.setVisible(false);
						Enemy2_Buff.setVisible(false);
						Enemy2_Debuff.setVisible(false);
					}
				}
				cardReinit();
			}
		}
	}

	@FXML
	public void onEnemy0MouseEntered() {
		Enemy tmpenemy = tmpBattle.Enemies.get(0);
		if (!tmpenemy.checkDead()) {
			String tmp = tmpenemy.getName() + " is intend to\n" + tmpenemy.getIntendContent();
			Enemy0_Intend.setText(tmp);
			Enemy0_Intend.setVisible(true);
		}
	}

	@FXML
	public void onEnemy0MouseExited() {
		Enemy0_Intend.setVisible(false);
	}

	@FXML
	public void onEnemy0BuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getBuffContents(tmpBattle.Enemies.get(0)));
	}

	@FXML
	public void onEnemy0DebuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getDebuffContents(tmpBattle.Enemies.get(0)));
	}

	@FXML
	public void onEnemy1Click() {
		if (enemyAmmount >= 2) {
			Enemy tmpenemy = tmpBattle.Enemies.get(1);
			if (!tmpenemy.checkDead()) {
				if (cardInd != -1) {
					tmpBattle.hero.UseCard(page * 5 + cardInd, tmpenemy);
					dataRefresh();
					if (tmpBattle.checkEnd()) {
						if (tmpBattle.hero.checkDead()) {
							try {
								Lose();
								return;
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							try {
								Win();
								return;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					if (tmpenemy.checkDead()) {
						Enemy1.setVisible(false);
						Enemy1_Buff.setVisible(false);
						Enemy1_Debuff.setVisible(false);
					}
					if (tmpBattle.Enemies.get(0).checkDead()) {
						Enemy0.setVisible(false);
						Enemy0_Buff.setVisible(false);
						Enemy0_Debuff.setVisible(false);
					}
					if (tmpBattle.Enemies.size() >= 3) {
						if (tmpBattle.Enemies.get(2).checkDead()) {
							Enemy2.setVisible(false);
							Enemy2_Buff.setVisible(false);
							Enemy2_Debuff.setVisible(false);
						}
					}
					cardReinit();
				}
			}
		}
	}

	@FXML
	public void onEnemy1MouseEntered() {
		if (enemyAmmount >= 2) {
			Enemy tmpenemy = tmpBattle.Enemies.get(1);
			if (!tmpenemy.checkDead()) {
				String tmp = tmpenemy.getName() + " is intend to\n" + tmpenemy.getIntendContent();
				Enemy1_Intend.setText(tmp);
				Enemy1_Intend.setVisible(true);
			}
		}
	}

	@FXML
	public void onEnemy1MouseExited() {
		if (enemyAmmount >= 2) {
			Enemy1_Intend.setVisible(false);
		}
	}

	@FXML
	public void onEnemy1BuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getBuffContents(tmpBattle.Enemies.get(1)));
	}

	@FXML
	public void onEnemy1DebuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getDebuffContents(tmpBattle.Enemies.get(1)));
	}

	@FXML
	public void onEnemy2Click() {
		if (enemyAmmount >= 3) {
			Enemy tmpenemy = tmpBattle.Enemies.get(2);
			if (!tmpenemy.checkDead()) {
				if (cardInd != -1) {
					tmpBattle.hero.UseCard(page * 5 + cardInd, tmpenemy);
					dataRefresh();
					if (tmpBattle.checkEnd()) {
						if (tmpBattle.hero.checkDead()) {
							try {
								Lose();
								return;
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							try {
								Win();
								return;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					if (tmpenemy.checkDead()) {
						Enemy2.setVisible(false);
						Enemy2_Buff.setVisible(false);
						Enemy2_Debuff.setVisible(false);
					}
					if (tmpBattle.Enemies.get(0).checkDead()) {
						Enemy0.setVisible(false);
						Enemy0_Buff.setVisible(false);
						Enemy0_Debuff.setVisible(false);
					}
					if (tmpBattle.Enemies.get(1).checkDead()) {
						Enemy1.setVisible(false);
						Enemy1_Buff.setVisible(false);
						Enemy1_Debuff.setVisible(false);
					}
					cardReinit();
				}
			}
		}
	}

	@FXML
	public void onEnemy2MouseEntered() {
		if (enemyAmmount >= 3) {
			Enemy tmpenemy = tmpBattle.Enemies.get(2);
			if (!tmpenemy.checkDead()) {
				String tmp = tmpenemy.getName() + " is intend to\n" + tmpenemy.getIntendContent();
				Enemy2_Intend.setText(tmp);
				Enemy2_Intend.setVisible(true);
			}
		}
	}

	@FXML
	public void onEnemy2MouseExited() {
		if (enemyAmmount >= 3) {
			Enemy2_Intend.setVisible(false);
		}
	}

	@FXML
	public void onEnemy2BuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getBuffContents(tmpBattle.Enemies.get(2)));
	}

	@FXML
	public void onEnemy2DebuffPressed() {
		Buff_Debuff_Pane.setVisible(true);
		Buff_Debuff_Text.setText(imain.getDebuffContents(tmpBattle.Enemies.get(2)));
	}

	@FXML
	public void onEndTurnClick() {
		this.page = 0;
		tmpBattle.Round++;
		hero.RoundPass();
		for (Enemy tmp : tmpBattle.Enemies) {
			if (!tmp.checkDead()) {
				tmp.gainBlock(-tmp.getBlock());	// Reduce block to 0

				int storeHp = hero.getHealth();
				int storeBlock = hero.getBlock();
				tmp.EnemyTurn(tmp, hero);
				if (hero.getHealth() < storeHp) {	// got hit
					Hurt.setVisible(true);
					Timeline Tl = new Timeline((new KeyFrame(Duration.millis(200), (d) -> {
						Hurt.setVisible(false);
					})));
					Tl.play();
				}
				if (hero.getBuff().checkBuff()) {
					if (hero.getBuff().checkFlame_Barrier()) {
						if (hero.getHealth() < storeHp || hero.getBlock() < storeBlock) {
							tmp.Hurt(4 * hero.getBuff().getFlame_BarrierLvl());
						}
					}
				}
				tmp.RoundPass();
				tmp.getIntend();
				dataRefresh();
			}
		}
		if (tmpBattle.checkEnd()) {
			if (tmpBattle.hero.checkDead()) {
				try {
					Lose();
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Win();
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(hero.getBuff().checkBuff()) {
			if(hero.getBuff().checkBerserk()) {
				hero.gainEnergy(hero.getBuff().getBerserkLvl());
			}
			if(hero.getBuff().checkBrutality()) {
				hero.removeHp(hero.getBuff().getBrutalityLvl());
				hero.Draw(hero.getBuff().getBrutalityLvl());
			}
			if(hero.getBuff().checkDemon_Form()) {
				hero.gotBuff("Strength", 2 * hero.getBuff().getDemon_FormLvl());
			}
		}
		if(hero.getBuff().checkBarricade() == false) {	// No longer reduce to 0
			hero.setBlock(0);	
		}
		hero.Draw(5);
		dataRefresh();
		cardReinit();
	}

	@FXML
	public void onDeckPressed() throws IOException {
		Parent deck = FXMLLoader.load(getClass().getResource("Deck.fxml"));
		Scene deckScene = new Scene(deck);
		deckScene.getRoot().requestFocus();
		Main.currentStage.setScene(deckScene);
	}

	@FXML
	public void onDiscardPressed() throws IOException {
		Parent discard = FXMLLoader.load(getClass().getResource("Discard.fxml"));
		Scene discardScene = new Scene(discard);
		discardScene.getRoot().requestFocus();
		Main.currentStage.setScene(discardScene);
	}
	
	@FXML
	public void onNext_PagePressed() {
		if(page + 1 < Max_Page) {
			page ++;
			
			Next_Page.setVisible(page != Max_Page - 1);
			Last_Page.setVisible(true);
			
			cardReinit();
		}
	}
	
	@FXML
	public void onLast_PagePressed(){
		if(page - 1 >= 0) {
			page --;
			
			Next_Page.setVisible(true);
			Last_Page.setVisible(page != 0);
			
			cardReinit();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Block.setText("0");

		Health.setText(String.valueOf(hero.getHealth()));
		MaxHealth.setText(String.valueOf(hero.getMaxHealth()));

		Energy.setText(String.valueOf(hero.getEnergy()));
		MaxEnergy.setText(String.valueOf(hero.getMaxEnergy()));
		
		Next_Page.setVisible(false);
		Last_Page.setVisible(false);
		
		Enemy tmpenemy = null;
		switch (tmpBattle.Enemies.size()) {
		case 3:
			tmpenemy = tmpBattle.Enemies.get(2);
			Enemy2_Health.setText(String.valueOf(tmpenemy.getHealth()));
			Enemy2_MaxHealth.setText(String.valueOf(tmpenemy.getMaxHealth()));
			Enemy2_Block.setText(String.valueOf(tmpenemy.getBlock()));
			Enemy2_Image
					.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpenemy.getName() + ".png")));
			tmpenemy = tmpBattle.Enemies.get(1);
			Enemy1_Health.setText(String.valueOf(tmpenemy.getHealth()));
			Enemy1_MaxHealth.setText(String.valueOf(tmpenemy.getMaxHealth()));
			Enemy1_Block.setText(String.valueOf(tmpenemy.getBlock()));
			Enemy1_Image
					.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpenemy.getName() + ".png")));
			break;
		case 2:
			tmpenemy = tmpBattle.Enemies.get(1);
			Enemy1_Health.setText(String.valueOf(tmpenemy.getHealth()));
			Enemy1_MaxHealth.setText(String.valueOf(tmpenemy.getMaxHealth()));
			Enemy1_Block.setText(String.valueOf(tmpenemy.getBlock()));
			Enemy1_Image
					.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpenemy.getName() + ".png")));
			Enemy2.setVisible(false);
			Enemy2_Buff.setVisible(false);
			Enemy2_Debuff.setVisible(false);
			break;
		case 1:
			Enemy1.setVisible(false);
			Enemy1_Buff.setVisible(false);
			Enemy1_Debuff.setVisible(false);
			Enemy2.setVisible(false);
			Enemy2_Buff.setVisible(false);
			Enemy2_Debuff.setVisible(false);
			break;
		default:
			break;
		}

		tmpenemy = tmpBattle.Enemies.get(0);
		Enemy0_Health.setText(String.valueOf(tmpenemy.getHealth()));
		Enemy0_MaxHealth.setText(String.valueOf(tmpenemy.getMaxHealth()));
		Enemy0_Block.setText(String.valueOf(tmpenemy.getBlock()));
		Enemy0_Image.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpenemy.getName() + ".png")));

		tmpBattle.hero.ShuffleDeck();
		tmpBattle.hero.Draw(5);

		for (Enemy tmp : tmpBattle.Enemies) {
			tmp.getIntend();
		}

		Enemy0_Intend.setVisible(false);
		Enemy1_Intend.setVisible(false);
		Enemy2_Intend.setVisible(false);

		cardinit();
	}

	private void dataRefresh() {
		Block.setText(String.valueOf(hero.getBlock()));
		Health.setText(String.valueOf(hero.getHealth()));
		MaxHealth.setText(String.valueOf(hero.getMaxHealth()));
		Energy.setText(String.valueOf(hero.getEnergy()));

		if (enemyAmmount >= 3) {
			Enemy2_Health.setText(String.valueOf(tmpBattle.Enemies.get(2).getHealth()));
			int tmpBlock = tmpBattle.Enemies.get(2).getBlock();
			Enemy2_Block.setText(String.valueOf(tmpBlock));
		}
		if (enemyAmmount >= 2) {
			Enemy1_Health.setText(String.valueOf(tmpBattle.Enemies.get(1).getHealth()));
			int tmpBlock = tmpBattle.Enemies.get(1).getBlock();
			Enemy1_Block.setText(String.valueOf(tmpBlock));
		}
		Enemy0_Health.setText(String.valueOf(tmpBattle.Enemies.get(0).getHealth()));
		int tmpBlock = tmpBattle.Enemies.get(0).getBlock();
		Enemy0_Block.setText(String.valueOf(tmpBlock));
	}

	private void cardinit() {
		cardInd = -1;
		Card0.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: black;-fx-background-color: gray;");

		Card0.setVisible(true);
		Card1.setVisible(true);
		Card2.setVisible(true);
		Card3.setVisible(true);
		Card4.setVisible(true);

		Card0_Refresh();
		Card1_Refresh();
		Card2_Refresh();
		Card3_Refresh();
		Card4_Refresh();
	}

	private void cardReinit() {
		int size = hero.getHand().size();
		Max_Page = (size % 5 == 0) ? (size / 5) : (size / 5 + 1);
		cardInd = -1;
		
		Next_Page.setVisible(Max_Page > 1 && page < Max_Page - 1);
		Last_Page.setVisible(page > 0);
		
		Card0.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card1.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card2.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card3.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		Card4.setStyle("-fx-border-color: black;-fx-background-color: gray;");
		
		Card0.setVisible(false);
		Card1.setVisible(false);
		Card2.setVisible(false);
		Card3.setVisible(false);
		Card4.setVisible(false);
		
		if(size - page * 5 >= 1) {
			Card0_Refresh();
		}
		if(size - page * 5 >= 2) {
			Card1_Refresh();
		}
		if(size - page * 5 >= 3) {
			Card2_Refresh();
		}
		if(size - page * 5 >= 4) {
			Card3_Refresh();
		}
		if(size - page * 5 >= 5) {
			Card4_Refresh();
		}
	}
	
	private void Card0_Refresh() {
		Cards tmpcard = tmpBattle.hero.getHand().get(this.page * 5);
		Card0.setVisible(true);
		Card0_Energy.setText(Integer.toString(tmpcard.getEnergy()));
		Card0_Name.setText(tmpcard.getName());
		Card0_Description.setText(tmpcard.getDescription());
		Card0_Image
				.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
	}
	
	private void Card1_Refresh() {
		Cards tmpcard = tmpBattle.hero.getHand().get(this.page * 5 + 1);
		Card1.setVisible(true);
		Card1_Energy.setText(Integer.toString(tmpcard.getEnergy()));
		Card1_Name.setText(tmpcard.getName());
		Card1_Description.setText(tmpcard.getDescription());
		Card1_Image
				.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
	}
	
	private void Card2_Refresh() {
		Cards tmpcard = tmpBattle.hero.getHand().get(this.page * 5 + 2);
		Card2.setVisible(true);
		Card2_Energy.setText(Integer.toString(tmpcard.getEnergy()));
		Card2_Name.setText(tmpcard.getName());
		Card2_Description.setText(tmpcard.getDescription());
		Card2_Image
				.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
	}
	
	private void Card3_Refresh() {
		Cards tmpcard = tmpBattle.hero.getHand().get(this.page * 5 + 3);
		Card3.setVisible(true);
		Card3_Energy.setText(Integer.toString(tmpcard.getEnergy()));
		Card3_Name.setText(tmpcard.getName());
		Card3_Description.setText(tmpcard.getDescription());
		Card3_Image
				.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
	}
	
	private void Card4_Refresh() {
		Cards tmpcard = tmpBattle.hero.getHand().get(this.page * 5 + 4);
		Card4.setVisible(true);
		Card4_Energy.setText(Integer.toString(tmpcard.getEnergy()));
		Card4_Name.setText(tmpcard.getName());
		Card4_Description.setText(tmpcard.getDescription());
		Card4_Image
				.setImage(new Image(this.getClass().getResourceAsStream("../Imgs/" + tmpcard.getName() + ".png")));
	}

	@FXML
	public void COMMANDS() throws IOException {
		Scanner input = new Scanner(System.in);
		switch (input.next()) {
		case "Win":
			this.Win();
			break;
		case "Restore":
			hero.gainHp(999);
			this.dataRefresh();
			break;
		case "Draw":
			hero.Draw(1);
			this.cardReinit();
			break;
		case "Energy":
			hero.setEnergy(999);
			this.dataRefresh();
			break;
		}
		return;
	}

	private void Win() throws IOException {
		hero.Battle_End();
		hero.gotGold(tmpBattle.DropGold);
		Parent winpage = FXMLLoader.load(getClass().getResource("WinPage.fxml"));
		Scene winpageScene = new Scene(winpage);
		winpageScene.getRoot().requestFocus();
		Main.currentStage.setScene(winpageScene);
	}

	private void Lose() throws IOException {
		Parent losepage = FXMLLoader.load(getClass().getResource("LosePage.fxml"));
		Scene losepageScene = new Scene(losepage);
		losepageScene.getRoot().requestFocus();
		Main.currentStage.setScene(losepageScene);
	}

	@FXML
	public Text Health;
	public Text MaxHealth;
	public Text Energy;
	public Text MaxEnergy;
	public Text Block;
	public Button Buff;
	public Button Debuff;
	public Button Next_Page;
	public Button Last_Page;
	public AnchorPane Card0;
	public Text Card0_Energy;
	public Text Card0_Name;
	public Text Card0_Description;
	public ImageView Card0_Image;
	public AnchorPane Card1;
	public Text Card1_Energy;
	public Text Card1_Name;
	public Text Card1_Description;
	public ImageView Card1_Image;
	public AnchorPane Card2;
	public Text Card2_Energy;
	public Text Card2_Name;
	public Text Card2_Description;
	public ImageView Card2_Image;
	public AnchorPane Card3;
	public Text Card3_Energy;
	public Text Card3_Name;
	public Text Card3_Description;
	public ImageView Card3_Image;
	public AnchorPane Card4;
	public Text Card4_Energy;
	public Text Card4_Name;
	public Text Card4_Description;
	public ImageView Card4_Image;
	public AnchorPane Enemy0;
	public Text Enemy0_Health;
	public Text Enemy0_MaxHealth;
	public Text Enemy0_Block;
	public Text Enemy0_Intend;
	public ImageView Enemy0_Image;
	public Button Enemy0_Buff;
	public Button Enemy0_Debuff;
	public AnchorPane Enemy1;
	public Text Enemy1_Health;
	public Text Enemy1_MaxHealth;
	public Text Enemy1_Block;
	public Text Enemy1_Intend;
	public ImageView Enemy1_Image;
	public Button Enemy1_Buff;
	public Button Enemy1_Debuff;
	public AnchorPane Enemy2;
	public Text Enemy2_Health;
	public Text Enemy2_MaxHealth;
	public Text Enemy2_Block;
	public Text Enemy2_Intend;
	public ImageView Enemy2_Image;
	public Button Enemy2_Buff;
	public Button Enemy2_Debuff;
	public Button EndTurn;
	public Button Deck;
	public Button Discard;
	public AnchorPane Buff_Debuff_Pane;
	public Text Buff_Debuff_Text;
	public Button Buff_Debuff_Back;
	public Pane Hurt;
}
