package com.ivoovi.demo.controler;

import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.services.HardwareServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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



    @PostMapping("/new")

    public ResponseEntity<?> save(@Valid @RequestBody HardwareDTO hardwareDTO){
        try{
            return ResponseEntity.ok(hardwareServices.save(hardwareDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PutMapping("/hardware/{id}")
    public ResponseEntity<HardwareDTO> update(@PathVariable Long id, @Valid @RequestBody HardwareDTO updateHardwareDTO){
       if(hardwareServices.hardwareByIdExists(id)){
          hardwareServices.update(updateHardwareDTO,id);
          return ResponseEntity.ok(updateHardwareDTO);
       }
       else {
           return ResponseEntity.notFound().build();
       }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public ResponseEntity<?>  delete(@PathVariable Long id){

        if(hardwareServices.hardwareByIdExists(id)){
            boolean result = hardwareServices.deleteByID(id);
            if(result){
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
