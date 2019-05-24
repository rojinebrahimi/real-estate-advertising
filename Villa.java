package realestateapp;

import java.io.Serializable;

public class Villa extends Residential {
	
	public void newAd() {
		super.newAd();
		System.out.println("Enter The Yard Area, Please: ");
		this.yardArea = in.nextFloat();
		this.model = "Residential";
		this.kind = "Villa";

	}
}
