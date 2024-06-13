package models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cart {
    private List<Product> products;
    private String subTotal;
    private  String coupon;
    private String couponDiscount;
    private String shipping;
    private String total;
    private ShippingMethod shippingMethod;
    private String taxes;
}
