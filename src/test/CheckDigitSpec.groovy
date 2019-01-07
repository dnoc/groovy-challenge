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
        ""   | 0
        null   | 0
        "00000000000"   | 0
    }

    def "it computes the check digit for uncommon inputs"(String upc, int expected) {
        given:
        int checkDigit = cd.compute(upc)

        expect:
        checkDigit >= 0
        checkDigit < 10
        checkDigit == expected

        where:
        upc           | expected
        "3600029145"  | 2
        "4210000526"  | 4
        "90483022"    | 2
        "1234567"     | 0
        "00000"       | 0
        ""            | 0
        null          | 0
    }
}
