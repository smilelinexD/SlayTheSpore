package cards;

import Role.Role;

public class Dark_Embrace implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.gotBuff("Dark_Embrace", 1);
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
	protected String Name = "Dark_Embrace";
	protected String Type = "Power";
	protected String Rarity = "Uncommon";
	protected int Energy = 2;
	protected String Description = "Whenever a card is\nExhausted,\ndraw 1 card.";
}
