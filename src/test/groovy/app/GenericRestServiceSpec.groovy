package app

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class GenericRestServiceSpec extends Specification implements ServiceUnitTest<GenericRestService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
