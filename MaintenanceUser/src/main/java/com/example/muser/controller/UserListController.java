package com.example.muser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.muser.entity.Area;
import com.example.muser.entity.User;
import com.example.muser.entity.UserCond;
import com.example.muser.form.UserSearchForm;
import com.example.muser.service.AreaService;
import com.example.muser.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserListController {

	private final UserService userService;
	private final AreaService areaService;
	
	/*--- 検索画面表示リクエスト ---*/
	@PostMapping("/user-show-list")
	private String userShowList(
			@ModelAttribute UserSearchForm form,
			Model model) {

		// 地域リストを Model に設定
		List<Area> list = areaService.findAll();
		model.addAttribute("areaList", list);

		// HTMLテンプレート名で return
		return "user-list";
	}
	
	/*--- 検索リクエスト ---*/
	@PostMapping("/user-search")
	private String userSearch(
			@ModelAttribute UserSearchForm form,
			Model model	) {

		//-- form (UserSearchForm) -> entity (UserCond) へ --
		UserCond cond = new UserCond();
		// userName設定
		if (!form.getUserName().equals("")) {
			cond.setUserName("%" + form.getUserName() + "%");
		}
		// areaCode設定
		if (!form.getAreaCode().equals("")) {
			cond.setAreaCode(form.getAreaCode());
		}

		// 一覧の条件検索
		List<User> list = userService.findListByConditions(cond);

		// 結果を格納
		model.addAttribute("userList", list);

		// 地域リストを Model に設定（次回検索用）
		List<Area> areaList = areaService.findAll();
		model.addAttribute("areaList", areaList);

		// HTMLテンプレート名で return
		return "user-list";
	}

}
