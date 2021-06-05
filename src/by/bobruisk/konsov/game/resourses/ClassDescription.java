package by.bobruisk.konsov.game.resourses;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * stores class descriptions and passes them to the character depending on the class of the character itself
 * @author Senger
 * 
 */
public class ClassDescription {
	private final static Logger LOGGER = Logger.getLogger(ClassDescription.class);
	private static PlayerClass selected;
	private static String warriorDescription = "�������� ������ ����\n ���� - �������� �������� �������������� �������� ����.\n ��� ������: \n����\n������\n��������\nP�����";
	private static String rogueDescription = "�������� ������ ����\n ����  - �������� �������� �������������� �������� ��������.\n ��� ������:\n����\n����\n������ �����\n����";
	private static String mageDescription = "�������� ������ ���\n ���  - �������� �������� �������������� �������� ���������.\n ��� ������: \n������\n������\n�������\n�����";
	
	public static String getWarriorDescription() {
		return warriorDescription;
	}
	public static void setWarriorDescription(String warriorDescription) {
		ClassDescription.warriorDescription = warriorDescription;
	}
	public static String getRogueDescription() {
		return rogueDescription;
	}
	public static void setRogueDescription(String rogueDescription) {
		ClassDescription.rogueDescription = rogueDescription;
	}
	public static String getMageDescription() {
		return mageDescription;
	}
	public static void setMageDescription(String mageDescription) {
		ClassDescription.mageDescription = mageDescription;
	}
	public static PlayerClass getSelected() {
		return selected;
	}
	public static void setSelected(PlayerClass selected) {
		ClassDescription.selected = selected;
	}
	public static String getDescription () {
		if(selected == PlayerClass.WARRIOR) {
			LOGGER.info("the warrior character is assigned a class description");
			return warriorDescription;
		}else if(selected == PlayerClass.ROGUE) {
			LOGGER.info("the rogue character is assigned a class description");
			return rogueDescription;
		}else if(selected == PlayerClass.MAGE) {
			LOGGER.info("the mage character is assigned a class description");
			return mageDescription;
		}
		return "";
	}	
}
