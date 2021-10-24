package com.wiktorkielar.backenddevelopertest.service;

import net.minidev.json.parser.ParseException;

import java.util.List;

public interface JsonConverter<T> {
    List<T> covertJSON(String httpEntity) throws ParseException;
}
