package cards;

import Role.Role;

public class Evolve implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Evolve", 1);
			Player.removeUsing();
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
	protected String Name = "Evolve";
	protected String Type = "Power";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Whenever you draw a\nStatus card, draw 1\ncard.";
}
