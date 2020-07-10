package com.mastercard.route.challenge.controller;


import com.mastercard.route.challenge.service.RouteFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionController {

    @Autowired
    private RouteFinder routeFinder;

    /**
     * request mapping to find a connection between origin and destination
     * @param origin
     * @param destination
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String connection(@RequestParam String origin, @RequestParam String destination) {
        return routeFinder.routeExists(origin, destination);
    }


}
