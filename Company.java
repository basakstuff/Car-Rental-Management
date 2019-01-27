import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Company {

	public static final int I_COM = 0;
	public static final int I_CAR = 1;
	public static final int I_CON = 2;
	public static final int I_CUS = 3;
	public static final int I_EMP = 4;

	private Car[] cars;
	private Contract[] contracts;
	private Customer[] customers;
	private Employee[] employees;

	public int[] sizes;

	private String name;
	private Address address;
	private Phone phone;

	public Company(String name, Address address, Phone phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;

		cars = new Car[50];
		contracts = new Contract[50];
		customers = new Customer[50];
		employees = new Employee[50];

		sizes = new int[5];
	}

	public void addEmployee(Employee newEmp) {
		int i = sizes[I_EMP]++;

		newEmp.setId(String.format("E%03d", i + 1));
		employees[i] = newEmp;
	}

	public void addCar(Car newCar) {
		int i = sizes[I_CAR]++;
		cars[i] = newCar;
	}

	public void addCustomer(Customer newCustomer) {
		int i = sizes[I_CUS]++;

		newCustomer.setId(String.format("C%03d", i + 1));
		customers[i] = newCustomer;
	}

	public void addContract(Contract newContract) {
		int i = sizes[I_CON]++;

		contracts[i] = newContract;

		// update customer
		Customer customer = findCustomerById(newContract.getCustomerId());
		if (customer != null) {
			customer.setRentalCount(customer.getRentalCount() + 1);
		}

		// increase wage of employee
		Employee employee = findEmployeeById(newContract.getEmployeeId());
		if (employee != null) {
			employee.setWage(employee.getWage() + newContract.getTotalPrice() * 0.05f);
		}

		// update rental count of car
		Car car = findCarByPlate(newContract.getCarPlate());
		if (car != null)
			car.incrementRentalCount();
	}

	public Car findCarByPlate(String plate) {
		for (int i = 0; i < sizes[I_CAR]; i++) {
			if (cars[i].getPlate().equals(plate))
				return cars[i];
		}

		return null;
	}

	public Employee findEmployeeById(String employeeId) {
		for (int i = 0; i < sizes[I_EMP]; i++) {
			if (employees[i].getId().equals(employeeId))
				return employees[i];
		}

		return null;
	}

	public Customer findCustomerById(String customerId) {
		// lineer search
		for (int i = 0; i < sizes[I_CUS]; i++) {
			if (customers[i].getId().equals(customerId))
				return customers[i];
		}

		return null;
	}

	public Customer[] findCustomersByType(Customer.Type customerType) {
		List<Customer> outList = new LinkedList<>();
		Customer[] customers = getCustomers();

		for (Customer c : customers) {
			if (c.getType().equals(customerType))
				outList.add(c);
		}

		return outList.toArray(new Customer[] {});
	}

	public void increaseSalariesBy(int percentage) {
		for (Employee e : getEmployees()) {
			e.setWage(e.getWage() * (1 + (percentage / 100.0f)));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Car[] getCars() {
		return Arrays.copyOf(cars, sizes[I_CAR]);
	}

	public Contract[] getContracts() {
		return Arrays.copyOf(contracts, sizes[I_CON]);
	}

	public Customer[] getCustomers() {
		return Arrays.copyOf(customers, sizes[I_CUS]);
	}

	public Employee[] getEmployees() {
		return Arrays.copyOf(employees, sizes[I_EMP]);
	}
}
