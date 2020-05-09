package com.QuantityConversionApplication.enumeration;

public enum Unit {
    // BaseUnit Inch For Length
    INCH(1.0,QuantityType.LENGTH),
    FEET(12.0,QuantityType.LENGTH),
    YARD(36.0,QuantityType.LENGTH),
    CM(0.4,QuantityType.LENGTH),

    // BaseUnit Litre For Volume
    MILLILITRE(0.001, QuantityType.VOLUME),
    LITRE(1.0, QuantityType.VOLUME),
    GALLON(3.78, QuantityType.VOLUME),

    // BaseUnit KG For Mass
    GRAM(0.001, QuantityType.MASS),
    KG(1, QuantityType.MASS),
    TONNE(1000, QuantityType.MASS),

    // BaseUnit Fahrenheit For Temperature
    FAHRENHEIT(1.0, QuantityType.TEMPERATURE),
    CELSIUS(2.12, QuantityType.TEMPERATURE);

    public double baseUnitConversion;
    public QuantityType quantityType;

    Unit(double baseUnitConversion, QuantityType quantityType) {
        this.baseUnitConversion = baseUnitConversion;
        this.quantityType = quantityType;
    }
}
