package com.project.visaoonline.mapper;

import com.project.visaoonline.model.Partner;
import com.project.visaoonline.model.dto.PartnerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartnerMapper {

    public Partner toEntity(PartnerDTO dto) {
        Partner partner = new Partner();
        partner.setId(dto.getId());
        partner.setDecade(dto.getDacade());
        partner.setName(dto.getName());
        partner.setRegion(dto.getRegion());
        partner.setTelephone(dto.getTelephone());
        partner.setMobile(dto.getMobile());
        partner.setEmail(dto.getEmail());
        partner.setTokenizer(dto.getTokenizer());
        partner.setStatesman(dto.getStatesman());
        return partner;
    }

    public PartnerDTO toDto(Partner partner) {
        PartnerDTO dto = new PartnerDTO();
        dto.setId(partner.getId());
        dto.setDacade(partner.getDecade());
        dto.setName(partner.getName());
        dto.setRegion(partner.getRegion());
        dto.setTelephone(partner.getTelephone());
        dto.setMobile(partner.getMobile());
        dto.setEmail(partner.getEmail());
        dto.setTokenizer(partner.getTokenizer());
        dto.setStatesman(partner.getStatesman());
        return dto;
    }

    public List<PartnerDTO> toDto(List<Partner> listPartner){
        return listPartner.stream().map(this::toDto).collect(Collectors.toList());
    }
}
