package gorm.pica

import grails.artefact.Artefact
import grails.converters.JSON
import groovy.json.JsonSlurper
import org.springframework.http.ResponseEntity

@Artefact("Controller")
class GenericRestController {

    static allowedMethods = [save: "POST", update:"PUT", delete:"DELETE"]

    def index(){
        ResponseEntity responseEntity=getService().index(getResource(), request)
        if (responseEntity.getBody()){
            def json=new JsonSlurper().parseText(responseEntity.getBody())
        }else{
            render ""
        }
    }


    def getService(){
        render {["status":200, "message": "OK"]} as Map
    }

    def getResource(){

    }
}
