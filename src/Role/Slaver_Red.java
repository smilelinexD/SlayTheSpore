package Role;

import java.util.Random;

public class Slaver_Red implements IEnemy {
	@Override
	public void getIntend() {
		if (Main.CombatController.tmpBattle.Round == 1) {
			this.Stab = true;
		} else {
			if (this.AlreadyEntangled == false) {
				int RANDOM = ran.nextInt(4);
				if (RANDOM == 0) {
					this.Stab = false;
					this.Scrape = false;
					this.Entangle = true;
					return;
				}
				if (pattern % 3 == 0) {
					this.Stab = true;
					this.Scrape = false;
					this.Entangle = false;
					pattern++;
				} else {
					this.Stab = false;
					this.Scrape = true;
					this.Entangle = false;
					pattern++;
				}
			} else {
				int RANDOM = ran.nextInt(100);
				if (RANDOM < 45) {
					if (this.StabCount < 3) {
						this.Stab = true;
						this.StabCount ++;
						
						this.Scrape = false;
						this.ScrapeCount = 0;
					}
					else {
						this.Stab = false;
						this.StabCount = 0;
						
						this.Scrape = true;
						this.ScrapeCount ++;
					}
				}
				else {
					if(this.ScrapeCount < 3) {
						this.Stab = false;
						this.StabCount = 0;
						
						this.Scrape = true;
						this.ScrapeCount ++;
					}
					else {
						this.Stab = true;
						this.StabCount ++;
						
						this.Scrape = false;
						this.ScrapeCount = 0;
					}
				}
			}
		}

	}

	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.Stab) {
			Player.Hurt(Enemy.DamageCount(13));
			return;
		} else if (this.Scrape){
			Player.Hurt(Enemy.DamageCount(8));
			Player.gotDebuff("Vulnerable", 1);
			return;
		} else {
			Player.gotDebuff("Entangled", 1);
		}
	}

	@Override
	public String getIntendContent(Enemy tmp) {
		if (this.Stab) {
			return "Deal " + tmp.DamageCount(13) + " Damage.";
		} else if (this.Scrape){
			return "Deal " + tmp.DamageCount(8) + " Damage and apply a Debuff.";
		} else {
			return "Apply a Debuff.";
		}
	}

	protected boolean Stab = false; // Deal Damage
	protected int StabCount = 0;
	protected boolean Scrape = false; // Deal Damage and apply debuff
	protected int ScrapeCount = 0;
	protected boolean Entangle = false;
	protected boolean AlreadyEntangled = false;

	private int pattern = 1;
	private Random ran = new Random();
}
