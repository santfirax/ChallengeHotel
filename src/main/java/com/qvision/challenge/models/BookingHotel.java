package com.qvision.challenge.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BookingHotel {
    private final String location;
    private final String checkIn;
    private final String checkOut;

    public BookingHotel(String location, String checkIn, String checkOut) {
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getLocation() {
        return location;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BookingHotel)) return false;

        BookingHotel that = (BookingHotel) o;

        return new EqualsBuilder()
                .append(getLocation(), that.getLocation())
                .append(getCheckIn(), that.getCheckIn())
                .append(getCheckOut(), that.getCheckOut())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getLocation())
                .append(getCheckIn())
                .append(getCheckOut())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("location", location)
                .append("checkIn", checkIn)
                .append("checkOut", checkOut)
                .toString();
    }
}
