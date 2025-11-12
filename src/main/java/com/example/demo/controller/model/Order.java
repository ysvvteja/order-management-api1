package com.example.demo.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;

    @NotBlank
    private String customerId;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @NotBlank
    private String shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    @Valid
    @NotNull
    private List<OrderItem> orderItems = new ArrayList<>();

    @Positive
    private Double totalAmount;

    private String status = "Processing";
}
