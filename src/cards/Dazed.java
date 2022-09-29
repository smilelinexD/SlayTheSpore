package cards;

import Role.Role;

public class Dazed implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		return -1;
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
	protected String Name = "Dazed";
	protected String Type = "Status";
	protected String Rarity = "Common";
	protected int Energy = -1;
	protected String Description = "Unplayable.\nEthereal.";
}
