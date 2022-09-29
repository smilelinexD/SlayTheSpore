package Role;

import java.util.Random;

public class Jaw_Worm implements IEnemy {
	@Override
	public void getIntend() {
		if (Main.CombatController.tmpBattle.Round == 1) {
			this.Chomp = true;
			this.ChompCount++;
		} else {
			int RANDOM = ran.nextInt(100);
			while (true) {
				if (RANDOM < 45) {
					if (this.BellowCount < 2) {
						this.Chomp = false;
						this.ChompCount = 0;

						this.Thrash = false;
						this.ThrashCount = 0;

						this.Bellow = true;
						this.BellowCount++;
						break;
					} else {
						RANDOM = ran.nextInt(100);
						continue;
					}
				} else if (RANDOM < 75) {
					if (this.ThrashCount < 3) {
						this.Chomp = false;
						this.ChompCount = 0;

						this.Thrash = true;
						this.ThrashCount++;

						this.Bellow = false;
						this.BellowCount = 0;
						break;
					} else {
						RANDOM = ran.nextInt(100);
						continue;
					}
				} else {
					if (this.ChompCount < 2) {
						this.Chomp = true;
						this.ChompCount++;

						this.Thrash = false;
						this.ThrashCount = 0;

						this.Bellow = false;
						this.BellowCount = 0;
						break;
					} else {
						RANDOM = ran.nextInt(100);
						continue;
					}
				}
			}
		}
	}
	
	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.Chomp) {
			Player.Hurt(Enemy.DamageCount(11));
			return;
		} else if (this.Thrash) {
			Player.Hurt(Enemy.DamageCount(7));
			Enemy.gainBlock(5);
			return;
		} else {
			Enemy.gotBuff("Strength", 3);
			Enemy.gainBlock(6);
			return;
		}
	}
	
	@Override
	public String getIntendContent(Enemy tmp) {
		if (this.Chomp) {
			return "Deal " + tmp.DamageCount(11) + " Damage.";
		} else if (this.Thrash) {
			return "Deal " + tmp.DamageCount(7) + " Damage and Block.";
		} else {
			return "Block and Apply self a Buff.";
		}
	}

	protected boolean Chomp = false; // Deal Damage
	protected int ChompCount = 0;
	protected boolean Thrash = false; // Deal Damage and Block
	protected int ThrashCount = 0;
	protected boolean Bellow = false; // Apply Buff and Block
	protected int BellowCount = 0;

	private Random ran = new Random();
}
