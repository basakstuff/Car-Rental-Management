public class Phone {
    private String countryCode;
    private String regionCode;
    private String number;

    public Phone() {
        countryCode = "00";
        regionCode = "000";
        number = "0000000";
    }

    public Phone(String countryCode, String regionCode, String number) {
        this.countryCode = countryCode;
        this.regionCode = regionCode;
        this.number = number;
    }

    public Phone(int countryCode, int regionCode, int number) {
        setCountryCode(countryCode);
        setRegionCode(regionCode);
        setNumber(number);
    }

    public void setCountryCode(int countryCode) {
        setCountryCode(String.format("%02d", countryCode));
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setRegionCode(int regionCode) {
        setRegionCode(String.format("%03d", regionCode));
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setNumber(int number) {
        String n = String.valueOf(number);

        if (n.length() < 7) {
            throw new RuntimeException("Phone number can not be shorter than 7 digits without spaces!");
        }

        n = String.format("%s %s %s",
                n.substring(0, 3),
                n.substring(3, 5),
                n.substring(5)
        );

        this.number = n;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.join("", new String[]{
                "+", countryCode, " (", regionCode, ") ", number
        });
    }
}
