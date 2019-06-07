package com.gmail.etauroginskaya.finalcontrolwork.service.convertors.impl;

import com.gmail.etauroginskaya.finalcontrolwork.repository.model.Discount;
import com.gmail.etauroginskaya.finalcontrolwork.repository.model.User;
import com.gmail.etauroginskaya.finalcontrolwork.service.convertors.DiscountConverter;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.DiscountDTO;
import org.springframework.stereotype.Component;

@Component
public class DiscountConverterImpl implements DiscountConverter {

    @Override
    public DiscountDTO toDTO(Discount discount) {
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setId(discount.getId());
        discountDTO.setUserID(discount.getUser().getId());
        discountDTO.setTitle(discount.getTitle());
        discountDTO.setPercent(discount.getPercent());
        discountDTO.setExpirationDate(discount.getExpirationDate());
        return discountDTO;
    }

    @Override
    public Discount toEntity(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        discount.setTitle(discountDTO.getTitle());
        discount.setPercent(discountDTO.getPercent());
        discount.setExpirationDate(discountDTO.getExpirationDate());
        User user = new User();
        user.setId(discountDTO.getUserID());
        discount.setUser(user);
        return discount;
    }
}
