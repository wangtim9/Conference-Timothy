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

			Attendee a1 = newAttendee(id, First, Last, company);

			arr[x] = a1;
			x++;
		}

		scan.close();
		numCompanies = x;
	}
}

public void listAttendees() {
	for (Attendee a : arr) {
		if (a != null) {
			System.out.println(a):
		}
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
	



