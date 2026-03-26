package com.example.muser.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.muser.entity.User;
import com.example.muser.entity.UserCond;
import com.example.muser.entity.UserUp;

@Mapper
public interface UserRepository {

	// 一覧全件検索
	List<User> selectListAll();

	// 登録
	void insert(@Param("user") UserUp userUp);

	// 一覧条件検索
	List<User> selectListByConditions(@Param("cond") UserCond cond);

	// 更新
	void update(@Param("user") UserUp userUp);

	// 削除
	void delete(@Param("userId") Integer userId);
}
