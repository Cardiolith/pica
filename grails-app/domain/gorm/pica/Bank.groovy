package gorm.pica

import grails.gorm.MultiTenant

class Bank implements MultiTenant<Bank> {

    static constraints = {
    }

    static mapping = {
        table: "bank"
    }

    Integer id
    Long accountNum
    BigDecimal balance
    String firstname
    String lastname
    Integer age
    Character gender
    String address
    String employer
    String email
    String city
    String state
}
