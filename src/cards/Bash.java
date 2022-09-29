package cards;

import Role.Role;

public class Bash implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(8));
			Target.gotDebuff("Vulnerable", 2);
			return 0;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String getName() {
		return this.Name;
	}
	
	@Override
	public String getType() {
		return this.Type;
	}
	
	@Override
	public String getRarity() {
		return this.Rarity;
	}
	
	@Override
	public int getEnergy() {
		return this.Energy;
	}
	
	@Override
	public String getDescription() {
		return this.Description;
	}
	
	// Member
	protected String Name = "Bash";
	protected String Type = "Attack";
	protected String Rarity = "Basic";
	protected int Energy = 2;
	protected String Description = "Deal 8 damage.\nApply 2 Vulnerable.";
}
