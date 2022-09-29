package Role;

import java.util.Random;

public class Lagavulin implements IEnemy {

	@Override
	public void getIntend() {
		if(this.Asleep) {
			return;
		}
		if (this.Stun) {
			if (!this.AlreadyStunned) {
				return;
			} else if (this.AttackCount < 2) {
				this.Attack = true;
				this.AttackCount++;

				this.Siphon_Soul = false;
			} else {
				this.Attack = false;
				this.AttackCount = 0;

				this.Siphon_Soul = true;
			}
		}
	}

	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if (this.StoredHP != -1 && this.StoredHP != Enemy.getHealth()) {
			Enemy.gotBuff("Metallicize", -1);
			this.StoredHP = Enemy.getHealth();
		}
		if (this.Asleep) {
			return;
		} else if (this.Stun && (!this.AlreadyStunned)) {
			this.AlreadyStunned = true;
			return;
		} else if(this.Attack){
			Player.Hurt(Enemy.DamageCount(18));
			return;
		}else {
			Player.gotBuff("Strength", -1);
			Player.gotBuff("Dexterity", -1);
			return;
		}
	}

	@Override
	public String getIntendContent(Enemy tmp) {
		if (tmp.getHealth() != tmp.getMaxHealth() && this.AlreadyStunned == false) {
			this.Asleep = false;
			this.Stun = true;
			this.StoredHP = tmp.getHealth();
			return "(Stunned)";
		} else if (this.Asleep) {
			return "(Asleep)";
		} else if (this.Attack) {
			return "Deal " + tmp.DamageCount(18) + " Damage.";
		} else {
			return "Apply Debuffs.";
		}
	}

	protected boolean Asleep = true; // (Asleep)
	protected boolean Stun = false; // (Stunned)
	protected boolean AlreadyStunned = false;
	protected boolean Attack = false; // Deal damage
	protected int AttackCount = 0;
	protected boolean Siphon_Soul = false; // Deal Damage and apply Debuff.
	protected int StoredHP = -1;
}
