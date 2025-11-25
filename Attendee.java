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

	public int getID() {
		return numID;
	}

	public int getComp() {
		return companyID;
	}
}






