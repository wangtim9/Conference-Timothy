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

			person[0].getID;
		
	


