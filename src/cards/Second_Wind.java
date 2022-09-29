package cards;

import Role.Role;

public class Second_Wind implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			int count = 0;
			for(int i = 0; i < Player.getHand().size(); i++) {
				if(Player.getHand().get(i).getType().equals("Attack") == false) {
					Player.Exhaust(i);
					count ++;
				}
			}
			Player.gainBlock(count * 5);
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
	protected String Name = "Second_Wind";
	protected String Type = "Skill";
	protected String Rarity = "Uncommon";
	protected int Energy = 1;
	protected String Description = "Exhaust all non-attack cards in your hand and gain 5 Block for each card Exhausted.";
}
