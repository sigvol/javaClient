package VC.client.bz.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VC.common.Course;
import VC.common.CourseMessage;
import VC.common.MessageType;

public class CourseSrvImpl extends ClientSrvImpl{
	
	public CourseSrvImpl() {
		super();
	}

	public List<Course> getAllCourse() throws IOException, ClassNotFoundException{
		
		List<Course> retCourselist = new ArrayList<Course>();
		String type = MessageType.CMD_GET_ALL_COURSE;
		CourseMessage sendmsg = new CourseMessage();
		sendmsg.setType(type);
		
		this.SendMessage(sendmsg);
		
		CourseMessage rcvmsg = new CourseMessage();
		rcvmsg = (CourseMessage) this.ReceiveMessage();
		retCourselist = rcvmsg.getCourselist();
		
		return retCourselist;
	}
	
	public void addCourse() {
		
	}
}
