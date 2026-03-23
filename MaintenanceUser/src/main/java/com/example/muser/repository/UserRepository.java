package com.example.muser.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.muser.entity.User;

@Mapper
public interface UserRepository {

	// 一覧全件検索
	List<User> selectListAll();

}
