package com.ssafy.demo.service;

import java.util.List;

import com.ssafy.demo.dto.MemberDTO;
import com.ssafy.demo.dto.MemberPageDTO;
import com.ssafy.demo.dto.PostPageDTO;

public interface MemberService {
	public int insert(MemberDTO member);
	public int update(MemberDTO member);
	public int deleteBySeq(int seq);
	public int deleteByEmail(String email);
	public MemberDTO selectByEmail(String email);
	public List<MemberDTO> selectAll();
	public MemberDTO selectByEmailAndPassword(String email, String password);
	public List<MemberDTO> searchByName(String name);
	public List<MemberDTO> searchByEmail(String email);
	public MemberPageDTO makePageMemberByEmail(String email, String page, int per);
}
