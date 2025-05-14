package com.Api.Livraria.dto;

import java.util.List;

public record SaleDto(Long employeeId, Long clientId, List <ItemSaleDto> itemsSale) {}
