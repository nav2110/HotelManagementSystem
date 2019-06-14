package model.enums;

public enum HotelLocation {
    BUCURESTI("Bucuresti", " 021 310 2020", "010051"),
    SATUMARE("Satu Mare", "0350 801 080", "902345"),
    CLUJNAPOCA("Cluj-Napoca", "0364 111 333", "400483"),
    PATA("Cluj-Napoca", "112", "333333");

    private String cityName;
    private String phoneNo;
    private String zipCode;

    HotelLocation(String cityName, String phoneNo, String zipCode) {

        this.cityName = cityName;
        this.phoneNo = phoneNo;
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getZipCode() {
        return zipCode;
    }
}
