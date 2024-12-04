package com.decskill.test.infrastructure.in.controller;

import com.decskill.test.application.usecases.PriceUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static com.decskill.test.utils.MockUtils.aPriceModel;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceUseCase priceUseCase;

    @Test
    void testQueryPrice() throws Exception {

        var priceModel = aPriceModel();

        when(priceUseCase.queryPrice(any(LocalDateTime.class), eq(priceModel.productId()), eq(priceModel.brandId())))
                .thenReturn(priceModel);

        mockMvc.perform(get("/api/v1/price")
                        .param("date", "2024-06-21T10:00:00")
                        .param("productId", priceModel.productId().toString())
                        .param("brandId", priceModel.brandId().toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(priceModel.productId()))
                .andExpect(jsonPath("$.brandId").value(priceModel.brandId()))
                .andExpect(jsonPath("$.priceList").value(priceModel.priceList()))
                .andExpect(jsonPath("$.price").value(priceModel.price()))
                .andExpect(jsonPath("$.currency").value(priceModel.currency()));
    }
}