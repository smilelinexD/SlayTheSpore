package cards;

import Role.Role;

public class Clothesline implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(12));
			Target.gotDebuff("Weak", 2);
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
	protected String Name = "Clothesline";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 2;
	protected String Description = "Deal 12 damage. Apply 2 Weak.";
}
