package cards;

import Role.Role;

public class Pummel implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			for(int i = 0; i < 4 ; i++) {
				Target.Hurt(Player.DamageCount(2));
			}
			Player.ExhaustUsing();
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
	protected String Name = "Pummel";
	protected String Type = "Attack";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Deal 2 damage 4 times.\nExhaust.";
}
