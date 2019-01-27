import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Main {

	public static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public static void main(String[] args) {

		Company cm = new Company("DECar", new Address(12, "DEU Kampüs", "Buca", "İzmir", "Turkey"),
				new Phone(90, 266, 7630196));

		// employees
		Employee e1 = new Employee("Berke", new Date(), new Phone(90, 850, 4400000));
		Employee e2 = new Employee("Berke", new Date(), new Phone(90, 850, 4400000));
		Employee e3 = new Employee("Berke", new Date(), new Phone(90, 850, 4400000));
		Employee e4 = new Employee("Berke", new Date(), new Phone(90, 850, 4400000));

		cm.addEmployee(e1);
		cm.addEmployee(e2);
		cm.addEmployee(e3);
		cm.addEmployee(e4);

		// employee list
		System.out.println();
		System.out.println(Employee.getTableHeader());
		printAll(cm.getEmployees());

		// car types
		Car.Type ct1 = new Car.Type(Car.Type.BodyType.Jeep, 850);
		Car.Type ct2 = new Car.Type(Car.Type.BodyType.Coupe, 1250);
		Car.Type ct3 = new Car.Type(Car.Type.BodyType.Hatchback, 700);
		Car.Type ct4 = new Car.Type(Car.Type.BodyType.Minivan, 600);
		Car.Type ct5 = new Car.Type(Car.Type.BodyType.Sedan, 500);

		// cars
		Car c1 = new Car("35AAB01", "Toyota", "Yaris", 2012, ct3);
		Car c2 = new Car("35AAB02", "Mercedes-Benz", "230", 2012, ct3);
		Car c3 = new Car("35AAB03", "Jeep", "Grand Cherokee", 2012, ct1);

		cm.addCar(c1);
		cm.addCar(c2);
		cm.addCar(c3);

		// customers
		Phone dummyCustomerPhone = new Phone(90, 266, 7630196);
		Address dummyCustomerAddress = new Address(27, "Street Name", "City Name", "Region Name", "Country");
		Customer cu1 = new Customer("Murat", dummyCustomerAddress, dummyCustomerPhone, new Date());
		Customer cu2 = new Customer("Mükerrem", dummyCustomerAddress, dummyCustomerPhone, new Date());
		Customer cu3 = new Customer("Ece", dummyCustomerAddress, dummyCustomerPhone, new Date());

		cm.addCustomer(cu1);
		cm.addCustomer(cu2);
		cm.addCustomer(cu3);

		// contracts
		Date[] randomDates = getRandomDateInterval();
		Contract con1 = new Contract(c1, cu3, e3, randomDates[0], randomDates[1]);
		randomDates = getRandomDateInterval();
		Contract con2 = new Contract(c3, cu1, e1, randomDates[0], randomDates[1]);
		randomDates = getRandomDateInterval();
		Contract con3 = new Contract(c2, cu1, e2, randomDates[0], randomDates[1]);
		randomDates = getRandomDateInterval();
		Contract con4 = new Contract(c1, cu2, e3, randomDates[0], randomDates[1]);
		randomDates = getRandomDateInterval();
		Contract con5 = new Contract(c2, cu1, e2, randomDates[0], randomDates[1]);

		cm.addContract(con1);
		cm.addContract(con1);
		cm.addContract(con1);
		cm.addContract(con2);
		cm.addContract(con2);
		cm.addContract(con2);
		cm.addContract(con2);
		cm.addContract(con2);
		cm.addContract(con2);
		cm.addContract(con3);
		cm.addContract(con4);
		cm.addContract(con5);

		// =============================================================================================================

		// list cars
		System.out.println();
		System.out.println(Car.getTableHeader());
		printAll(cm.getCars());

		// customers
		System.out.println();
		System.out.println(Customer.getTableHeader());
		printAll(cm.getCustomers());

		// silver customers
		System.out.println("\nSILVER");
		System.out.println(Customer.getTableHeader());
		printAll(cm.findCustomersByType(Customer.Type.Silver));

		// employee list
		System.out.println();
		System.out.println(Employee.getTableHeader());
		printAll(cm.getEmployees());

		System.out.println();
		System.out.println("Increasing salaries by 10%");
		cm.increaseSalariesBy(10);

		System.out.println();
		System.out.println(Employee.getTableHeader());
		printAll(cm.getEmployees());

		// contracts
		System.out.println();
		System.out.println(Contract.getTableHeader());
		printAll(cm.getContracts());

		float totalIncome = 0;
		for (Contract c : cm.getContracts()) {
			totalIncome += c.getTotalPrice();
		}

		System.out.print("TOTAL:\t" + totalIncome);
		System.out.println();

		// == most rented car
		Car[] cars = cm.getCars();
		Arrays.sort(cars);

		System.out.println();
		System.out.println("Most Rented Car:");
		System.out.println(cars[0]);

	}

	public static void printAll(Object[] collection) {
		for (Object e : collection) {
			System.out.println(e.toString());
		}
	}

	public static Date[] getRandomDateInterval() {
		Date[] out = new Date[2];

		Date currentDate = new Date();
		Random random = new Random();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		// basla
		calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(7));
		out[0] = calendar.getTime();

		// bitir
		calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(14));
		out[1] = calendar.getTime();

		return out;
	}

}
