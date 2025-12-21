package com.conceptcoding.interviewquestions.bookmyshow.booking;

import com.conceptcoding.interviewquestions.bookmyshow.enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    int theatreId;
    String address;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<Show> shows = new ArrayList<>();

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theatre [theatreId=" + theatreId + ", address=" + address + ", city=" + city + ", screen=" + screens
                + ", shows=" + shows + "]";
    }
}
