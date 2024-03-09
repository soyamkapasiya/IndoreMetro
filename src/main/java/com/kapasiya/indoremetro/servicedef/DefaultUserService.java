package com.kapasiya.indoremetro.servicedef;

import com.kapasiya.indoremetro.dto.BookingsDTO;
import com.kapasiya.indoremetro.dto.UserRegisteredDTO;
import com.kapasiya.indoremetro.entity.Bookings;
import com.kapasiya.indoremetro.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DefaultUserService extends UserDetailsService
{
    User save(UserRegisteredDTO userRegisteredDTO);

    Bookings updateBookings(BookingsDTO bookingDTO, UserDetails user);

    void sendEmail(BookingsDTO bookingDTO, User users, String nameGenrator);

}