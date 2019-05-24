package realestateapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class IO{

	
	@SuppressWarnings("unchecked")
	public ArrayList<RealEstate> fileReader() throws ClassNotFoundException, IOException {

		ArrayList<RealEstate> arraylist = new ArrayList<RealEstate>();
		try {
			File file = new File("D:\\Eclipse\\RealEstate\\Ads.txt");
			if (file.length() == 0) {
				arraylist = new ArrayList<RealEstate>();
			} else {
				FileInputStream fis = new FileInputStream("D:\\Eclipse\\RealEstate\\Ads.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				arraylist = (ArrayList<RealEstate>) ois.readObject();
				ois.close();
				fis.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return arraylist;
	}

	// File Writer Method
	public void fileWriter(ArrayList<RealEstate> arr) throws IOException {

		FileOutputStream fos = new FileOutputStream("D:\\Eclipse\\RealEstate\\Ads.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(arr);

		oos.close();
		fos.close();

	}
}
