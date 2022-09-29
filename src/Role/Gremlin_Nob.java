package Role;

import java.util.Random;

public class Gremlin_Nob implements IEnemy {

	@Override
	public void getIntend() {
		if (Main.CombatController.tmpBattle.Round == 1) {
			this.Bellow = true;
		} else {
			this.Bellow = false;
			int RANDOM = ran.nextInt(3);
			if (RANDOM < 2) {
				if (this.RushCount < 3) {
					this.Rush = true;
					this.RushCount++;

					this.Skull_Bash = false;
				} else {
					this.Rush = false;
					this.RushCount = 0;

					this.Skull_Bash = true;
				}
			} else {
				this.Rush = false;
				this.RushCount = 0;

				this.Skull_Bash = true;
			}
		}

	}

	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.Bellow) {
			Enemy.gotBuff("Enrage", 2);
		} else if (this.Rush) {
			Player.Hurt(Enemy.DamageCount(14));
			return;
		} else {
			Player.Hurt(Enemy.DamageCount(8));
			Player.gotDebuff("Vulnerable", 2);
			return;
		}
	}

	@Override
	public String getIntendContent(Enemy tmp) {
		if (this.Bellow) {
			return "Apply self a Buff.";
		} else if (this.Rush) {
			return "Deal " + tmp.DamageCount(14) + " Damage.";
		} else {
			return "Deal " + tmp.DamageCount(6) + " Damage and apply a Debuff.";
		}
	}

	protected boolean Bellow = false; // Apply self a Buff
	protected boolean Rush = false; // Deal damage
	protected int RushCount = 0;
	protected boolean Skull_Bash = false; // Deal Damage and apply Debuff.

	private Random ran = new Random();
}
