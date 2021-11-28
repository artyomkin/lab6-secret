package DOM;

import utils.Logger;
/**
 * Address of the Venue
 * @see Venue
 * **/
public class Address {
    private String street;
    private final int MAX_STREET_LENGTH = 56;
    private String zipCode;
    private final int MIN_ZIP_CODE_LENGTH = 9;
    private Location town;

    public Address(String street, String zipCode, Location town) {
        if (street != null && street.length() > MAX_STREET_LENGTH || zipCode != null && zipCode.length() < MIN_ZIP_CODE_LENGTH || town == null){
            Logger.error("incorrect data in Address constructor");
        }
        this.street = street;
        this.zipCode = zipCode;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null && street.length() > MAX_STREET_LENGTH){
            Logger.error("street length is more than " + MAX_STREET_LENGTH + " in Address setter");
            System.exit(0);
        }
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if (zipCode != null && zipCode.length() < MIN_ZIP_CODE_LENGTH){
            Logger.error("zipCode length is less than " + MIN_ZIP_CODE_LENGTH + " in Address setter");
            System.exit(0);
        }
        this.zipCode = zipCode;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        if (town == null){
            Logger.error("town is null in Address constructor");
            System.exit(0);
        }
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", town=" + town.toString() +
                '}';
    }
}
