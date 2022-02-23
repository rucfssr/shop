package com.perterworks.service

import com.perterworks.dto.ShopDto

interface ShopService {

  List<ShopDto> fetch()

  ShopDto fetchById(Long id)

  ShopDto addNew(ShopDto shopDto)

  ShopDto updateById(Long id, ShopDto shopDto)

  Boolean deleteById(Long id)

}