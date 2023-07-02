package com.tpe.controller;

import com.tpe.dto.shoe.AllShoesResponseDto;
import com.tpe.dto.shoe.NewShoesRequestDto;
import com.tpe.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoesController implements AllCommandController<NewShoesRequestDto, AllShoesResponseDto>{

    @Autowired
    private ShoesService shoesService;

    @Override
    @RequestMapping("/add")
    public ResponseEntity<String> addNew(@Valid @RequestBody NewShoesRequestDto newShoesRequestDto) {
        shoesService.addNewShoe(newShoesRequestDto);
        return ResponseEntity.ok("Shoe added");
    }

    @Override
    @RequestMapping("/all")
    public ResponseEntity<List<AllShoesResponseDto>> getAll() {
        List<AllShoesResponseDto> allShoesResponseDtos = shoesService.getAllShoes();
        return ResponseEntity.ok(allShoesResponseDtos);

    }

}
