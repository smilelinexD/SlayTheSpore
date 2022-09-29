package cards;

import Role.Role;

public class Feed implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(10));
			if(Target.checkDead()) {
				Player.gainMaxHp(3);
				Player.gainHp(3);
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
	protected String Name = "Feed";
	protected String Type = "Skill";
	protected String Rarity = "Rare";
	protected int Energy = 1;
	protected String Description = "Deal 10 damage.\nIf Fatal, raise your Max HP by 3.Exhaust.";
}
