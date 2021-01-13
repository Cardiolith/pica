package interceptors


import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.slf4j.MDC

import javax.servlet.http.HttpServletRequest

@CompileStatic
@Slf4j
class LogInterceptor {

    /**
     *
     */
    LogInterceptor() {
        matchAll().except(
                controllerName: "PingController"
        )
    }

    /**
     * 执行方法拦截之前
     * @return
     */
    boolean before() {
        HttpServletRequest req = request
        String x_request_id = req.getHeader("x_request_id")
        if (!x_request_id) {
            x_request_id = UUID.randomUUID().toString().replace("-", "")
        }
        MDC.put("request_id", x_request_id)

        long startTime = new Date().getTime()
        MDC.put("request_start_time", String.valueOf(startTime))

        def queryString = req.queryString
        if (queryString) {
            queryString = "?$queryString"
        }else{
            queryString = ""
        }

        String path=""
        if (request.servletPath){
            path+=request.servletPath
        }
        if (request.contextPath){
            path+=request.contextPath
        }
        if (request.pathInfo){
            path+=request.pathInfo
        }
        log.info("==== request URL: ${req.method} ${path}$queryString")
        true
    }

    /**
     * 执行方法拦截之后
     * @return
     */
    boolean after() {
        MDC.remove("request_id")
        MDC.remove("request_start_time")
        true
    }

    /**
     * 页面渲染
     */
    void afterView() {
        // no-op
    }
}
