package models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetails {
    private String orderId;
    private Cart cartSummary;
    private Customer customerDetails;
}
