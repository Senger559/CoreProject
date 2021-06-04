package by.bobruisk.konsov.game.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import by.bobruisk.konsov.game.model.Account;
import by.bobruisk.konsov.game.model.Player;
import by.bobruisk.konsov.game.resourses.Accounts;

public class FileManager {
	
	public final String FILE_NAME = "accounts.txt";

	public void checkFile() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			try {
				file.createNewFile();
				write(new ArrayList<Account>());
				
				FileOutputStream fos = new FileOutputStream("FILE_NAME");
		        ObjectOutputStream oos = new ObjectOutputStream(fos);
		        oos.writeObject(new Player());
		        oos.flush();
		        oos.close();
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Account> read() {
		ArrayList<Account> accounts = null;
		 try {
			 FileInputStream fis = new FileInputStream(FILE_NAME);	 		 
			 ObjectInputStream oin = new ObjectInputStream(fis);			
			 accounts = (ArrayList<Account>) oin.readObject();
		} catch (ClassNotFoundException | IOException e) {
			 e.printStackTrace();
		}
        return accounts;
    }

	public void write(ArrayList<Account> ac) {
		try {
		   FileOutputStream fos = new FileOutputStream(FILE_NAME);
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(ac);
	        oos.flush();
	        oos.close();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
}





