package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	//フォーム画面にアクセス
	@GetMapping("/form")
	public String form(Model model) {
		
		if(!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm()); // モデルに追加
		}
		
		return "contactFormView";
	}
	
	//確認画面に遷移
	@PostMapping("/confirm")
	public String confirm(RedirectAttributes redirectAttributes,
			@Validated ContactForm form, BindingResult result) {
		//バリデーションエラーがあったら終了
		if(result.hasErrors()) {
			//フォームクラスをビューに渡す
			redirectAttributes.addFlashAttribute("contactForm", form);
			//バリデーション結果をビューに渡す
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
					+ Conventions.getVariableName(form),result);
			
			//お問い合わせ画面にリダイレクト
			return "redirect:/form";
			
		}else {
	        redirectAttributes.addFlashAttribute("contactForm", form); // 確認画面にデータを渡す
	        return "confirmView"; 
		}
	}
}
