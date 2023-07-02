package com.tpe.service;

import com.tpe.domain.Shoes;
import com.tpe.dto.shoe.NewShoesRequestDto;
import com.tpe.exception.ShoesAlreadyAdded;
import com.tpe.repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
