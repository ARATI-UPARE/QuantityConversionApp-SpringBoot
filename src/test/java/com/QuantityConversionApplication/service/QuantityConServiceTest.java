package com.QuantityConversionApplication.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuantityConversionService.class)
public class QuantityConServiceTest {
    @Autowired
    IQuantityConversionService quantityConversionService;
    @Test
    public void whenQunatityConversion_requiredGetQuantity_shouldReturnQuantityTypes(){
        int size = quantityConversionService.getQuantityList().size();
        Assert.assertEquals(4,size);
    }
}
