public class Address {

	private int buildingNumber;
	private String street;
	private String city;
	private String region;
	private String country;

	public Address(int buildingNumber, String street, String city, String region, String country) {
		this.buildingNumber = buildingNumber;
		this.street = street;
		this.city = city;
		this.region = region;
		this.country = country;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.join(" ", new String[] { street, String.valueOf(buildingNumber), city, region, country });
	}
}
