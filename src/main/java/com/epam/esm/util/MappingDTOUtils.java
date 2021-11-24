package com.epam.esm.util;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.dto.TagDto;
import com.epam.esm.entity.Certificate;
import com.epam.esm.entity.Tag;

import java.util.ArrayList;
import java.util.List;

public class MappingDTOUtils {

    private MappingDTOUtils() {
    }

    public static CertificateDto mapToCertificateDto(Certificate certificate) {
        CertificateDto dto = new CertificateDto();

        dto.setId(certificate.getId());
        dto.setName(certificate.getName());
        dto.setDescription(certificate.getDescription());
        dto.setPrice(certificate.getPrice());
        dto.setDuration(certificate.getDuration());
        dto.setCreateDate(certificate.getCreateDate());
        dto.setLastUpdateDate(certificate.getLastUpdateDate());

        return dto;
    }

    public static Certificate mapToCertificate(CertificateDto dto) {
        Certificate certificate = new Certificate();

        certificate.setId(dto.getId());
        certificate.setName(dto.getName());
        certificate.setDescription(dto.getDescription());
        certificate.setPrice(dto.getPrice());
        certificate.setDuration(dto.getDuration());
        certificate.setCreateDate(dto.getCreateDate());
        certificate.setLastUpdateDate(dto.getLastUpdateDate());
        List<Tag> tags = MappingDTOUtils.mapToListTag(dto.getTags());
        certificate.setTags(tags);
        return certificate;
    }

    private static List<Tag> mapToListTag(List<TagDto> tagDTOS){
        List<Tag> tags = new ArrayList<>();
        for (TagDto tagDTO: tagDTOS) {
            Tag tag = new Tag();
            tag.setId(tagDTO.getId());
            tag.setName(tagDTO.getName());
            tags.add(tag);
        }
        return tags;
    }

    public static List<CertificateDto> mapToListCertificateDTO(List<Certificate> certificates){
        List<CertificateDto> certificateDTOS = new ArrayList<>();
        for(Certificate certificate: certificates){
            List<TagDto> tags = new ArrayList<>();
            CertificateDto certificateDTO = new CertificateDto();
            certificateDTO.setId(certificate.getId());
            certificateDTO.setName(certificate.getName());
            certificateDTO.setDescription(certificate.getDescription());
            certificateDTO.setPrice(certificate.getPrice());
            certificateDTO.setDuration(certificate.getDuration());
            certificateDTO.setCreateDate(certificate.getCreateDate());
            certificateDTO.setLastUpdateDate(certificate.getLastUpdateDate());
            for(Tag tag: certificate.getTags()){
                TagDto tag1 = new TagDto();
                tag1.setId(tag.getId());
                tag1.setName(tag.getName());
                tags.add(tag1);
            }
            certificateDTO.setTags(tags);
            certificateDTOS.add(certificateDTO);
        }
        return certificateDTOS;
    }

}
