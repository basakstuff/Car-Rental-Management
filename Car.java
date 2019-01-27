public class Car implements Comparable<Car> {

	private String plate;
	private String brand;
	private String model;
	private int productionYear;

	private Type type;

	private int rentalCount;

	public Car(String plate, String brand, String model, int productionYear, Type type) {
		this.plate = plate;
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.type = type;
		this.rentalCount = 0;
	}

	public int getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}

	public void incrementRentalCount() {
		this.rentalCount++;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public static String getTableHeader() {
		return String.format("\nCARS\n%-10s | %-16s | %-16s | %4s | %-10s | %10s\n%s", "Plate", "Brand", "Model",
				"Year", "Body Type", "Daily Price",
				"-----------------------------------------------------------------------------------");
	}

	@Override
	public String toString() {
		return String.format("%-10s | %-16s | %-16s | %4d | %-10s | %4.2f TL", plate, brand, model, productionYear,
				type.bodyType.toString(), type.dailyPrice);
	}

	public static class Type {

		public enum BodyType {
			Jeep, Minivan, Coupe, Hatchback, Sedan
		}

		private BodyType bodyType;
		private float dailyPrice;

		public Type() {
		}

		public Type(BodyType bodyType, float dailyPrice) {
			this.bodyType = bodyType;
			this.dailyPrice = dailyPrice;
		}

		public BodyType getBodyType() {
			return bodyType;
		}

		public void setBodyType(BodyType bodyType) {
			this.bodyType = bodyType;
		}

		public float getDailyPrice() {
			return dailyPrice;
		}

		public void setDailyPrice(float dailyPrice) {
			this.dailyPrice = dailyPrice;
		}
	}

	@Override
	public int compareTo(Car car) {
		return -1 * Integer.compare(rentalCount, car.rentalCount);
	}
}
