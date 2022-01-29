package com.ca.onyoureve;

public class Events {


    private int venueId,eventId,mediaId,cateringID;
    private String eventName;
    private double cost;

    public Events(int eventId,String eventName, int venueId, int mediaId, int cateringID, double cost) {
        this.venueId = venueId;
        this.eventId = eventId;
        this.mediaId = mediaId;
        this.cateringID = cateringID;
        this.cost = cost;
        this.eventName = eventName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueIdId(int venueId) {
        this.venueId = venueId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getCateringID() {
        return cateringID;
    }

    public void setCateringID(int cateringID) {
        this.cateringID = cateringID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
