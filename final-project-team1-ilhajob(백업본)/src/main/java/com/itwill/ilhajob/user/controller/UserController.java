package com.itwill.ilhajob.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.app.AppService;
import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.message.Message;
import com.itwill.ilhajob.message.MessageService;
import com.itwill.ilhajob.review.Review;
import com.itwill.ilhajob.review.ReviewService;
import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.UserService;
import com.itwill.ilhajob.user.exception.ExistedUserException;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.exception.UserNotFoundException;

/*
/user_main 
/user_write_form 
/user_write_action 
/user_login_form
/user_login_action 
/user_logout_action 
/user_view /user_modify_form
/user_modify_action 
/user_remove_action
*/
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//@Autowired
	//private MessageService messageService;
	
	@Autowired
	private ReviewService reviewService;
	

	@Autowired
	private AppService appService;


	/**************Local Exception Handler**************/
	@ExceptionHandler(Exception.class)
	public String user_excetpion_handler(Exception e) {
		return "user_error";
	}
	
	/*
	 * <<유저 정보>> my profile 유저정보 업데이트 폼
	 * 회원 로그인
	 * 회원 로그아웃
	 * 회원 정보 수정
	 * 회원 탈퇴
	 * 회원 정보 보기
	 * ++ 메시지 알림
	 */
	
	//메인 페이지
	@RequestMapping("/index")
	public String main() {
		return "index";
	}
	
	//회원 대시보드 보기
	@LoginCheck
	@RequestMapping("/candidate-dashboard")
	public String dashboard(HttpServletRequest request) throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		//System.out.println(">>>>>>>>"+sUserId);
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		String forwardPath = "candidate-dashboard";
		return forwardPath;
	}
	
	//회원 정보 보기
	@LoginCheck
	@RequestMapping("/candidate-dashboard-profile")
	public String user_profile(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath = "candidate-dashboard-profile";
		return forwardPath;
	}
	
	// 회원 정보수정 폼 ***템플릿 복사해서 수정 가능한 modify-form 만들어야 함****
	@LoginCheck
	@RequestMapping("/candidate-dashboard-profile-modify-form")
	public String modify_form(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath = "candidate-dashboard-profile-modify-form";
		return forwardPath;
	}
	
	// 회원 정보수정
	@LoginCheck
	@RequestMapping("/modify_action")
	public String modify_action(@ModelAttribute User user, HttpServletRequest request) throws Exception {
		String forwardPath = "";
		userService.update(user);
		forwardPath = "redirect:candidate-dashboard-profile";
		return forwardPath;
	}
	
	
	//회원 로그인 폼
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//회원 로그인 액션
	@PostMapping("/user_login_action")
	public String user_login_action(@ModelAttribute("fuser")User user,Model model,HttpSession session) throws Exception{
		String forwardPath = "";
		try {
			userService.login(user.getUserEmail(),user.getUserPassword());
			session.setAttribute("sUserId", user.getUserEmail());
			forwardPath = "redirect:index";
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath = "login";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2", e.getMessage());
			forwardPath = "login";
		}
		return forwardPath;
	}
	
	// 회원 로그아웃 액션
	@LoginCheck
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";
		request.getSession().invalidate();
		forwardPath = "redirect:index";
		return forwardPath;
	}
	

	// 회원 가입 폼
	@RequestMapping("/register")
	public String user_join() {
		String forwardPath = "";
		forwardPath = "register";
		return forwardPath;
	}
	
	// 회원 가입 액션
	@RequestMapping("/user_join_action")
	public String user_join_action(@ModelAttribute("fuser")User user,Model model) throws Exception {
		String forwardPath = "";
		try {
			userService.create(user);
			forwardPath = "redirect:login";
		}catch (ExistedUserException e) {
			model.addAttribute("msg",e.getMessage());
			forwardPath = "redirect:register";
		}
		return forwardPath;
	}

	//나의 지원현황

	
	// 회원 탈퇴
	@LoginCheck
	@RequestMapping("/delete-action")
	public String user_delete(HttpServletRequest request) throws Exception {
		String forwardPath="";
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		userService.remove(sUserId);
		request.getSession().invalidate();
		forwardPath = "redirect:index";
		return forwardPath;
	}
	
	
	//회원이 지원한 공고
	@LoginCheck
	@RequestMapping("/candidate-dashboard-applied-job")
	public String user_applied_job(HttpServletRequest request) throws Exception{
		String forwardPath="";
		request.getSession().setAttribute("sUserId", "test3@test.com");
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
 		User user = userService.findAppList(loginUser.getUserSeq());
		//System.out.println(user);
 		request.setAttribute("loginUser", user);
		forwardPath = "/candidate-dashboard-applied-job";
		return forwardPath;
	}
	
	//회원이 공고삭제하기
	@LoginCheck
	@RequestMapping(value = "/remove-applied-job")
	public String remove_applied_job(HttpServletRequest request, @RequestParam int appSeq) throws Exception{
		appService.deleteApp(appSeq);
		return "redirect:candidate-dashboard-applied-job";
	}
	/*
	// 회원 알림 전체보기
		@LoginCheck
		@RequestMapping("/candidate-dashboard-job-alerts")
		public String user_alerts(HttpServletRequest request,User user,Model model) throws Exception {
			String forwardPath="";
			String sUserId = (String)request.getSession().getAttribute("sUserId");
			User loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			List<Message> messageList = messageService.fineMessageOfUser(loginUser.getUserSeq());
			model.addAttribute("messageList",messageList);
			forwardPath = "candidate-dashboard-job-alerts";
			return forwardPath;
		}
		
		// 알림 삭제
		@LoginCheck
		@RequestMapping("/alerts-remove")
		public String user_alerts_remove(HttpServletRequest request,int messageSeq) throws Exception {
			String forwardPath="";
			messageService.removeMessageBySeq(messageSeq);
			forwardPath="redirect:candidate-dashboard-job-alerts";
			return forwardPath;
		}

	 */
	
	
	//리뷰 작성
	//corpSeq필요 -> delete할떄 appseq처럼 input hidden corpseq필요(redirect용)
	@RequestMapping("/review_write_action")
	public String review_write_action(@ModelAttribute Review review, @RequestParam("corpId") String corpId, Model model,HttpServletRequest request) throws Exception{
		request.getSession().setAttribute("sUserId", "test3@test.com");
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		review.setCorpId(corpId);
		review.setUserSeq(loginUser.getUserSeq());
		System.out.println(review);
		request.setAttribute("loginUser", loginUser);	
	    reviewService.insertReview(review);
		String forwardPath = "redirect:corp-detail?corpId="+corpId;
		return forwardPath;
		
	}

	/*//회원이 공고삭제하기
	@LoginCheck
	@RequestMapping(value = "/remove-applied-job")
	public String remove_applied_job(HttpServletRequest request, @RequestParam int appSeq) throws Exception{
		appService.deleteApp(appSeq);
		return "redirect:candidate-dashboard-applied-job";
	}*/
	
	@RequestMapping("/review_delete")
	public String review_delete(@ModelAttribute Review review, HttpServletRequest request, @RequestParam int reviewSeq,@RequestParam("corpId") String corpId) throws Exception{
		reviewService.deleteReview(reviewSeq);
		return "redirect:corp-detail?corpId="+corpId;
	}
	
	
	
	
	
	
	
	
	
	
	
	// my resume 이력서 작성 폼
	
	/*
	 * <<지원>> applied jobs 지원한 공고 목록
	 * 회사에 이력서 지원 하기
	 * 이력서 지원한 회사 목록 보기
	 * 지원취소
	 */
	
	/*
	 * 리뷰(기업에 대한 리뷰) -- > 템플릿 페이지 만들 필요 있음
	 * 리뷰 작성 , 삭제 , 수정 
	 */
}
