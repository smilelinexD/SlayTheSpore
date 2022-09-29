package Role;

import java.util.Random;

public class Fungi_Beast implements IEnemy {

	@Override
	public void getIntend() {
		int RANDOM = ran.nextInt(5);
		if (RANDOM < 3) {
			if (this.BiteCount < 3) {
				this.Bite = true;
				this.BiteCount++;

				this.Grow = false;
				this.GrowCount = 0;
			} else {
				this.Bite = false;
				this.BiteCount = 0;

				this.Grow = true;
				this.GrowCount++;
			}
		} else {
			if (this.GrowCount < 2) {
				this.Bite = false;
				this.BiteCount = 0;

				this.Grow = true;
				this.GrowCount++;
			} else {
				this.Bite = true;
				this.BiteCount++;

				this.Grow = false;
				this.GrowCount = 0;
			}
		}
	}
	
	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.Bite) {
			Player.Hurt(Enemy.DamageCount(6));
		} else{
			Enemy.gotBuff("Strength", 3);
			return;
		}
	}

	@Override
	public String getIntendContent(Enemy tmp) {
		if (this.Bite) {
			return "Deal " + tmp.DamageCount(6) + " Damage.";
		} else {
			return "Apply self a Buff.";
		}
	}

	protected boolean Bite = false; // Deal damage
	protected int BiteCount = 0;
	protected boolean Grow = false; // Apply self a Buff
	protected int GrowCount = 0;

	private Random ran = new Random();
}
