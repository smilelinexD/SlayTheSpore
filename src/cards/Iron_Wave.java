package cards;

import Role.Role;

public class Iron_Wave implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gainBlock(5);
			Target.Hurt(Player.DamageCount(5));
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
	protected String Name = "Iron_Wave";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Gain 5 Block.\nDeal 5 damage.";
}
