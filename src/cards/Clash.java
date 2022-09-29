package cards;

import Role.Role;

public class Clash implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		for(Cards hand : Player.getHand()) {
			if(!hand.getType().equals("Attack")) {
				return -1;
			}
		}
		if(Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(14));
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
	protected String Name = "Clash";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 0;
	protected String Description = "Can only be played if every card in your hand is an Attack.\nDeal 14 damage.";
}