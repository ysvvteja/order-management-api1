package com.example.demo.controller.repository;

import com.example.demo.controller.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {}
