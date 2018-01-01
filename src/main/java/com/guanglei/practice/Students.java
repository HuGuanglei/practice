package com.guanglei.practice;

import java.util.ArrayList;

public class Students {
	
	private String name;
	private ArrayList<String> course=new ArrayList();
	private ArrayList<String> friend=new ArrayList();
	private ArrayList<String> secFriend=new ArrayList();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getSecFriend() {
		return secFriend;
	}
	public void setSecFriend(String secFriend) {
		this.secFriend.add(secFriend);
	}
	public ArrayList<String> getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course.add(course);
	}
	public ArrayList<String> getFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		this.friend.add(friend);
	}
	@Override
	public String toString() {
		return "Students [name=" + name + ", course=" + course + ", friend=" + friend + ", secFriend=" + secFriend
				+ "]";
	}	

}
