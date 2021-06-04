package by.bobruisk.konsov.game.model;


import java.io.Serializable;
import by.bobruisk.konsov.game.resourses.PlayerClass;
import by.bobruisk.konsov.game.skills.Skill;
/**
 * This class stores the player model
 * @author Senger
 *
 */
public class Player implements Serializable{
	private String login;
	private String password;
	private static final long serialVersionUID = 8701073242655401421L;
	private String name;
	private String ii;
	private String classDescriptionL;
	private PlayerClass playerClass;
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
	
	
	
	@Override
	public String toString() {
		return "Player name " + name + ", Class " + playerClass;
	}
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active1 == null) ? 0 : active1.hashCode());
		result = prime * result + ((active2 == null) ? 0 : active2.hashCode());
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + battleLose;
		result = prime * result + battleWin;
		result = prime * result + ((classDescriptionL == null) ? 0 : classDescriptionL.hashCode());
		result = prime * result + defense;
		result = prime * result + dexterity;
		result = prime * result + expirience;
		result = prime * result + healthPoints;
		result = prime * result + ((ii == null) ? 0 : ii.hashCode());
		result = prime * result + intelligence;
		result = prime * result + level;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((playerClass == null) ? 0 : playerClass.hashCode());
		result = prime * result + power;
		result = prime * result + ((ultimate == null) ? 0 : ultimate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (active1 == null) {
			if (other.active1 != null)
				return false;
		} else if (!active1.equals(other.active1))
			return false;
		if (active2 == null) {
			if (other.active2 != null)
				return false;
		} else if (!active2.equals(other.active2))
			return false;
		if (basic == null) {
			if (other.basic != null)
				return false;
		} else if (!basic.equals(other.basic))
			return false;
		if (battleLose != other.battleLose)
			return false;
		if (battleWin != other.battleWin)
			return false;
		if (classDescriptionL == null) {
			if (other.classDescriptionL != null)
				return false;
		} else if (!classDescriptionL.equals(other.classDescriptionL))
			return false;
		if (defense != other.defense)
			return false;
		if (dexterity != other.dexterity)
			return false;
		if (expirience != other.expirience)
			return false;
		if (healthPoints != other.healthPoints)
			return false;
		if (ii == null) {
			if (other.ii != null)
				return false;
		} else if (!ii.equals(other.ii))
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (level != other.level)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (playerClass != other.playerClass)
			return false;
		if (power != other.power)
			return false;
		if (ultimate == null) {
			if (other.ultimate != null)
				return false;
		} else if (!ultimate.equals(other.ultimate))
			return false;
		return true;
	}

	
	
	

}
