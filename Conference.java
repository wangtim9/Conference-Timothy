import java.io.*;
import java.util.*;

public class Conference {
	int numTables=10;
	int numCompanies;
	Attendee[] arr = new Attendee[150];//create array of 150 attendees
	ArrayList<String> companies = new ArrayList<String>();
	int PplPerTable=10;
	Attendee[][] tables;//create 2d array of tables

	public Conference() {
		loadData();
	}

	public void loadData() {
		try {
            File file = new File("confGuests.txt");
            Scanner scan = new Scanner(file);

            int x = 0;
			//loop to establish the objects in array
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] person = data.split(",");

                int id = Integer.parseInt(person[0]);
				String Last = person[1];
				String First = person[2];
				int company = Integer.parseInt(person[3]);

				Attendee a1 = new Attendee(id, Last, First, company);

				arr[x] = a1;
				x++;
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: confGuests.txt not found.");
        }
        try {
			File file1 = new File("companies.txt");
			Scanner scan1 = new Scanner(file1);
			while(scan1.hasNextLine()) {
				String Company = scan1.nextLine();
				companies.add(Company);
			}
			scan1.close();
		}catch (FileNotFoundException e) {
            System.out.println("ERROR: companies.txt not found.");
        }
	}
	
	public void prompt() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("How many tables will there be?");
		numTables = scan.nextInt();
		System.out.println("How many seats for each table?");
		PplPerTable = scan2.nextInt();
		tables = new Attendee[numTables][PplPerTable];
	}
	
	public void placeGuests() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			outer:
			for (int table = 0; table < numTables; table++) {
				for (int seat = 0; seat < PplPerTable; seat++) {
					if (tables[table][seat] == null) {
						tables[table][seat] = arr[i];
						break outer;
					}
					else if ((tables[table][seat]).getComp() == arr[i].getComp()) {
						break;
					}
				}
			}
		}
	}
	
	public void manual() {
	clearScreen();
	Scanner scan = new Scanner(System.in);

	System.out.println("Choose an option:");
	System.out.println("1. Retrieve Guest List");
	System.out.println("2. Add new attendee");
	System.out.println("3. Retrieve attendees from a company");
	System.out.println("4. Retrieve list of attendees at a table");
	System.out.println("5. Retrieve information about a guest");
	int choice = scan.nextInt();
	scan.nextLine();

	if (choice == 1) {
		clearScreen();
		System.out.println("\nAttendee List");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.println(arr[i]);
			}
		}
	}
	else if (choice == 2) {
		clearScreen();
		System.out.println("Enter ID: ");
		int ID = scan.nextInt();
	
		System.out.println("Enter first name: ");
		String First = scan.nextLine();
		scan.nextLine();//used to fix error where first and last name were both being asked at the same time

		System.out.println("Enter last name: ");
		String Last = scan.nextLine();

		System.out.println("Enter company ID: ");
		int coID = scan.nextInt();
		//for loop to put object where there is empty space
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = new Attendee(ID, Last, First, coID);
			}
		}
		System.out.println("New attendee added.");
	}
	else if (choice == 3) {
		System.out.println("Enter company ID");
		int company = scan.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getComp() == company) {
				System.out.println(arr[i]);
			}
		}
	}
	else if (choice == 4) {
		clearScreen();
		System.out.println("Which table?");
		int tableID = scan.nextInt() - 1;
		for (int i = 0; i < PplPerTable; i++) {
			if (tables[tableID][i] != null){
				System.out.println(tables[tableID][i]);
			}
		}
	}
	else if (choice == 5) {
		System.out.println("Which guest?");
		String guest = scan.nextLine();
		String guestCompany = "";
		outer:
		for (int table = 0; table < numTables; table++) {
			for (int seat = 0; seat < PplPerTable; seat++) {
				if (tables[table][seat] != null && ((tables[table][seat]).getFullName()).equals(guest)) {
					System.out.println("Table: " + table + 1);
					System.out.println("Seat: " + seat + 1);
					for (int i = 0; i < companies.size(); i++) {
						if((companies.get(i)).contains(Integer.toString((tables[table][seat]).getComp()))) {
							guestCompany = (companies.get(i)).substring((companies.get(i)).indexOf(",") + 1);
							break;
						}
					}
					System.out.println("Company: " + guestCompany);
					break outer;
				}
			}
		}
	}
	goBack();
	}
	
	public void goBack() {
		Scanner scan = new Scanner(System.in);
		System.out.println("would you like to go back to the main screen?");
		String response = scan.nextLine();
		if (response.equals("yes")) {
			clearScreen();
			manual();
		}
		else {
			goBack();
		}
	}
	
	public static void clearScreen() {
		// \033[H moves the cursor to the top left
		// \033[2J clears the entire screen
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}







