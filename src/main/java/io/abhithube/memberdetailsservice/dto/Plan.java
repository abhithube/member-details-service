package io.abhithube.memberdetailsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Plan {
    private String id;
    private String name;
    private double cost;
    private double deductible;

    private String productId;
    private String priceId;
}
