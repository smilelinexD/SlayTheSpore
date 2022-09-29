package Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Main.IMain;
import Main.MainFunctions;
import cards.Cards;

public class Role {
	// Constructor
	public Role(String Name, int Health, int Energy) {
		this.Name = Name;
		this.Health = Health;
		this.MaxHealth = Health;
		this.Energy = Energy;
		this.MaxEnergy = Energy;
	}

	// Method

	// Get
	public String getName() {
		return this.Name;
	}

	public int getHealth() {
		return this.Health;
	}

	public int getMaxHealth() {
		return this.MaxHealth;
	}

	public int getEnergy() {
		return this.Energy;
	}

	public int getMaxEnergy() {
		return this.MaxEnergy;
	}

	public int getBlock() {
		return this.Block;
	}

	public ArrayList<Cards> getDeck() {
		return this.Deck;
	}

	public ArrayList<Cards> getHand() {
		return this.Hand;
	}

	public ArrayList<Cards> getDiscard() {
		return this.Discard;
	}

	public Buffs getBuff() {
		return this.Buff;
	}

	public Debuffs getDebuff() {
		return this.Debuff;
	}

	public Battle getBattle() {
		return this.battle;
	}

	public int getGotHitInCombat() {
		return this.GotHitInCombat;
	}

	public int getGold() {
		return this.Gold;
	}

	public Cards getUsing() {
		return this.Using;
	}

	// Deck
	public void ShuffleDeck() {
		Collections.shuffle(Deck);
	}

	public void addCardToDeck(boolean RAN, Cards card) { // true = random
		if (RAN) {
			this.Deck.add(ran.nextInt(this.Deck.size()), card);
		} else {
			this.Deck.add(0, card);
		}
	}

	public void removeCardFromDeck(int index) {
		this.Deck.remove(index);
	}

	public void addCardToHand(Cards card) {
		if (this.Hand.size() >= 5) {
			return;
		} else {
			this.Hand.add(card);
		}
	}

	public void removeCardFromHand(int index) {
		this.Hand.remove(index);
	}

	public void addCardToDiscard(boolean RAN, Cards card) {
		if (RAN) {
			if (this.Discard.isEmpty()) {
				this.Discard.add(card);
			} else {
				this.Discard.add(ran.nextInt(this.Discard.size()), card);
			}
		} else {
			this.Discard.add(card);
		}
	}

	public void removeCardFromDiscard(int index) {
		this.Discard.remove(index);
	}

	public void addCardToRemovedFromCombat(Cards card) {
		this.RemovedFromCombat.add(card);
	}

	public void removeUsing() {
		this.RemovedFromCombat.add(Using);
		this.Using = null;
	}

	// In-Game
	public int UseCard(int index, Role Target) {
		if (index >= this.Hand.size()) {
			return -1;
		}
		if (this.Debuff.checkDebuff()) {
			if (this.Debuff.checkEntangled()) {
				if (this.Hand.get(index).getType().equals("Attack")) {
					return -1;
				}
			}
		}
		Cards TMP = this.Hand.get(index);
		this.Using = TMP;
		this.Hand.remove(index);
		int re = TMP.Use(this, Target);
		if (re == -1) {
			this.Hand.add(index, TMP);
		} else {
			if (this.Buff.checkBuff()) {
				if (this.Buff.checkRage()) {
					if (TMP.getType().equals("Attack")) {
						this.gainBlock(3 * this.Buff.getRageLvl());
					}
				}
			}
			for (Enemy tmpenemy : this.battle.Enemies) {
				if (tmpenemy.getBuff().checkBuff()) {
					if (tmpenemy.getBuff().checkEnrage()) {
						if (TMP.getType().equals("Skill")) {
							tmpenemy.gotBuff("Strength", tmpenemy.getBuff().getEnrageLvl());
						}
					}
				}
			}
			if (this.Using != null) {
				this.Discard.add(TMP);
			}
		}
		this.Using = null;
		return re;
	}

	public void Draw(int num) {
		if (this.Debuff.checkDebuff()) {
			if (this.Debuff.checkCantDraw()) {
				return;
			}
		}
		for (int i = 0; i < num; i++) {
			if (this.Deck.isEmpty()) {
				for (Cards tmpcard : this.Discard) {
					this.Deck.add(tmpcard);
				}
				this.Discard.clear();
				this.ShuffleDeck();
			}
			this.Hand.add(this.Deck.get(0));
			this.Deck.remove(0);
			if (this.Buff.checkBuff()) {
				if (this.Hand.get(this.Hand.size() - 1).getType().equals("Status")) {
					if (this.Buff.checkEvolve()) {
						this.Draw(this.Buff.getEvolveLvl());
					}
					if (this.Buff.checkFire_Breathing()) {
						for (Enemy tmpenemy : this.battle.Enemies) {
							if (tmpenemy.checkDead() == false) {
								tmpenemy.Hurt(6);
							}
						}
					}
				}
				if (this.Hand.get(this.Hand.size() - 1).getType().equals("Curse")) {
					if (this.Buff.checkFire_Breathing()) {
						for (Enemy tmpenemy : this.battle.Enemies) {
							if (tmpenemy.checkDead() == false) {
								tmpenemy.Hurt(6 * this.Buff.getFire_BreathingLvl());
							}
						}
					}
				}
			}
		}
	}

	public int Hurt(int Damage) {
		if (this.Debuff.checkVulnerable()) {
			Damage *= 1.5;
		}
		if (Damage <= this.Block) {
			this.Block -= Damage;
			return 0;
		} else {
			Damage -= this.Block;
			this.Block = 0;
			this.Health -= Damage;
			this.GotHitInCombat++;
			return Damage;
		}
	}

	public void gainHp(int ammount) {
		this.Health = (this.Health + ammount > this.MaxHealth) ? (this.MaxHealth) : (this.Health + ammount);
	}

	public void gainMaxHp(int ammount) {
		this.MaxHealth += ammount;
	}

	public void removeHp(int ammount) {
		this.Health -= ammount;
	}

	public void gainBlock(int ammount) {
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkDexterity()) {
				this.Block += this.Buff.getDexterityLvl();
			}
			if (this.Buff.checkJuggernaut()) {
				int ind;
				do {
					ind = ran.nextInt(this.battle.Enemies.size());
				} while (this.battle.Enemies.get(ind).checkDead());

				this.battle.Enemies.get(ind).Hurt(this.DamageCount(5 * this.Buff.getJuggernautLvl()));

			}
		}
		this.Block += ammount;
	}

	public int useEnergy(int ammount) {
		if (ammount > this.Energy) {
			return -1;
		} else {
			this.Energy -= ammount;
			return 0;
		}
	}

	public void gainEnergy(int ammount) {
		this.Energy += ammount;
	}

	public void RoundPass() {
		this.Buff.RoundPass();
		this.Debuff.RoundPass();
		this.Energy = this.MaxEnergy;
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkMetallicize()) {
				this.gainBlock(this.Buff.getMetallicizeLvl());
			}
			if (this.Buff.checkRitual()) {
				this.gotBuff("Strength", this.Buff.getRitualLvl());
			}
			if (this.Buff.checkCombust()) {
				this.removeHp(this.Buff.getCombustLvl());
				for (Role tmpenemy : this.battle.Enemies) {
					tmpenemy.Hurt(5 * this.Buff.getCombustLvl());
				}
			}
		}
		for (Cards tmpcard : this.Hand) {
			if (tmpcard.getName().equals("Burn")) {
				this.Hurt(2);
			}
			if (tmpcard.checkEthereal()) {
				this.RemovedFromCombat.add(tmpcard);
			} else {
				this.Discard.add(tmpcard);
			}
		}
		this.Hand.clear();
		this.Buff.gotStrength(-this.EndTurn_LoseStrength);
		this.EndTurn_LoseStrength = 0;

	}

	public void Exhaust(int index) {
		if (this.Hand.get(index).getName().equals("Sentinel")) {
			this.gainEnergy(2);
		}
		this.addCardToRemovedFromCombat(this.Hand.get(index));
		this.Hand.remove(index);
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkDark_Embrace()) {
				this.Draw(this.Buff.getDark_EmbraceLvl());
			}
			if (this.Buff.checkFeel_No_Pain()) {
				this.gainBlock(3 * this.Buff.getFeel_No_PainLvl());
			}
		}
	}

	public void ExhaustUsing() {
		if (this.Using.getName().equals("Sentinel")) {
			this.gainEnergy(2);
		}
		this.addCardToRemovedFromCombat(Using);
		this.Using = null;
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkDark_Embrace()) {
				this.Draw(this.Buff.getDark_EmbraceLvl());
			}
			if (this.Buff.checkFeel_No_Pain()) {
				this.gainBlock(3 * this.Buff.getFeel_No_PainLvl());
			}
		}
	}

	public void ExhaustDeck() {
		if (this.Deck.get(0).getName().equals("Sentinel")) {
			this.gainEnergy(2);
		}
		this.addCardToRemovedFromCombat(this.Deck.get(0));
		this.Deck.remove(0);
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkDark_Embrace()) {
				this.Draw(this.Buff.getDark_EmbraceLvl());
			}
			if (this.Buff.checkFeel_No_Pain()) {
				this.gainBlock(3 * this.Buff.getFeel_No_PainLvl());
			}
		}
	}

	public void ExhaustDiscard() {
		if (this.Discard.get(this.Discard.size() - 1).getName().equals("Sentinel")) {
			this.gainEnergy(2);
		}
		this.addCardToRemovedFromCombat(this.Discard.get(this.Discard.size() - 1));
		this.Discard.remove(this.Discard.size() - 1);
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkDark_Embrace()) {
				this.Draw(this.Buff.getDark_EmbraceLvl());
			}
			if (this.Buff.checkFeel_No_Pain()) {
				this.gainBlock(3 * this.Buff.getFeel_No_PainLvl());
			}
		}
	}

	public int spendGold(int ammount) {
		if (this.Gold < ammount) {
			return -1;
		} else {
			this.Gold -= ammount;
			return 0;
		}
	}

	// Got
	public void gotBuff(String Type, int Lvl) {
		imain.gotBuff(this, Type, Lvl);
	}

	public void gotDebuff(String Type, int Duration) {
		imain.gotDebuff(this, Type, Duration);
	}

	public void gotStatus(String Type, int Lvl) {
		switch (Type) {
		case "LoseStrength":
			this.EndTurn_LoseStrength += Lvl;
			break;
		default:
			break;
		}
	}

	public void gotGold(int ammount) {
		this.Gold += ammount;
	}

	// Set
	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public void setEnergy(int num) {
		this.Energy = num;
	}
	
	public void setBlock(int num) {
		this.Block = num;
	}

	// Damage Count
	public int DamageCount(int Damage) {
		Damage = this.CheckBUFF(Damage);
		Damage = this.CheckDEBUFF(Damage);

		return Damage;
	}

	public int DamageCount(int Damage, int Multiple) {
		Damage = this.CheckBUFF(Damage, Multiple);
		Damage = this.CheckDEBUFF(Damage);

		return Damage;
	}

	// Check
	public int CheckBUFF(int Damage) {
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkStrength()) {
				Damage += this.Buff.getStrengthLvl();
			}
		}
		return Damage;
	}

	public int CheckBUFF(int Damage, int Multiple) {
		if (this.Buff.checkBuff()) {
			if (this.Buff.checkStrength()) {
				Damage += this.Buff.getStrengthLvl() * Multiple;
			}
		}
		return Damage;
	}

	public int CheckDEBUFF(int Damage) {
		if (this.Debuff.checkDebuff()) {
			if (this.Debuff.checkWeak()) {
				Damage *= 0.75;
			}
		}
		return Damage;
	}

	public boolean checkDead() {
		return this.Health <= 0;
	}

	// Member
	protected String Name;
	protected int Health;
	protected int MaxHealth;
	protected int Energy;
	protected int MaxEnergy;

	protected int Gold = 0;

	protected ArrayList<Cards> Deck = new ArrayList<Cards>();
	protected ArrayList<Cards> Hand = new ArrayList<Cards>();
	protected Cards Using = null;
	protected ArrayList<Cards> Discard = new ArrayList<Cards>();
	protected ArrayList<Cards> RemovedFromCombat = new ArrayList<Cards>();

	protected int Block = 0;
	protected Buffs Buff = new Buffs();
	protected Debuffs Debuff = new Debuffs();
	protected int GotHitInCombat = 0;

	protected Battle battle = null;
	protected int EndTurn_LoseStrength = 0;

	private Random ran = new Random();
	private IMain imain = new MainFunctions();
}
