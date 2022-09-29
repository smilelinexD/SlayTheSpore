package Main;

import java.util.Random;

import Role.Enemy;
import Role.Role;
import cards.Cards;

public class MainFunctions extends Main implements IMain {
	
	public MainFunctions() {};

	public String getBuffContents(Role role) {
		if (role.getBuff().checkBuff() == false) {
			return "(none)";
		} else {
			String tmp = "";
			if (role.getBuff().checkBarricade()) {
				tmp += "Barricade\n";
			}
			if (role.getBuff().checkBerserk()) {
				tmp += "Berserk, " + role.getBuff().getBerserkLvl() + "\n";
			}
			if (role.getBuff().checkBrutality()) {
				tmp += "Brutality, " + role.getBuff().getBrutalityLvl() + "\n";
			}
			if (role.getBuff().checkCombust()) {
				tmp += "Combust, " + role.getBuff().getCombustLvl() + "\n";
			}
			if (role.getBuff().checkDark_Embrace()) {
				tmp += "Dark_Embrace, " + role.getBuff().getDark_EmbraceLvl() + "\n";
			}
			if (role.getBuff().checkDemon_Form()) {
				tmp += "Demon_Form, " + role.getBuff().getDemon_FormLvl() + "\n";
			}
			if (role.getBuff().checkDexterity()) {
				tmp += "Dexterity, " + role.getBuff().getDexterityLvl() + "\n";
			}
			if (role.getBuff().checkEnrage()) {
				tmp += "Enrage, " + role.getBuff().getEnrageLvl() + "\n";
			}
			if (role.getBuff().checkEvolve()) {
				tmp += "Evolve, " + role.getBuff().getEvolveLvl() + "\n";
			}
			if (role.getBuff().checkFeel_No_Pain()) {
				tmp += "Feel_No_Pain, " + role.getBuff().getFeel_No_PainLvl() + "\n";
			}
			if (role.getBuff().checkFire_Breathing()) {
				tmp += "Fire_Breathing, " + role.getBuff().getFire_BreathingLvl() + "\n";
			}
			if (role.getBuff().checkFlame_Barrier()) {
				tmp += "Flame_Barrier, " + role.getBuff().getFlame_BarrierLvl() + "\n";
			}
			if (role.getBuff().checkJuggernaut()) {
				tmp += "Juggernaut, " + role.getBuff().getJuggernautLvl() + "\n";
			}
			if (role.getBuff().checkMetallicize()) {
				tmp += "Metallicize, " + role.getBuff().getMetallicizeLvl() + "\n";
			}
			if (role.getBuff().checkRage()) {
				tmp += "Rage, " + role.getBuff().getRageLvl() + "\n";
			}
			if (role.getBuff().checkRitual()) {
				tmp += "Ritual, " + role.getBuff().getRitualLvl() + "\n";
			}
			if (role.getBuff().checkStrength()) {
				tmp += "Strength, " + role.getBuff().getStrengthLvl() + "\n";
			}
			return tmp;
		}
	}

	public String getDebuffContents(Role role) {
		if (role.getDebuff().checkDebuff() == false) {
			return "(none)";
		} else {
			String tmp = "";
			if (role.getDebuff().checkCantDraw()) {
				tmp += "CantDraw, " + role.getDebuff().getCantDrawDuration() + "\n";
			}
			if (role.getDebuff().checkEntangled()) {
				tmp += "Entangled, " + role.getDebuff().getEntangledDuration() + "\n";
			}
			if (role.getDebuff().checkVulnerable()) {
				tmp += "Vulnerable, " + role.getDebuff().getVulnerableDuration() + "\n";
			}
			if (role.getDebuff().checkWeak()) {
				tmp += "Weak, " + role.getDebuff().getWeakDuration() + "\n";
			}
			return tmp;
		}
	}

	public Cards generateCard() {
		int Rarity = ran.nextInt(100);
		if (Rarity < 60) {	// Common
			int index = ran.nextInt(20);
			switch (index) {
			case 0:
				return new Cards("Anger");
			case 1:
				return new Cards("Armaments");
			case 2:
				return new Cards("Body_Slam");
			case 3:
				return new Cards("Clash");
			case 4:
				return new Cards("Cleave");
			case 5:
				return new Cards("Clothesline");
			case 6:
				return new Cards("Flex");
			case 7:
				return new Cards("Havoc");
			case 8:
				return new Cards("Headbutt");
			case 9:
				return new Cards("Heavy_Blade");
			case 10:
				return new Cards("Iron_Wave");
			case 11:
				return new Cards("Perfected_Strike");
			case 12:
				return new Cards("Pommel_Strike");
			case 13:
				return new Cards("Shrug_It_Off");
			case 14:
				return new Cards("Sword_Boomerang");
			case 15:
				return new Cards("Thunderclap");
			case 16:
				return new Cards("True_Gift");
			case 17:
				return new Cards("Twin_Strike");
			case 18:
				return new Cards("Warcry");
			case 19:
				return new Cards("Wild_Strike");
			}
		} else if (Rarity < 97) {	// Uncommon
			int index = ran.nextInt(31);
			switch (index) {
			case 0:
				return new Cards("Battle_Trance");
			case 1:
				return new Cards("Blood_For_Blood");
			case 2:
				return new Cards("Bloodletting");
			case 3:
				return new Cards("Burning_Pact");
			case 4:
				return new Cards("Carnage");
			case 5:
				return new Cards("Combust");
			case 6:
				return new Cards("Dark_Embrace");
			case 7:
				return new Cards("Disarm");
			case 8:
				return new Cards("Dropkick");
			case 9:
				return new Cards("Dual_Wield");
			case 10:
				return new Cards("Entrench");
			case 11:
				return new Cards("Evolve");
			case 12:
				return new Cards("Feel_No_Pain");
			case 13:
				return new Cards("Fire_Breathing");
			case 14:
				return new Cards("Flame_Barrier");
			case 15:
				return new Cards("Ghostly_Armor");
			case 16:
				return new Cards("Hemokinesis");
			case 17:
				return new Cards("Inflame");
			case 18:
				return new Cards("Metallicize");
			case 19:
				return new Cards("Power_Through");
			case 20:
				return new Cards("Pummel");
			case 21:
				return new Cards("Rage");
			case 22:
				return new Cards("Reckless_Charge");
			case 23:
				return new Cards("Searing_Blow");
			case 24:
				return new Cards("Second_Wind");
			case 25:
				return new Cards("Seeing_Red");
			case 26:
				return new Cards("Sentinel");
			case 27:
				return new Cards("Sever_Soul");
			case 28:
				return new Cards("Shockwave");
			case 29:
				return new Cards("Uppercut");
			case 30:
				return new Cards("Whirlwind");
			}
		} else {	// Rare
			switch(ran.nextInt(12)) {
			case 0:
				return new Cards("Barricade");
			case 1:
				return new Cards("Berserk");
			case 2:
				return new Cards("Bludgeon");
			case 3:
				return new Cards("Brutality");
			case 4:
				return new Cards("Demon_Form");
			case 5:
				return new Cards("Feed");
			case 6:
				return new Cards("Fiend_Fire");
			case 7:
				return new Cards("Immolate");
			case 8 :
				return new Cards("Impervious");
			case 9:
				return new Cards("Juggernaut");
			case 10:
				return new Cards("Limit_Break");
			case 11:
				return new Cards("Offering");
			}
			return new Cards("Anger");
		}
		return null;
	}

	public void generateEnemy(boolean Elite, int Stage) {
		if (Stage <= 3) {
			switch (ran.nextInt(3)) {
			case 0:
				this.generateCultist();
				break;
			case 1:
				this.generateJaw_Worm();
				break;
			case 2:
				for (int i = 0; i < 2; i++) {
					this.generateLouse();
				}
			}
		} else if (Stage <= 8) {
			if (Elite) {
				switch (ran.nextInt(2)) {
				case 0:
					this.generateGremlin_Nob();
					break;
				case 1:
					this.generateLagavulin();
					break;
				}
			} else { // normal encounter
				int RANDOM = ran.nextInt(20);
				if (RANDOM < 4) {
					this.generateSlaver_Blue();
				} else if (RANDOM < 6) {
					this.generateSlaver_Red();
				} else if (RANDOM < 10) {
					for (int i = 0; i < 3; i++) {
						this.generateLouse();
					}
				} else if (RANDOM < 14) {
					for (int i = 0; i < 2; i++) {
						this.generateFungi_Beast();
					}
				} else if (RANDOM < 17) {
					this.generateLouse();
					switch (ran.nextInt(2)) {
					case 0:
						switch (ran.nextInt(2)) {
						case 0:
							this.generateSlaver_Blue();
							break;
						case 1:
							this.generateSlaver_Red();
							break;
						}
						break;
					case 1:
						this.generateCultist();
						break;
					}
				} else {
					switch (ran.nextInt(2)) {
					case 0:
						this.generateFungi_Beast();
						break;
					case 1:
						this.generateJaw_Worm();
						break;
					}
					this.generateLouse();
				}
			}
		} else if (Stage == 10) {
			this.generateHexaghost();
		}
	}

	public void gotBuff(Role role, String Type, int Lvl) {
		switch (Type) {
		case "Strength":
			role.getBuff().gotStrength(Lvl);
			break;
		case "Ritual":
			role.getBuff().gotRitual(Lvl);
			break;
		case "Dexterity":
			role.getBuff().gotDexterity(Lvl);
			break;
		case "Metallicize":
			role.getBuff().gotMetallicize(Lvl);
			break;
		case "Rage":
			role.getBuff().gotRage(Lvl);
			break;
		case "Enrage":
			role.getBuff().gotEnrage(Lvl);
			break;
		case "Evolve":
			role.getBuff().gotEvolve(Lvl);
			break;
		case "Combust":
			role.getBuff().gotCombust(Lvl);
			break;
		case "Dark_Embrace":
			role.getBuff().gotDark_Embrace(Lvl);
			break;
		case "Feel_No_Pain":
			role.getBuff().gotFeel_No_Pain(Lvl);
			break;
		case "Fire_Breathing":
			role.getBuff().gotFire_Breathing(Lvl);
			break;
		case "Flame_Barrier":
			role.getBuff().gotFlame_Barrier(Lvl);
			break;
		case "Barricade":
			role.getBuff().gotBarricade();
			break;
		case "Berserk":
			role.getBuff().gotBerserk(Lvl);
			break;
		case "Brutality":
			role.getBuff().gotBrutality(Lvl);
			break;
		case "Demon_Form":
			role.getBuff().gotDemon_Form(Lvl);
			break;
		case "Juggernaut":
			role.getBuff().gotJuggernaut(Lvl);
			break;
		
		default:
			break;
		}
	}

	public void gotDebuff(Role role, String Type, int Duration) {
		switch (Type) {
		case "Vulnerable":
			role.getDebuff().GotVulnerable(Duration);
			break;
		case "Weak":
			role.getDebuff().GotWeak(Duration);
			break;
		case "Entangled":
			role.getDebuff().GotEntangled(Duration);
			break;
		case "Cantdraw":
			role.getDebuff().gotCantDraw(Duration);
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("static-access")
	private void generateCultist() {
		int HP = 54 - ran.nextInt(7);
		Enemy tmp = new Enemy("Cultist", HP, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
		return;
	}

	@SuppressWarnings("static-access")
	private void generateJaw_Worm() {
		int HP = 44 - ran.nextInt(5);
		Enemy tmp = new Enemy("Jaw_Worm", HP, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	@SuppressWarnings("static-access")
	private void generateLouse() {
		int HP;
		Enemy tmp = null;
		switch (ran.nextInt(2)) {
		case 0:
			HP = 15 - ran.nextInt(6);
			tmp = new Enemy("Louse_Red", HP, 999);
			tmp.setBattle(tmpBattle);
			super.tmpBattle.Enemies.add(tmp);
			tmp = null;
			break;
		case 1:
			HP = 15 - ran.nextInt(6);
			tmp = new Enemy("Louse_Green", HP, 999);
			tmp.setBattle(tmpBattle);
			super.tmpBattle.Enemies.add(tmp);
			tmp = null;
			break;
		}
	}

	@SuppressWarnings("static-access")
	private void generateGremlin_Nob() {
		int HP = 86 - ran.nextInt(5);
		Enemy tmp = new Enemy("Gremlin_Nob", HP, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	@SuppressWarnings("static-access")
	private void generateLagavulin() {
		int HP = 111 - ran.nextInt(3);
		Enemy tmp = new Enemy("Lagavulin", HP, 999);
		tmp.gotBuff("Metallicize", 8);
		tmp.gainBlock(8);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	@SuppressWarnings("static-access")
	private void generateSlaver_Blue() {
		int HP = 50 - ran.nextInt(5);
		Enemy tmp = new Enemy("Slaver_Blue", HP, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	@SuppressWarnings("static-access")
	private void generateSlaver_Red() {
		int HP = 50 - ran.nextInt(5);
		Enemy tmp = new Enemy("Slaver_Red", HP, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	@SuppressWarnings("static-access")
	private void generateFungi_Beast() {
		int HP = 28 - ran.nextInt(7);
		Enemy tmp = new Enemy("Fungi_Beast", HP, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	@SuppressWarnings("static-access")
	private void generateHexaghost() {
		Enemy tmp = new Enemy("Hexaghost", 250, 999);
		tmp.setBattle(tmpBattle);
		super.tmpBattle.Enemies.add(tmp);
	}

	private Random ran = new Random();
}
