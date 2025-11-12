package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repo;
    public OrderService(OrderRepository repo) { this.repo = repo; }

    public Order save(Order o) {
        if (repo.existsById(o.getOrderId())) throw new RuntimeException("Order ID exists");
        return repo.save(o);
    }
    public Order get(String id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found")); }
    public Order updateStatus(String id, String s) {
        Order o = get(id);
        if (!s.matches("(?i)Processing|Shipped|Delivered")) throw new RuntimeException("Invalid status");
        o.setStatus(s); return repo.save(o);
    }
    public void delete(String id) { if (!repo.existsById(id)) throw new RuntimeException("Not found"); repo.deleteById(id); }
}
