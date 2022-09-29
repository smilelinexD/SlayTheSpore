package cards;

import Role.Role;

public class Sever_Soul implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			for(int i = 0; i < Player.getHand().size(); i++) {
				if(Player.getHand().get(i).getType().equals("Attack") == false) {
					Player.Exhaust(i);
					i--;
				}
			}
			Target.Hurt(Player.DamageCount(16));
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
	protected String Name = "Sever_Soul";
	protected String Type = "Attack";
	protected String Rarity = "Uncommon";
	protected int Energy = 2;
	protected String Description = "Exhaust all non-Attack cards in your hand.\nDeal 16 damage.";
}
