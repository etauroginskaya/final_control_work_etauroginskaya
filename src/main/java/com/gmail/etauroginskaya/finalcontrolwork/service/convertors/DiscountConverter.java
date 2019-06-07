package com.gmail.etauroginskaya.finalcontrolwork.service.convertors;

import com.gmail.etauroginskaya.finalcontrolwork.repository.model.Discount;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.DiscountDTO;

public interface DiscountConverter {

    DiscountDTO toDTO(Discount discount);

    Discount toEntity(DiscountDTO discountDTO);
}
