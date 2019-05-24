package realestateapp;

import java.io.Serializable;
import java.util.Scanner;

public class RealEstate extends RunApp implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1244967234027971300L;

	transient Scanner input = new Scanner(System.in);
	
	protected long telephone;
	protected float area;
	protected String address;
	protected float price;
	protected float rent;
	protected float mortgage;
	protected int room;
	String adType; // sale rent
	String model; // commercial residential land
	String useType = "";
	String kind; // villa apartment official field
	float yardArea;
	int stair;
	
	public static void main(String[] args) {
	}

	public void newAd() {
		System.out.println("Enter The Exact Address: ");
		this.address = input.nextLine();

		System.out.println("Enter The Real Estate Area, Please: ");
		this.area = input.nextFloat();

		System.out.println("Enter A Telephone Number, Please: ");
		this.telephone = input.nextLong();

	}

	// ad type getter
	public String getType() {
		return adType;
	}

	// address getter
	public String getAddress() {
		return address;
	}// telephone getter

	public long getTelephone() {
		return telephone;
	}

	// area getter
	public float getArea() {
		return area;
	}

	// model getter
	public String getModel() {
		return model;
	}

	// kind getter(villa/apartment/official/field)
	public String getKind() {
		return kind;
	}

	// getter for price
	public float getPrice() {
		return price;

	}

	// getter for rent
	public float getRent() {
		return rent;
	}

	// getter for mortgage
	public float getMortgage() {
		return mortgage;
	}

	// getter for yard area
	public float getYardArea() {
		return yardArea;
	}

	// getter for apartment stair
	public int getStair() {
		return stair;
	}

	// getter for room
	public int getRoom() {
		return room;
	}
	
	//getter for use type
	public String getUseType() {
		return useType;
	}

}
