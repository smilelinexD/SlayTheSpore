package cards;

import Role.Role;

public class Power_Through implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Null) {
		if(Player.useEnergy(this.Energy) != -1) {
			Cards tmp = new Cards("Wound");
			Player.addCardToHand(tmp);
			Player.addCardToHand(tmp);
			Player.gainBlock(15);
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
	protected String Name = "Power_through";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Add 2 Wounds into your hand.\nGain 15 Block.";
}
