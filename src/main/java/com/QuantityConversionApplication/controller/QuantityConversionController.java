package com.QuantityConversionApplication.controller;

import com.QuantityConversionApplication.enumeration.QuantityType;
import com.QuantityConversionApplication.enumeration.Unit;
import com.QuantityConversionApplication.model.ConversionDto;
import com.QuantityConversionApplication.service.IQuantityConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class QuantityConversionController {
   @Autowired
   IQuantityConversionService quantityConversionService;
  @GetMapping("/quantity")
  public ResponseEntity quantityList(){

    return new ResponseEntity(quantityConversionService.getQuantityList(), HttpStatus.OK);
  }

  @GetMapping("/quantity/{quantityUnits}")
  public ResponseEntity unitList(@PathVariable QuantityType quantityUnits) {

    return new ResponseEntity(quantityConversionService.getUnitList(quantityUnits), HttpStatus.OK);
  }

  @PostMapping("quantity/conversion/{conversionUnit}")
    public ResponseEntity quantityConversion(@RequestBody ConversionDto conversion, @PathVariable Unit conversionUnit) {

    return new ResponseEntity(quantityConversionService.quantityConversion(conversion, conversionUnit), HttpStatus.OK);
  }
}
