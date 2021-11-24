package com.epam.esm.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class CertificateDto {

    private long id;
    private String name;
    private String description;
    private long price;
    private int duration;
    private LocalDate createDate;
    private LocalDate lastUpdateDate;
    private List<TagDto> tags;


}
