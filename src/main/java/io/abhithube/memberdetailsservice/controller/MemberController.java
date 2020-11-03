package io.abhithube.memberdetailsservice.controller;

import io.abhithube.memberdetailsservice.dto.RegisterRequest;
import io.abhithube.memberdetailsservice.model.Member;
import io.abhithube.memberdetailsservice.service.MemberService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/members", produces = "application/json")
@Api(tags = "Member Details Resource", description = "Defines the CRUD operations associated with a member's account")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{username}")
    @ApiOperation("Retrieves a member by username")
    public ResponseEntity<Member> getMemberByUsername(@ApiParam(value = "The username to query for",
            example = "athube") @PathVariable String username) {
        return ResponseEntity.ok(memberService.getMemberByUsername(username));
    }

    @GetMapping("/customer/{customerId}")
    @ApiOperation(value = "", hidden = true)
    public ResponseEntity<Member> getMemberByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(memberService.getMemberByCustomerId(customerId));
    }

    @PostMapping
    @ApiOperation("Persists a member")
    public ResponseEntity<Member> saveMember(@ApiParam("The member details needed to create an account")
            @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(memberService.saveMember(registerRequest));
    }

    @PutMapping("/{username}")
    @ApiOperation("Updates a member")
    public ResponseEntity<Member> updateMember(@ApiParam("The member to update")
            @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(member));
    }
}
