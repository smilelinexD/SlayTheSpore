package cards;

import Role.Role;

public class Flame_Barrier implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gainBlock(12);
			Player.gotBuff("Flame_Barrier", 1);
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
	protected String Name = "Flame_Barrier";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 2;
	protected String Description = "Gain 12 Block.\nWhenever you are attacked this turn, deal 4 damage back.";
}
