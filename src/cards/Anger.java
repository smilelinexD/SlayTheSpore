package cards;

import Role.Role;

public class Anger implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(6));
			Cards tmp = new Cards("Anger");
			tmp.setTmpInGame();
			Player.addCardToDiscard(false, tmp);
			tmp = null;
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
	protected String Name = "Anger";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 0;
	protected String Description = "Deal 6 damage.\nAdd a copy of this card to your discard pile.";
}
