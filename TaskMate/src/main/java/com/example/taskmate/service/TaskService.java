package com.example.taskmate.service;

import java.util.List;

import com.example.taskmate.entity.TaskSummary;

public interface TaskService {

	// 一覧全件検索
	List<TaskSummary> findListAll();

}
