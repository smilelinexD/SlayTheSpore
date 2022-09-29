package Role;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
	// Constructor
	public Battle() {
	}

	// Method

	public boolean checkEnd() {
		if (hero.getHealth() <= 0) {
			return true;
		}
		for (Enemy tmp : Enemies) {
			if (tmp.getHealth() > 0) {
				return false;
			}
		}
		return true;
	}

	// Member
	public int Round = 1;
	public Ironclad hero = null;
	public ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
	public int DropGold = 20 - new Random().nextInt(11);
}
