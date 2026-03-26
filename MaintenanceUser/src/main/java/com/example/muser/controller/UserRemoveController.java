package com.example.muser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.muser.form.UserRemoveForm;
import com.example.muser.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserRemoveController {

	private final UserService userService;
	
	/*--- 削除リクエスト（一覧画面より） ---*/
	@PostMapping("/user-remove")
	public String remove(
			@ModelAttribute UserRemoveForm form) {

		// 削除確認画面に遷移する
		return "user-confirm-remove";
	}
	
	/*--- 削除リクエスト（削除確認画面より） ---*/
	@PostMapping("/user-confirm-remove")
	public String confirmRemove(
			@ModelAttribute UserRemoveForm form,
			RedirectAttributes redirectAttributes) {

		// 削除処理
		userService.remove(form.getUserId());

		// フラッシュスコープに完了メッセージを表示して リダイレクト
		redirectAttributes.addFlashAttribute("msg", "(ユーザ削除)");
		
		return "redirect:/user-complete";
	}

}
