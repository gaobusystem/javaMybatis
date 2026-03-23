package com.example.muser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.muser.entity.User;
import com.example.muser.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserListController {

	private final UserService userService;
	
	/*--- 検索画面表示リクエスト ---*/
	@PostMapping("/user-show-list")
	private String userShowList() {

		// HTMLテンプレート名で return
		return "user-list";
	}
	
	/*--- 検索リクエスト ---*/
	@PostMapping("/user-search")
	private String userSearch(Model model) {

		// 一覧の全件検索
		List<User> list = userService.findListAll();

		// 結果を格納
		model.addAttribute("userList", list);

		// HTMLテンプレート名で return
		return "user-list";
	}

}
