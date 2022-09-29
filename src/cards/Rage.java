package cards;

import Role.Role;

public class Rage implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Rage", 1);
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
	protected String Name = "Rage";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 0;
	protected String Description = "Whenever you play an Attack this turn, gain 3 Block.";
}
