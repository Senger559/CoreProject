package by.bobruisk.konsov.game.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Player;

public class BattleResultDialog extends JDialog{
	
	public BattleResultDialog(Player player, boolean battleResult) {
		JDialog dialog = new JDialog(GameRunner.getFrame(), "		������", true);
		JLabel message = new JLabel(selectResultMessage(player, battleResult));
		message.setHorizontalAlignment(JLabel.CENTER);
		dialog.add(message);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    dialog.setSize(270, 100);
	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
	}
	private String selectResultMessage(Player player, boolean battleResult) {
		return battleResult ? "<html> <br>"+ "����������� � �������!<br>"+"���� ����� �����: "+ player.getBattleWin()+ " !<br><br></html>"
				:"<html> <br>"  + "��� ����� �������� � �������<br>" +  "����� ����� ���������: " + player.getBattleLose() + " !<br><br><html>";
	}
	
}
