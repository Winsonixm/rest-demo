package com.example.bus.DB;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.db.BusLineInfo;
import com.example.db.BusStopInfo;

@SuppressWarnings("unchecked")
public class BUSDB {

	// 模拟班车数据库
	private static Map mapbus = new LinkedHashMap();
	private static Map map1stop = new LinkedHashMap();
	private static Map map2stop = new LinkedHashMap();
	private static Map map3stop = new LinkedHashMap();


	static {
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
		
		
		mapbus.put("1", new BusLineInfo("1","1", "ibm", "鄂A11111", "王师傅", "13011111111", "小王", "xiaowang@aaa.com","18011111111", "45座", map1stop));
		mapbus.put("2", new BusLineInfo("2","2", "ibm", "鄂A22222", "张师傅", "13011111222", "小王2", "xiaowang2@aaa.com","18011121111", "40座",map2stop));
		mapbus.put("3", new BusLineInfo("3","3", "public", "鄂A33333", "赵师傅", "13011333111", "小王3", "xiaowang3@aaa.com","18031111111", "45座",map3stop));
			
	}
	
	public static Map getAll(){
		return mapbus;
	}
}
