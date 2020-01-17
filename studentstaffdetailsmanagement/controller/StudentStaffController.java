package org.deloitte.sms.studentstaffdetailsmanagement.controller;

import java.util.List;

import org.deloitte.sms.studentstaffdetailsmanagement.beans.StaffInfo;

//import java.util.List;

//import org.deloitte.sms.studentstaffdetailsmanagement.beans.StaffInfo;
import org.deloitte.sms.studentstaffdetailsmanagement.beans.StudentInfo;
import org.deloitte.sms.studentstaffdetailsmanagement.dao.StaffDao;
//import org.deloitte.sms.studentstaffdetailsmanagement.dao.StaffDao;
import org.deloitte.sms.studentstaffdetailsmanagement.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentStaffController {
	@Autowired
	StudentDao dao;
	@Autowired
	StaffDao dao1;
	
	
	
	@RequestMapping(value="/viewscreen",method=RequestMethod.GET)
	public String  showViewScreen(){
		return "ViewScreen";
		}
	
	
	//for displaying studentinfo table
	@RequestMapping(value="/viewstudent")
	public ModelAndView getStudent(){
		
		ModelAndView mav=new ModelAndView();
		List<StudentInfo> list=dao.getStudents();
		mav.addObject("student",list);
		mav.setViewName("ViewStudent");
		return mav;	
		
	}
	//for updating studnet details
	@RequestMapping(value="/studentupdate",method=RequestMethod.GET)
	public ModelAndView showUpdateStudentForm(@RequestParam("code")String code){
		StudentInfo std=dao.getStudents(code); 
		ModelAndView mav=new ModelAndView();
		mav.addObject("std",std);
		mav.setViewName("UpdateStudent");
		return mav;
	}
	@RequestMapping(value="/studentupdate",method=RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam("student_Id")String student_Id,@RequestParam("address")String address,@RequestParam("contact_No")long contact_No,@RequestParam("mail_Id")String mail_Id,@RequestParam("transport")char transport){
		System.out.println("hello");
		System.out.println(address);
		System.out.println(transport);
		System.out.println(contact_No);
		StudentInfo std=dao.getStudents(student_Id);
		std.setAddress(address);
		std.setContact_No(contact_No);
		std.setTransport(transport);
		System.out.println(std.getAddress());
		std.setMail_Id(mail_Id);
		System.out.println(mail_Id);//@ModelAttribute("studentInfo")StudentInfo std
		ModelAndView mav=new ModelAndView();
		dao.studentUpdate(std);
		System.out.println("heeeyyyy");
		//mav.setViewName("redirect:viewstudent");
		mav.setViewName("ViewScreen");
		return mav;
	}
	

	
	//--------------------staff-------------------------------------------------------------
	//for displaying staffinfo table
	@RequestMapping(value="/viewstaff")
	public ModelAndView getStaff(){
		
		ModelAndView mav=new ModelAndView();
		List<StaffInfo> list1=dao1.getStaffs();
		mav.addObject("staff",list1);
		mav.setViewName("ViewStaff");
		return mav;	
		
	}

	@RequestMapping(value="/staffupdate",method=RequestMethod.GET)
	public ModelAndView showUpdateStaffForm(String code){
		
		StaffInfo std=dao1.getStaff(code);
		ModelAndView mav=new ModelAndView();
		mav.addObject("stf",std);
		mav.setViewName("UpdateStaff");
		return mav;
	}
	
	
	@RequestMapping(value="/staffupdate",method=RequestMethod.POST)
	public ModelAndView updateStaff(@RequestParam("staff_Id")String staff_Id,@RequestParam("address")String address,@RequestParam("contact_Number")long contact_Number,@RequestParam("emailId")String emailId,@RequestParam("designation") String designation, 
			@RequestParam("experience")int experience,@RequestParam("country_Id")String country_Id)
	{
	
		StaffInfo stf=dao1.getStaff(staff_Id);
		stf.setAddress(address);
		stf.setContact_Number(contact_Number);
		stf.setCountry_Id(country_Id);
		stf.setDesignation(designation);
		stf.setEmailId(emailId);
		stf.setExperience(experience);
		
		
		
		ModelAndView mav=new ModelAndView();
		dao1.staffUpdate(stf);
		//System.out.println("heeeyyyy");
		//mav.setViewName("redirect:viewstudent");
		mav.setViewName("ViewScreen");
		return mav;
	}
	
	
}
