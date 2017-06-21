package com.example.db;

import java.util.LinkedHashMap;
import java.util.Map;

public class BusLineInfo {

	private String id;
	private String linenum;
	private String bustype;
	private String licenseplatenum;
	private String drivername;
	private String driverphonenum;
	private String captionname;
	private String captionemail;
	private String captionphonenum;
	private String seats;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<String, BusStopInfo> map = new LinkedHashMap();

	public BusLineInfo(String id, String linenum, String bustype, String licenseplatenum, String drivername,
			String driverphonenum, String captionname, String captionemail, String captionphonenum, String seats,
			Map<String, BusStopInfo> map) {
		
		super();
		
		this.id = id;
		this.linenum = linenum;
		this.bustype = bustype;
		this.licenseplatenum = licenseplatenum;
		this.drivername = drivername;
		this.driverphonenum = driverphonenum;
		this.captionname = captionname;
		this.captionemail = captionemail;
		this.captionphonenum = captionphonenum;
		this.seats = seats;
		this.map = map;
	}

	public String getLinenum() {
		return linenum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLinenum(String linenum) {
		this.linenum = linenum;
	}

	public String getBustype() {
		return bustype;
	}

	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public String getLicenseplatenum() {
		return licenseplatenum;
	}

	public void setLicenseplatenum(String licenseplatenum) {
		this.licenseplatenum = licenseplatenum;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getDriverphonenum() {
		return driverphonenum;
	}

	public void setDriverphonenum(String driverphonenum) {
		this.driverphonenum = driverphonenum;
	}

	public String getCaptionname() {
		return captionname;
	}

	public void setCaptionname(String captionname) {
		this.captionname = captionname;
	}

	public String getCaptionemail() {
		return captionemail;
	}

	public void setCaptionemail(String captionemail) {
		this.captionemail = captionemail;
	}

	public String getCaptionphonenum() {
		return captionphonenum;
	}

	public void setCaptionphonenum(String captionphonenum) {
		this.captionphonenum = captionphonenum;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public Map<String, BusStopInfo> getBusstopinfo() {
		return map;
	}

	public void setBusstopinfo(Map<String, BusStopInfo> busstopinfo) {
		this.map = busstopinfo;
	}

	public BusLineInfo(String linenum, String bustype, String licenseplatenum, String drivername, String driverphonenum,
			String captionname, String captionemail, String captionphonenum, String seats,
			Map<String, BusStopInfo> busstopinfo) {
		super();
		this.linenum = linenum;
		this.bustype = bustype;
		this.licenseplatenum = licenseplatenum;
		this.drivername = drivername;
		this.driverphonenum = driverphonenum;
		this.captionname = captionname;
		this.captionemail = captionemail;
		this.captionphonenum = captionphonenum;
		this.seats = seats;
		this.map = busstopinfo;
	}

	public BusLineInfo(String linenum, String bustype, String licenseplatenum, String drivername, String driverphonenum,
			String captionname, String captionemail, String captionphonenum, String seats) {
		super();
		this.linenum = linenum;
		this.bustype = bustype;
		this.licenseplatenum = licenseplatenum;
		this.drivername = drivername;
		this.driverphonenum = driverphonenum;
		this.captionname = captionname;
		this.captionemail = captionemail;
		this.captionphonenum = captionphonenum;
		this.seats = seats;
	}

	public BusLineInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BusLineInfo [id=" + id + ", linenum=" + linenum + ", bustype=" + bustype + ", licenseplatenum="
				+ licenseplatenum + ", drivername=" + drivername + ", driverphonenum=" + driverphonenum
				+ ", captionname=" + captionname + ", captionemail=" + captionemail + ", captionphonenum="
				+ captionphonenum + ", seats=" + seats + ", map=" + map + "]";
	}



}
