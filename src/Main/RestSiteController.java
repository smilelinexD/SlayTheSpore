package Main;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class RestSiteController extends Main{
	@FXML
	public Button Continue;

	@FXML
	public void onContinuePressed() throws IOException {
		hero.gainHp((int)(hero.getMaxHealth() * 0.2));
		Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Scene menuScene = new Scene(menu);
		menuScene.getRoot().requestFocus();
		Main.currentStage.setScene(menuScene);
	}
}
