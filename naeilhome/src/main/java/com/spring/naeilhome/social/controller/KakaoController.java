package com.spring.naeilhome.social.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.naeilhome.member.controller.MemberController;
import com.spring.naeilhome.member.domain.MemberDomain;
import com.spring.naeilhome.social.service.KakaoService;

@Controller("kakaoController")
@RequestMapping("/kakao")
public class KakaoController {
	
	@Autowired
	KakaoService kakaoService;
	@Autowired
	MemberDomain member;
	@Autowired
	MemberController memberController;
	
	@Value("${api.kakao.rest-key}")
	private String CLIENT_ID;
	
	@RequestMapping("/kakaoLogin.do")
	public String kakaoLogin() {
		StringBuffer loginUrl = new StringBuffer();
		loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
		loginUrl.append(CLIENT_ID); // REST API 키
//		loginUrl.append("&redirect_uri=https://naeilhome-jnbm.onrender.com/kakao/kakao_callback");
		loginUrl.append("&redirect_uri=https://naeilhome-jnbm.onrender.com/kakao/kakao_callback");
		loginUrl.append("&response_type=code");
		
		return "redirect:"+loginUrl.toString();
	}
	
	@GetMapping("/kakao_callback")
	public ModelAndView kakaoCallback(@RequestParam String code, HttpSession session) throws Exception{
		Map<String, Object> userInfo = new HashMap<>();
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("code : " + code);
		Map<String, String> tokens = kakaoService.getTokens(code);
		System.out.println("callback method kakaoAccessToken : " + tokens);
		String accessToken = tokens.get("access_token");
        String refreshToken = tokens.get("refresh_token");
        
        // 세션에 access token과 refresh token 저장
        session.setAttribute("accessToken", accessToken);
        session.setAttribute("refreshToken", refreshToken);
        
		userInfo = kakaoService.getUserInfo(accessToken);
		member.setMemberId((String)userInfo.get("memberId"));
		//member.setMemberNickname((String)userInfo.get("memberNickname"));
		member.setMemberEmail1((String)userInfo.get("email"));
		member.setMemberEmail2("kakaoSocial");
		
		mav.addObject("member", member);
		mav.addObject("resultMember", (boolean) userInfo.get("resultMember"));
		
		System.out.println("memberId : " + member.getMemberId());
		//System.out.println("memberNickname : " + member.getMemberNickname());
		System.out.println("email : " + member.getMemberEmail1());
		System.out.println("resultMember : " + (boolean) userInfo.get("resultMember"));
		// 조회한 멤버가 없으면 true 있으면 false
		
		if((boolean) userInfo.get("resultMember")) {
			mav.setViewName("/member/memberForm");
			
		} else {
			session.setAttribute("member", userInfo.get("m"));
//			session.setAttribute("token", kakaoAccessToken);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/member/kakaoLogin.do");			
		}
		
		System.out.println("mav.getView : " + mav.getViewName());
		
		return mav;
	}
	
	// 연동 해제
    @PostMapping("/memberDelete.do")
    public String unlinkKakaoAccount(@RequestParam("memberId") String memberId, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        
        // 세션에 저장된 accessToken과 refreshToken을 가져오기
        String accessToken = (String) session.getAttribute("accessToken");
        String refreshToken = (String) session.getAttribute("refreshToken");
        
        // accessToken이 없으면 refreshToken을 사용하여 새로운 accessToken을 발급받음
        if (accessToken == null || accessToken.isEmpty()) {
            if (refreshToken != null && !refreshToken.isEmpty()) {
                
                // refreshToken을 사용하여 새로운 accessToken 발급
                accessToken = kakaoService.getAccessTokenUsingRefreshToken(refreshToken);
                
                if (accessToken != null) {
                    // 새로운 accessToken을 세션에 저장
                    session.setAttribute("accessToken", accessToken);
                } else {
                	System.out.println("refreshToken을 사용한 accessToken 발급 실패");
                }
            } else {
            	System.out.println("accessToken과 refreshToken이 존재x");
            }
        }

        // 카카오 연동 해제 요청
        boolean unlinkSuccess = kakaoService.unlinkKakaoAccount(accessToken);

        if (unlinkSuccess) {
            System.out.println("카카오 연동 해제 성공");

            // 회원 탈퇴
            memberController.deleteMember(memberId, session);
            
            redirectAttributes.addFlashAttribute("socialMessage", "Kakao 연동 해제 및 탈퇴되었습니다.");
            return "redirect:/";
        } else {
            System.out.println("카카오 연동 해제 실패");
            return "redirect:/";
        }
    }
}

