package by.bobruisk.konsov.game.resourses;

public class PicturesData {
	
	private static String [] url = new String[14];
	private static int selectedPicture = 0;
	static {
		url[0] = "Mage00.jpg";
		url[1] = "Mage01.jpg";
		url[2] = "Mage02.jpg";
		url[3] = "Mage03.jpg";
		url[4] = "Rogue00.jpg";
		url[5] = "Rogue01.jpg";
		url[6] = "Rogue02.jpg";
		url[7] = "Warroir00.jpg";
		url[8] = "Warroir01.jpg";
		url[9] = "Warroir02.jpg";
		url[10] = "Warroir04.jpg";
		url[11] = "Warroir05.jpg";
		url[12] = "Warroir06.jpg";
		url[13] = "Warroir07.jpg";
	
	}

	public static String[] getUrl() {
		return url;
	}
	public static String getPicture() {
		return url[selectedPicture];
	}
	
	public static void setUrl(String[] url) {
		PicturesData.url = url;
	}
	public static int getSelectedPicture() {
		return selectedPicture;
	}
	public static void setSelectedPicture(int selectedPicture) {
		PicturesData.selectedPicture = selectedPicture;
	}

}

