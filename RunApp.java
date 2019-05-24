package realestateapp;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class RunApp{

	
	ArrayList<RealEstate> homes = new ArrayList<RealEstate>();

	public static void main(String[] args) throws IOException, EOFException {

		try {

			new Menu().menu();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
