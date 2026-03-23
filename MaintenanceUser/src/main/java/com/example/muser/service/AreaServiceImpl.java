package com.example.muser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.muser.entity.Area;
import com.example.muser.repository.AreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

	private final AreaRepository areaRepository;
	
	@Override
	public List<Area> findAll() {

		List<Area> list = areaRepository.selectAll();
		
		return list;
	}

	@Override
	public Area findByCode(String areaCode) {

		Area area = areaRepository.selectByCode(areaCode);
		
		return area;
	}

}
