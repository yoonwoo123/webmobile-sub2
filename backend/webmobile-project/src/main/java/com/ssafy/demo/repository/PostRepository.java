package com.ssafy.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.demo.dto.PostDTO;
import com.ssafy.demo.dto.PostSimpleDTO;

public interface PostRepository {
	public int insert(PostDTO post);
	public PostDTO selectByPostNo(int postNo);
	public List<PostSimpleDTO> selectByKeyword(String keyword);
	public List<PostSimpleDTO> pageList(@Param("keyword")String keyword, @Param("startCol")int startCol, @Param("count")int count);
	public List<PostSimpleDTO> selectAll();
	public int increaseLikesByPostNo(int postNo);
	public int increaseViewsByPostNo(int postNo);
}
