package Main;

import Role.Role;
import cards.Cards;

public interface IMain {
	String getBuffContents(Role role);
	String getDebuffContents(Role role);
	Cards generateCard();
	void generateEnemy(boolean Elite, int Stage);
	void gotBuff(Role role, String Type, int Lvl);
	void gotDebuff(Role role, String Type, int Duration);
}
