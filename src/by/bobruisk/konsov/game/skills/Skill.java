package by.bobruisk.konsov.game.skills;

import java.io.Serializable;

import by.bobruisk.konsov.game.resourses.SkillType;
/**
 * basic abstract skill class
 * @author Sergey
 *
 */
public abstract class Skill implements SkillMechanic, Serializable{


	private static final long serialVersionUID = -2965930876911519204L;
	protected String name;
	protected String description;
	protected SkillType skillType;
	protected int cooldown;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SkillType getSkillType() {
		return skillType;
	}
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	@Override
	public String toString() {
		return name;
	}
	
}