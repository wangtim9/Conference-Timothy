import java.io.File;

public class Attendee {
	public static void main(String[] args) {
		File ConfAtt = new File ("confGuest.txt");
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
}




