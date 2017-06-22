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
            throw new NotFoundException("No bus line found");
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


    @RequestMapping(value = "/addBus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createBus(@RequestBody BusLineInfo bus) {
        logger.info("Creating bus line information : {}", bus);

        if (busService.isBusExist(bus)) {
            logger.error("Unable to create. A Bus with name {} already exist", bus.getId());
            throw new DataIntegrityViolationException("bus line already exist");
        }
        busService.saveBus(bus);
    }


    @RequestMapping(value = "/updateBus/{id}", method = RequestMethod.PUT)
    public void updateBus(@PathVariable("id") String id, @RequestBody BusLineInfo bus) {
        logger.info("Updating Bus with id {}", id);

        Optional<BusLineInfo> currentBusOpt = busService.findById(id);

        if (!currentBusOpt.isPresent()) {
            logger.error("Unable to update. Bus line with id {} not found.", id);
            throw new NotFoundException(String.format("Bus line %s not found", id));
        }
        
        BusLineInfo currentBus = currentBusOpt.get();
       
        currentBus.setLinenum(bus.getLinenum());
        currentBus.setBustype(bus.getBustype());
        
        currentBus.setLicenseplatenum(bus.getLicenseplatenum());
        
        currentBus.setDrivername(bus.getDrivername());
        currentBus.setDriverphonenum(bus.getDriverphonenum());
        
        currentBus.setCaptionname(bus.getCaptionname());
        currentBus.setCaptionemail(bus.getCaptionemail());
        currentBus.setCaptionphonenum(bus.getCaptionphonenum());
        
        currentBus.setSeats(bus.getSeats());
      

        busService.updateBus(currentBus);
    }

    @RequestMapping(value = "/deleteBus/{id}", method = RequestMethod.DELETE)
    public void deleteBus(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting Bus with id {}", id);

        Optional<BusLineInfo> currentBusOpt = busService.findById(id);
        if (!currentBusOpt.isPresent()) {
            logger.error("Unable to delete. Bus line with id {} not found.", id);
            throw new NotFoundException(String.format("Bus %s not found", id));
        }
        busService.deleteBusById(id);
    }


    @RequestMapping(value = "/deleteAllBus", method = RequestMethod.DELETE)
    public void deleteAllBuss() {
        logger.info("Deleting All Bus");

        busService.deleteAllBus();
    }

}
