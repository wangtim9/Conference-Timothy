import java.io.*;
import java.util.*;

public class Conference {
	int numTables=10;
	int numCompanies;
	Attendee[] arr = new Attendee[150];
	int PplPerTable=10;

	public Conference() {
		loadData();
	}

	public void loadData() {
		File G = new File("confGuests.txt");
		Scanner scan = new Scanner(G);

		int x = 0;
		while (scan.hasNextLine()) {
			String data = scan.nextLine();
			String[] person = data.split(",");

			int id = person[0].getID;
			String First = person[1].getFirst;
			String Last = person[2].getLast;
			int company = person[3].getComp;

			Attendee a1 = new Attendee(id, Last, First, company);

			arr[x] = a1;
			x++;
		}

		scan.close();
		numCompanies = x;
	}
}

public Attendee findAttendee() {
	for (Attendee a : arr) {
		if (a != null && a.getID() == id) {
			return a;
		}
	}
	return null;
}

public void manual() {
	Scanner scan = new Scanner(System.in);

	System.out.println("Choose an option:");
	System.out.println("1. Retrieve Guest List");
	System.out.println("2. Add new attendee");
	int choice = scan.nextInt();
	scan.nextLine();

	if (choice == 1) {
		System.out.println("\nAttendee List");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.println(arr[i]);
			}
		}
	else if (choice == 2) {
		System.out.println("Enter ID: ")
		int ID = scan.nextInt();
	
		System.out.println("Enter first name: ");
		String First = scan.nextLine();

		System.out.println("Enter last name: ");
		String Last = scan.nextLine();

		System.out.println("Enter company ID: ");
		int coID = scan.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = new Attendee(ID, Last, First, coID);
				System.out.println("New attendee added.");
				return;
			}
		}
	}
		





