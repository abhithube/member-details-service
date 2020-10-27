package io.abhithube.memberdetailsservice.controller;

import io.abhithube.memberdetailsservice.dto.RegisterRequest;
import io.abhithube.memberdetailsservice.model.Member;
import io.abhithube.memberdetailsservice.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberControllerTest {
    @InjectMocks
    private MemberController memberController;
    @Mock
    private MemberService memberService;

    @Test
    @DisplayName("it should retrieve a member by username")
    void getMemberByUsername() {
        // Arrange
        Member in = new Member();
        in.setUsername("name");

        when(memberService.getMemberByUsername(anyString()))
                .thenReturn(in);

        // Act
        ResponseEntity<Member> responseEntity = memberController.getMemberByUsername("test");

        // Assert
        Member out = responseEntity.getBody();

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertNotNull(out);
        assertEquals("name", out.getUsername());
    }


    @Test
    @DisplayName("it should retrieve a member by customer id")
    void getMemberByCustomerId1() {
        // Arrange
        Member in = new Member();
        in.setCustomerId("cust123");

        when(memberService.getMemberByCustomerId(anyString()))
                .thenReturn(in);

        // Act
        ResponseEntity<Member> responseEntity = memberController.getMemberByCustomerId("test");

        // Assert
        Member out = responseEntity.getBody();

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertNotNull(out);
        assertEquals("cust123", out.getCustomerId());
    }


    @Test
    @DisplayName("it should save a member")
    void saveMember() {
        // Arrange
        Member member = new Member();
        member.setUsername("name");

        when(memberService.saveMember(any(RegisterRequest.class)))
                .thenReturn(member);

        // Act
        ResponseEntity<Member> responseEntity = memberController.saveMember(new RegisterRequest());

        // Assert
        Member out = responseEntity.getBody();

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertNotNull(out);
        assertEquals("name", out.getUsername());
    }
}