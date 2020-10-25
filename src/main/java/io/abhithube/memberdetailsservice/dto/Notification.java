package io.abhithube.memberdetailsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Notification {
    private String id;
    private String title;
    private String description;
    private long createdAt;
}
