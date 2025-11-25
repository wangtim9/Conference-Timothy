import java.io.File;

public class Attendee {
	int numID;
	String nameLast;
	String nameFirst;
	int companyID;
	int Table;
	int Seat;
	//constructor for Attendee object
	public Attendee(int ID, String Last, String First, int CompanyID) {
		numID = ID;
		nameLast = Last;
		nameFirst = First;
		companyID = CompanyID;
	}
//below are all the getters
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
	public void toString() {
		System.out.println("Attendee: " + this.numID + " " + this.nameLast + " " + this.nameFirst + " " + companyID);
	}
}


