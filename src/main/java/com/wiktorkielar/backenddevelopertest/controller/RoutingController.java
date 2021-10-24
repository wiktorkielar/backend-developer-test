package com.wiktorkielar.backenddevelopertest.controller;

import com.wiktorkielar.backenddevelopertest.model.Route;
import com.wiktorkielar.backenddevelopertest.service.RoutingService;
import net.minidev.json.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/routing")
public class RoutingController {

    private final RoutingService routingService;

    public RoutingController(RoutingService routingService) {
        this.routingService = routingService;
    }

    @GetMapping("/{sourceCountry}/{destinationCountry}")
    public ResponseEntity<Route> getRoute(@PathVariable String sourceCountry, @PathVariable String destinationCountry) throws IOException, ParseException {
        if(routingService.getRoute(sourceCountry, destinationCountry).getRoute().size() > 1) {
            return new ResponseEntity<>(routingService.getRoute(sourceCountry, destinationCountry), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
