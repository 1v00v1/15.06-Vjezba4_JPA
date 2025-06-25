package com.ivoovi.demo.services;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.repository.HardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServicesImpl implements HardwareServices{

private final HardwareRepository hardwareRepository;

    public HardwareServicesImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }


    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(HardwareDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByICode(String code) {
        return hardwareRepository.findByICode(code).map(HardwareDTO::new);
    }

    @Override
    public Optional<HardwareDTO> save(HardwareDTO hardwareDTO) {
        return hardwareRepository.save(new Hardware(hardwareDTO)).map(HardwareDTO::new);
    }

    @Override
    public Optional<HardwareDTO> update(String code, HardwareDTO updateHardwareDTO) {
        return hardwareRepository.update(code, new Hardware(updateHardwareDTO)).map(HardwareDTO::new);
    }

    @Override
    public void deleteByCode(String code) {
        hardwareRepository.deleteByCode(code);
    }
}
