package com.gmail.etauroginskaya.finalcontrolwork.controller;

import com.gmail.etauroginskaya.finalcontrolwork.service.DiscountService;
import com.gmail.etauroginskaya.finalcontrolwork.service.model.DiscountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNTS_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNT_ADD_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNT_URL;

@RestController
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping(API_DISCOUNTS_URL)
    public ResponseEntity<List<DiscountDTO>> getDiscounts() {
        return new ResponseEntity<>(discountService.getDiscounts(), HttpStatus.OK);
    }

    @PostMapping(API_DISCOUNT_ADD_URL)
    public ResponseEntity saveDiscount(@Valid @RequestBody DiscountDTO discountDTO,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        discountService.addDiscount(discountDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(API_DISCOUNT_URL)
    public ResponseEntity deleteDiscount(@PathVariable("id") Long id) {
        DiscountDTO discountDTO = discountService.deleteDiscountById(id);
        if (discountDTO == null) {
            return new ResponseEntity("Not found discount", HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity(discountDTO, HttpStatus.OK);
    }
}