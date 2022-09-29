package cards;

import Role.Role;

public class Bloodletting implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.removeHp(3);
			Player.gainEnergy(1);
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
	protected String Name = "Bloodletting";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 0;
	protected String Description = "Lose 3 HP.\nGain 1 Energy.";
}
