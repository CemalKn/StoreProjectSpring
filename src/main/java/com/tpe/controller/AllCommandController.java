package com.tpe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface AllCommandController<T,S> {

    ResponseEntity<String> addNew(T t);
    ResponseEntity<List<S>> getAll();
}
