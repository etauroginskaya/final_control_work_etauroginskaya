package com.gmail.etauroginskaya.finalcontrolwork.service.impl;

import com.gmail.etauroginskaya.finalcontrolwork.repository.DiscountRepository;
import com.gmail.etauroginskaya.finalcontrolwork.repository.model.Discount;
import com.gmail.etauroginskaya.finalcontrolwork.service.DiscountService;
import com.gmail.etauroginskaya.finalcontrolwork.service.convertors.DiscountConverter;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.DiscountDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final DiscountConverter discountConverter;

    public DiscountServiceImpl(DiscountRepository discountRepository, DiscountConverter discountConverter) {
        this.discountRepository = discountRepository;
        this.discountConverter = discountConverter;
    }

    @Override
    @Transactional
    public List<DiscountDTO> getDiscounts() {
        return discountRepository.getAll().stream()
                .map(discountConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addDiscount(DiscountDTO cardDTO) {
        Discount card = discountConverter.toEntity(cardDTO);
        discountRepository.persist(card);
    }

    @Override
    @Transactional
    public DiscountDTO deleteDiscountById(Long id) {
        Discount card = discountRepository.getById(id);
        if (card == null) {
            return null;
        }
        discountRepository.remove(card);
        return discountConverter.toDTO(card);
    }
}