package cards;

import Role.Role;

public class Cleave implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Null) {
		if(Player.useEnergy(this.Energy) != -1) {
			for(Role Target : Player.getBattle().Enemies) {
				if(Target.checkDead() == false) {
					Target.Hurt(Player.DamageCount(8));
				}
			}
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
	protected String Name = "Cleave";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Deal 8 damage to ALL enemies.";
}
