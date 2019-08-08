package com.ssafy.demo.repository;

public interface ScheduleRepository {
	public int insertSchedule(String s);
	public int updateSchedule(int scdNo, String s);
	public int deleteSchedule(int scdNo);
	
}
