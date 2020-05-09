package com.QuantityConversionApplication.service;

import com.QuantityConversionApplication.enumeration.QuantityType;
import com.QuantityConversionApplication.enumeration.Unit;
import com.QuantityConversionApplication.model.ConversionDto;

import java.util.List;

public interface IQuantityConversionService {
    List<QuantityType> getQuantityList();
    List<Unit> getUnitList(QuantityType quantityUnits);
    ConversionDto quantityConversion(ConversionDto conversion, Unit conversionUnit);
}
