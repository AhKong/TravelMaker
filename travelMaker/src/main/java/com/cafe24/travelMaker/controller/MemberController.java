package com.cafe24.travelMaker.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cafe24.travelMaker.domain.Goods;
import com.cafe24.travelMaker.domain.Mail;
import com.cafe24.travelMaker.domain.Member;
import com.cafe24.travelMaker.domain.MemberLogin;
import com.cafe24.travelMaker.domain.ResReview;
import com.cafe24.travelMaker.domain.SightsReview;
import com.cafe24.travelMaker.mapper.FollowMapper;
import com.cafe24.travelMaker.service.CertSerivce;
import com.cafe24.travelMaker.service.GoodsService;
import com.cafe24.travelMaker.service.MailService;
import com.cafe24.travelMaker.service.MemberService;
import com.cafe24.travelMaker.service.PointService;
import com.cafe24.travelMaker.service.ReviewService;
import com.cafe24.travelMaker.service.StorageService;

@Controller
@RequestMapping("/member")
public class MemberController{

	@Autowired MemberService memberService;
	@Autowired private StorageService storageService;
	@Autowired private PointService pointService;
	@Autowired private GoodsService goodsService;
	@Autowired private FollowMapper followMapper;
	@Autowired private ReviewService reviewService;
	@Autowired private  MailService mailService;
	@Autowired private  CertSerivce certService;
	
	@GetMapping("/myPage")
	public String myPage(Model model, HttpSession session, Member member, @RequestParam(name="memberId",required=false) String memberId) {
		String loginId = (String)session.getAttribute("SID");
		List<Goods> goodsList = goodsService.getMyBuyGoods(loginId);
		model.addAttribute("goodsList", goodsList);
		member = memberService.getMemberInfo(loginId);
		model.addAttribute("member", member);
		int followersNum = followMapper.followersNum(loginId);
		model.addAttribute("followersNum", followersNum);
		int followingNum = followMapper.followingNum(loginId);
		model.addAttribute("followingNum", followingNum);
		List<ResReview> followersResReviewList = reviewService.followersResReviewList(loginId);
		model.addAttribute("followersResReviewList", followersResReviewList);
		List<SightsReview> followersSightsReviewList = reviewService.followersSightsReviewList(loginId);
		model.addAttribute("followersSightsReviewList", followersSightsReviewList);
		return "/member/myPage";
	}
	
	@PostMapping("/myPage")
	public String myPage(Model model, Member member, @RequestParam(name="memberId",required=false) String memberId, HttpSession session) {
		String loginId = (String)session.getAttribute("SID");
		member = memberService.followersPage(memberId);
		model.addAttribute("member", member);
		int followersNum = followMapper.followersNum(memberId);
		model.addAttribute("followersNum", followersNum);
		int followingNum = followMapper.followingNum(memberId);
		model.addAttribute("followingNum", followingNum);
		List<ResReview> followersResReviewList = reviewService.followersResReviewList(memberId);
		model.addAttribute("followersResReviewList", followersResReviewList);
		List<SightsReview> followersSightsReviewList = reviewService.followersSightsReviewList(memberId);
		model.addAttribute("followersSightsReviewList", followersSightsReviewList);
		int followYesNoResult = followMapper.followYesNo(memberId, loginId);
		model.addAttribute("followYesNoResult", followYesNoResult);
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
	
	//회원정보 수정
	@PostMapping("/updateMember")
	public String updateMember(Member member) {
		System.out.println("(Post) updateMember MemberController 도착");
		String mId = member.getmId();
		Member m = memberService.getMemberInfo(mId);	//db 에서 조회한 회원정보
		member.setmAvatar(member.getFile().getOriginalFilename());
		System.out.println(mId+" <- mId");
		System.out.println(member+" <<<--- member updateMember 폼에서 넘어온 데이터");
		System.out.println(member.getmAvatar()+" <-- 변경 될 프로필 사진");
		System.out.println(m.getmAvatar()+" <-- db 에서 조회된 프로필 사진");
		if(m.getmAvatar().equals(member.getmAvatar()) || "".equals(member.getmAvatar()) ) {
			System.out.println("현재 프로필과 같은 사진입니다. ");
			int re1 = memberService.updateMember(member);
			System.out.println(re1+" <- 1이면 사진 변경 없이 회원정보수정 완료!");
		}
		if(m.getmAvatar() != member.getmAvatar() && !"".equals(member.getmAvatar())) {
			int re1 = memberService.updateMember(member);
			int re2 = memberService.deleteMAvatar(member.getmAvatar(), mId);
			int re3 = memberService.updateMAvatar(member.getmAvatar(), mId);
			storageService.delete(m.getmAvatar());
			storageService.store(member.getFile());
			System.out.println(re1+" <- 1이면 사진 변경 없이 회원정보수정 완료!");
			System.out.println(re2+" <- 1이면 프로필 사진 지우기 완료!");
			System.out.println(re3+" <- 1이면 프로필 사진 변경 완료!");
		}
		return "redirect:/member/myPage";
	}
	
	//회원정보 수정 화면
	@GetMapping("/updateMember")
	public String updateMember(Model model, HttpSession session) {
		System.out.println("(Get) updateMember MemberController 도착");
		String mId = (String) session.getAttribute("SID");
		Member beforeUpdateMember = memberService.beforeUpdateMember(mId);
		System.out.println(beforeUpdateMember+" <- beforeUpdateMember");
		model.addAttribute("beforeUpdateMember", beforeUpdateMember);
		
		return "member/updateMember";
	}

	//탈퇴회원 조회 - 관리자 페이지
	@GetMapping("/getDeleteMemberList")
	public String getDeleteMemberList(Model model) {
		System.out.println("getDeleteMemberList MemberController 도착");
		List<Member> getDeleteMemberList = memberService.getDeleteMemberList();
		System.out.println(getDeleteMemberList+" <- getDeleteMemberList");
		model.addAttribute("getDeleteMemberList", getDeleteMemberList);
		
		return "member/getDeleteMemberList";
	}
	
	//탈퇴
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session, Model model) {
		System.out.println("deleteMember MemberController 도착");
		String mId = (String) session.getAttribute("SID");
		int result = memberService.deleteMember(mId);
		System.out.println(result+" <- 1이면 탈퇴완료 ㅠㅠ 탈퇴하지 마세요");
		session.invalidate();	//세션종료. 로그아웃되면서 인덱스로 이동!
		
		return "redirect:/main";
	}
	
	//탈퇴 회유 시 최초1회 포인트 지급
	@GetMapping("/conciliateDeleteMember")
	public String conciliateDeleteMember(Member member) {
		
		return "member/myPage";
	}
	
	//휴면회원 관리
	@GetMapping("/dormantMember")
	public String dormantMember(Model model) {
		System.out.println("dormantMember MemberController 도착");
		List<Member> selectDormantMember = memberService.selectDormantMember();	/////수정해야함
		List<Member> getDormantMemberList = memberService.getDormantMemberList();
		model.addAttribute("getDormantMemberList", getDormantMemberList);
		
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
		    		if(result.getmLevel().equals("4")) {
		    			return "redirect:/member/restMemberCert?mId="+member.getmId();
		    		} else {	
		    			session.setAttribute("SID", result.getmId());
		    			session.setAttribute("SLEVEL",result.getmLevel());
		    			session.setAttribute("SNAME", result.getmName());
		    			session.setAttribute("SAVATAR", result.getmAvatar());
		    			MemberLogin memberLogin = new MemberLogin();
		    			memberLogin.setmId(member.getmId());
		    			memberService.addLoginLog(memberLogin);
		    			return "redirect:/main";
		    		}
				}
			}
			//redirect 할 때 값 유지할 수 있도록 해주는것!!! 
			redirectAttr.addFlashAttribute("message","등록된 정보가 없습니다.");
		}
		return "redirect:/member/login";
	}

	/*회원가입 페이지 */
	@GetMapping("/join")
	public String addMember() {
		
		return "member/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member,RedirectAttributes redirectAttr) {
		
		//System.out.println(result +"<----result");

		member.setmAvatar(member.getFile().getOriginalFilename());
		if(!"".equals(member.getmAvatar())) {
			storageService.store(member.getFile());
		}
		int result = memberService.addMember(member);
		if(result >0) {// 회원가입 성공
 			System.out.println(result +"<----ryesult");
 			
 			int pointAddResult = pointService.SavePointForJoin(member.getmId());
 			System.out.println(pointAddResult+"<----point 적립 성공!");
 			int pointResult = pointService.setPoint();
 			System.out.println(pointResult+"<----point insert 성공!");
 			redirectAttr.addFlashAttribute("message","TravelMaker의 회원이 되신것을 환영합니다!🥳");
 
		}
		return "redirect:/member/login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@GetMapping("/adminLogin")
	public String adminLogin(HttpSession session) {
		session.setAttribute("SID", "id002");
		session.setAttribute("SLEVEL","1");
		session.setAttribute("SNAME", "강민수");
		session.setAttribute("SAVATAR", "man.png");
		return "redirect:/main";
	}

	@GetMapping("/affLogin")
	public String affLogin(HttpSession session) {
		session.setAttribute("SID", "id005");
		session.setAttribute("SLEVEL","6");
		session.setAttribute("SNAME", "이승환");
		session.setAttribute("SAVATAR", "man.png");
		return "redirect:/main";
	}
	
	@GetMapping("/restMemberCert")
	public String restMemberCert(String mId,Model model) {
		String mEmail = memberService.getMemberInfo(mId).getmEmail();
		HashMap<String, Object> certEmail = certService.certEmail(mEmail); // 보낼 메일 생성, 랜덤코드 생성 
		mailService.sendMail((Mail)certEmail.get("mail"));//메일 보내기 
		model.addAttribute("email", memberService.getMemberInfo(mId).getmEmail());
		model.addAttribute("randomCode", (String)certEmail.get("randomCode"));
		model.addAttribute("mId", mId);
		return "/member/certRestMember";
	}
	
	@PostMapping("/certRestMember")
	public String restMemberCert(@RequestParam(name="mId") String mId,HttpSession session ) {
		System.out.println(mId +"<----mId");
		int updateResult = memberService.updateRestMember(mId);
		if(updateResult>0) {
			Member member = memberService.getMemberInfo(mId);
			session.setAttribute("SID", member.getmId());
			session.setAttribute("SLEVEL",member.getmLevel());
			session.setAttribute("SNAME", member.getmName());
			session.setAttribute("SAVATAR", member.getmAvatar());
			MemberLogin memberLogin = new MemberLogin();
			memberLogin.setmId(member.getmId());
			memberService.addLoginLog(memberLogin);
		}
		return "redirect:/main";
	}
}
