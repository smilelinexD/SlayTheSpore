package cards;

import Role.Role;

public class Dropkick implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(5));
			if(Target.getDebuff().checkVulnerable()) {
				Player.gainEnergy(1);
				Player.Draw(1);
			}
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
	protected String Name = "Dropkick";
	protected String Type = "Attack";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Deal 5 damage.\nIf the enemy has Vulnerable gain 1 energy and draw 1 card.";
}
