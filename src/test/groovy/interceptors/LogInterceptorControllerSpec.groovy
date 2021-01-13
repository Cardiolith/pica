package interceptors

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class LogInterceptorControllerSpec extends Specification implements ControllerUnitTest<LogInterceptorController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
