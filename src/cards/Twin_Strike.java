package cards;

import Role.Role;

public class Twin_Strike implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			for (int i = 0; i < 2; i++) {
				Target.Hurt(Player.DamageCount(5));
			}
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
	protected String Name = "Twin_Strike";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Deal 5 damage twice.";
}
