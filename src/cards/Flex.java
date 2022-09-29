package cards;

import Role.Role;

public class Flex implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Strength", 2);
			Player.gotStatus("LoseStrength", 2);
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
	protected String Name = "Flex";
	protected String Type = "Skill";
	protected String Rarity = "Common";
	protected int Energy = 0;
	protected String Description = "Gain 2 Strength.\nAt the end of your turn,\nlose 2 Strength.";

}
