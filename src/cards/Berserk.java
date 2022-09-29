package cards;

import Role.Role;

public class Berserk implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			Player.gotDebuff("Vulnerable", 2);
			Player.gotBuff("Berserk", 1);
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
	protected String Name = "Berserk";
	protected String Type = "Power";
	protected String Rarity = "Rare";
	protected int Energy = 0;
	protected String Description = "Gain 2 Vulnerable.\nAt the start of ypur turn, gain 1 Energy.";
}
