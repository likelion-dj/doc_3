package com.ll.exam.doc_3.security;


import com.ll.exam.doc_3.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class AccountContext implements OAuth2User {
    private final Map<String, Object> attibutes;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String nameAttributeKey;

    private final Long id;

    public AccountContext(Member member, Map<String, Object> attibutes, Collection<? extends GrantedAuthority> authorities, String nameAttributeKey) {
        this.attibutes = attibutes;
        this.authorities = authorities;
        this.nameAttributeKey = nameAttributeKey;
        this.id = member.getId();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attibutes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return getAttribute(this.nameAttributeKey).toString();
    }
}
