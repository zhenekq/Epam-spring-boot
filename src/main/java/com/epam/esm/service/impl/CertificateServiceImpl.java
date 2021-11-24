package com.epam.esm.service.impl;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.entity.Certificate;
import com.epam.esm.repository.CertificateRepository;
import com.epam.esm.repository.TagRepository;
import com.epam.esm.service.CertificateService;
import com.epam.esm.util.MappingDTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final TagRepository tagRepository;

    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository, TagRepository tagRepository) {
        this.certificateRepository = certificateRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void addNewCertificate(CertificateDto certificateDto) {
        Certificate certificate = MappingDTOUtils.mapToCertificate(certificateDto);
        CertificateDto certificateDTO = MappingDTOUtils.mapToCertificateDto(certificateRepository.save(certificate));
    }

    @Override
    public CertificateDto getCertificateById(int certificateId) {
        return null;
    }

    @Override
    public List<CertificateDto> getAllCertificates() {
        return null;
    }
}
