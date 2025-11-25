public class Main {
  public static void main (String[] args) {
    Conference c1 = new Conference();
    c1.loadData("confGuests.txt");
    c1.manual();
  }
}
