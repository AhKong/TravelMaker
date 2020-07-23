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
import com.cafe24.travelMaker.domain.Notice;
import com.cafe24.travelMaker.domain.ReportType;
import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.ResReviewComments;
import com.cafe24.travelMaker.domain.ReviewLike;
import com.cafe24.travelMaker.domain.Si;
import com.cafe24.travelMaker.domain.SightsReview;
import com.cafe24.travelMaker.domain.SightsReviewComments;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.CommentsService;
import com.cafe24.travelMaker.service.LikeService;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.MsgService;
import com.cafe24.travelMaker.service.NoticeService;
import com.cafe24.travelMaker.service.ReportService;
import com.cafe24.travelMaker.service.ReviewService;
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
	@Autowired private CommentsService commentsService;
	@Autowired private NoticeService noticeService;
	@Autowired private ReportService reportService;
	@Autowired private ReviewService reviewService;
	
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
	
	@GetMapping("/noticeList")	
	public @ResponseBody HashMap<String,List<Notice>> noticeList(HttpSession session){
		HashMap<String,List<Notice>> noticeList = new HashMap<String,List<Notice>>();
		String targetId = (String) session.getAttribute("SID");
		System.out.println(noticeService.noticeList(targetId));
		noticeList.put("result", noticeService.noticeList(targetId));
		return noticeList;
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
	public  HashMap<String,String>likeResReview(ReviewLike reviewLike,@RequestParam(name="reviewWriter")String reviewWriter){
		System.out.println(reviewLike);
		likeService.likeResReview(reviewLike , reviewWriter);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessLike");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/unLikeSightsReview")
	@ResponseBody 
	public  HashMap<String,String>unLikeSightsReview(ReviewLike reviewLike){
		System.out.println(reviewLike);
		likeService.unLikeSightsReview(reviewLike);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessUnLike");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/likeSightsReview")
	@ResponseBody 
	public  HashMap<String,String>likeSightsReview(ReviewLike reviewLike,@RequestParam(name="reviewWriter")String reviewWriter){
		
		likeService.likeSightsReview(reviewLike,reviewWriter);
	
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessLike");
		return result;
	}
	
	@GetMapping("/unLikeResReview")
	@ResponseBody 
	public  HashMap<String,String>unLikeResReview(ReviewLike reviewLike){
		System.out.println(reviewLike);
		likeService.unLikeResReview(reviewLike);
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("result", "sucessUnLike");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/addResReivewComment")
	@ResponseBody 
	public  HashMap<String,List<ResReviewComments>>addResReviewComments(ResReviewComments resReviewComments,
																@RequestParam(name="reviewWirter") String reviewWirter){
		System.out.println(resReviewComments +"<---ㅋㅋㄹㅋ");
		HashMap<String,List<ResReviewComments>> result = new HashMap<String,List<ResReviewComments>>();
		int insertResult = commentsService.addResReviewComments(resReviewComments,reviewWirter);
		if(insertResult >0) {
			result.put("commentsList",commentsService.getResCommentsList(resReviewComments.getReviewNum()));
		}
		return result;
	}
	
	@GetMapping("/getResCommentsList")
	@ResponseBody 
	public HashMap<String,List<ResReviewComments>> getResCommentsList( @RequestParam(name="reviewNum") String resReviewNum){
		System.out.println("resReviewNum?"+resReviewNum);	
		HashMap<String,List<ResReviewComments>> result = new HashMap<String,List<ResReviewComments>>();
		result.put("commentsList",commentsService.getResCommentsList(resReviewNum));
		return result;
	}
	
	@GetMapping("/deleteResReivewComment")
	@ResponseBody 
	public HashMap<String,String> deleteResReivewComment( @RequestParam(name="commentsNum") String commentsNum){
		HashMap<String,String> result = new HashMap<String,String>();
		int deleteResult = commentsService.deleletResReviewComments(commentsNum);
		if(deleteResult>0) {
			result.put("result", "success");
		}
		return result;
	}
	
	@GetMapping("/addSightsReivewComments")
	@ResponseBody 
	public  HashMap<String,List<SightsReviewComments>>addSightsReivewComment(SightsReviewComments sightsReviewComments,
																@RequestParam(name="reviewWirter") String reviewWirter){
		System.out.println(sightsReviewComments +"ㅎㅇㅎㅇㅎㅇㅎㅇ");
		HashMap<String,List<SightsReviewComments>> result = new HashMap<String,List<SightsReviewComments>>();
		int insertResult = commentsService.addSightsReviewComments(sightsReviewComments,reviewWirter);
		if(insertResult >0) {
			result.put("commentsList",commentsService.getSightsCommentsList(sightsReviewComments.getReviewNum()));
		}
		return result;
	}
	
	@GetMapping("/getSightsCommentsList")
	@ResponseBody 
	public HashMap<String,List<SightsReviewComments>> getSightsCommentsList( @RequestParam(name="reviewNum") String sightsReviewNum){
		System.out.println("resReviewNum?"+sightsReviewNum);	
		HashMap<String,List<SightsReviewComments>> result = new HashMap<String,List<SightsReviewComments>>();
		result.put("commentsList",commentsService.getSightsCommentsList(sightsReviewNum));
		return result;
	}
	
	@GetMapping("/deleteSightsReivewComment")
	@ResponseBody 
	public HashMap<String,String> deleteSightsReivewComment( @RequestParam(name="commentsNum") String commentsNum){
		HashMap<String,String> result = new HashMap<String,String>();
		int deleteResult = commentsService.deleletSightsReviewComments(commentsNum);
		if(deleteResult>0) {
			result.put("result", "success");
		}
		return result;
	}
	
	@GetMapping("/getReadyForReport")
	@ResponseBody 
	public HashMap<String,List<ReportType>> getReadyForReport(@RequestParam(name="mId") String mId, 
															  @RequestParam(name="reviewNum") String reviewNum){
		HashMap<String,List<ReportType>> result = new HashMap<String,List<ReportType>>();
		int isReported = reportService.isReportedReview(mId, reviewNum);
		if(isReported >0) {
			result.put("result",null);
		} else {
			result.put("result",reportService.getReportType() );
		}
		return result;
	}
	
	@GetMapping("/getReportedResReview")
	@ResponseBody 
	public HashMap<String,ResReview> getReportedResReview(@RequestParam(name="reviewNum") String reviewNum) {
		HashMap<String,ResReview> result = new HashMap<String,ResReview>();
		result.put("result", reviewService.getResReviewInfo(reviewNum));		
		return result;
	}
	
	@GetMapping("/getReportedSightsReview")
	@ResponseBody 
	public HashMap<String,SightsReview> getReportedSightsReview(@RequestParam(name="reviewNum") String reviewNum){
		HashMap<String,SightsReview> result = new HashMap<String,SightsReview>();
		result.put("result", reviewService.getSightsReviewInfo(reviewNum));
		return result;
	}
}
