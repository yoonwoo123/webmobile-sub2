package com.ssafy.demo.dto;

public class PostSimpleDTO {
	private int postNo;
	private String title;
	private String description;
	private String createDate;
	private String name;
	private String thumbnail;
	public PostSimpleDTO(int postNo, String title, String description, String createDate, String name,
			String thumbnail) {
		this.postNo = postNo;
		this.title = title;
		this.description = description;
		this.createDate = createDate;
		this.name = name;
		this.thumbnail = thumbnail;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@Override
	public String toString() {
		return "PostSimpleDTO [postNo=" + postNo + ", title=" + title + ", description=" + description + ", createDate="
				+ createDate + ", name=" + name + ", thumbnail=" + thumbnail + "]";
	}
	
	
}
