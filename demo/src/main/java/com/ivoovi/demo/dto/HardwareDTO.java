package com.ivoovi.demo.dto;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.domain.Type;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HardwareDTO {


    @NotBlank(message = "Name cannot be blank")
    @Size(max = 200 , message = "Name cannot be more than 200 characters")
    private String name;

    @NotNull(message = "Type must be set to CPU, GPU, MBO, RAM, STORAGE or OTHER")
    private String type;
    @NotBlank(message = "Code cannot be blank")
    @Size(min = 7 , max = 7, message = "Code must be 7 characters")
    private String code;

    @PositiveOrZero(message = "Stock must be greater than or equal to zero")
    @Max(value = 10000, message = "Stock cannot be more than 10000")
    private long stock;


    @PositiveOrZero(message = "Price must be greater than or equal to zero")
    @Digits(integer = 5, fraction = 2, message = "Price can't be higher than 99999")
    private BigDecimal price;




}
