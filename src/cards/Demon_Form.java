package cards;

import Role.Role;

public class Demon_Form implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Demon_Form", 1);
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
	protected String Name = "Demon_Form";
	protected String Type = "Power";
	protected String Rarity = "Rare";
	protected int Energy = 3;
	protected String Description = "At the start of your turn, gain 2 Strength.";
}
