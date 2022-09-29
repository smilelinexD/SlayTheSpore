package cards;

import Role.Role;

public class Burn implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		return -1;
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
	protected String Name = "Burn";
	protected String Type = "Status";
	protected String Rarity = "Common";
	protected int Energy = -1;
	protected String Description = "Unplayable.\nAt the end of your turn, take 2 damage.";
}
