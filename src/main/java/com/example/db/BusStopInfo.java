package com.example.db;

public class BusStopInfo {

	private String linenum;
	private String stopnum;
	private String stopname;
	private String stoptime;
	private String stopdetail;

	public String getLinenum() {
		return linenum;
	}

	public void setLinenum(String linenum) {
		this.linenum = linenum;
	}

	public String getStopnum() {
		return stopnum;
	}

	public void setStopnum(String stopnum) {
		this.stopnum = stopnum;
	}

	public String getStopname() {
		return stopname;
	}

	public void setStopname(String stopname) {
		this.stopname = stopname;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	public String getStopdetail() {
		return stopdetail;
	}

	public void setStopdetail(String stopdetail) {
		this.stopdetail = stopdetail;
	}

	public BusStopInfo(String linenum, String stopnum, String stopname, String stoptime, String stopdetail) {
		super();
		this.linenum = linenum;
		this.stopnum = stopnum;
		this.stopname = stopname;
		this.stoptime = stoptime;
		this.stopdetail = stopdetail;
	}

	public BusStopInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BusLineInfo [linenum=" + linenum + ", stopnum=" + stopnum + ", stopname=" + stopname + ", stoptime="
				+ stoptime + ", stopdetail=" + stopdetail + "]";
	}

}
