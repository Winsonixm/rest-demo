package com.example.controller;

import com.example.db.Bus;
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
    public List<Bus> listAllBus() {
        List<Bus> bus = busService.findAllBus();
        if (bus.isEmpty()) {
            throw new NotFoundException("No bus found");
        }
         
        return bus;
    }

    @RequestMapping(value = "/bus/{id}", method = RequestMethod.GET)
    public Bus getBus(@PathVariable("id") String id) {
        logger.info("Fetching Bus with id {}", id);
        Optional<Bus> bus = busService.findById(id) ;
        if (!bus.isPresent()) {
            logger.error("Bus with id {} not found.", id) ;
            throw new NotFoundException(String.format("Bus %s not found  ", id));
        }

        return bus.get();
    }
//    @RequestMapping(value = "/users", method = RequestMethod.ADD)
//    public List<User> addAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if (users.isEmpty()) {
//            throw new NotFoundException("No users found");
//        }
//
//        return users;
//    }
//    @RequestMapping(value = "/users/{id}", method = RequestMethod.ADD)
//    public User addUser(@PathVariable("id") String id) {
//        logger.info("Adding User with id {}", id);
//        Optional<User> user = userService.findById(id);
//        if (!user.isPresent()) {
//            logger.error("User with id {} not found.", id);
//            throw new NotFoundException(String.format("User %s not found", id));
//        }
//
//        return user.add();
//    }

    @RequestMapping(value = "/buss", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Bus bus) {
        logger.info("Creating User : {}", bus);

        if (busService.isBusExist(bus)) {
            logger.error("Unable to create. A Bus with name {} already exist", bus.getUsername());
            throw new DataIntegrityViolationException("bus already exist");
        }
        busService.saveBus(bus);
    }


    @RequestMapping(value = "/buss/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") String id, @RequestBody Bus bus) {
        logger.info("Updating Bus with id {}", id);

        Optional<Bus> currentBusOpt = busService.findById(id);

        if (!currentBusOpt.isPresent()) {
            logger.error("Unable to update. Bus with id {} not found.", id);
            throw new NotFoundException(String.format("User %s not found", id));
        }

        Bus currentBus = currentBusOpt.get();
        currentBus.setUsername(bus.getUsername());
//        currentUser.setAge(bus.getAge());
//        currentUser.setSalary(bus.getSalary());

        busService.updateBus(currentBus);
    }

    @RequestMapping(value = "/buss/{id}", method = RequestMethod.DELETE)
    public void deleteBus(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting Bus with id {}", id);

        Optional<Bus> currentBusOpt = busService.findById(id);
        if (!currentBusOpt.isPresent()) {
            logger.error("Unable to delete. Bus with id {} not found.", id);
            throw new NotFoundException(String.format("Bus %s not found", id));
        }
        busService.deleteBusById(id);
    }


    @RequestMapping(value = "/buss", method = RequestMethod.DELETE)
    public void deleteAllBuss() {
        logger.info("Deleting All Buss");

        busService.deleteAllBus();
    }

}
