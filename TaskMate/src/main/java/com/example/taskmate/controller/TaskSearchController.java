package com.example.taskmate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.taskmate.entity.Status;
import com.example.taskmate.entity.TaskSummary;
import com.example.taskmate.form.TaskSearchListForm;
import com.example.taskmate.service.StatusService;
import com.example.taskmate.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskSearchController {
	
	private final TaskService taskService;
	private final StatusService statusService;

	/*--- 最初のリクエスト -------------------------------*/
	@GetMapping("/top")
	private String showListSelection(
			@ModelAttribute TaskSearchListForm form,
			Model model) {
		
		// ステータスリストを Model に設定
		List<Status> list = statusService.findAll();
		model.addAttribute("statusList", list);

		// HTMLテンプレート名で return
		return "task-list";
	}

	/*--- 一覧検索リクエスト -------------------------------*/
	@PostMapping("/task-search-list")
	private String searchList(
			@Validated @ModelAttribute TaskSearchListForm form,
			BindingResult result,
			Model model) {
		
		// form内容の表示
		System.out.println("---searchList---");
		System.out.println(form);
		
		// 全件検索ー＞条件検索に変更する
		
		// 一覧の全件検索
		List<TaskSummary> list = taskService.findListAll();
		
		// ステータスリストを Model に設定（次回検索用）
		List<Status> statusList = statusService.findAll();
		model.addAttribute("statusList", statusList);
		
		// 結果を格納して HTMLテンプレート名で reutrn
		model.addAttribute("taskSummaryList", list);
		
		return "task-list";
	}

}
