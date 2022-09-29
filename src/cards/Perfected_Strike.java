package cards;

import Role.Role;

public class Perfected_Strike implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			int count = 0;
			for(Cards tmpcard : Player.getHand()) {
				if(tmpcard.getName().contains("Strike")) {
					count ++;
				}
			}
			Target.Hurt(Player.DamageCount(6 + count * 2));
			return 0;
		} else {
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
	protected String Name = "Perfected_Strike";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 2;
	protected String Description = "Deal 6 damage. Deals 2 addition damage for ALL your cards contains \"Strike\".";
}
