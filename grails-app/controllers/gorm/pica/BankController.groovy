package gorm.pica

import grails.converters.JSON

class BankController {

    def bankService

    def create(){
        def data = request.JSON
        return bankService.create(data) as JSON
    }

    def getBankById(Integer id){
        render bankService.getById(id) as JSON
    }
}
