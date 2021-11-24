package com.epam.esm.service;

import com.epam.esm.dto.CertificateDto;

import java.util.List;

public interface CertificateService {
    void addNewCertificate(CertificateDto certificate);
    CertificateDto getCertificateById(int certificateId);
    List<CertificateDto> getAllCertificates();
}
