package cards;

import Role.Role;

public class Disarm implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			for(Role Target : Player.getBattle().Enemies) {
				Target.gotBuff("Strength", -2);
			}
			Player.ExhaustUsing();
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
	protected String Name = "Disarm";
	protected String Type = "Power";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Enemy loses 2\nStrength.\nExhaust.";
}
