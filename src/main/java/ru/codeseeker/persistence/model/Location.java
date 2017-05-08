package ru.codeseeker.persistence.model;

import java.io.Serializable;

public class Location implements Serializable {
    private String city;
    private String cityType;

    public Location() { // for jackson
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        return cityType != null ? cityType.equals(location.cityType) : location.cityType == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (cityType != null ? cityType.hashCode() : 0);
        return result;
    }
}
