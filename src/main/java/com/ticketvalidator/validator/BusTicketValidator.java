package com.ticketvalidator.validator;

import com.ticketvalidator.model.BusTicket;
import com.ticketvalidator.util.FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.List;

public class BusTicketValidator {
    private static String filePath = "src/main/resources/busTikcetsJsonFile";
    private static List<BusTicket> busTicketList;
    private static FileReader fileReader;
    private static Validator validator;


    public static void main(String[] args) throws FileNotFoundException {
        busTicketList = fileReader.parseData(filePath);
        validator = new Validator();
        validator.validateTicket(busTicketList);
    }

}
