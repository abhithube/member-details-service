package io.abhithube.memberdetailsservice.service;

import io.abhithube.memberdetailsservice.dto.RegisterRequest;
import io.abhithube.memberdetailsservice.exception.CustomerNotFoundException;
import io.abhithube.memberdetailsservice.exception.MemberNotFoundException;
import io.abhithube.memberdetailsservice.model.Member;
import io.abhithube.memberdetailsservice.repository.MemberRepository;
import io.abhithube.memberdetailsservice.util.KafkaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final KafkaClient kafkaClient;

    @Autowired
    public MemberService(MemberRepository memberRepository, KafkaClient kafkaClient) {
        this.memberRepository = memberRepository;
        this.kafkaClient = kafkaClient;
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
        Member in = new Member();
        in.setUsername(registerRequest.getUsername());
        in.setEmail(registerRequest.getEmail());

        Member out = memberRepository.save(in);
        kafkaClient.publish(out);

        return out;
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }
}
