package com.sopt.seminar.controller;

import com.sopt.seminar.common.dto.SuccessMessage;
import com.sopt.seminar.common.dto.SuccessStatusResponse;
import com.sopt.seminar.service.MemberService;
import com.sopt.seminar.service.dto.MemberCreateRequest;
import com.sopt.seminar.service.dto.MemberDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<SuccessStatusResponse> createMember(
            @RequestBody MemberCreateRequest memberCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessStatusResponse.of(
                        SuccessMessage.MEMBER_CREATE_SUCCESS,
                        memberService.createMember(memberCreateRequest))
                );
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<SuccessStatusResponse> findMemberById(@PathVariable Long memberId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(
                        SuccessMessage.MEMBER_FIND_SUCCESS,
                        memberService.findMemberById(memberId))
                );
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<SuccessStatusResponse> deleteMemberById(@PathVariable Long memberId){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(SuccessMessage.MEMBER_DELETE_SUCCESS));
    }

}