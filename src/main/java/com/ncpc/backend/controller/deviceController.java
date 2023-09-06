package com.ncpc.backend.controller;



import com.ncpc.backend.exception.ResourceNotFoundException;
import com.ncpc.backend.model.device;
import com.ncpc.backend.repository.DeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class deviceController {
    @Autowired
    private DeviceRepository deviceRepository;

    //get all memory
    @GetMapping("/device")
    public List<device> getAllMemory() {
        return deviceRepository.findAll();
    }

    //create memory rest api
    @PostMapping("/device")
    public device createVga(@RequestBody device device)
    {return deviceRepository.save(device);}

    //get motherboard by id rest api
    @GetMapping("device/{id}")
    public ResponseEntity<device> getMemoryByUd(@PathVariable Long id) {

        device device = deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("device not exist with id :" + id));
        return ResponseEntity.ok(device);
    }



    // update motherboard rest api
    @PutMapping("/device/{id}")
    public ResponseEntity<device> updateMemory(@PathVariable Long id, @RequestBody device memoryDetails) {

        device device= deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("device not exist with id :" + id));
        device.setName(memoryDetails.getName());
        device.setPrice(memoryDetails.getPrice());
        device.setDetails(memoryDetails.getDetails());
        device.setImageUrl(memoryDetails.getImageUrl());

        device updateDevice = deviceRepository.save(device);
        return ResponseEntity.ok(updateDevice);
    }

    // delete vga rest api
    @DeleteMapping("/device/{id}")
    public ResponseEntity<Map<String, Boolean>>deleteMemory(@PathVariable Long id){
        device device = deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("device not exist with id :" + id));

        deviceRepository.delete(device);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted" , Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
