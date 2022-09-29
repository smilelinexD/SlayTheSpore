package cards;

import java.util.Random;
import Role.Role;

public class True_Gift implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gainBlock(7);
			Player.Exhaust(new Random().nextInt(Player.getHand().size()));
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
	protected String Name = "True_Gift";
	protected String Type = "Skill";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Gain 7 Block.\nExhaust a random card in yor hand.";
}
