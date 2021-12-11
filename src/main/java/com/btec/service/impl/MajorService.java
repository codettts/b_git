package com.btec.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btec.entity.MajorEntity;
import com.btec.repository.MajorRepository;
import com.btec.service.IMajorService;


@Service
public class MajorService implements IMajorService {

	@Autowired
	private MajorRepository majorRepository;
	
	@Override
	public Map<Long, String> findAll() {
		Map<Long, String> result = new HashMap<>();
		List<MajorEntity> entities = majorRepository.findAll();
		for (MajorEntity item: entities) {
			result.put(item.getMajorId(), item.getMajorName());
		}
		return result;
	}

}
