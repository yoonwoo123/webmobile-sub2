package com.ssafy.demo.dto;

import java.util.List;

public class DaysDTO {
	private int day;
	private List<RouteDTO> route;
	public DaysDTO(int day, List<RouteDTO> route) {
		this.day = day;
		this.route = route;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public List<RouteDTO> getRoute() {
		return route;
	}
	public void setRoute(List<RouteDTO> route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "DaysDTO [day=" + day + ", route=" + route + "]";
	}
	
	
	
}
