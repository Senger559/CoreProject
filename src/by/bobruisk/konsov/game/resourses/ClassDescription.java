package by.bobruisk.konsov.game.resourses;

public class ClassDescription {
	private static PlayerClass selected;
	private static String warriorDescription = "�������� ������ ����\n ��� �������������� � ������";
	private static String rogueDescription = "�������� ������ ����\n ��� �������������� � ������";
	private static String mageDescription = "�������� ������ ���\n ��� �������������� � ������";
	
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
			return warriorDescription;
		}else if(selected == PlayerClass.ROGUE) {
			return rogueDescription;
		}else if(selected == PlayerClass.MAGE) {
			return mageDescription;
		}
		return "";
	}	
}
