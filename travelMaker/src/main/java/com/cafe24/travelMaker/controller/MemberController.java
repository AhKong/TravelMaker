package com.cafe24.travelMaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.mapper.FollowMapper;
import com.cafe24.travelMaker.service.GoodsService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.PointService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/member")
public class MemberController{

	@Autowired MemberService memberService;
	@Autowired private StorageService storageService;
	@Autowired private PointService pointService;
	@Autowired private GoodsService goodsService;
	@Autowired private FollowMapper followMapper;
	
	@GetMapping("/myPage")
	public String myPage(Model model, HttpSession session, Member member) {
		String loginId = (String)session.getAttribute("SID");
		List<Goods> goodsList = goodsService.getMyBuyGoods(loginId);
		model.addAttribute("goodsList", goodsList);
		member = memberService.getMemberInfo(loginId);
		model.addAttribute("member", member);
		int followersNum = followMapper.followersNum(loginId);
		model.addAttribute("followersNum", followersNum);
		int followingNum = followMapper.followingNum(loginId);
		model.addAttribute("followingNum", followingNum);
		return "/member/myPage";
	}
	
	//아이디 찾기
	@GetMapping("/memberFindId") 
	public String memberFindId(Member member) {
		 
		return "/member/memberFindId";
	}
	
	//비밀번호 찾기
	@GetMapping("/memberFindPw")
	public String memberFindPw(Member member) {
		
		return "/member/memberFindPw";
	}
	
	//탈퇴회원 관리
	@PostMapping("/deleteMember")
	public String deleteMember(Member member) {
		
		return "member/myPage";
	}
	
	//탈퇴회원 관리
	@GetMapping("/deleteMember")
	public String deleteMember(Model model) {
		
		return "member/deleteMember";
	}
	
	//회원정보수정
	@PostMapping("/updateMember")
	public String updateMember(Member member) {
		
		return "member/myPage";
	}
	
	//회원정보 수정
	@GetMapping("/updateMember")
	public String updateMember(Model model) {
		
		return "member/updateMember";
	}
	
	//휴면회원 관리
	@GetMapping("/dormantMember")
	public String dormantMember() {
		
		return "member/dormantMember";
	}

	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	/*일반회원 로그인*/
	@PostMapping("/login")	
	public String loginMember(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		if(member.getmId() != null &&  member.getmPw() != null && !"".equals(member.getmPw()) &&  !"".equals(member.getmId())) {
			Member result = memberService.memberLogin(member.getmId());
			if(result !=null) {
				if(member.getmPw().equals(result.getmPw())) {
					session.setAttribute("SID", result.getmId());
		    		session.setAttribute("SLEVEL",result.getmLevel());
		    		session.setAttribute("SNAME", result.getmName());	
		    		System.out.println(session.getAttribute("SID"));
		    		System.out.println(session.getAttribute("SLEVEL"));
		    		System.out.println(session.getAttribute("SNAME"));
		    		System.out.println(pointService.isMyPoint(member.getmId())+"<----내 포인트 ");
		    		return "redirect:/";
				}
			}
			//redirect 할 때 값 유지할 수 있도록 해주는것!!! 
			redirectAttr.addAttribute("message","등록된 정보가 없습니다.");
		}
		return "redirect:/login";
	}

	/*회원가입 페이지 */
	@GetMapping("/join")
	public String addMember() {
		
		return "member/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		//System.out.println(result +"<----result");

		member.setmAvatar(member.getFile().getOriginalFilename());
		if(!"".equals(member.getmAvatar())) {
			storageService.store(member.getFile());
		}
		int result = memberService.addMember(member);
		if(result >0) {// 회원가입 성공
 			System.out.println(result +"<----ryesult");
 			pointService.setSavePointForJoin(member.getmId());
 			int pointAddResult = pointService.savePoint();
 			System.out.println(pointAddResult+"<----point 적립 성공!");
 			int pointResult = pointService.setPoint();
 			System.out.println(pointResult+"<----point insert 성공!");
		}
		return "redirect:/member/login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/adminLogin")
	public String adminLogin(HttpSession session) {
		session.setAttribute("SID", "id002");
		session.setAttribute("SLEVEL","1");
		session.setAttribute("SNAME", "강민수");
		return "redirect:/";
	}

	@GetMapping("/affLogin")
	public String affLogin(HttpSession session) {
		session.setAttribute("SID", "id005");
		session.setAttribute("SLEVEL","6");
		session.setAttribute("SNAME", "이승환");
		return "redirect:/";
	}
}
