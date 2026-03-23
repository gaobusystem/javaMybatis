package com.example.muser.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.muser.entity.Area;

@Mapper
public interface AreaRepository {

	// 全件検索
	List<Area> selectAll();

	// １件検索
	Area selectByCode(@Param("areaCode") String areaCode);

}
