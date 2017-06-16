package com.example.services;

import com.example.db.Bus;
import com.example.db.BusLineInfo;
import com.example.db.BusStopInfo;
import com.example.models.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class BusService {

    private static List<BusLineInfo> buses;

    static {
    	buses = populateDummyBus();
    }

    public List<BusLineInfo> findAllBus() {
        return buses;
    }

    public Optional<BusLineInfo> findById(String id) {
        return buses.stream().filter(bus -> bus.getId().equals(id)).findFirst();
    }

    private Optional<BusLineInfo> findByName(String linenum) {
        return buses.stream().filter(bus -> bus.getLinenum().equalsIgnoreCase(linenum)).findFirst();
    }

    public void saveBus(BusLineInfo bus) {
        bus.setId(UUID.randomUUID().toString());
        buses.add(bus);
    }

    public void updateBus(BusLineInfo bus) {
        int index = buses.indexOf(bus);
        buses.set(index, bus);
    }

    public void deleteBusById(String id) {
    	buses.removeIf(bus -> bus.getId().equals(id));
    }

    public boolean isBusExist(BusLineInfo bus) {
        return findByName(bus.getLinenum()).isPresent();
    }

    public void deleteAllBus() {
    	buses.clear();
    }

    private static List<BusLineInfo> populateDummyBus() {
        List<BusLineInfo> buses = new ArrayList<>();
    	Map map1stop = new LinkedHashMap();
    	Map map2stop = new LinkedHashMap();
    	Map map3stop = new LinkedHashMap();
    	
    	
    		map1stop.put("1", new BusStopInfo("1", "1a", "站点1a", "7:10:00", "某路口1"));
    		map1stop.put("2", new BusStopInfo("1", "1b", "站点1b", "7:20:00", "某路口2"));
    		map1stop.put("3", new BusStopInfo("1", "1c", "站点1c", "7:30:00", "某路口3"));
    		map1stop.put("4", new BusStopInfo("1", "1d", "站点1d", "8:40:00", "终点4"));

    		map2stop.put("1", new BusStopInfo("2", "2a", "站点2a", "7:10:00", "某路口1"));
    		map2stop.put("2", new BusStopInfo("2", "2b", "站点2b", "7:20:00", "某路口2"));
    		map2stop.put("3", new BusStopInfo("2", "2c", "站点2c", "8:30:00", "某路口3"));
    		map2stop.put("4", new BusStopInfo("2", "2d", "站点2d", "8:40:00", "终点4"));
    		
    		map3stop.put("1", new BusStopInfo("3", "3a", "站点3a", "7:10:00", "某路口1"));
    		map3stop.put("2", new BusStopInfo("3", "3b", "站点3b", "7:20:00", "某路口2"));
    		map3stop.put("3", new BusStopInfo("3", "3c", "站点3c", "7:30:00", "某路口3"));
    		map3stop.put("4", new BusStopInfo("3", "3d", "站点3d", "7:40:00", "某路口4"));
    		map3stop.put("5", new BusStopInfo("3", "3e", "站点3e", "7:50:00", "某路口5"));
    		map3stop.put("6", new BusStopInfo("3", "3f", "站点3f", "8:55:00", "终点6"));
    
        buses.add(new BusLineInfo("1","1", "ibm", "鄂A11111", "王师傅", "13011111111", "小王", "xiaowang@aaa.com","18011111111", "45座", map1stop));
        buses.add(new BusLineInfo("2","2", "ibm", "鄂A22222", "李师傅", "13011111111", "小王", "xiaowang@aaa.com","18011111111", "45座", map2stop));
        buses.add(new BusLineInfo("3","3", "ibm", "鄂A33333", "王师傅", "13011111111", "小王", "xiaowang@aaa.com","18011111111", "40座", map3stop));
        
//        bus.add(new User(UUID.randomUUID().toString(), "Tom", 40, new BigDecimal("50000")));
//        bus.add(new User(UUID.randomUUID().toString(), "Jerome", 45, new BigDecimal("30000")));
//        bus.add(new User(UUID.randomUUID().toString(), "Silvia", 50, new BigDecimal("40000")));
        return buses;
    }

}

