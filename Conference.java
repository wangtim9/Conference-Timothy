import java.io.*;
import java.util.*;

public class Conference {
	int numTables=10;
	int numCompanies;
	Attendee[] arr = new Attendee[150];//create array of 150 attendees
	Attendee[][] tables = new Attendee[10][10];
	int PplPerTable=10;

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
	}
	
	//public void placeGuest() {
	//	for (int i = 0; i < 
	//}
	
	public void prompt() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("How many tables will there be?");
		numTables = scan.nextInt();
		System.out.println("How many seat for each table?");
		PplPerTable = scan2.nextInt();
	}
	public void manual() {
	Scanner scan = new Scanner(System.in);

	System.out.println("Choose an option:");
	System.out.println("1. Retrieve Guest List");
	System.out.println("2. Add new attendee");
	System.out.println("3. Retrieve attendees from a company");
	System.out.println("4. Retrieve list of attendees at a table");
	System.out.println("5. Retrieve information of a guest");
	int choice = scan.nextInt();
	scan.nextLine();

	if (choice == 1) {
		System.out.println("\nAttendee List");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.println(arr[i]);
			}
		}
	}
	else if (choice == 2) {
		System.out.println("Enter ID: ");
		int ID = scan.nextInt();
	
		System.out.println("Enter first name: ");
		String First = scan.nextLine();
		scan.nextLine();//used to fix error where first an dlast name were both being asked at the same time

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
	manual();
	}
}







