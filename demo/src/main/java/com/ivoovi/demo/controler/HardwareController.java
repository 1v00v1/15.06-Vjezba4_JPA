package com.ivoovi.demo.controler;

import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.services.HardwareServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("hardware")
public class HardwareController {

    private final HardwareServices hardwareServices;

    public HardwareController(HardwareServices hardwareServices) {
        this.hardwareServices = hardwareServices;
    }

    @GetMapping
    public List<HardwareDTO> getAll(){
        return hardwareServices.findAll();
    }

    @GetMapping("{code}")
    public HardwareDTO getByCode(@PathVariable String code){
        return hardwareServices.findByICode(code).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"HARDWARE NOT FOUND BY THAT CODE")
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HardwareDTO save(@Valid @RequestBody HardwareDTO hardwareDTO){
        return hardwareServices.save(hardwareDTO).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT,"HARDWARE WITH THAT CODE ALREADY EXISTS")
        );
    }

    @PutMapping("{code}")
    public HardwareDTO update(@PathVariable String code, @Valid @RequestBody HardwareDTO updateHardwareDTO){
        return hardwareServices.update(code, updateHardwareDTO).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"HARDWARE NOT FOUND BY THAT CODE")
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{code}")
    public void delete(@PathVariable String code){
        hardwareServices.deleteByCode(code);
    }
}
