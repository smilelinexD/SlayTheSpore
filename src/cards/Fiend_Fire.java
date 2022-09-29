package cards;

import Role.Role;

public class Fiend_Fire implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			int size = Player.getHand().size();
			
			for(int i = 0; i < size; i++) {
				Player.Exhaust(0);
			}
			Target.Hurt(Player.DamageCount(7 * size));
			
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
	protected String Name = "Fiend_Fire";
	protected String Type = "Attack";
	protected String Rarity = "Rare";
	protected int Energy = 2;
	protected String Description = "Exhaust all cards in your hand.\nDeal 7 damage for each Exhaust card.Exhaust.";
}
