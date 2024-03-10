package com.jj.demo.config.auditing;

import com.jj.demo.config.security.CustomUserDetails;
import com.jj.demo.member.Member;
import com.jj.demo.member.MemberRepository;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<Member> {
    @Override
    public Optional<Member> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증 정보가 없거나, 인증되지 않은 상태라면 빈 값을 반환합니다.
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return Optional.empty();
        }
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        // 인증된 사용자의 이름(또는 사용자명)을 반환합니다.
        // 여기서는 인증된 사용자의 'username'을 사용하고 있습니다.
        // 실제 어플리케이션의 Security 설정에 따라 사용자 정보를 가져오는 방식은 달라질 수 있습니다.
        return Optional.ofNullable(customUserDetails.getMember());
    }
}
