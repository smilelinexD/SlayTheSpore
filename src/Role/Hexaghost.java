package Role;

import java.util.Random;

import cards.Cards;

public class Hexaghost implements IEnemy {

	@Override
	public void getIntend() {
		if (Main.CombatController.tmpBattle.Round == 1) {
			return;
		}
		if (Main.CombatController.tmpBattle.Round == 2) {
			this.Activate = false;
			this.Divider = true;
			return;
		}
		this.Divider = false;
		if (pattern % 7 == 0 || pattern % 7 == 2 || pattern % 7 == 5) {
			this.Sear = true;
			this.Tackle = false;
			this.Inflame = false;
			this.Inferno = false;
		} else if (pattern % 7 == 1 || pattern % 7 == 4) {
			this.Sear = false;
			this.Tackle = true;
			this.Inflame = false;
			this.Inferno = false;
		} else if (pattern % 7 == 3) {
			this.Sear = false;
			this.Tackle = false;
			this.Inflame = true;
			this.Inferno = false;
		} else {
			this.Sear = false;
			this.Tackle = false;
			this.Inflame = false;
			this.Inferno = true;
		}
		pattern++;
		return;
	}

	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.Activate) {
			return;
		} else if (this.Divider) {
			Player.Hurt(Enemy.DamageCount((Main.Main.hero.getHealth() / 12) + 1));
		} else if (this.Sear) {
			Player.Hurt(Enemy.DamageCount(6));
			Cards tmp = new Cards("Burn");
			tmp.setTmpInGame();
			Player.addCardToDiscard(true, tmp);
		} else if (this.Tackle) {
			for (int i = 0; i < 2; i++) {
				Player.Hurt(Enemy.DamageCount(5));
			}
		} else if (this.Inflame) {
			Enemy.gotBuff("Strength", 2);
			Enemy.gainBlock(12);
		} else {
			for (int i = 0; i < 6; i++) {
				Player.Hurt(Enemy.DamageCount(2));
			}
			Cards tmp = new Cards("Burn");
			tmp.setTmpInGame();
			Player.addCardToDiscard(true, tmp);
			Player.addCardToDiscard(true, tmp);
			Player.addCardToDiscard(true, tmp);
		}
	}

	@Override
	public String getIntendContent(Enemy tmp) {
		if (this.Activate) {
			return "(nothing)";
		} else if (this.Divider) {
			return "Deal " + tmp.DamageCount((Main.Main.hero.getHealth() / 12) + 1) + " Damage.";
		} else if (this.Sear) {
			return "Deal " + tmp.DamageCount(6) + " Damage and gives a status.";
		} else if (this.Tackle) {
			return "Deal " + tmp.DamageCount(5) + "X2 Damage";
		} else if (this.Inflame) {
			return "Block and apply self a Buff.";
		} else {
			return "Deal " + tmp.DamageCount(2) + "X6 Damage and gives status.";
		}
	}

	protected boolean Activate = true; // nothing
	protected boolean Divider = false; // Deal Damage
	protected boolean Sear = false; // Deal Damage and Give status
	protected boolean Tackle = false; // Deal Damage
	protected boolean Inflame = false; // Block and apply buff
	protected boolean Inferno = false; // Deal Damage and Give Status

	protected int pattern = 0;

	private Random ran = new Random();
}
