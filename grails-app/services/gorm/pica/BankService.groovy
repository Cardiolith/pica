package gorm.pica

import common.CommonErrors
import grails.gorm.transactions.Transactional

@Transactional
class BankService {

    def create(data){
        def bank = new Bank(
                accountNum: data.accountNum,
                balance: data.balance,
                firstname: data.firstname,
                lastname: data.lastname,
                age: data.age,
                gender:  data.gender,
                address: data.address,
                employer: data.employer,
                email: data.email,
                city: data.city,
                state: data.state
        )
        bank.save()
        return bank
    }

    def getById(id){
        if (!id){
            return CommonErrors.MISSING_FIELD
        }
        def bank = Bank.findById(id)
        return bank
    }
}
