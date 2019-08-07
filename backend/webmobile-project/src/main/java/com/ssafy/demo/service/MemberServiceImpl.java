package com.ssafy.demo.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.demo.dto.MemberDTO;
import com.ssafy.demo.dto.MemberPageDTO;
import com.ssafy.demo.dto.PostPageDTO;
import com.ssafy.demo.dto.PostSimpleDTO;
import com.ssafy.demo.repository.MemberRepository;
import com.ssafy.util.AES256Util;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository repo;
	@Override
	public int insert(MemberDTO member) {
		member.setType("user");
		try {
			AES256Util aes = new AES256Util();
			member.setPassword(aes.encrypt(member.getPassword()));
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return repo.insert(member);
	}

	@Override
	public int update(MemberDTO member) {
		try {
			AES256Util aes = new AES256Util();
			member.setPassword(aes.encrypt(member.getPassword()));
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return repo.insert(member);
	}

	@Override
	public int deleteBySeq(int seq) {
		return repo.deleteBySeq(seq);
	}

	@Override
	public int deleteByEmail(String email) {
		return repo.deleteByEmail(email);
	}

	
	@Override
	public MemberDTO selectByEmail(String email) {
		return repo.selectByEmail(email);
	}

	@Override
	public List<MemberDTO> selectAll() {
		return repo.selectAll();
	}

	@Override
	public MemberDTO selectByEmailAndPassword(String email, String password) {
		AES256Util aes;
		try {
			aes = new AES256Util();
			password = aes.encrypt(password);
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return repo.selectByEmailAndPassword(email, password);
	}

	@Override
	public List<MemberDTO> searchByName(String name) {
		return repo.searchByName(name);
	}
	
	@Override
	public MemberPageDTO makePageMemberByEmail(String email, String page, int per) {
		MemberPageDTO mp = new MemberPageDTO();
		mp.setEmail(email);
		int totalBoardCount;
		int p=1;
		if (page != null && page.length() > 0) {
			p = Integer.parseInt(page);
		}
		System.out.println("//"+email+"//");
		if (email == "" || email == null || email.equals(" ")) {
			email = "%";
			System.out.println("email null: " + email);
			totalBoardCount = repo.selectAll().size();
		} else {
			email = "%"+email+"%";
			System.out.println("email not null: " + email);
			totalBoardCount = repo.searchByEmail(email).size();
		}
		
		int totalPageCount = totalBoardCount / per;
		if (totalBoardCount % per != 0)
			totalPageCount++;

		int startCol = (p - 1) * per;
		System.out.println(startCol +" / "+ per);
		List<MemberDTO> memberList = repo.pageListByEmail(email, startCol, per);

		int startPage = (p - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;
		if (endPage > totalPageCount) // 시작페이지에서 9씩 더하다가 총 페이지수 넘어가면 끝페이지를 총 페이지수로
			endPage = totalPageCount;
		mp.setMemberList(memberList);
		mp.setPage(p);
		mp.setStartPage(startPage);
		mp.setEndPage(endPage);
		mp.setTotalPage(totalPageCount);
		return mp;
	}
	
	
	@Override
	public List<MemberDTO> searchByEmail(String email) {
		return repo.searchByEmail(email);
	}

	
}
