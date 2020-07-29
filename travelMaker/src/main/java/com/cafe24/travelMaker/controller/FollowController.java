package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.travelMaker.domain.Follow;
import com.cafe24.travelMaker.service.FollowService;
import com.cafe24.travelMaker.service.NoticeService;

@Controller
@RequestMapping("/follow")
public class FollowController {
	@Autowired private FollowService followService;
	@Autowired private NoticeService noticeService;
	
	@GetMapping("/followers")
	public String followers(Model model, @RequestParam(name="followers", required=false) String followers, @RequestParam(name="memberId", required=false) String memberId){
		List<Follow> followList = followService.followers(followers);
		model.addAttribute("followList", followList);
		
		return "member/followers";
	}  
	
	@GetMapping("/following")
	public String following(Model model, @RequestParam(name="following", required=false) String following){
		List<Follow> followList = followService.following(following);
		model.addAttribute("followList", followList);
		return "member/following";
	}
	
	@GetMapping("/followInsert")
	public String followInsert(Follow follow, @RequestParam(name="memberId", required=false) String memberId, HttpSession session){
		String loginId = (String)session.getAttribute("SID");
		follow.setmId(loginId);
		follow.setTargetId(memberId);
		int result = followService.followInsert(follow);
		noticeService.followNotice(loginId, memberId);
		return "redirect:/member/myPage";
	}
	
	@GetMapping("/followDelete")
	public String followDelete(Follow follow, @RequestParam(name="memberId", required=false) String memberId, HttpSession session){
		String loginId = (String)session.getAttribute("SID");
		follow.setmId(loginId);
		follow.setTargetId(memberId);
		int result = followService.followDelete(follow);
		return "redirect:/member/myPage";
	}
	
	
}
