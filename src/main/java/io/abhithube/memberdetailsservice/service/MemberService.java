package io.abhithube.memberdetailsservice.service;

import io.abhithube.memberdetailsservice.exception.CustomerNotFoundException;
import io.abhithube.memberdetailsservice.exception.MemberAlreadyExistsException;
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

    public Member saveMember(Member member) {
        String username = member.getUsername();
        String email = member.getEmail();

        if (memberRepository.existsByUsername(username))
            throw new MemberAlreadyExistsException("Username already exists");
        else if (memberRepository.existsByEmail(email))
            throw new MemberAlreadyExistsException("Email already exists");

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }
}
