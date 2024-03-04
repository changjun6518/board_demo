package com.jj.demo.config.security;

import com.jj.demo.member.Member;
import com.jj.demo.member.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(username);
        Member member = memberRepository.findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (member.getNickname().equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        System.out.println("앙");
        System.out.println("member.getNickname() = " + member.getNickname());
        return new User(member.getNickname(), member.getPassword(), authorities);
    }
}