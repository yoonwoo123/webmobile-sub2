package com.ssafy.demo.service;

import java.util.List;

import com.ssafy.demo.dto.PostDTO;
import com.ssafy.demo.dto.PostPageDTO;
import com.ssafy.demo.dto.PostSimpleDTO;

public interface PostService {
	public int insert(PostDTO post);
	public PostDTO selectByPostNo(int postNo);
	public List<PostSimpleDTO> selectByKeyword(String keword);
	public List<PostSimpleDTO> selectAll();
	public PostPageDTO makePagePost(String keyword, String page, int per);
	public int increaseLikesByPostNo(int postNo);
	public int increaseViewsByPostNo(int postNo);
}
