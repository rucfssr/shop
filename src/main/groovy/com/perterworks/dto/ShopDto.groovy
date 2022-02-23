package com.perterworks.dto

import com.perterworks.domain.Shop
import com.perterworks.enumeration.Items

class ShopDto {

  Long id
  String name
  Double cost
  Items item
  Integer available

  static ShopDto convertToDto(Shop shop) {
    new ShopDto(
      id: shop.id,
      name: shop.name,
      cost: shop.cost,
            item: shop.item,
      available: shop.available
    )
  }

  static Shop convertToEntity(ShopDto shopDto) {
    new Shop(
      id: shopDto.id,
      name: shopDto.name,
      cost: shopDto.cost,
            item: shopDto.item,
      available: shopDto.available
    )
  }

}
