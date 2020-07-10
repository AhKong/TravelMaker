package com.cafe24.travelMaker.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Message;
import com.cafe24.travelMaker.domain.ReviewLike;
import com.cafe24.travelMaker.domain.Si;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.LikeService;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.MsgService;
import com.cafe24.travelMaker.service.SightsService;

/*ajax 컨트롤러*/
@Controller
@RequestMapping("/ajax")
public class AjaxControllerKAR {

	@Autowired private  MailService mailService;
	@Autowired private  CertSerivce certService;
	@Autowired private MemberService memberService;
	@Autowired private MsgService msgService;
	@Autowired private SightsService sightsService;
	@Autowired private LikeService likeService;
	
	@GetMapping("/certEmail")
	@ResponseBody
	public HashMap<String,String> certEmail(@RequestParam(name="email" ) String email){
		/* 이메일 인증 */
		System.out.println("email>>>>"+email);
		HashMap<String, String> certEmailResult = new HashMap<String,String>();
		HashMap<String, Object> certEmail = certService.certEmail(email); // 보낼 메일 생성, 랜덤코드 생성 
		mailService.sendMail((Mail)certEmail.get("mail"));//메일 보내기 
		certEmailResult.put("randomCode", (String)certEmail.get("randomCode"));
		return certEmailResult;
	}
	
   /*
    * 아이디 중복검사
    * */
	@PostMapping("/idCheck")
	public @ResponseBody HashMap<String,String> idCheck(@RequestParam(name="mId") String mId ){
		System.out.println(mId);
		
		HashMap<String, String> idCheckResult = new HashMap<String,String>();

		if(memberService.mIdCheck(mId)==0) {
			idCheckResult.put("result", "N");
		} else {
			idCheckResult.put("result", "Y");
		}
		return idCheckResult;
	}
	
	@GetMapping("/unReadMsgList")	
	public @ResponseBody HashMap<String,List<Message>> unReadMsgList(HttpSession session){

		HashMap<String,List<Message>> unReadMsgList = new HashMap<String,List<Message>>();
		String targetId = (String) session.getAttribute("SID");
		System.out.println(msgService.unReadMsgList(targetId));
		unReadMsgList.put("result", msgService.unReadMsgList(targetId));
		return unReadMsgList;
	}
	
	@GetMapping("/getSiList")
	@ResponseBody 
	public HashMap<String,List<Si>> getSiList(@RequestParam(name="num") String doNum) {
		System.out.println(doNum+"<----doNum");
		HashMap <String,List<Si>> result = new HashMap <String,List<Si>>();
		result.put("siList",sightsService.selectSi(doNum));
		return result;
		
	}
	
	@GetMapping("/likeResReview")
	@ResponseBody 
	public  HashMap<String,String>likeResReview(ReviewLike reviewLike){
		System.out.println(reviewLike);
		likeService.likeResReview(reviewLike);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessLike");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/unLikeSightsReview")
	@ResponseBody 
	public  HashMap<String,String>unLikeSightsReview(ReviewLike reviewLike){
		System.out.println(reviewLike);
		likeService.unLikeResReview(reviewLike);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessUnLike");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/likeSightsReview")
	@ResponseBody 
	public  HashMap<String,String>likeSightsReview(ReviewLike reviewLike){
		likeService.likeSightsReview(reviewLike);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessLike");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/unLikeResReview")
	@ResponseBody 
	public  HashMap<String,String>unLikeResReview(ReviewLike reviewLike){
		System.out.println(reviewLike);
		likeService.unLikeSightsReview(reviewLike);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessUnLike");
		System.out.println(result);
		return result;
	}
	
	
}
