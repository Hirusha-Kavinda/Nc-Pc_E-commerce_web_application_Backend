package com.ncpc.backend.repository;


import com.ncpc.backend.model.device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository <device, Long> {
}
