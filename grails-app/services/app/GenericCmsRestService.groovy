package app

import grails.gorm.transactions.Transactional
import org.springframework.beans.factory.annotation.Value

@Transactional
class GenericCmsRestService extends GenericRestService {

    @Value('')
    String serviceId
    @Value('')
    String serviceUrl

    @Override
    def getServiceId() {
        return serviceId
    }

    @Override
    def getServerUrl() {
        if (eurekaClientEnabled){
            return getLoadbalancedServiceUrl()
        }else{
            return serviceUrl
        }
    }
}
