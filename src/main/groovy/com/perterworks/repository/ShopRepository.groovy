package com.perterworks.repository

import com.perterworks.domain.Shop
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository extends CrudRepository<Shop, Long> {

  Shop findByNameIgnoreCase(String name)

}
