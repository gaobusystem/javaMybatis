package com.example.muser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.muser.entity.Area;
import com.example.muser.entity.UserUp;
import com.example.muser.form.UserRegistForm;
import com.example.muser.service.AreaService;
import com.example.muser.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserRegistController {

	private final UserService userService;
	private final AreaService areaService;

	/*--- 登録画面表示リクエスト ---*/
	@PostMapping("/user-show-regist")
	public String userShowRegist(
			@ModelAttribute UserRegistForm form,
			Model model) {

		// 地域リストを Model に設定
		List<Area> list = areaService.findAll();
		model.addAttribute("areaList", list);

		return "user-regist";
	}

	/*--- 登録リクエスト（登録画面より） ---*/
	@PostMapping("/user-regist")
	public String userRegist(
		@Validated @ModelAttribute UserRegistForm form,
		BindingResult result,
		Model model) {

		if (result.hasErrors()) {

			// 地域リストを Model に設定
			List<Area> list = areaService.findAll();
			model.addAttribute("areaList", list);

			return "user-regist";			// 入力がエラーの場合
		}

		// 地域名を form に設定 (Model内)
		Area area = areaService.findByCode(form.getAreaCode());
		form.setAreaName(area.getAreaName());

		return "user-confirm-regist";		// 入力が正常の場合
	}

	/*--- 登録リクエスト（登録確認画面より） ---*/
	@PostMapping("/user-confirm-regist")
	public String userConfirmRegist(
			@Validated @ModelAttribute UserRegistForm form,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes ) {

		if (result.hasErrors()) {

			// ステータスリストを Model に設定
			List<Area> list = areaService.findAll();
			model.addAttribute("areaList", list);

			return "user-regist";			// 入力がエラーの場合
		}

		UserUp userUp = new UserUp();
		userUp.setUserName(form.getUserName());
		userUp.setAreaCode(form.getAreaCode());
		userUp.setEmail(form.getEmail());

		userService.regist(userUp);
			
		redirectAttributes.addFlashAttribute("msg", "(ユーザ登録)");
			
		return "redirect:/user-complete";
	}

}
