package cards;

import Role.Role;

public interface ICards {
	int Use(Role Player, Role Target);
	String getName();
	String getType();
	String getRarity();
	int getEnergy();
	String getDescription();
}
