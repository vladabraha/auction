package cz.vb.auction.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["cz.vb.auction"])
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
