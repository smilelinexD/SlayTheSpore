package cards;

import Role.Role;

public class Shockwave implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			for(Role Target : Player.getBattle().Enemies) {
				if(Target.checkDead() == false) {
					Target.gotDebuff("Weak", 3);
					Target.gotDebuff("Vulnerable", 3);
				}
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
	protected String Name = "Shockwave";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 2;
	protected String Description = "Apply 3 Weak and Vulnerable to ALL enemies.\nExhaust.";
}
