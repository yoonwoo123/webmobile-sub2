package com.ssafy.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.demo.dto.MemberDTO;
import com.ssafy.demo.dto.MemberPageDTO;
import com.ssafy.demo.service.MemberService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping("selectAll")
	public List<MemberDTO> selectAll(){
		System.out.println("Members : selectAll");
		return service.selectAll();
	}
	
	@PostMapping("login/{email}/{password}")
	public MemberDTO login(@PathVariable String email, @PathVariable String password) {
		System.out.println(service.selectByEmailAndPassword(email, password));
		return service.selectByEmailAndPassword(email, password);
	}
	
	@PostMapping("insert")
	public int insert(@RequestBody MemberDTO member) {
		int result = service.insert(member);
		System.out.println("SignUp : "+ member.toString());
		return result;
	}
	
	@DeleteMapping("delete/{seq}")
	public int deleteBySeq(@PathVariable int seq) {
		System.out.println("delete : "+seq);
		return service.deleteBySeq(seq);
	}

	@GetMapping("search_name/{name}")
	public List<MemberDTO> searchByName(@PathVariable String name){
		return service.searchByName(name);
	}
	
	@GetMapping("search_email/{email}")
	public List<MemberDTO> searchByEmail(@PathVariable String email){
		return service.searchByEmail(email);
	}
	
	@GetMapping("searchPage_email/{email}/{page}")
	public MemberPageDTO searchPageByEmail(@PathVariable String email, @PathVariable String page) {
		return service.makePageMemberByEmail(email, page, 10);
	}
}
