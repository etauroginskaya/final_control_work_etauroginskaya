package com.gmail.etauroginskaya.finalcontrolwork.repository.impl;

import com.gmail.etauroginskaya.finalcontrolwork.repository.DiscountRepository;
import com.gmail.etauroginskaya.finalcontrolwork.repository.model.Discount;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountRepositoryImpl extends GenericRepositoryImpl<Long, Discount> implements DiscountRepository {
}