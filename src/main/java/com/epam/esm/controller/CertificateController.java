package com.epam.esm.controller;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.entity.Certificate;
import com.epam.esm.repository.CertificateRepository;
import com.epam.esm.service.impl.CertificateServiceImpl;
import com.epam.esm.util.MappingDTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateServiceImpl certificateService;
    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateController(CertificateServiceImpl certificateService, CertificateRepository certificateRepository) {
        this.certificateService = certificateService;
        this.certificateRepository = certificateRepository;
    }


    @GetMapping
    public List<CertificateDto> getAllCertificates(){
        List<Certificate> certificates = certificateRepository.findAll();
        return MappingDTOUtils.mapToListCertificateDTO(certificates);
    }

    @PostMapping("/add")
    public CertificateDto addNewCertificate(@RequestBody CertificateDto certificateDto){
        certificateService.addNewCertificate(certificateDto);

    }


}


