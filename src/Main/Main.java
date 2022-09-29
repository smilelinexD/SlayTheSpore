package Main;
//import java.util.ArrayList;

import Role.*;
import cards.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage currentStage;
	public static Scene menuScene;
	public static int Stage = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		currentStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		menuScene = new Scene(root);

		currentStage.setTitle("Slay the spore");
		currentStage.setScene(menuScene);
		currentStage.show();
	}

	public static void main(String[] args) {
		Cards tmp = new Cards("Bash"); // Line28~43: �򥻵P��
		hero.addCardToDeck(false, tmp);
		tmp = null;
		tmp = new Cards("Defend");
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		tmp = null;
		tmp = new Cards("Strike");
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		hero.addCardToDeck(false, tmp);
		tmp = null;
		launch(args);
	}

	public static Battle tmpBattle = new Battle();
	public static Ironclad hero = new Ironclad("Ironclad", 80, 3);

}
