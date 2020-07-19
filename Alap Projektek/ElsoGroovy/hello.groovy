@RestController
class Hello {
    @RequestMapping("/")
    String home() {
        "This is Spring Boot application"
    }
}