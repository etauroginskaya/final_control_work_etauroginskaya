package com.gmail.etauroginskaya.finalcontrolwork.service;

import com.gmail.etauroginskaya.finalcontrolwork.service.model.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> getDiscounts();

    void addDiscount(DiscountDTO discountDTO);

    DiscountDTO deleteDiscountById(Long id);
}
