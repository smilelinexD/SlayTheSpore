package cards;

import Role.Role;

public class Immolate implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if(Player.useEnergy(this.Energy) != -1) {
			for(Role Target : Player.getBattle().Enemies) {
				Target.Hurt(Player.DamageCount(21));
			}
			Player.addCardToDiscard(false, new Cards("Burn"));
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
	protected String Name = "Immolate";
	protected String Type = "Attack";
	protected String Rarity = "Rare";
	protected int Energy = 2;
	protected String Description = "Deal 21 damage to ALL enemies.\nAdd a Burn into your discard pile.";
}
