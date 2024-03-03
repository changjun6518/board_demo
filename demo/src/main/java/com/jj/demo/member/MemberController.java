package com.jj.demo.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        MemberDto newMember = memberService.createMember(memberDto);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Long id) {
        MemberDto memberDto = memberService.getMemberById(id);
        return ResponseEntity.ok(memberDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        MemberDto updatedMember = memberService.updateMember(id, memberDto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
