package com.QuantityConversionApplication.controller;

import com.QuantityConversionApplication.enumeration.QuantityType;
import com.QuantityConversionApplication.enumeration.Unit;
import com.QuantityConversionApplication.model.ConversionDto;
import com.QuantityConversionApplication.service.IQuantityConversionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.QuantityConversionApplication.enumeration.QuantityType.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityConControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    IQuantityConversionService quantityConversionService;
    Gson gson = new Gson();


    @Test
    // TC: To Mock getQuantityList method
    public void whenQuantityConversion_requiredGetQuantityList_shouldReturns_quantityType()throws Exception {
        List<QuantityType> quantityTypes = Arrays.asList(values());
        when(quantityConversionService.getQuantityList()).thenReturn(quantityTypes);
        MvcResult mvcResult = mockMvc.perform(get("/getQuantity")
                              .contentType(MediaType.APPLICATION_JSON))
                              .andExpect(status().isOk())
                              .andReturn();
        String quantityList = mvcResult.getResponse().getContentAsString();
        List<QuantityType> quantityType = gson.fromJson(quantityList, new TypeToken<ArrayList<String>>(){}
                                              .getType());
        Assert.assertEquals(4,quantityType.size());
    }

    @Test
    // TC: To Mock getUnits method
    public void whenQuantityConversion_requiredGetUnits_shouldReturns_Units()throws Exception {
        List<Unit> units = Arrays.asList(Unit.values());
        when(quantityConversionService.getUnitList(LENGTH)).thenReturn(units);
        MvcResult mvcResult = mockMvc.perform(get("/quantity/LENGTH")
                                      .contentType(MediaType.APPLICATION_JSON))
                                      .andExpect(status().isOk())
                                      .andReturn();
        String unitList = mvcResult.getResponse().getContentAsString();
        List<Unit> units1 = gson.fromJson(unitList, new TypeToken<ArrayList<String>>() {}
                                .getType());
        Assert.assertEquals(12, units1.size());
    }

}
