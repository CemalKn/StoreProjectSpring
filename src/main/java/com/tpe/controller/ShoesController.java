package com.tpe.controller;

import com.tpe.dto.shoe.AllShoesResponseDto;
import com.tpe.dto.shoe.NewShoesRequestDto;
import com.tpe.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoesController implements AllCommandController<NewShoesRequestDto, AllShoesResponseDto>{

    @Autowired
    private ShoesService shoesService;

    @Override
    @PostMapping("/add")
    public ResponseEntity<String> addNew(@Valid @RequestBody NewShoesRequestDto newShoesRequestDto) {
        shoesService.addNewShoe(newShoesRequestDto);
        return ResponseEntity.ok("Shoe added");
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<AllShoesResponseDto>> getAll() {
        List<AllShoesResponseDto> allShoesResponseDtos = shoesService.getAllShoes();
        return ResponseEntity.ok(allShoesResponseDtos);

    }

    @Override
    @DeleteMapping("/{name}")
    public ResponseEntity<String> delete(@PathVariable("name") String name) {
        String result = shoesService.delete(name);
        return ResponseEntity.ok(result);
    }

}
