package com.tpe.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AllCommandController<T,S> {

    ResponseEntity<String> addNew(T t);
    ResponseEntity<List<S>> getAll();
    ResponseEntity<String> delete(String name);
}
