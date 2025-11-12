package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    private String orderId;

    @NotBlank private String customerId;
    @NotNull private LocalDate orderDate;
    @NotBlank private String shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @NotEmpty private List<OrderItem> orderItems;

    @Positive private Double totalAmount;
    private String status = "Processing";
}
