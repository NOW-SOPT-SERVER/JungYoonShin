package com.sopt.practice.controller;

import com.sopt.practice.global.ApiResponse;
import com.sopt.practice.global.ApiUtils;
import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberCreateRequest;
import com.sopt.practice.service.dto.MemberDetailResponse;
import com.sopt.practice.service.dto.MemberListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")  //v1은 버전관리할 때 이렇게 쓰곤 함
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createMember(
            @RequestBody MemberCreateRequest memberCreateDto
    ) {
        return ApiUtils.success(HttpStatus.CREATED, memberService.createMember(memberCreateDto));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<?>> findMemberById(@PathVariable("memberId") Long memberId) {
        return ApiUtils.success(HttpStatus.OK, memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiResponse<?>> deleteMemberById(@PathVariable("memberId") Long memberId) {
        memberService.deleteMemberById(memberId);
        return ApiUtils.success(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getMemberList() {
        memberService.getMemberList();
        return ApiUtils.success(HttpStatus.OK, memberService.getMemberList());
    }
}
