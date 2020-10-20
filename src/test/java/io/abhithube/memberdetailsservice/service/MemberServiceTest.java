package io.abhithube.memberdetailsservice.service;

import io.abhithube.memberdetailsservice.exception.CustomerNotFoundException;
import io.abhithube.memberdetailsservice.exception.MemberAlreadyExistsException;
import io.abhithube.memberdetailsservice.exception.MemberNotFoundException;
import io.abhithube.memberdetailsservice.model.Member;
import io.abhithube.memberdetailsservice.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("it should retrieve a member by username")
    void getMemberByUsername1() {
        // Arrange
        Member m = new Member();
        m.setUsername("name");
        when(memberRepository.findByUsername(anyString()))
                .thenReturn(Optional.of(m));

        // Act
        Member member = memberService.getMemberByUsername("test");

        // Assert
        assertEquals("name", member.getUsername());
    }

    @Test
    @DisplayName("it should throw an exception if a member is not found")
    void getMemberByUsername2() {
        // Arrange
        when(memberRepository.findByUsername(anyString()))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(MemberNotFoundException.class, () -> memberService.getMemberByUsername("test"));
    }

    @Test
    @DisplayName("it should retrieve a member by customer id")
    void getMemberByCustomerId1() {
        // Arrange
        Member m = new Member();
        m.setCustomerId("cust123");
        when(memberRepository.findByCustomerId(anyString()))
                .thenReturn(Optional.of(m));

        // Act
        Member member = memberService.getMemberByCustomerId("test");

        // Assert
        assertEquals("cust123", member.getCustomerId());
    }

    @Test
    @DisplayName("it should throw an exception if a customer is not found")
    void getMemberByCustomerId2() {
        // Arrange
        when(memberRepository.findByCustomerId(anyString()))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CustomerNotFoundException.class, () -> memberService.getMemberByCustomerId("test"));
    }

    @Test
    @DisplayName("it should save a member")
    void saveMember1() {
        // Arrange;
        when(memberRepository.existsByUsername(anyString()))
                .thenReturn(false);
        when(memberRepository.existsByEmail(anyString()))
                .thenReturn(false);

        Member m = new Member();
        m.setUsername("name");
        m.setEmail("name@email.com");
        when(memberRepository.save(any(Member.class)))
                .thenReturn(m);

        // Act
        Member member = memberService.saveMember(m);

        // Assert
        assertEquals("name", member.getUsername());
    }

    @Test
    @DisplayName("it should throw an exception if a username is already taken")
    void saveMember2() {
        // Arrange
        when(memberRepository.existsByUsername(anyString()))
                .thenReturn(true);

        // Act & Assert
        Member member = new Member();
        member.setUsername("user");
        assertThrows(MemberAlreadyExistsException.class, () -> memberService.saveMember(member));
    }

    @Test
    @DisplayName("it should throw an exception if an email is already taken")
    void saveMember3() {
        // Arrange
        when(memberRepository.existsByEmail(anyString()))
                .thenReturn(true);

        // Act & Assert
        Member member = new Member();
        member.setEmail("name@email.com");
        assertThrows(MemberAlreadyExistsException.class, () -> memberService.saveMember(member));
    }

    @Test
    @DisplayName("it should update member")
    void updateMember() {
        // Arrange
        Member m = new Member();
        m.setUsername("name");
        when(memberRepository.save(any(Member.class)))
                .thenReturn(m);

        // Act
        Member member = memberService.updateMember(m);

        // Assert
        assertEquals("name", member.getUsername());
    }
}