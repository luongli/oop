package li.com;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
	public static final String delimiter = ",";  
	
	public static void main(String[] args) {
		ArrayList company = new ArrayList();
		if(args.length == 0){
			// create four-element Payable array
			Payable[] payableObjects = new Payable[4];
			// populate array with objects that implement Payable
			payableObjects[0] = new HourlyEmployee("Nguyen", "Luong", "111-22-3333", new Date(22, 4, 1995), 20, 7);
			payableObjects[1] = new CommissionEmployee("Nguyen", "Huy", "114-22-3333", new Date(22, 5, 1995), 50.0, 0.5);
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
			Department d1 = new Department("D1");
			Department d2 = new Department("D2");
			
			d2.addEmployee(new HourlyEmployee("Nguyen", "Luong1", "111-22-3333", new Date(22, 4, 1995), 20, 7));
			d2.addEmployee(new CommissionEmployee("Nguyen", "Huy1", "114-22-3333", new Date(22, 5, 1995), 50.0, 0.5));
			d2.addEmployee(new SalariedEmployee("John", "Smith1", "111-11-1111", new Date(22, 6, 1995), 800.00));
			d2.addEmployee(new SalariedEmployee("Lisa", "Barnes1", "888-88-8888", new Date(22, 7, 1995), 1200.00));
			
			Employee e;
			try{
				for (Payable currentPayable : payableObjects) {
					e = (Employee) currentPayable;
					d1.addEmployee(e);
					System.out.println(e.getInfo());
				}
				company.add(d1);
				company.add(d2);
			}catch(Exception exc){
				System.out.println(exc.toString());
			}
			
			// write d1 to disk
			try{
				FileOutputStream fileOut = new FileOutputStream("data.ser");//creates a card serial file in output stream
			     ObjectOutputStream out = new ObjectOutputStream(fileOut);//routs an object into the output stream.
			     out.writeObject(company);// we designate our array of cards to be routed
			     out.close();// closes the data paths
			     fileOut.close();// closes the data paths
			}catch(IOException ie){
				System.out.println(ie.toString());
			}
			
		}else{
			try{
				FileInputStream fileIn = new FileInputStream("data.ser");// Read serial file.
	            ObjectInputStream in = new ObjectInputStream(fileIn);// input the read file.
	            company = (ArrayList) in.readObject();// allocate it to the object file already instanciated.
	            in.close();//closes the input stream.
	            fileIn.close();//closes the file data stream.
	            Department d1 = ((Department)company.get(1));
	            Employee e[] = d1.getEmployees();
	            System.out.println("length of e = " + e.length);
	            System.out.println("currentSize = " + d1.getCurrentSize());
	            for(int i = 0; i < d1.getCurrentSize(); i++){
	            	System.out.println(e[i].getLastName());
	            }
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		
		
	} // end main
}
