package com.btec.api.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btec.dto.ClassDTO;
import com.btec.service.IClassService;

@RestController(value = "classAPIOfStaff")
public class ClassAPI {
	
	@Autowired
	private IClassService classService;
	
	@PostMapping("/api/class")
	public ClassDTO addNewClass(@RequestBody ClassDTO newclassDTO) {
		return classService.save(newclassDTO);
	}
	
	@PutMapping("/api/class")
	public ClassDTO editClass(@RequestBody ClassDTO editclassDTO) {
		return classService.save(editclassDTO);
	}
}
