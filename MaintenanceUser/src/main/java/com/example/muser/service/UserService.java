package com.example.muser.service;

import java.util.List;

import com.example.muser.entity.User;
import com.example.muser.entity.UserCond;
import com.example.muser.entity.UserUp;

public interface UserService {

	// 一覧全件検索
	List<User> findListAll();

	// 登録
	void regist(UserUp userUp);

	// 一覧条件検索
	List<User> findListByConditions(UserCond cond);

}
