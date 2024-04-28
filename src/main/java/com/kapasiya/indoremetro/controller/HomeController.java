package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.entity.LAFData;
import com.kapasiya.indoremetro.entity.Station;
import com.kapasiya.indoremetro.servicedef.LAFService;
import com.kapasiya.indoremetro.servicedef.NotificationService;
import com.kapasiya.indoremetro.servicedef.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
//@RequestMapping()
public class HomeController
{
    private static double priceShow = 0 ;

    @Autowired
    StationService stationService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    LAFService lafService;

    @GetMapping({"/","/home"})
    public String home(Model model)
    {
        System.out.println(stationService.getAllStations());
        model.addAttribute("station", stationService.getAllStations());
        model.addAttribute("notification",notificationService.getAllNotifications());
        model.addAttribute("stations", stationService.getAllStations());
        return "index";
    }

    @GetMapping("/tourGuide")
    public String tourGuide()
    {
        return "tourGuide";
    }

    @GetMapping("/faq")
    public String faq()
    {
        return "faq";
    }

    @GetMapping("/ticket")
    public String ticket()
    {
        return "/ticket";
    }

    @GetMapping("/aboutUs")
    private String aboutUs()
    {
        return "aboutUs";
    }

    @GetMapping("/notificationPanel")
    public String notificationPanel(Model model)
    {
        model.addAttribute("notification",notificationService.getAllNotifications());
        return "notificationPanel";
    }

    @GetMapping("/lostAndFound")
    private String lostAndFound()
    {
        return "lostAndFound";
    }

    @GetMapping("/index")
    public String homeAfter(Model model, @ModelAttribute("price") Double price) {
        model.addAttribute("station", stationService.getAllStations());
        model.addAttribute("stations", stationService.getAllStations());
        model.addAttribute("price", price);
        return "index";
    }

    @PostMapping("/stationDetail")
    public String stationIdName(Model model,@ModelAttribute("stationIdName") String stationIdName)
    {
//        System.out.println(stationIdName);
        model.addAttribute("stationIdName",stationIdName);

        return "stationDetails";
    }

    @GetMapping("/stationDetail")
    public String stationDetail(@RequestParam("stationIdName") int stationIdName, RedirectAttributes redirectAttributes)
    {
//        System.out.println(stationIdName);
        Optional<Station> station = stationService.findStationById(stationIdName);

        return "redirect:/stationDetails";
    }


//    @GetMapping("/fare")
//    public String fareCalculation()
//    {
////        Model model
////        model.addAttribute("stations", stationService.getAllStations() );
////        System.out.println(stationService.getAllStations());
//        return "/index";
//    }

    @PostMapping("/fare")
    public String fareCalculationLogic(@RequestParam("sourceId") int sourceId,
                                       @RequestParam("destinationId") int destinationId,
                                       RedirectAttributes redirectAttributes) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2, 4),
                new Edge(2, 3, 3),
                new Edge(3, 4, 2),
                new Edge(4, 5, 1),
                new Edge(5, 6, 1),
                new Edge(6, 7, 3),
                new Edge(7, 8, 1),
                new Edge(8, 9, 4),
                new Edge(9, 10, 2),
                new Edge(10, 11, 1),
                new Edge(11, 12, 1),
                new Edge(12, 13, 3),
                new Edge(13, 14, 2),
                new Edge(14, 15, 4),
                new Edge(15, 16, 1),
                new Edge(16, 17, 2),
                new Edge(17, 18, 1),
                new Edge(18, 19, 4),
                new Edge(19, 20, 1),
                new Edge(20, 21, 1),
                new Edge(21, 22, 2),
                new Edge(22, 23, 3),
                new Edge(23, 24, 2),
                new Edge(24, 25, 1),
                new Edge(25, 26, 2),
                new Edge(26, 27, 2),
                new Edge(27, 1, 1)
        );

        int minDistance = minDistance(edges, sourceId, destinationId);
        if (minDistance != -1)
        {
            priceShow = minDistance * 10;

            System.out.println("Price: " + priceShow);
            System.out.println("Minimum distance from source to destination: " + minDistance);

            redirectAttributes.addFlashAttribute("price", priceShow);
            return "redirect:/";
        }
        else
        {
            System.out.println("No path found from source to destination");
        }
        return "redirect:/";
    }

    //    @GetMapping("/index")
//    public String index(@RequestParam("value") int minDistance)
//    {
//        return "redirect:/index";
//    }
    public static int minDistance(List<Edge> edges, int source, int destination) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (Edge edge : edges) {
            graph.putIfAbsent(edge.source, new ArrayList<>());
            graph.get(edge.source).add(edge);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        minHeap.offer(new Node(source, 0));

        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(source, 0);

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentId = currentNode.id;
            int currentDistance = currentNode.distance;

            if (currentId == destination) {
                return currentDistance;
            }

            if (graph.containsKey(currentId)) {
                for (Edge neighbor : graph.get(currentId)) {
                    int newDistance = currentDistance + neighbor.distance;
                    if (!distances.containsKey(neighbor.destination) || newDistance < distances.get(neighbor.destination)) {
                        distances.put(neighbor.destination, newDistance);
                        minHeap.offer(new Node(neighbor.destination, newDistance));
                    }
                }
            }
        }

        return -1; // No path found
    }
    private static class Edge {
        int source;
        int destination;
        int distance;

        Edge(int source, int destination, int distance) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }
    }
    private static class Node {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    @GetMapping("/help")
    public String helpDesk()
    {
        return "help";
    }


    @GetMapping("/lost")
    public String lostRequest(Model model)
    {
        model.addAttribute("data", new LAFData());
        return "lostRequest";
    }

    @GetMapping("/SmartCard")
    public String smartCard()
    {
        return "smartCard";
    }


}