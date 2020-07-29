package com.bsuir.vmsis.dto.impl;


import com.bsuir.vmsis.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDto extends BaseDto {
    private LocalDate year;
}
