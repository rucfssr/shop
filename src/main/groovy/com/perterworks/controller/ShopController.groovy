package com.perterworks.controller

import com.perterworks.dto.ShopDto
import com.perterworks.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shop")
class ShopController {

  @Autowired
  ShopService shopService

  @GetMapping
  @ResponseBody
  ResponseEntity<List<ShopDto>> fetch() {
    List<ShopDto> shops = shopService.fetch()
    shops
      ? new ResponseEntity<List<ShopDto>>(shops, HttpStatus.OK)
      : new ResponseEntity<List<ShopDto>>(HttpStatus.NO_CONTENT)
  }

  @GetMapping("/{id}")
  @ResponseBody
  ResponseEntity<ShopDto> fetchById(@PathVariable Long id) {
    ShopDto shop = shopService.fetchById(id)
    shop
      ? new ResponseEntity<ShopDto>(shop, HttpStatus.OK)
      : new ResponseEntity<ShopDto>(HttpStatus.NOT_FOUND)
  }

  @PostMapping
  @ResponseBody
  ResponseEntity<String> create(@RequestBody ShopDto shopDto) {
    ShopDto shop = shopService.addNew(shopDto)
    shop
      ? new ResponseEntity(shop, HttpStatus.OK)
      : new ResponseEntity(HttpStatus.BAD_REQUEST)
  }

  @PutMapping("/{id}")
  @ResponseBody
  ResponseEntity<ShopDto> updateById(@PathVariable Long id, @RequestBody ShopDto shopDto) {
    ShopDto shop = shopService.updateById(id, shopDto)
    shop
      ? new ResponseEntity(shop, HttpStatus.OK)
      : new ResponseEntity(HttpStatus.BAD_REQUEST)
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  ResponseEntity<Void> delete(@PathVariable Long id) {
    shopService.deleteById(id)
     ? new ResponseEntity(HttpStatus.OK)
     : new ResponseEntity(HttpStatus.NOT_FOUND)
  }

}
