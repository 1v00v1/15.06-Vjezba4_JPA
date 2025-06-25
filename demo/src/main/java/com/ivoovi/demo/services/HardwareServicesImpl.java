package com.ivoovi.demo.services;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.repository.CategoryRepository;
import com.ivoovi.demo.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HardwareServicesImpl implements HardwareServices{

private final HardwareRepository hardwareRepository;
private final CategoryRepository categoryRepository;


    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<HardwareDTO> findById(Long id) {
        return hardwareRepository.findById(id).stream().map(this::mapToDTO).toList();
    }


    @Override
    public HardwareDTO save(HardwareDTO hardwareDTO) {
        return mapToDTO(hardwareRepository.save(mapToEntity(hardwareDTO)));
    }

    @Override
    public Optional<HardwareDTO> update( HardwareDTO updateHardwareDTO, Long id) {
       Optional<Hardware> hardwareToUpdate = hardwareRepository.findById(id);

       if(hardwareToUpdate.isPresent()){
           Hardware hardware = hardwareToUpdate.get();
           hardware.setName(updateHardwareDTO.getName());
           hardware.setCode(updateHardwareDTO.getCode());
           hardware.setStock(updateHardwareDTO.getStock());
           hardware.setPrice(updateHardwareDTO.getPrice());
           hardware.setType(categoryRepository.findByName(updateHardwareDTO.getType()));
           return Optional.of(mapToDTO(hardwareRepository.save(hardware)));
       }
       return Optional.empty();
    }

    @Override
    public boolean deleteByID(Long id) {
        if(hardwareRepository.existsById(id)){
            hardwareRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean hardwareByIdExists(Long id) {
        return hardwareRepository.existsById(id);
    }


    private HardwareDTO mapToDTO(Hardware hardware){
        HardwareDTO hardwareDTO = new HardwareDTO();

        hardwareDTO.setName(hardware.getName());
        hardwareDTO.setCode(hardware.getCode());
        hardwareDTO.setStock(hardware.getStock());
        hardwareDTO.setPrice(hardware.getPrice());
        hardwareDTO.setType(hardware.getType().getName());

        return  hardwareDTO;
    }

    private Hardware mapToEntity(HardwareDTO hardwareDTO){
        Hardware hardware = new Hardware();
        hardware.setName(hardwareDTO.getName());
        hardware.setCode(hardwareDTO.getCode());
        hardware.setStock(hardwareDTO.getStock());
        hardware.setPrice(hardwareDTO.getPrice());
        hardware.setType(categoryRepository.findByName(hardwareDTO.getType()));

        return  hardware;
    }
}
