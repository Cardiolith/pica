

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/ping"(controller: "ping"){
            action = [GET: "pong"]
        }

        group "/bank", {
            "/create"(controller: "bank", action: "create", method: "POST")
            "/get/$id"(controller: "bank", action: "getBankById", method: "GET")
        }
    }
}
