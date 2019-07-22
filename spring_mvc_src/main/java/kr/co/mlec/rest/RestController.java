package kr.co.mlec.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mlec.form.MemberVO;

@RequestMapping("/ajax")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/restBody.do")
	public String restStringBody() {
		return "OK, 성공";
	}
	
	@RequestMapping("/restBody.json")
	public Map<String, String> restJsonBody() {
		
		Map<String, String> result = new HashMap<>();
		
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울시 서초구");
		
		return result;		
	}
	
	@RequestMapping("/restVOBody.json")	
	public MemberVO restJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	@RequestMapping("/restStringListBody.json")
	public List<String> restJsonStringListBody() {
		
		List<String> list = new ArrayList<>();
		
		for(int i = 1; i <= 4; i++) {
			list.add(String.valueOf(i));
		}
		
		return list;
	}
	
	@RequestMapping("/restVOListBody.json")	
	public List<MemberVO> restJsonVOListBody() {
		List<MemberVO> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPassword("1234");
			
			list.add(vo);
		}
		return list;
	}
}












