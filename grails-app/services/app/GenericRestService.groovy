package app

import grails.gorm.transactions.Transactional
import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import javax.servlet.http.HttpServletRequest

@Transactional
abstract class GenericRestService {

    Boolean eurekaClientEnabled

    LoadBalancerClient loadBalancerClient  // Ribbon 客户端
    RestTemplate restTemplate  //

    /**
     *
     * @return EUREKA 服务名
     */
    abstract def getServiceId()
    /**
     *
     * @return Service IP:PORT
     */
    abstract def getServerUrl()

    String getLoadbalancedServiceUrl(){
        ServiceInstance instance=loadBalancerClient.choose(getServiceId())
        def host=instance.getHost()
        def port=instance.getPort()
        return "http://${host}:${port}".toString()
    }

    def index(resource, request){
        request=(HttpServletRequest)request
        HttpEntity entity=getHttpEntity()
        log.info "request Query: ${request.getQueryString()}"
        ResponseEntity responseEntity = restTemplate.exchange(getResourceUrl(resource, request.getQueryString()), HttpMethod.GET, entity, String.class)
        return responseEntity
    }

    def getHttpEntity() {
        HttpHeaders headers = new HttpHeaders()
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON))
        headers.setContentType(MediaType.APPLICATION_JSON)
        headers.set("", "")
        HttpEntity entity=new HttpEntity(headers: headers)
    }

    /**
     *
     * @param resource Target Controller Name
     * @param queryString HttpRequest
     * @return Target URL
     */
    def getResourceUrl(resource, queryString){
        if (queryString){
            def decodeStr=URLDecoder.decode(queryString, "UTF-8")
            return "${getServerUrl()}/$resource?$decodeStr"
        }else{
            return "${getServerUrl()}/${resource}"
        }
    }


}
