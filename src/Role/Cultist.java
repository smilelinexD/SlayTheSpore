package Role;

public class Cultist implements IEnemy{
	@Override
	public void getIntend() {
		if(Main.CombatController.tmpBattle.Round == 1) {
			this.Incantation = true;
		}
		else {
			this.Dark_Strike = true;
			
			this.Incantation = false;
		}
	}
	
	@Override
	public void EnemyTurn(Role Enemy, Role Player) {
		if(this.Dark_Strike) {
			Player.Hurt(Enemy.DamageCount(6));
		}
		else {
			Enemy.gotBuff("Strength", -3);
			Enemy.gotBuff("Ritual", 3);
		}
	}
	
	@Override
	public String getIntendContent(Enemy tmp) {
		if(this.Incantation) {
			return "Apply self a buff.";
		}
		else {
			int dmg = tmp.DamageCount(6);
			return "Deal " + dmg + " Damage.";
		}
	}
	
	protected boolean Dark_Strike = false;	//Deal Damage
	protected boolean Incantation = false;	//Apply Buff
}
