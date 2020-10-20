package io.abhithube.memberdetailsservice.model;

import io.abhithube.memberdetailsservice.dto.Notification;
import io.abhithube.memberdetailsservice.dto.Payment;
import io.abhithube.memberdetailsservice.dto.Plan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "members")
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;

    private Plan plan;
    private long memberSince;
    private long nextPaymentDate;
    private List<Payment> payments = new ArrayList<>();

    private List<Notification> notifications = new ArrayList<>();

    private String customerId;
    private String subscriptionId;
}
