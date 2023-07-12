package com.tpe.service;

import com.tpe.domain.Shoes;
import com.tpe.dto.AllGoodsVariablesDto;
import com.tpe.dto.shoe.AllShoesResponseDto;
import com.tpe.dto.shoe.NewShoesRequestDto;
import com.tpe.exception.ShoesAlreadyAdded;
import com.tpe.repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoesService {

    @Autowired
    private ShoesRepository shoesRepository;
    public void addNewShoe(NewShoesRequestDto newShoesRequestDto) {
        Shoes shoes = new Shoes();
        shoes.setName(newShoesRequestDto.getName());
        shoes.setPrice(newShoesRequestDto.getPrice());
        boolean existByName = shoesRepository.existsByName(shoes.getName());
        if (existByName){
            throw new ShoesAlreadyAdded("Shoes already added");
        }
        shoesRepository.save(shoes);
    }

    public List<AllShoesResponseDto> getAllShoes() {
        List<Shoes> shoes = shoesRepository.findAll();
        List<AllShoesResponseDto> shoesDto = new ArrayList<>();
        int i = 0;
        shoes.forEach(t-> shoesDto.add(new AllShoesResponseDto(t.getName(),t.getPrice())));
        return shoesDto;
    }

    public String delete(String name) {
        Shoes shoes = shoesRepository.findByName(name);
        if (shoes==null){
            return "Shoe has been not found!";
        }else {
            shoesRepository.delete(shoes);
            return "Shoe Deleted";
        }
    }
}
