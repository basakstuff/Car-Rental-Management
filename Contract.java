import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contract {

	private String customerId;
	private String carPlate;
	private float dailyPrice;
	private String employeeId;
	private Date pickupDate;
	private Date dropoffDate;
	private long duration;

	public Contract(Car car, Customer customer, Employee employee, Date pickupDate, Date dropoffDate) {
		carPlate = car.getPlate();
		customerId = customer.getId();
		employeeId = employee.getId();
		dailyPrice = car.getType().getDailyPrice();

		this.pickupDate = pickupDate;
		this.dropoffDate = dropoffDate;

		updateDuration();
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
		updateDuration();
	}

	public Date getDropoffDate() {
		return dropoffDate;
	}

	public void setDropoffDate(Date dropoffDate) {
		this.dropoffDate = dropoffDate;
		updateDuration();
	}

	private void updateDuration() {
		long t1 = pickupDate.getTime();
		long t2 = dropoffDate.getTime();
		long diff = t2 - t1;
		duration = TimeUnit.MILLISECONDS.toDays(diff);
	}

	public long getDuration() {
		return duration;
	}

	public float getTotalPrice() {
		return duration * dailyPrice;
	}

	public static String getTableHeader() {
		return String.format("CONTRACTS\n%-12s | %-10s | %-15s | %-12s | %-10s | %-10s\n", "Customer", "Car",
				"Daily Price", "Employee", "Pickup @", "Dropoff @");
	}

	@Override
	public String toString() {
		return String.format("%-12s | %-10s | %12.3f TL | %-12s | %-10s | %-10s", customerId, carPlate, dailyPrice,
				employeeId, Main.dateFormat.format(pickupDate), Main.dateFormat.format(dropoffDate));
	}
}
