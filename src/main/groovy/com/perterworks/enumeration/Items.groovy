package com.perterworks.enumeration

enum Items {

  CARS("Cars"),
  BIKES("Bikes"),
  NONE("None")

  final String value

  Items(String value) {
    this.value = value
  }

}
