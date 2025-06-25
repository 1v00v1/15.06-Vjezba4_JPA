package com.ivoovi.demo.services;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareServices {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByICode(String code);

    Optional<HardwareDTO> save(HardwareDTO hardwareDTO);

    Optional<HardwareDTO> update(String code, HardwareDTO updateHardwareDTO);

    void deleteByCode(String code);
}
