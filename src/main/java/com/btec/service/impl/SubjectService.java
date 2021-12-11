package com.btec.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btec.entity.SubjectEntity;
import com.btec.repository.SubjectRepository;
import com.btec.service.ISubjectService;

@Service
public class SubjectService implements ISubjectService{

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public Map<Long, String> findAll() {
		Map<Long, String> result = new HashMap<>();
		List<SubjectEntity> entities = subjectRepository.findAll();
		for (SubjectEntity item: entities) {
			result.put(item.getSubjectId(), item.getSubjectName());
		}
		return result;
	}

}
