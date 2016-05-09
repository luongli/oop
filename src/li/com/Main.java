package li.com;

public class Main {
	public static final String delimiter = ","; 
	
	public static void main(String[] args) {
		// create four-element Payable array
		Payable[] payableObjects = new Payable[4];
		// populate array with objects that implement Payable
		payableObjects[0] = new HourlyEmployee("Nguyen", "Luong", "111-22-3333", new Date(22, 4, 1995), 20, 7);
		payableObjects[1] = new CommissionEmployee("Nguyen", "Huy", "111-22-3333", new Date(22, 5, 1995), 50.0, 0.5);
		payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", new Date(22, 6, 1995), 800.00);
		payableObjects[3] = new SalariedEmployee("Lisa", "Barnes", "888-88-8888", new Date(22, 7, 1995), 1200.00);
		System.out.println("Invoices and Employees processed polymorphically:\n");
		// generically process each element in array payableObjects
		for (Payable currentPayable : payableObjects) {
			// output currentPayable and its appropriate payment amount
			System.out.printf("%s \n%s: $%,.2f\n\n", currentPayable.toString(), "payment due",
					currentPayable.getPaymentAmount());
		} // end for
		
		System.out.println("Check for print info of object");
		
		Employee e;
		for (Payable currentPayable : payableObjects) {
			e = (Employee) currentPayable;
			System.out.println(e.getInfo());
		}
	} // end main
}
