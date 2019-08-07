package com.ssafy.demo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.demo.mapper.ScheduleMapper;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{

	@Autowired
	private SqlSessionTemplate template;
	
	public int insertSchedule(String s) {
//		System.out.println("repository");
//		System.out.println(o.toString());
		ScheduleMapper mapper = template.getMapper(ScheduleMapper.class);
		return mapper.insertSchedule(s);
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
	
}
