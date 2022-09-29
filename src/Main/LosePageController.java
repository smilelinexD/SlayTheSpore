package Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LosePageController {
	@FXML
	public Button Exit;
	
	@FXML
	public void onExitPressed() {
		Main.currentStage.close();
	}
}
