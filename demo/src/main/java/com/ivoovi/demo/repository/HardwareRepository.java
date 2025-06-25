package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository extends JpaRepository<Hardware, Long> , JpaSpecificationExecutor<Hardware> {

   List< Hardware> findByName(String name);
    Optional<Hardware> findById(Long id);






}
