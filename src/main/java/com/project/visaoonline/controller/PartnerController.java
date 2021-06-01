package com.project.visaoonline.controller;

import com.project.visaoonline.model.dto.PartnerDTO;
import com.project.visaoonline.model.dto.StockDTO;
import com.project.visaoonline.service.PartnerService;
import com.project.visaoonline.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/partner")
public class PartnerController {

    @Autowired
    private PartnerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartnerDTO> save(@Valid @RequestBody PartnerDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartnerDTO> update(@Valid @RequestBody PartnerDTO dto){

        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PartnerDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<PartnerDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartnerDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

   // @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
   // public ResponseEntity<List<PartnerDTO>> findByToday(){
   //     return ResponseEntity.ok(service.findByToday());
    //}


}
