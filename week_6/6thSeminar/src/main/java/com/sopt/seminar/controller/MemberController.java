package com.sopt.seminar.controller;

import com.sopt.seminar.service.dto.UserJoinResponse;
import com.sopt.seminar.global.ApiResponse;
import com.sopt.seminar.global.ApiUtils;
import com.sopt.seminar.service.MemberService;
import com.sopt.seminar.service.dto.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")  //v1은 버전관리할 때 이렇게 쓰곤 함
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<UserJoinResponse> postMember(
            @RequestBody MemberCreateRequest memberCreate
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
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
