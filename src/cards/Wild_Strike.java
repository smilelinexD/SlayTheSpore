package cards;

import Role.Role;

public class Wild_Strike implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(12));
			Cards Wound = new Cards("Wound");
			Wound.setTmpInGame();
			Player.addCardToDeck(true, Wound);
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
	protected String Name = "Wild_Strike";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Deal 12 damage.\nShuffle a Wound into your draw pile.";
}
