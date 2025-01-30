package com.products.domain.aggregate;


import com.products.domain.aggregate.values.Currencies;

public record Producto(Integer id, String name, double price, Currencies currency){
}

