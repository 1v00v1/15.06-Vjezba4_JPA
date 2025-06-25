package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;

import java.util.Optional;
import java.util.Set;

public interface HardwareRepository {

    Set<Hardware> findAll();

    Optional<Hardware> findByICode(String code);

    Optional<Hardware> save(Hardware hardware);

    Optional<Hardware> update(String code, Hardware updateHardware);

    void deleteByCode(String code);
}
