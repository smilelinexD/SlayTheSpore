package cards;

import Role.Role;

public class Havoc implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role Target) {
		if (Player.useEnergy(this.Energy) != -1) {
			if (Player.getDeck().isEmpty() == false) {
				int tmpEnergy = Player.getEnergy();
				Player.setEnergy(999);
				Cards card = Player.getDeck().get(0);
				if (card.getName().equals("Sentinel")) {
					tmpEnergy += 2;
				}
				if (card.getName().equals("Havoc")) {
					Player.ExhaustDeck();
					Player.setEnergy(tmpEnergy);
					return 0;
				}
				if (card.Use(Player, Target) == -1) {
					Player.setEnergy(tmpEnergy);
					return 0;
				}
				Player.addCardToDiscard(false, card);
				Player.removeCardFromDeck(0);
				Player.ExhaustDiscard();
				Player.setEnergy(tmpEnergy);

				return 0;
			} else {
				return -1;
			}
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
	protected String Name = "Havoc";
	protected String Type = "Skill";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Play the top card of your draw pile and Exhaust it.";
}
