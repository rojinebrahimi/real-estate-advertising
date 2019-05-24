package realestateapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu extends RealEstate {

	int selection = 0;
	int option = 0;
	int choice = 0;
	int number = 0;
	String remove = null;
	boolean exit = false;

	public void menu() throws FileNotFoundException, IOException {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		IO io = new IO();

		try {
			homes = io.fileReader();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("\t\tWELCOME TO HOMELAND APP!(PROVIDED BY ROJIN EBRAHIMI)\n\n");

		do {
			System.out.println("1.New Ad\n2.Search Ads\n3.Show Listing\n4.Remove Ad\n5.Exit\n");

			System.out.print("Select The Opreration You Want To Be Done By Entering The Number:\n ");
			selection = input.nextInt();

			switch (selection) {

			case 1:
				System.out.println("\nSelect A Type Of Real Estate, Please:\n1.Residential\n2.Commercial\n3.Land ");
				choice = input.nextInt();

				if (choice == 1) {
					System.out.println("Select One:\n1.Villa\n2.Apartment");
					number = input.nextInt();

					if (number == 1) {
						Villa villa = new Villa();
						villa.newAd();
						homes.add(villa);
						io.fileWriter(homes);

					}

					if (number == 2) {
						Apartment ap = new Apartment();
						ap.newAd();
						homes.add(ap);
					}

				}

				if (choice == 2) {
					Official of = new Official();
					of.newAd();
					homes.add(of);
				}

				if (choice == 3) {
					Field field = new Field();
					field.newAd();
					homes.add(field);
				}

				break;
			case 2:
				System.out.println(
						"Select Search By:\n1.Estate Model(Residential, Commercial, Land)\n2.Ad Type(Sale, Rent)");
				option = input.nextInt();

				if (option == 1) {
					searchByModel();
				}

				if (option == 2) {
					searchByAdType();
				}
				break;
			case 3:

				showListing();

				break;

			case 4:

				removeAd();
				System.out.println("The Ad Was Deleted Successfully!\n");
				break;

			case 5:
				System.out.println("\nHave A Nice Day!\n");
				exit = true;
			default:
				break;
			}
		} while (!exit);
		io.fileWriter(homes);
		System.out.println("GoodBye!");

	}

	// search by the property model(Commercial, Residential, Land)
	// ----------------------------------------------------------------------------------------------------------------------------------

	public void searchByModel() {
		System.out.println("Enter The Type Of The Property You Are Looking For:(Residential, Commercial, Land)");
		String toSearch = input.nextLine();
//residential model
		for (int i = 0; i < homes.size(); i++) {
			if (toSearch.equalsIgnoreCase("Residential")) {
				if (homes.get(i).getType().equals("Rent")) {
					if (homes.get(i).getKind().equals("Apartment")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nStair: " + homes.get(i).getStair() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nMortgage: "
								+ homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}

					else if (homes.get(i).getKind().equals("Villa")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nYardArea: " + homes.get(i).getYardArea() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nMortgage: "
								+ homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}
				}

				else if (homes.get(i).getType().equals("Sale")) {
					if (homes.get(i).getKind().equals("Villa")) {

						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nYardArea: " + homes.get(i).getYardArea() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nPrice: " + homes.get(i).getPrice()
								+ "\n*********************************");
					}
					// if it is an apartment kind
					else if (homes.get(i).getKind().equals("Apartment")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nStair: " + homes.get(i).getStair() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nPrice: " + homes.get(i).getPrice()
								+ "\n*********************************");
					}

				}
			}

//commercial model
			else if (toSearch.equalsIgnoreCase("Commercial")) {
				if (homes.get(i).getKind().equals("Official")) {
					if (homes.get(i).getType().equals("Rent")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nMortgage: " + homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}

					else if (homes.get(i).getType().equals("Sale")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nPrice: " + homes.get(i).getPrice() + "\n*********************************");
					}
				}
			}
//land model
			else if (toSearch.equalsIgnoreCase("Land")) {
				if (homes.get(i).getKind().equals("Field")) {
					if (homes.get(i).getType().equals("Rent")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nUseType: " + homes.get(i).getUseType() + "\nAddress:" + homes.get(i).getAddress()
								+ "\nArea: " + homes.get(i).getArea() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nMortgage: " + homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}

					else if (homes.get(i).getType().equals("Sale")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nUseType: " + homes.get(i).getUseType() + "\nAddress: " + homes.get(i).getAddress()
								+ "\nArea: " + homes.get(i).getArea() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nPrice: " + homes.get(i).getPrice() + "\n*********************************");
					}
				}
			}
		}
	}

	// search by the ad type(Sale, Rent)
	// ----------------------------------------------------------------------------------------------------------------------------------

	public void searchByAdType() {

		System.out.println("Enter The Type Of The Ad You Are Looking For:(Sale, Rent)");
		String toSearch = input.nextLine();

		System.out.println("THE RESULT: ");
		for (int i = 0; i < homes.size(); i++) {
			if (toSearch.equalsIgnoreCase("Sale")) {
				if (homes.get(i).getType().equals("Sale")) {

					// if it is a villa kind
					if (homes.get(i).getKind().equals("Villa")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nYardArea: " + homes.get(i).getYardArea() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nPrice: " + homes.get(i).getPrice()
								+ "\n*********************************");
					}
					// if it is an apartment kind
					else if (homes.get(i).getKind().equals("Apartment")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nStair: " + homes.get(i).getStair() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nPrice: " + homes.get(i).getPrice()
								+ "\n*********************************");
					}

					// if it is an office
					else if (homes.get(i).getKind().equals("Official")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nPrice: " + homes.get(i).getPrice() + "\n*********************************");
					}

					else if (homes.get(i).getKind().equals("Field")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nUseType: " + homes.get(i).getUseType() + "\nAddress: " + homes.get(i).getAddress()
								+ "\nArea: " + homes.get(i).getArea() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nPrice: " + homes.get(i).getPrice() + "\n*********************************");
					}
				}
			}

			else if (toSearch.equalsIgnoreCase("Rent")) {

				if (homes.get(i).getType().equals("Rent")) {
					// if it is a villa kind
					if (homes.get(i).getKind().equals("Villa")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nYardArea: " + homes.get(i).getYardArea() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nMortgage: "
								+ homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}
					// if it is a apartment kind
					else if (homes.get(i).getKind().equals("Apartment")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nStair: " + homes.get(i).getStair() + "\nRoom(s): " + homes.get(i).getRoom()
								+ "\nTelephone: " + homes.get(i).getTelephone() + "\nMortgage: "
								+ homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}

					else if (homes.get(i).getKind().equals("Official")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
								+ "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nMortgage: " + homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}

					else if (homes.get(i).getKind().equals("Field")) {
						System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
								+ "\nUseType: " + homes.get(i).getUseType() + "\nAddress:" + homes.get(i).getAddress()
								+ "\nArea: " + homes.get(i).getArea() + "\nTelephone: " + homes.get(i).getTelephone()
								+ "\nMortgage: " + homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
								+ "\n*********************************");
					}
				}
			}
		}
	}

	// show listing (Sale, Rent)
	// ----------------------------------------------------------------------------------------------------------------------------------
	public void showListing() {
		System.out.println("THE RESULT: ");

		for (int i = 0; i < homes.size(); i++) {

			if (homes.get(i).getType().equals("Rent")) {

				// if it is a villa kind
				if (homes.get(i).getKind().equals("Villa")) {
					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
							+ "\nYardArea: " + homes.get(i).getYardArea() + "\nRoom(s): " + homes.get(i).getRoom()
							+ "\nTelephone: " + homes.get(i).getTelephone() + "\nMortgage: "
							+ homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
							+ "\n*********************************");
				}
				// if it is an apartment kind
				else if (homes.get(i).getKind().equals("Apartment")) {
					System.out.println(
							"Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind() + "\nAddress:"
									+ homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea() + "\nStair: "
									+ homes.get(i).getStair() + "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: "
									+ homes.get(i).getTelephone() + "\nMortgage: " + homes.get(i).getMortgage()
									+ "\nRent: " + homes.get(i).getRent() + "\n*********************************");
				}
				// if it is an official kind
				else if (homes.get(i).getKind().equals("Official")) {
					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nAddress:" + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
							+ "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: " + homes.get(i).getTelephone()
							+ "\nMortgage: " + homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
							+ "\n*********************************");
				}

				else if (homes.get(i).getKind().equals("Field")) {
					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nUseType: " + homes.get(i).getUseType() + "\nAddress:" + homes.get(i).getAddress()
							+ "\nArea: " + homes.get(i).getArea() + "\nTelephone: " + homes.get(i).getTelephone()
							+ "\nMortgage: " + homes.get(i).getMortgage() + "\nRent: " + homes.get(i).getRent()
							+ "\n*********************************");
				}
			}

			if (homes.get(i).getType().equals("Sale")) {

				if (homes.get(i).getKind().equals("Villa")) {

					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
							+ "\nYardArea: " + homes.get(i).getYardArea() + "\nRoom(s): " + homes.get(i).getRoom()
							+ "\nTelephone: " + homes.get(i).getTelephone() + "\nPrice: " + homes.get(i).getPrice()
							+ "\n*********************************");
				}
				// if it is an apartment kind
				else if (homes.get(i).getKind().equals("Apartment")) {
					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
							+ "\nStair: " + homes.get(i).getStair() + "\nRoom(s): " + homes.get(i).getRoom()
							+ "\nTelephone: " + homes.get(i).getTelephone() + "\nPrice: " + homes.get(i).getPrice()
							+ "\n*********************************");
				}

				// if it is an office
				else if (homes.get(i).getKind().equals("Official")) {
					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nAddress: " + homes.get(i).getAddress() + "\nArea: " + homes.get(i).getArea()
							+ "\nRoom(s): " + homes.get(i).getRoom() + "\nTelephone: " + homes.get(i).getTelephone()
							+ "\nPrice: " + homes.get(i).getPrice() + "\n*********************************");
				}

				else if (homes.get(i).getKind().equals("Field")) {
					System.out.println("Ad Type: " + homes.get(i).getType() + "\nAd Kind: " + homes.get(i).getKind()
							+ "\nUseType: " + homes.get(i).getUseType() + "\nAddress: " + homes.get(i).getAddress()
							+ "\nArea: " + homes.get(i).getArea() + "\nTelephone: " + homes.get(i).getTelephone()
							+ "\nPrice: " + homes.get(i).getPrice() + "\n*********************************");
				}
			}
		}

	}

	// remove an ad
	// ----------------------------------------------------------------------------------------------------------------------------------
	public void removeAd() {
		long toRemove;
		System.out.println("Enter The Telephone Number For This Ad: ");
		toRemove = input.nextLong();

		for (int i = 0; i < homes.size(); i++) {
			if (toRemove == homes.get(i).getTelephone()) {
				homes.remove(homes.get(i));
			}
		}
	}
}
