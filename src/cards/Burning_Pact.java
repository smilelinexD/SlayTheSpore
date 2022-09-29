package cards;

import java.util.Random;
import Role.Role;

public class Burning_Pact implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			if(Player.getHand().size() != 0) {
				Player.Exhaust(new Random().nextInt(Player.getHand().size()));
			}
			Player.Draw(2);
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
	protected String Name = "Burning_Pact";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Exhaust 1 card.\nDraw 2 cards.";
}
