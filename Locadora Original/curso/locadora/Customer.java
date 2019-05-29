package curso.locadora;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(rental.getAmount()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}
	
	public int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			frequentRenterPoints += rental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}
	
	public double getTotalAmount() {
		double totalAmount = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
			totalAmount += rental.getAmount();
		}
		return totalAmount;
	}
	
}