package com.ssafy.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.demo.dto.PostDTO;
import com.ssafy.demo.dto.PostPageDTO;
import com.ssafy.demo.dto.PostSimpleDTO;
import com.ssafy.demo.service.PostService;

import org.apache.commons.io.FilenameUtils;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService service;
	@RequestMapping(path = "/uploadImage", method = RequestMethod.POST)
	public String uploadImage(@RequestPart MultipartFile image) throws IOException {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String filename = "i"+df.format(date) + image.getOriginalFilename();
		System.out.println(filename);
		
		
		byte[] pData = image.getBytes();
//		int lByteArraySize = pData.length;
		File lOutFile = null;
		FileOutputStream lFileOutputStream = null;
		String url ="";
		try {
			lOutFile = new File("C:\\assets/"+filename);
			lFileOutputStream = new FileOutputStream(lOutFile);
			lFileOutputStream.write(pData);
			
		} catch (Throwable e) {
			e.printStackTrace(System.out);
		} finally {
			lFileOutputStream.close();
			url = "http://192.168.31.114:8399/assets/"+filename;
		}
		return url;
	}
	
	@PostMapping("uploadPost")
	public int uploadPost(@RequestBody PostDTO post) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		post.setCreateDate(df.format(date));
		System.out.println(post.toString());
		return service.insert(post);
	}
	
	
	@GetMapping("selectPage/{title}/{p}")
	public PostPageDTO selectPage(@PathVariable String p,@PathVariable String title){
		System.out.println("p:"+p);
		System.out.println("title:"+title);
		PostPageDTO pp = service.makePagePost(title,p,12);
		System.out.println(pp);
		return pp;
	}
	
	@GetMapping("select_sq/{postNo}")
	public PostDTO selectByPostNo(@PathVariable int postNo) {
		return service.selectByPostNo(postNo);
	}
	
	@GetMapping("detailPost/{postNo}")
	public PostDTO detailPost(@PathVariable int postNo) {
		service.increaseViewsByPostNo(postNo);
		return service.selectByPostNo(postNo);
	}
	
	@GetMapping("test")
	public String test() {
		return "test";
	}
}
