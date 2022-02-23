package com.perterworks.service.impl


import com.perterworks.domain.Shop
import com.perterworks.dto.ShopDto
import com.perterworks.repository.ShopRepository
import com.perterworks.service.ShopService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.springframework.transaction.annotation.Transactional

@Slf4j
@Service
class ShopServiceImpl implements ShopService {

  @Autowired
  ShopRepository shopRepository

  @Override
  @Transactional(readOnly = true)
  List<ShopDto> fetch() {
    shopRepository.findAll().collect { shop ->
      ShopDto.convertToDto(shop)
    }
  }

  @Override
  @Transactional(readOnly = true)
  ShopDto fetchById(Long id) {
    Optional<Shop> shop = shopRepository.findById(id)
    if (shop.isPresent()) {
      return ShopDto.convertToDto(shop.get())
    }
  }

  @Override
  @Transactional(rollbackFor = Exception)
  ShopDto addNew(ShopDto shopDto) {
    Shop shop = ShopDto.convertToEntity(shopDto)
    Shop newShop = shopRepository.save(shop)
    ShopDto.convertToDto(newShop)
  }

  @Override
  @Transactional(rollbackFor = Exception)
  ShopDto updateById(Long id, ShopDto shopDto) {
    Shop shop = shopRepository.findById(id)?.get()
    shop?.with {
      name = shopDto.name
      cost = shopDto.cost
      available = shopDto.available
    }
    ShopDto.convertToDto(shopRepository.save(shop))
  }

  @Override
  Boolean deleteById(Long id) {
    if (shopRepository.existsById(id)) {
      shopRepository.deleteById(id)
      return true
    }
    return false
  }

}
