package com.btec.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.btec.service.IClassService;
import com.btec.service.IMajorService;
import com.btec.service.ISubjectService;
import com.btec.service.IUserService;

@RestController(value = "accOfAdmin")
public class UserAPI {

	
	@Autowired 
	private IUserService userService;
	
	@Autowired
	private IMajorService majorService;
	
	@Autowired
	private ISubjectService subjectService;
	
	@Autowired
	private IClassService classService;
	

}
