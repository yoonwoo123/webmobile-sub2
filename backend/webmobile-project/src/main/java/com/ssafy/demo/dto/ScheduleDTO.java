package com.ssafy.demo.dto;

import java.util.List;

public class ScheduleDTO {
	private String title;
	private String date;
	private List<DaysDTO> days;
	public ScheduleDTO(String title, String date, List<DaysDTO> days) {
		this.title = title;
		this.date = date;
		this.days = days;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<DaysDTO> getDays() {
		return days;
	}
	public void setDays(List<DaysDTO> days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "ScheduleDTO [title=" + title + ", date=" + date + ", days=" + days + "]";
	}

	
	
	
	
}
