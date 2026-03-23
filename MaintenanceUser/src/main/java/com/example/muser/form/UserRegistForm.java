package com.example.muser.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistForm {

	@Size(min=1, max=32, message="1文字から32文字で指定してください。")
	private String userName;

	@Size(min=2, max=2, message="指定に誤りがあります。")
	private String areaCode;

	private String areaName;
	
	@Size(min=1, max=32, message="1文字から32文字で指定してください。")
    @Email(message = "メールアドレスの形式が無効です")
	private String email;

}
