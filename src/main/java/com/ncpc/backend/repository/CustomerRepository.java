package com.ncpc.backend.repository;


import com.ncpc.backend.dto.OrderResponse;
import com.ncpc.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   @Query("SELECT new com.ncpc.backend.dto.OrderResponse(c.name , p.name) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();




}
