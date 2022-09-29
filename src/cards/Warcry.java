package cards;

import java.util.Random;
import Role.Role;

public class Warcry implements ICards{
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			Player.Draw(1);
			int index = new Random().nextInt(Player.getHand().size());
			Player.addCardToDeck(false, Player.getHand().get(index));
			Player.removeCardFromHand(index);
			Player.ExhaustUsing();
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
	protected String Name = "Warcry";
	protected String Type = "Skill";
	protected String Rarity = "Common";
	protected int Energy = 0;
	protected String Description = "Draw 1 card.\nPlace a card from your hand on top of your draw pile.\nExhaust.";
}
