package com.ll.exam.doc_3.security;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class OAuth2Service extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId().toLowerCase();
        if ("kakao".equals(registrationId)) {
            LinkedHashMap properties = oAuth2User.getAttribute("properties");
            LinkedHashMap kakao_account = oAuth2User.getAttribute("kakao_account");

            // 이메일
            Boolean has_email = (Boolean) kakao_account.get("has_email");
            if (has_email) {
                String email = (String) kakao_account.get("email");
            }

            // 닉네임
            String nickname = (String) properties.get("nickname");
        }

        return null;
    }
}
