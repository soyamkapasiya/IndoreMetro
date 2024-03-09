package com.kapasiya.indoremetro.helper;


import com.kapasiya.indoremetro.dto.BookingsDTO;
import com.kapasiya.indoremetro.entity.Bookings;
import com.kapasiya.indoremetro.entity.MetroData;

public class ObjectCreationHelper {
    public static BookingsDTO createBookingsDTO(MetroData metrodata) {
        BookingsDTO bks = new BookingsDTO();

        bks.setMetroName(metrodata.getMetroName());
        bks.setFilterDate(metrodata.getFilterDate());
        bks.setFromDestination(metrodata.getFromDestination());
        bks.setToDestination(metrodata.getToDestination());
        bks.setPrice(metrodata.getPrice());
        bks.setNoOfPersons(0);
        bks.setTime(metrodata.getTime());
        bks.setTotalCalculated(0.0);

        return bks;


    }

    public static BookingsDTO createBookingsDTO(Bookings metrodata) {
        BookingsDTO bks = new BookingsDTO();
        bks.setId(metrodata.getId());

        bks.setMetroName(metrodata.getMetroName());
        bks.setFilterDate(metrodata.getFilterDate());
        bks.setFromDestination(metrodata.getFromDestination());
        bks.setToDestination(metrodata.getToDestination());
        bks.setNoOfPersons(metrodata.getNoOfPersons());
        bks.setTime(metrodata.getTime());
        bks.setTicketID(metrodata.getTicketID());
        bks.setTotalCalculated(metrodata.getTotalCalculated());
        if (metrodata.isTripStatus() == true) {
            bks.setTripStatus("Active");
        } else {
            bks.setTripStatus("Canceled");
        }

        return bks;
    }
}
