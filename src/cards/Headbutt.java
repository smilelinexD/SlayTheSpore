package cards;

import Role.Role;
import java.util.Random;

public class Headbutt implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			Target.Hurt(Player.DamageCount(9));
			if(!Player.getDiscard().isEmpty()) {
				int index = new Random().nextInt(Player.getDiscard().size());
				Player.addCardToDeck(false, Player.getDiscard().get(index));
				Player.removeCardFromDiscard(index);
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
	protected String Name = "Headbutt";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Deal 9 damage.\nPlace a card from your discard pile on top of your draw pile.";
}
