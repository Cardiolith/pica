package gorm.pica

import grails.artefact.Artefact

@Artefact("Controller")
class GenericCmsRestController extends GenericRestController {

    def genericCmsRestService
    String resourceName

    GenericCmsRestController() {

    }

    GenericCmsRestController(resource) {
        this.resourceName = resource
    }

    @Override
    def getService() {
        return genericCmsRestService
    }

    @Override
    def getResource() {
        return resourceName
    }
}
