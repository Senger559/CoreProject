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
	private static String warriorDescription = "Описание класса воин\n Воин - персонаж основная характеристика которого сила.\n Его навыки: \nУдар\nРазрез\nУсиление\nPаскол";
	private static String rogueDescription = "Описание класса плут\n Плут  - персонаж основная характеристика которого ловкость.\n Его навыки:\nТрюк\nФинт\nБросок удачи\nРиск";
	private static String mageDescription = "Описание класса маг\n Маг  - персонаж основная характеристика которого интеллект.\n Его навыки: \nТолчок\nМолния\nЗакалка\nШторм";
	
	
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
