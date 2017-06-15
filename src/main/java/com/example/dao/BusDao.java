package com.example.dao;

import java.util.Map;

import com.example.bus.DB.BUSDB;
import com.example.db.BusLineInfo;

public class BusDao {

	public Map getAll(){
		
		return BUSDB.getAll();
		
	}
	
	public BusLineInfo find(String id){
		
		return (BusLineInfo) BUSDB.getAll().get(id);
		
	}
	
	
//	public Map findstop(String id){
//		
//		BusLineInfo theline = find(id);
//		return  theline.getBusstopinfo();
//		
//	}
	
}
