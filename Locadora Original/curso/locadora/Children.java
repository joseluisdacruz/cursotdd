package curso.locadora;

public class Children extends Movie {

	public Children(String title) {
		super(title);
	}
	
	@Override
	public double getAmount(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}
	
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
