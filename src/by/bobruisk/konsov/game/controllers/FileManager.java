package by.bobruisk.konsov.game.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import by.bobruisk.konsov.game.main.GameRunner;
import by.bobruisk.konsov.game.model.Account;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.players.and.monsters.PlayerData;
import org.apache.log4j.Logger;
import by.bobruisk.konsov.game.view.BattleMenu;
/**
 * Reads, writes, and checks for the presence of a file with player data
 * @author Senger
 *
 */
public class FileManager {
	private final static Logger LOGGER = Logger.getLogger(BattleMenu.class);
	public final String FILE_NAME = "players.txt";
	private List<Player> players = PlayerData.getPlayers();

	public void checkFile() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			try {
				file.createNewFile();		
				write(players);	
			} catch (IOException e) {
				 LOGGER.fatal("file creation error");
				e.printStackTrace();		
			}
		}	
	}
	public List<Player> extract() {
		List<Player>  players = new ArrayList<>();
		 try {
			 FileInputStream fis = new FileInputStream(FILE_NAME);	 		 
			 ObjectInputStream oin = new ObjectInputStream(fis);			
			 List<Account> acc = (List<Account>) oin.readObject();
			 for (int i = 0; i < acc.size(); i++) {
			 Player player = PlayerCompiller.prepareToRead(acc.get(i).getParameters());
			 player.setName(acc.get(i).getName());
			 player.setLogin(acc.get(i).getLogin());
			 player.setPassword(acc.get(i).getPassword());
			 players.add(player);
			 }			 
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.fatal("extraction error");
			 e.printStackTrace();
		}
        return players;
    }

	public void write(List<Player> ac) {
		List<Account> acc = new ArrayList<>();
		for (int i = 0; i < ac.size(); i++) {
			prepareData(ac.get(i));
		}	
		try {
		   FileOutputStream fos = new FileOutputStream(FILE_NAME);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(acc);
	        oos.flush();
	        oos.close();
		} catch (IOException e) {
			LOGGER.fatal("recording error");
			 e.printStackTrace();
		}
	}
	public  void write(Player player) {
		players.add(player);
		write(players);
	}
	
	public Account prepareData(Player ac) {
		Account account = new  Account();
		account.setParameters(PlayerCompiller.prepareToWrite(ac));	
		account.setLogin(ac.getLogin());
		account.setName(ac.getName());
		account.setPassword(ac.getPassword());
		return account;
	}
	public  void addPlayer(Player player) {
		players.add(player);
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}





