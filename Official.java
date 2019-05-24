package realestateapp;

import java.io.Serializable;

public class Official extends Commercial {

	public void newAd() {
		super.newAd();
		this.model = "Commercial";
		this.kind = "Official";
	}

	
}
