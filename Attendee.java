import java.io.File;

public class Attendee {
	int numID;
	String nameLast;
	String nameFirst;
	int companyID;
	int Table;
	int Seat;
	public Attendee(int ID, String Last, String First, int CompanyID) {
		numID = ID;
		nameLast = Last;
		nameFirst = First;
		companyID = CompanyID;
	}

	public String getLast() {
		return nameLast;
	}

	public String getFirst() {
		return nameFirst;
	}
	
	public String getFullName() {
		return nameFirst + " "  + nameLast;
	}

	public int getID() {
		return numID;
	}

	public int getComp() {
		return companyID;
	}
	
	public String toString() {
		return numID + ". " + nameFirst + " " + nameLast + ", " + companyID;
	}
}




