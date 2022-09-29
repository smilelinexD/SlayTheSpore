package cards;

import Role.Role;

public class Entrench implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gainBlock(Player.getBlock());
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
	protected String Name = "Entrench";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 2;
	protected String Description = "Double your Block.";
}
