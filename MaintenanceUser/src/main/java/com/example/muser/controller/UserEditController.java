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
import com.example.muser.form.UserEditForm;
import com.example.muser.service.AreaService;
import com.example.muser.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserEditController {

	private final AreaService areaService;
	private final UserService userService;
	
	/*--- 編集画面表示リクエスト ---*/
	@PostMapping("/user-show-edit")
	public String showEdit(@ModelAttribute UserEditForm form,
			Model model) {
		
		// 地域リストを Model に設定
		List<Area> list = areaService.findAll();
		model.addAttribute("areaList", list);

		// 編集画面へ
		return "user-edit";
	}

	/*--- 編集リクエスト（編集画面より） ---*/
	@PostMapping("/user-edit")
	public String edit(
			@Validated @ModelAttribute UserEditForm form,
			BindingResult result,
			Model model) {

		// 入力エラーがある場合には タスク編集画面に戻す
		if (result.hasErrors()) {
			
			// 地域リストを Model に設定
			List<Area> list = areaService.findAll();
			model.addAttribute("areaList", list);

			return "user-edit";
		}
		
		// 地域名を form に設定 (Model内)
		Area area = areaService.findByCode(form.getAreaCode());
		form.setAreaName(area.getAreaName());

		// 正常な場合に 編集確認画面に遷移する
		return "user-confirm-edit";
	}
	
	/*--- 編集リクエスト（編集確認画面より） ---*/
	@PostMapping("/user-confirm-edit")
	public String confirmEdit(
			@Validated @ModelAttribute UserEditForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {

		// 入力エラーがある場合には タスク編集画面に戻す
		if (result.hasErrors()) {
			
			// 地域リストを Model に設定
			List<Area> list = areaService.findAll();
			model.addAttribute("areaList", list);

			return "user-edit";
		}

		// form -> entity へ
		UserUp userUp = new UserUp();
		userUp.setUserId(form.getUserId());
		userUp.setUserName(form.getUserName());
		userUp.setAreaCode(form.getAreaCode());
		userUp.setEmail(form.getEmail());
		
		// 更新処理
		userService.edit(userUp);

		// フラッシュスコープに完了メッセージを表示して リダイレクト
		redirectAttributes.addFlashAttribute("msg", "(ユーザ更新)");
		
		return "redirect:/user-complete";
	}

}
