package com.ticketvalidator.validator;

import com.ticketvalidator.model.BusTicket;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Validator {
    private static Map<String, Integer> vialations = new HashMap<>();

    public Validator() {
        vialations.put("priceVialation", 0);
        vialations.put("startDateVialation", 0);
        vialations.put("ticketTypeVialation", 0);
    }

    public static void validateTicket(List<BusTicket> busTickets){
        System.out.println("task 1 [total number of tickets]: " + busTickets.size());
        int validTickets = busTickets.size();
        int vialationsInCurrentTicket = 0;
        int priceToValidate;

        for(BusTicket ticket : busTickets) {
            if (ticket.getPrice() == null) {
                 priceToValidate = 0;
                vialations.put("priceVialation", vialations.get("priceVialation") + 1);
                vialationsInCurrentTicket++;
            } else {
                priceToValidate = Integer.parseInt(ticket.getPrice());
                if(priceToValidate == 0) {
                    vialations.put("priceVialation", vialations.get("priceVialation") + 1);
                    vialationsInCurrentTicket++;
                }
            }
            if(ticket.getStartDate() != null && !ticket.getStartDate().isEmpty()) {
                try{
                    LocalDate startDate = LocalDate.parse(ticket.getStartDate());
                    if(startDate.isAfter(LocalDate.now())){
                        vialations.put("startDateVialation", vialations.get("startDateVialation") + 1);
                        vialationsInCurrentTicket++;
                    }
                }catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
            } else if(!Arrays.asList("DAY", "MONTH", "WEEK", "YEAR").contains(ticket.getTicketType())) {
                vialations.put("ticketTypeVialation", vialations.get("ticketTypeVialation") + 1);
                vialationsInCurrentTicket++;;
            }
            if(vialationsInCurrentTicket > 0) {
                validTickets--;
            }
            vialationsInCurrentTicket = 0;
        }
        System.out.println("task 2 [total of valid tickets] :" + validTickets);
        getTheMostPopularValidation();
    }

    public static void getTheMostPopularValidation() {
        System.out.println("The most popular violation is: " + Collections.max(vialations.entrySet(), Map.Entry.comparingByValue()).getKey());
    }
}
