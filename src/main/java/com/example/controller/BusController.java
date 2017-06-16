package com.example.controller;

import com.example.db.BusLineInfo;
import com.example.exceptions.DataIntegrityViolationException;
import com.example.exceptions.NotFoundException;
import com.example.services.BusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BusController {

    private static final Logger logger = LoggerFactory.getLogger(BusController.class);

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @RequestMapping(value = "/bus", method = RequestMethod.GET)
    public List<BusLineInfo> listAllBus() {
        List<BusLineInfo> buses = busService.findAllBus();
        if (buses.isEmpty()) {
            throw new NotFoundException("No bus found");
        }
         
        return buses;
    }

    @RequestMapping(value = "/bus/{id}", method = RequestMethod.GET)
    public BusLineInfo getBus(@PathVariable("id") String id) {
        logger.info("Fetching Bus with id {}", id);
        Optional<BusLineInfo> bus = busService.findById(id) ;
        if (!bus.isPresent()) {
            logger.error("Bus with id {} not found.", id) ;
            throw new NotFoundException(String.format("Bus %s not found  ", id));
        }

        return bus.get();
    }


    @RequestMapping(value = "/bus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createBus(@RequestBody BusLineInfo bus) {
        logger.info("Creating User : {}", bus);

        if (busService.isBusExist(bus)) {
            logger.error("Unable to create. A Bus with name {} already exist", bus.getId());
            throw new DataIntegrityViolationException("bus already exist");
        }
        busService.saveBus(bus);
    }


    @RequestMapping(value = "/bus/{id}", method = RequestMethod.PUT)
    public void updateBus(@PathVariable("id") String id, @RequestBody BusLineInfo bus) {
        logger.info("Updating Bus with id {}", id);

        Optional<BusLineInfo> currentBusOpt = busService.findById(id);

        if (!currentBusOpt.isPresent()) {
            logger.error("Unable to update. Bus with id {} not found.", id);
            throw new NotFoundException(String.format("User %s not found", id));
        }

        BusLineInfo currentBus = currentBusOpt.get();
        currentBus.setCaptionname(bus.getCaptionname());
//        currentUser.setAge(bus.getAge());
//        currentUser.setSalary(bus.getSalary());

        busService.updateBus(currentBus);
    }

    @RequestMapping(value = "/bus/{id}", method = RequestMethod.DELETE)
    public void deleteBus(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting Bus with id {}", id);

        Optional<BusLineInfo> currentBusOpt = busService.findById(id);
        if (!currentBusOpt.isPresent()) {
            logger.error("Unable to delete. Bus with id {} not found.", id);
            throw new NotFoundException(String.format("Bus %s not found", id));
        }
        busService.deleteBusById(id);
    }


    @RequestMapping(value = "/bus", method = RequestMethod.DELETE)
    public void deleteAllBuss() {
        logger.info("Deleting All Bus");

        busService.deleteAllBus();
    }

}