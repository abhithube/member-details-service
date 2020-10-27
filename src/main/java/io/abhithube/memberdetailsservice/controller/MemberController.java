package io.abhithube.memberdetailsservice.controller;

import io.abhithube.memberdetailsservice.dto.RegisterRequest;
import io.abhithube.memberdetailsservice.model.Member;
import io.abhithube.memberdetailsservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Member> getMemberByUsername(@PathVariable String username) {
        return ResponseEntity.ok(memberService.getMemberByUsername(username));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Member> getMemberByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(memberService.getMemberByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(memberService.saveMember(registerRequest));
    }

    @PutMapping("/{username}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(member));
    }
}
