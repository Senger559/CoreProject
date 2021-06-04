package by.bobruisk.konsov.game.model;


import java.io.Serializable;
import by.bobruisk.konsov.game.resourses.PlayerClass;
import by.bobruisk.konsov.game.skills.Skill;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8701073242655401421L;
	private String name;
	private String classDescriptionL;
	private PlayerClass playerClass;
	private String ii;
	private int level;
	private int healthPoints;
	private int defense;
	private int power;
	private int dexterity;
	private int intelligence;
	private int expirience;
	private int battleWin;
	private int battleLose;
	private Skill basic;
	private Skill active1;
	private Skill active2;
	private Skill ultimate;
	
	
	
	public String getClassDescriptionL() {
		return classDescriptionL;
	}
	public void setClassDescriptionL(String classDescriptionL) {
		this.classDescriptionL = classDescriptionL;
	}
	public int getBattleWin() {
		return battleWin;
	}
	public void setBattleWin(int battleWin) {
		this.battleWin = battleWin;
	}
	public int getBattleLose() {
		return battleLose;
	}
	public void setBattleLose(int battleLose) {
		this.battleLose = battleLose;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getExpirience() {
		return expirience;
	}
	public void setExpirience(int expirience) {
		this.expirience = expirience;
	}
	public Skill getBasic() {
		return basic;
	}
	public void setBasic(Skill basic) {
		this.basic = basic;
	}
	public Skill getActive1() {
		return active1;
	}
	public void setActive1(Skill active1) {
		this.active1 = active1;
	}
	public Skill getActive2() {
		return active2;
	}
	public void setActive2(Skill active2) {
		this.active2 = active2;
	}
	public Skill getUltimate() {
		return ultimate;
	}
	public void setUltimate(Skill ultimate) {
		this.ultimate = ultimate;
	}
	public PlayerClass getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
	public String getIi() {
		return ii;
	}
	public void setIi(String ii) {
		this.ii = ii;
	}


	
	

}
