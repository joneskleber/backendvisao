package com.project.visaoonline.service;

import com.project.visaoonline.exceptions.BusinessException;
import com.project.visaoonline.exceptions.NotFoundException;
import com.project.visaoonline.mapper.PartnerMapper;
import com.project.visaoonline.model.Partner;
import com.project.visaoonline.model.Stock;
import com.project.visaoonline.model.dto.PartnerDTO;
import com.project.visaoonline.model.dto.StockDTO;
import com.project.visaoonline.repository.PartnerRepository;
import com.project.visaoonline.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    public PartnerRepository repository;

    @Autowired
    public PartnerMapper mapper;

    @Transactional
    public PartnerDTO save(PartnerDTO dto) {
        Optional<Partner> optionalPartner = repository.findByNameAndDate(dto.getName(), dto.getDecade());
        if(optionalPartner.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Partner partner = mapper.toEntity(dto);
        repository.save(partner);
        return mapper.toDto(partner);
    }

    @Transactional
    public PartnerDTO update(PartnerDTO dto) {
        Optional<Partner> optionalPartner = repository.findByPartnerUpdate(dto.getName(), dto.getDecade(), dto.getId());
        if(optionalPartner.isPresent()){
            throw new BusinessException(MessageUtils.PARTNER_ALREADY_EXISTS);
        }

        Partner partner = mapper.toEntity(dto);
        repository.save(partner);
        return mapper.toDto(partner);
    }



    @Transactional
    public PartnerDTO delete(Long id) {
        PartnerDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional
    public List<PartnerDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }


    @Transactional
    public PartnerDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }


}
