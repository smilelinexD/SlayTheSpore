package cards;

import Role.Role;

public class Barricade implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Barricade", 1);
			Player.removeUsing();
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
	protected String Name = "Barricade";
	protected String Type = "Power";
	protected String Rarity = "Rare";
	protected int Energy = 3;
	protected String Description = "Block is not removed at the start of yout turn.";
}
