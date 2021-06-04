package by.bobruisk.konsov.game.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import org.apache.log4j.Logger;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Player;
/**
 * 
 * @author Senger
 *
 */
public class BattleResultDialog extends JDialog{
	private static final long serialVersionUID = -698840057978491797L;
	private final static Logger LOGGER = Logger.getLogger(BattleResultDialog.class);
	public BattleResultDialog(Player player, boolean battleResult) {
		JDialog dialog = new JDialog(GameRunner.getFrame(), "		Победа", true);
		JLabel message = new JLabel(selectResultMessage(player, battleResult));
		message.setHorizontalAlignment(JLabel.CENTER);
		dialog.add(message);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    dialog.setSize(270, 100);
	    dialog.setLocationRelativeTo(null);
	    LOGGER.info("the result of the battle is shown");
	    dialog.setVisible(true);
	}
	private String selectResultMessage(Player player, boolean battleResult) {
		return battleResult ? "<html> <br>"+ "Поздравляем с успехом!<br>"+"Выше число побед: "+ player.getBattleWin()+ " !<br><br></html>"
				:"<html> <br>"  + "Вам стоит подумать о тактике<br>" +  "Число ваших поражений: " + player.getBattleLose() + " !<br><br><html>";
	}
	
}
