import java.util.Date;

public class Employee {

	private String id;
	private String name;
	private Date birthday;
	private Phone phone;
	private float wage;

	private Employee() {
		this.wage = 2029.50f;
	}

	public Employee(String name, Date birthday, Phone phone) {
		this();

		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
	}

	public Employee(String name, Date birthday, Phone phone, float wage) {
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.wage = wage;
	}

	public Employee(String id, String name, Date birthday, Phone phone) {
		this();

		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
	}

	public Employee(String id, String name, Date birthday, Phone phone, float wage) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.wage = wage;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public float getWage() {
		return wage;
	}

	public void setWage(float wage) {
		this.wage = wage;
	}

	public static String getTableHeader() {
		return String.format("\nEMPLOYEES\n%-4s | %-16s | %-20s | %10s | %-5s\n%s", "ID", "Name", "Phone", "Birthday",
				"Wage", "-------------------------------------------------------------------------");
	}

	@Override
	public String toString() {
		return String.format("%-4s | %-16s | %-20s | %10s | %8.3f TL", id, name, phone,
				Main.dateFormat.format(birthday), wage);
	}
}
