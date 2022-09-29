package cards;

import Role.Role;

public class Blood_For_Blood implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if(this.Energy - Main.Main.hero.getGotHitInCombat() < 0) {
			Target.Hurt(Player.DamageCount(18));
			return 0;
		}
		else {
			if (Player.useEnergy(this.Energy - Player.getGotHitInCombat()) != -1) {
				Target.Hurt(Player.DamageCount(18));
				return 0;
			} else {
				return -1;
			}
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
		if(this.Energy - Main.Main.hero.getGotHitInCombat() < 0) {
			return 0;
		}
		else {
			return this.Energy - Main.Main.hero.getGotHitInCombat();
		}
	}

	@Override
	public String getDescription() {
		return this.Description;
	}

	// Member
	protected String Name = "Blood_For_Blood";
	protected String Type = "Attack";
	protected String Rarity = "Uncommon";
	protected int Energy = 4;
	protected String Description = "Cost 1 less energy for each time you lose HP in combat.\nDeal 18 damage.";
}
