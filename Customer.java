import java.util.Date;

public class Customer {

	public enum Type {
		Bronze, Silver, Gold
	}

	private String id;
	private String name;
	private Address contactAddress;
	private Phone phone;
	private Date birthday;

	private Type type;
	private int rentalCount;

	private Company company;

	public Customer() {
		this.type = Type.Bronze;
		this.rentalCount = 0;
		this.company = null;
	}

	public Customer(String name, Address contactAddress, Phone phone, Date birthday) {
		this();
		this.name = name;
		this.contactAddress = contactAddress;
		this.phone = phone;
		this.birthday = birthday;
	}

	public Customer(String id, String name, Address contactAddress, Phone phone, Date birthday) {
		this.id = id;
		this.name = name;
		this.contactAddress = contactAddress;
		this.phone = phone;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(Address contactAddress) {
		this.contactAddress = contactAddress;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
		updateType();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	private void updateType() {
		if (rentalCount < 3)
			type = Type.Bronze;
		else if (rentalCount <= 5)
			type = Type.Silver;
		else
			type = Type.Gold;
	}

	public static String getTableHeader() {
		return String.format("CUSTOMERS\n%-4s | %-16s | %-20s | %10s | %-8s | %-15s | %-16s | %s\n%s", "ID", "Name",
				"Phone", "Birthday", "Type", "Total Rentals", "Company", "Contact Address",
				"-------------------------------------------------------------------------");
	}

	@Override
	public String toString() {
		return String.format("%-4s | %-16s | %-20s | %10s | %-8s | %-15s | %-16s | %s", id, name, phone,
				Main.dateFormat.format(birthday), type.toString(), rentalCount,
				company == null ? "-" : company.getName(), contactAddress.toString());
	}
}
