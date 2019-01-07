import spock.lang.Specification

class CheckDigitSpec extends Specification {
    def cd = new CheckDigit()

    def "it computes the check digit for a 11 digit upc"(String upc, int expected) {
        given:
        int checkDigit = cd.compute(upc)

        expect:
        checkDigit >= 0
        checkDigit < 10
        checkDigit == expected

        where:
        upc             | expected
        "03600029145"   | 2
        "04210000526"   | 4
        "03600029145"   | 2
        "12345678910"   | 4
        "00001234567"   | 0
        "00000000000"   | 0
    }
}
