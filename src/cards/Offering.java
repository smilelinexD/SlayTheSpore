package cards;

import Role.Role;

public class Offering implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			Player.removeHp(6);
			Player.gainEnergy(2);
			Player.Draw(3);
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
	protected String Name = "Offering";
	protected String Type = "Skill";
	protected String Rarity = "Rare";
	protected int Energy = 0;
	protected String Description = "Lose 6 HP.Gain 2 Energy.Draw 3 Cards.Exhaust.";
}
