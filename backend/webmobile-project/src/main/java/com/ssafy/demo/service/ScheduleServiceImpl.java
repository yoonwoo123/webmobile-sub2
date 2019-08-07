package com.ssafy.demo.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.demo.dto.DaysDTO;
import com.ssafy.demo.dto.RouteDTO;
import com.ssafy.demo.dto.ScheduleDTO;
import com.ssafy.demo.mapper.ScheduleMapper;
import com.ssafy.demo.repository.ScheduleRepositoryImpl;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleRepositoryImpl repo;
	
	public int insertSchedule(String s) {
		return repo.insertSchedule(s);
	}

	@Override
	public int updateSchedule(int scdNo, String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchedule(int scdNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public int insertSchedule(ScheduleDTO s) {
//		
//		//days Object to String
//		JSONObject js = new JSONObject();
//		JSONArray days = new JSONArray();
//		for(DaysDTO day : s.getDays()) {
//			JSONObject jDay = new JSONObject();
//			jDay.put("day", day.getDay());
//			
//			JSONArray jRoutes = new JSONArray();
//			for(RouteDTO r : day.getRoute()) {
//				JSONObject obj = new JSONObject();
//				obj.put("origin", r.getOrigin());
//				obj.put("destination", r.getDestination());
//				obj.put("travelMode", r.getTravelMode());
//				obj.put("start_time", r.getStart_time());
//				obj.put("end_time", r.getEnd_time());
//				obj.put("comment", r.getComment());
//				jRoutes.put(obj);
//			}
//			jDay.put("route", jRoutes);
//		}
//		js.put("days", days);
//		
//		System.out.println(js.toString());
//		
//		
//		return 1;
//	}
}
