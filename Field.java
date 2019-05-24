package realestateapp;

public class Field extends Land {

	public void newAd() {
		super.newAd();
		System.out.println("Enter The Use Type Of This Field: ");
		this.useType = in.next();
		this.model = "Land";
		this.kind = "Field";
	}
}
