package com.tistory.offbyone.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tistory.offbyone.service.SawonService;
import com.tistory.offbyone.service.SawonVO;

@Controller
@SessionAttributes({"sawon","sawonDetail"})
public class SawonController {
	
	@Resource(name = "sawonService")
	private SawonService sawonService;

	private static final Logger logger = LoggerFactory.getLogger(SawonController.class);
	
	/**
	 * 입력폼에 @ModelAttribute 를 사용할때 빈 sawon 객체를 만들어 주기 위해서 사용한다.
	 * SessionAttributes 를 사용하지 않는다면 필요없다.
	 *  
	 * @return
	 */
	@ModelAttribute("sawon")
	public SawonVO setEmptySawon() {
		return new SawonVO();
	}
	
	/**
	 * 사원 리스트를 조회한다.
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sawon_list.do", method = RequestMethod.GET)
	public String sawonList(Model model, SessionStatus sessionStatus) throws Exception {

	    List<SawonVO> list = sawonService.selectSawonList();

	    logger.info(list.toString());

	    model.addAttribute("list", list);
	    sessionStatus.setComplete();

	    return "sawon_list";
	}
	
	/**
	 * 사원 상세정보를 조회한다.
	 * @param sabun
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sawon_detail.do", method = RequestMethod.GET)
	public String sawonDetail(String sabun, Model model) throws Exception {
		
		model.addAttribute("sawonDetail", sawonService.selectSawon(sabun));
		
		return "sawon_detail";
	}
	
	/**
	 * 사원 등록폼을 출력한다.
	 * @param model
	 * @return
	 */
/*	@RequestMapping(value = "/sawon_regform.do", method = RequestMethod.GET)
	public String sawonRegform(Model model) {
		model.addAttribute("sawon", new SawonVO());
		return "sawon_regform";
	}*/

	@RequestMapping(value = "/sawon_regform.do", method = RequestMethod.POST)
	public String sawonRegform(@ModelAttribute("sawon") SawonVO sawon, Model model) {
		return "sawon_regform";
	}
	
	/**
	 * 사원 등록폼 두 번째 페이지
	 * @param sawon
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sawon_regnextform.do", method = RequestMethod.POST)
	public String sawonRegnextform(@ModelAttribute("sawon") SawonVO sawon, Model model) {
		
		logger.info(sawon.toString());
		
		return "sawon_regnextform";
	}
	
	/**
	 * 사원을 등록한다.
	 * @param sawon
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sawon_register.do", method = RequestMethod.POST)
	public String sawonRegister(@ModelAttribute("sawon") SawonVO sawon, Model model, SessionStatus sessionStatus) throws Exception {
		
		logger.info(sawon.toString());
		
		// 입력한다.
		sawonService.register(sawon);
		
		// 세션에서 지운다.
		sessionStatus.setComplete();
		
		return "redirect:/sawon_list.do";
	}
	
	/**
	 * 사원 수정을 위한 폼을 출력한다.
	 * @param sawon
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sawon_updateform.do", method = RequestMethod.GET)
	public String sawonUpdateform(@ModelAttribute("sawonDetail") SawonVO sawon, Model model) throws Exception {
		
		// 상세보기에서 설정할 정보를 사용하고 있다.
		// 사번을 입력받에 조회하는 형식으로 사용할 수 도 있다.
		
		return "sawon_updateform";
	}
	
	/**
	 * 사원을 수정한다.
	 * @param sawon
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sawon_update.do", method = RequestMethod.POST)
	public String sawonUpdate(@ModelAttribute("sawonDetail") SawonVO sawon, Model model, SessionStatus sessionStatus) throws Exception {
		
		logger.info(sawon.toString());
		
		// 수정한다.
		sawonService.updateSawon(sawon);
		
		// 세션에서 지운다.
		sessionStatus.setComplete();
		
		return "redirect:/sawon_list.do";
	}
	
	/**
	 * 사원을 삭제한다.
	 * 
	 * @param sawonDetail
	 * @param model
	 * @param sessionStatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sawon_delete.do", method = RequestMethod.POST)
	public String sawonDelete(@ModelAttribute("sawonDetail") SawonVO sawon, Model model, SessionStatus sessionStatus) throws Exception {
		
		logger.info(sawon.toString());
		
		// 사원을 삭제한다.
		sawonService.deleteSawon(sawon);
		
		// 세션에서 지운다.
		sessionStatus.setComplete();
		
		return "redirect:/sawon_list.do";
	}
}
