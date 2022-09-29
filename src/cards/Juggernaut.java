package cards;

import Role.Role;

public class Juggernaut implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Juggernaut", 1);
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
	protected String Name = "Juggernaut";
	protected String Type = "Power";
	protected String Rarity = "Rare";
	protected int Energy = 2;
	protected String Description = "Whenever you gain Block, deal 5 damage to a random enemy.";
}
