import spock.lang.Specification

class CheckDigitSpec extends Specification {
    def checkDigit = new CheckDigit()

    def "it runs a test"() {
        expect:
        checkDigit.compute() == 0
    }
}
