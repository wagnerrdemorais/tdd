package com.morais.wagner.tdd.frete.controller;

import java.math.BigDecimal;

public interface IShippingService {

    BigDecimal checkLocationDeliveryFee(String postalCode);

}
