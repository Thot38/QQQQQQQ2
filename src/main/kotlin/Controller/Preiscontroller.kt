package Controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.DateTimeException
import java.time.LocalDateTime

@RestController
public class Preiscontroller{
    @GetMapping("/price")
    fun getPrice(@RequestParam(value = "name", defaultValue = "World") name: String) =
    Price(LocalDateTime.now(), "15.43")

}