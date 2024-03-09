package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.dto.BookingsDTO;
import com.kapasiya.indoremetro.dto.ReservationDTO;
import com.kapasiya.indoremetro.entity.Bookings;
import com.kapasiya.indoremetro.entity.MetroData;
import com.kapasiya.indoremetro.entity.User;
import com.kapasiya.indoremetro.helper.ObjectCreationHelper;
import com.kapasiya.indoremetro.repository.BookingsRepository;
import com.kapasiya.indoremetro.repository.MetroDataRepository;
import com.kapasiya.indoremetro.repository.UserRepository;
import com.kapasiya.indoremetro.servicedef.DefaultUserService;
import com.kapasiya.indoremetro.servicedef.StationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.razorpay.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
@Secured("ROLE_USER")
@RequestMapping("/dashboard")
public class DashboardController
{
    private DefaultUserService userService;

    @Autowired
    private UserRepository userRepository;

    public DashboardController(DefaultUserService userService) {
        super();
        this.userService = userService;
    }

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    StationService stationService;

    @Autowired
    private MetroDataRepository metroDataRepository;

    @ModelAttribute("reservation")
    public ReservationDTO reservationDTO() {
        return new ReservationDTO();
    }

    @GetMapping
    public String displayDashboard(Model model){
        String user= returnUsername();
        model.addAttribute("userDetails", user);
        model.addAttribute("station",stationService.getAllStations());
        return "ticket";
    }

    @GetMapping("/book/{id}")
    public String bookPage(@PathVariable int id, Model model)
    {
        Optional<MetroData> busdata = metroDataRepository.findById(id);

        BookingsDTO bks = ObjectCreationHelper.createBookingsDTO(busdata.get());

        String user = returnUsername();
        model.addAttribute("userDetails", user);
        model.addAttribute("record", bks);
        return "book";
    }

    @PostMapping("/booking")
    @ResponseBody
    public String finalBooking(@RequestBody Map<String,Object> data) throws RazorpayException
    {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();

        System.out.println(data);

        BookingsDTO bookingDTO = new BookingsDTO();
        bookingDTO.setMetroName((String) data.get("metroName"));
        bookingDTO.setTicketID((String) data.get("ticketId"));
        bookingDTO.setFromDestination((String) data.get("from"));
        bookingDTO.setFilterDate((String) data.get("filterDate"));
        bookingDTO.setPrice(Double.valueOf((String) data.get("price")));
        bookingDTO.setTime((String) data.get("time"));
        bookingDTO.setToDestination((String) data.get("to"));
        bookingDTO.setTripStatus(String.valueOf(1));
        bookingDTO.setNoOfPersons(Integer.parseInt((String) data.get("noOfPassenger")));
        bookingDTO.setTotalCalculated(Double.valueOf((String) data.get("amount")));



        Bookings b = userService.updateBookings(bookingDTO,user);

        // Payment API Integration..........

        var client = new RazorpayClient("rzp_test_CAOmLVEJtoNizm","hChC99xBGSoEnQQRMj07GGOR");

        JSONObject object = new JSONObject();

        object.put("amount",bookingDTO.getTotalCalculated() *100);
        object.put("currency","INR");
        object.put("receipt","txn_75563");

        Order order = client.orders.create(object);

        System.out.println(order);


//        model.addAttribute("record", new BookingsDTO());
        return order.toString();
    }

    @PostMapping
    public String filterBusData(@ModelAttribute("reservation") ReservationDTO reservationDTO , Model model)
    {
        List<MetroData> metroData = metroDataRepository.findByToFromAndDate(reservationDTO.getTo(), reservationDTO.getFrom());

        if(metroData.isEmpty()) {
            metroData = null;
        }
        String user = returnUsername();
        model.addAttribute("userDetails", user);
        model.addAttribute("busData",metroData);
        model.addAttribute("reservation", reservationDTO);
        return "ticket";
    }


    private String returnUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        User users = userRepository.findByEmail(user.getUsername());
        return users.getName();
    }

}
