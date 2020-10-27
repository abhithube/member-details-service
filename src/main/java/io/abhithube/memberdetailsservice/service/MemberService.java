package io.abhithube.memberdetailsservice.service;

import io.abhithube.memberdetailsservice.dto.RegisterRequest;
import io.abhithube.memberdetailsservice.exception.CustomerNotFoundException;
import io.abhithube.memberdetailsservice.exception.MemberNotFoundException;
import io.abhithube.memberdetailsservice.model.Member;
import io.abhithube.memberdetailsservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new MemberNotFoundException(username));
    }

    public Member getMemberByCustomerId(String customerId) {
        return memberRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public Member saveMember(RegisterRequest registerRequest) {
        Member member = new Member();
        member.setUsername(registerRequest.getUsername());
        member.setEmail(registerRequest.getEmail());

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }
}
