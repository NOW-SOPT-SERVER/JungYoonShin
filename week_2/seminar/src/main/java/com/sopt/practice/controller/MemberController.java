package com.sopt.practice.controller;

import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberCreateDto;
import com.sopt.practice.service.dto.MemberFindDto;
import com.sopt.practice.service.dto.MemberListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")  //v1은 버전관리할 때 이렇게 쓰곤 함
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(
            @RequestBody MemberCreateDto memberCreateDto
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable("memberId") Long memberId) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<MemberListDto> getMemberList() {
        memberService.getMemberList();
        return ResponseEntity.ok(memberService.getMemberList());
    }

}
