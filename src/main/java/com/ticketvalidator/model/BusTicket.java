package com.ticketvalidator.model;

import java.util.Objects;

public class BusTicket {

    String ticketClass;

    String ticketType;

    String startDate;

    String price;

    public BusTicket(){

    }

    public BusTicket(String ticketClass, String ticketType, String price, String startDate) {
        this.ticketClass = ticketClass;
        this.ticketType = ticketType;
        this.price = price;
        this.startDate = startDate;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BusTicket busTicket = (BusTicket) object;
        return Objects.equals(ticketClass, busTicket.ticketClass) && Objects.equals(ticketType, busTicket.ticketType) && Objects.equals(startDate, busTicket.startDate) && Objects.equals(price, busTicket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketClass, ticketType, startDate, price);
    }
}
