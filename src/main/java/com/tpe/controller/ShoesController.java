package com.tpe.controller;

import com.tpe.dto.shoe.NewShoesRequestDto;
import com.tpe.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shoes")
public class ShoesController {

    @Autowired
    private ShoesService shoesService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewShoe(@Valid @RequestBody NewShoesRequestDto newShoesRequestDto){
        shoesService.addNewShoe(newShoesRequestDto);
        return ResponseEntity.ok("Shoe added");
    }
}
