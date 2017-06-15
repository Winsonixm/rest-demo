package com.example.services;

import com.example.db.Bus;
import com.example.models.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BusService {

    private static List<Bus> bus;

    static {
        bus = populateDummyBus();
    }

    public List<Bus> findAllBus() {
        return bus;
    }

    public Optional<Bus> findById(String id) {
        return bus.stream().filter(bus -> bus.getId().equals(id)).findFirst();
    }

    private Optional<Bus> findByName(String name) {
        return bus.stream().filter(bus -> bus.getUsername().equalsIgnoreCase(name)).findFirst();
    }

    public void saveBus(Bus bus) {
        bus.setId(UUID.randomUUID().toString());
        bus.add(bus);
    }

    public void updateBus(Bus bus) {
        int index = bus.indexOf(bus);
        bus.set(index, bus);
    }

    public void deleteBusById(String id) {
        bus.removeIf(bus -> bus.getId().equals(id));
    }

    public boolean isBusExist(Bus bus) {
        return findByName(bus.getUsername()).isPresent();
    }

    public void deleteAllBus() {
        bus.clear();
    }

    private static List<Bus> populateDummyBus() {
        List<Bus> bus = new ArrayList<>();
        bus.add(new Bus(UUID.randomUUID().toString(), "Sam", 30, new BigDecimal("70000")));
        bus.add(new User(UUID.randomUUID().toString(), "Tom", 40, new BigDecimal("50000")));
        bus.add(new User(UUID.randomUUID().toString(), "Jerome", 45, new BigDecimal("30000")));
        bus.add(new User(UUID.randomUUID().toString(), "Silvia", 50, new BigDecimal("40000")));
        return bus;
    }

}

