package kr.or.ksmart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.Dto.KmaListDto;
import kr.or.ksmart.MyService.MyService;

@Controller
public class MyController {
	
	@Autowired
	MyService myService;
	
	@GetMapping("/")
	public String index(Model model) {
		KmaListDto kmaListDto = myService.myService("5000000000");
		
		System.out.println(kmaListDto);
		model.addAttribute("kmaListDto", kmaListDto);
		
		return "index";
	}
	
	@RequestMapping(value = "/apiasdaadasddsadsadsadadsasadas", produces = "application/json")
	@ResponseBody
	public KmaListDto api(@RequestParam(name = "zone", required = false) String zone) {
		return myService.myService(zone);
	}
	
}
