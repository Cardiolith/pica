package gorm.pica

class StartProjectJob {
    static triggers = {
      simple name: "StartProjectJob", startDelay: 10000, repeatInterval: 5000l // execute job once in 5 seconds

    }

    def execute() {
        // execute job
        log.info("executing quartz job")
    }
}
