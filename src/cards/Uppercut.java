package cards;

import Role.Role;

public class Uppercut implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(13));
			Target.gotDebuff("Weak", 1);
			Target.gotDebuff("Vulnerable", 1);
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
	protected String Name = "Uppercut";
	protected String Type = "Attack";
	protected String Rarity = "Uncommon";
	protected int Energy = 2;
	protected String Description = "Deal 13 damage.\nApply 1 Weak.\nApply 1 Vulnerable.";
}
