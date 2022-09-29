package Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cards.Cards;

public class Ironclad extends Role{
	// Constructor
	public Ironclad(String Name, int Health, int Energy) {
		super(Name, Health, Energy);
	}
		
	
	public void Battle_End(){
		int index = -1;
		ArrayList<Integer> ind = new ArrayList<Integer>();
		for(Cards tmp : super.Deck) {
			index ++;
			if(tmp.checkTmpInGame()) {
				ind.add(index);
			}
		}
		if(!ind.isEmpty()) {
			Collections.reverse(ind);
			for(int tmp : ind) {
				super.Deck.remove(tmp);
			}
		}
		ind = null;
		for(Cards tmp : super.Discard) {
			if(!tmp.checkTmpInGame()) {
				super.Deck.add(tmp);
			}
		}
		super.Discard.clear();
		for(Cards tmp : super.RemovedFromCombat) {
			if(!tmp.checkTmpInGame()) {
				super.Deck.add(tmp);
			}
		}
		super.RemovedFromCombat.clear();
		for(Cards tmp : super.Hand) {
			if(!tmp.checkTmpInGame()) {
				super.Deck.add(tmp);
			}
		}
		super.Hand.clear();
		
		super.Block = 0;
		super.Buff = new Buffs();
		super.Debuff = new Debuffs();
		super.GotHitInCombat = 0;

		super.battle = null;
		super.EndTurn_LoseStrength = 0;
		super.gainHp(6);
		super.Energy = super.MaxEnergy;
	}
	
	
	
	
	// Member
	public int removeCards = 0;

}
