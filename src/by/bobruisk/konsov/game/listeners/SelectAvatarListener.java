package by.bobruisk.konsov.game.listeners;
//¬ременно утратил актуальность. ≈сли не создам класс-слушатель дл€ временного хранени€ переменных(картинка, им€) удалить
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import by.bobruisk.konsov.game.controllers.CharacterCreator;
import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.resourses.PicturesData;
import by.bobruisk.konsov.game.view.CreateCharacterMenu;
import by.bobruisk.konsov.game.view.helper.FrameSelector;

public class SelectAvatarListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if("previous".equals(e.getActionCommand())) {
			getAnotherPicture(PicturesData.getSelectedPicture()-1);
		} else if("next".equals(e.getActionCommand())) {
			getAnotherPicture(PicturesData.getSelectedPicture()+1);			
		}
	}
	
	public void getAnotherPicture(int picNumber) {
		if(picNumber<0) {
			PicturesData.setSelectedPicture(PicturesData.getUrl().length-1);
		} else if(picNumber>PicturesData.getUrl().length-1) {	
			PicturesData.setSelectedPicture(0);
		} else {
			PicturesData.setSelectedPicture(picNumber);
		}
//		GameRunner.getFrame().repaint();
		FrameSelector.getCreateCharacterMenu();
	}
}
