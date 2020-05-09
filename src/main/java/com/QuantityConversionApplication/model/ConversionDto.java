package com.QuantityConversionApplication.model;

import com.QuantityConversionApplication.enumeration.Unit;

public class ConversionDto {
    public Double value;
    public Unit quantityUnits;

    public ConversionDto(Double value, Unit quantityUnits) {
        this.value = value;
        this.quantityUnits = quantityUnits;
    }

}
