package com.example.muser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserCommonController {

	/*--- メニュー画面表示 ---*/
	@GetMapping("/user-top")
	private String userShowTop() {
		return "user-top";
	}

	/*--- 完了後のリダイレクト先 ---*/
	@GetMapping("/user-complete")
	private String userComplete() {
		return "user-complete";
	}

}
