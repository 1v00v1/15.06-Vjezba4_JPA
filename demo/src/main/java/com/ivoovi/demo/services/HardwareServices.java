package com.ivoovi.demo.services;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareServices {

    List<HardwareDTO> findAll();

    List<HardwareDTO> findById(Long id);

    HardwareDTO save(HardwareDTO hardwareDTO);

    Optional<HardwareDTO> update( HardwareDTO updateHardwareDTO,Long id);

    boolean deleteByID(Long id);
    boolean hardwareByIdExists(Long id);
}
