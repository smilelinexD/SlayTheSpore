package cards;

import Role.Role;

public class Heavy_Blade implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(14, 3));
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
	protected String Name = "Heavy_Blade";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 2;
	protected String Description = "Deal 14 damage.\nStrength affects this card 3 times.";
}
