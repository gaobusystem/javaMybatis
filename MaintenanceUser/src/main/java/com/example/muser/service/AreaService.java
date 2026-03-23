package com.example.muser.service;

import java.util.List;

import com.example.muser.entity.Area;

public interface AreaService {

	// 一覧全件取得
	List<Area> findAll();
	
	// １件取得
	Area findByCode(String areaCode);

}
