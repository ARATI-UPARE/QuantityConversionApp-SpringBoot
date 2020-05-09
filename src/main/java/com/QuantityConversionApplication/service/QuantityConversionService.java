package com.QuantityConversionApplication.service;

import com.QuantityConversionApplication.enumeration.QuantityType;
import com.QuantityConversionApplication.enumeration.Unit;
import com.QuantityConversionApplication.model.ConversionDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuantityConversionService implements IQuantityConversionService{

    @Override
    public List<QuantityType> getQuantityList() {
        List<QuantityType> quantityTypes = new ArrayList<>();
        quantityTypes.add(QuantityType.LENGTH);
        quantityTypes.add(QuantityType.VOLUME);
        quantityTypes.add(QuantityType.MASS);
        quantityTypes.add(QuantityType.TEMPERATURE);
        return quantityTypes;
    }

    @Override
    public List<Unit> getUnitList(QuantityType quantityType) {
        List<Unit> units = new ArrayList<>();
        if(quantityType.equals(QuantityType.LENGTH)){
            units.add(Unit.CM);
            units.add(Unit.INCH);
            units.add(Unit.FEET);
            units.add(Unit.YARD);
        }
        if(quantityType.equals(QuantityType.MASS)){
            units.add(Unit.TONNE);
            units.add(Unit.GRAM);
            units.add(Unit.KG);
        }
        if(quantityType.equals(QuantityType.VOLUME)){
            units.add(Unit.LITRE);
            units.add(Unit.MILLILITRE);
            units.add(Unit.GALLON);
        }
        if(quantityType.equals(QuantityType.TEMPERATURE)){
            units.add(Unit.CELSIUS);
            units.add(Unit.FAHRENHEIT);
        }
        return units;
    }

    @Override
    public ConversionDto quantityConversion(ConversionDto conversion, Unit conversionUnit) {

        double value = conversion.value * conversion.quantityUnits.baseUnitConversion;
        double valueType = (value/conversionUnit.baseUnitConversion);
        return new ConversionDto(valueType, conversionUnit);

    }

}
