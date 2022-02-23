package com.perterworks.domain

import com.perterworks.enumeration.Items

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Shop {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  @Enumerated(EnumType.STRING)
  Items item

  String name
  Double cost
  Integer available

}
