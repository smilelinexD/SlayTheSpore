package cards;

import java.util.Random;
import Role.Role;

public class Sword_Boomerang implements ICards {
	// Method
	@Override
	public int Use(Role Player, Role NULL) {
		if (Player.useEnergy(this.Energy) != -1) {
			for (int i = 0; i < 3; i++) {
				int index = new Random().nextInt(Player.getBattle().Enemies.size());
				Role Target = null;
				
				int count = 0;
				for(Role tmpenemy : Player.getBattle().Enemies) {
					if(tmpenemy.checkDead()) {
						count ++;
					}
				}
				if(count == Player.getBattle().Enemies.size()) {
					return 0;
				}
				
				do {
					Target = Player.getBattle().Enemies.get(index);
				}while(Target.checkDead());
				Target.Hurt(Player.DamageCount(3));
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
	protected String Name = "Sword_Boomerang";
	protected String Type = "Attack";
	protected String Rarity = "Common";
	protected int Energy = 1;
	protected String Description = "Deal 3 damage to a\nrandom enemy 3 times.";
}
