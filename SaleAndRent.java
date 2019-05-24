package realestateapp;

import java.util.Scanner;

public class SaleAndRent extends RealEstate{

	transient Scanner in = new Scanner(System.in);

	// new ad
	public void newAd() {
		super.newAd();
		System.out.println("Enter The Type Of The Ad:(Sale, Rent)");
		String answer = in.nextLine();
		if (answer.equalsIgnoreCase("Sale")) {
			System.out.println("Enter The Price Of This Property, Please: ");
			this.price = in.nextFloat();
			System.out.println("Enter The Number Of The Rooms For This Estate: ");
			this.room = in.nextInt();
			this.adType = "Sale";

		} else if (answer.equalsIgnoreCase("Rent")) {
			setMortgage();
			setRent();
			System.out.println("Enter The Number Of The Rooms For This Estate: ");
			this.room = in.nextInt();
			this.adType = "Rent";
		}

	}

	// setter for rent
	public void setRent() {
		System.out.println("Enter The Amount Of Rent For This Property, Please: ");
		this.rent = in.nextFloat();
	}

	// setter for mortgage
	public void setMortgage() {
		System.out.println("Enter The Amount Of Mortgage: ");
		this.mortgage = in.nextFloat();
	}

}
