package realestateapp;

public class Apartment extends Residential{
	
	public void newAd() {
		super.newAd();
		System.out.println("Enter The Specific Stair Of This Property:");
		this.stair = in.nextInt();
		this.model = "Residential";
		this.kind = "Apartment";
	}
}
