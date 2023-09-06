package com.ncpc.backend.controller;

//import com.javatechie.jpa.dto.OrderRequest;
//import com.javatechie.jpa.dto.OrderResponse;
//import com.javatechie.jpa.entity.Customer;
//import com.javatechie.jpa.entity.Product;

import com.ncpc.backend.dto.OrderRequest;
import com.ncpc.backend.dto.OrderResponse;
import com.ncpc.backend.entity.Customer;









//import com.javatechie.jpa.exception.ResourceNotFoundException;
//import com.javatechie.jpa.repository.CustomerRepository;
//import com.javatechie.jpa.repository.ProductRepository;


import com.ncpc.backend.entity.Product;
import com.ncpc.backend.exception.ResourceNotFoundException;
import com.ncpc.backend.repository.CustomerRepository;
import com.ncpc.backend.repository.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;



    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());

    }

    @GetMapping("/product")
   public List<Product> product(){return productRepository.findAll();
   }

    @GetMapping("/findAllOrder")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/findSellsOrder")
    public List<Product> findConfirmedProducts() {
        List<Customer> customers = customerRepository.findAll();
        List<Product> confirmedProducts = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getStates().equals("confirme") && customer.getProducts() != null) {
                confirmedProducts.addAll(customer.getProducts());
            }
        }

        return confirmedProducts;
    }



    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }


 // get order by id
   @GetMapping("/getInfo/{id}")
   public ResponseEntity <Customer> findOrderById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("device not exist with id :" + id));
        return ResponseEntity.ok(customer);
    }




    @PutMapping("/updateOrderState/{id}")
    public ResponseEntity<Customer> updateOrderState(@PathVariable int id, @RequestBody Customer OrderStates) {
       Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(" order not exist with id :" + id));
       customer.setStates(OrderStates.getStates());

       Customer updateStates = customerRepository.save(customer);
        return ResponseEntity.ok(updateStates);
    }


}
