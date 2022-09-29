package cards;

import Role.Role;

public class Shrug_It_Off implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gainBlock(8);
			Player.Draw(1);
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
	protected String Name = "Shrug_It_Off";
	protected String Type = "Skill";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Gain 8 Block.\nDraw 1 card.";
}
