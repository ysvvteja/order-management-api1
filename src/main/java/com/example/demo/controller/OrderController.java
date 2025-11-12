package com.example.demo.controller;

import com.example.demo.controller.model.Order;
import com.example.demo.controller.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService s) { this.service = s; }

    @PostMapping public ResponseEntity<Order> create(@Valid @RequestBody Order o) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(o));
    }

    @GetMapping("/{id}") public ResponseEntity<Order> get(@PathVariable String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> update(@PathVariable String id, @RequestBody Map<String, String> r) {
        return ResponseEntity.ok(service.updateStatus(id, r.get("status")));
    }

    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id); return ResponseEntity.ok("Deleted");
    }
}
