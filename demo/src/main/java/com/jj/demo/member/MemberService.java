package com.jj.demo.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDto createMember(MemberDto memberDto) {
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        Member member = MemberMapper.INSTANCE.memberDtoToMember(memberDto);
        member = memberRepository.save(member);
        return MemberMapper.INSTANCE.memberToMemberDto(member);
    }

    public MemberDto getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return MemberMapper.INSTANCE.memberToMemberDto(member);
    }

    @Transactional
    public MemberDto updateMember(Long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow();
        // Update properties, excluding nulls if necessary
        MemberMapper.INSTANCE.update(member, memberDto);
        // More properties to update
        return MemberMapper.INSTANCE.memberToMemberDto(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
