package Role;

import java.util.Random;

public class Louse_Green implements IEnemy {
	@Override
	public void getIntend() {
		int RANDOM = ran.nextInt(4);
		if (RANDOM == 0) {
			if (this.Spit_WebCount < 3) {
				this.Bite = false;
				this.BiteCount = 0;

				this.Spit_Web = true;
				this.Spit_WebCount++;
			} else {
				this.Bite = true;
				this.BiteCount++;

				this.Spit_Web = false;
				this.Spit_WebCount = 0;
			}
		} else {
			if (this.BiteCount < 3) {
				this.Bite = true;
				this.BiteCount++;

				this.Spit_Web = false;
				this.Spit_WebCount = 0;
			} else {
				this.Bite = false;
				this.BiteCount = 0;

				this.Spit_Web = true;
				this.Spit_WebCount++;
			}
		}
	}
	
	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (Enemy.getGotHitInCombat() != 0 && !this.Curled) {
			Enemy.gainBlock(Dice);
			this.Curled = true;
			return;
		} else if (this.Bite) {
			Player.Hurt(Enemy.DamageCount(Dice + 1));
			return;
		} else {
			Player.gotDebuff("Weak", 2);
			return;
		}
	}
	
	@Override
	public String getIntendContent(Enemy tmp) {
		if (tmp.getGotHitInCombat() != 0 && !this.Curled) {
			return "Block.";
		} else if (this.Bite) {
			return "Deal " + tmp.DamageCount(Dice + 1) + " Damage.";
		} else {
			return "Apply a Debuff.";
		}
	}

	protected boolean Bite = false; // Deal Damage
	protected int BiteCount = 0;
	protected boolean Spit_Web = false; // Deal Damage and Block
	protected int Spit_WebCount = 0;
	protected boolean Curled = false;

	private Random ran = new Random();
	private int Dice = 7 - ran.nextInt(3);
}
