package com.example.taskmate.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskmate.entity.TaskSummary;

@Controller
public class TaskSearchController {

	/*--- 最初のリクエスト -------------------------------*/
	@GetMapping("/top")
	private String showListSelection() {
		// HTMLテンプレート名で return
		return "task-list";
	}

	/*--- 一覧検索リクエスト -------------------------------*/
	@PostMapping("/task-search-list")
	private String searchList(Model model) {
		//**** （仮にデータ設定）****
		List<TaskSummary> list = new ArrayList<TaskSummary>();
		TaskSummary t = new TaskSummary();
		t.setTaskId(1);
		t.setTaskName("タスク１");
		t.setLimitDate(Date.valueOf("2024-12-20"));
		t.setStatusCode("00");
		list.add(t);
		t = new TaskSummary();
		t.setTaskId(2);
		t.setTaskName("タスク２");
		t.setLimitDate(Date.valueOf("2024-12-22"));
		t.setStatusCode("05");
		list.add(t);
		//****
		
		// 結果を格納して HTMLテンプレート名で reutrn
		model.addAttribute("taskSummaryList", list);
		
		return "task-list";
	}

}
