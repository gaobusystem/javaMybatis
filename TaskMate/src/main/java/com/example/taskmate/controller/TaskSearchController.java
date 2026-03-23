package com.example.taskmate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskmate.entity.TaskSummary;
import com.example.taskmate.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskSearchController {
	
	private final TaskService taskService;

	/*--- 最初のリクエスト -------------------------------*/
	@GetMapping("/top")
	private String showListSelection() {
		// HTMLテンプレート名で return
		return "task-list";
	}

	/*--- 一覧検索リクエスト -------------------------------*/
	@PostMapping("/task-search-list")
	private String searchList(Model model) {
		// 一覧の全件検索
		List<TaskSummary> list = taskService.findListAll();
		
		// 結果を格納して HTMLテンプレート名で reutrn
		model.addAttribute("taskSummaryList", list);
		
		return "task-list";
	}

}
