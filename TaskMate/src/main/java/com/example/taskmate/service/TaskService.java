package com.example.taskmate.service;

import java.util.List;

import com.example.taskmate.entity.Task;
import com.example.taskmate.entity.TaskSummary;

public interface TaskService {

	// 一覧全件検索
	List<TaskSummary> findListAll();
	
	// 登録
	void regist(Task task);

}
