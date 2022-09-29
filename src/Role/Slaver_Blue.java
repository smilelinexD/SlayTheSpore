package Role;

import java.util.Random;

public class Slaver_Blue implements IEnemy {
	@Override
	public void getIntend() {
		int RANDOM = ran.nextInt(5);
		while (true) {
			if (RANDOM < 2) {
				if (this.RakeCount < 3) {
					this.Stab = false;
					this.StabCount = 0;

					this.Rake = true;
					this.RakeCount++;
					break;
				} else {
					this.Stab = true;
					this.StabCount++;

					this.Rake = false;
					this.RakeCount = 0;
					break;
				}
			} else {
				if (this.StabCount < 3) {
					this.Stab = true;
					this.StabCount++;

					this.Rake = false;
					this.RakeCount = 0;
					break;
				} else {
					this.Stab = false;
					this.StabCount = 0;

					this.Rake = true;
					this.RakeCount++;
					break;
				}
			}
		}
	}

	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.Stab) {
			Player.Hurt(Enemy.DamageCount(12));
			return;
		} else {
			Player.Hurt(Enemy.DamageCount(7));
			Player.gotDebuff("Weak", 1);
			return;
		}
	}

	@Override
	public String getIntendContent(Enemy tmp) {
		if (this.Stab) {
			return "Deal " + tmp.DamageCount(12) + " Damage.";
		} else {
			return "Deal " + tmp.DamageCount(7) + " Damage and apply a Debuff.";
		}
	}

	protected boolean Stab = false; // Deal Damage
	protected int StabCount = 0;
	protected boolean Rake = false; // Deal Damage and applt debuff
	protected int RakeCount = 0;

	private Random ran = new Random();
}
