import spock.lang.Specification

class GreatestCommonFactorSpec extends Specification {
    def gfc = new GreatestCommonFactor()

    def "it returns the greatest common factor"(int a, int b, int expected) {
        expect:
        gfc.find(a, b) == expected

        where:
        a       | b     | expected
        7       | 3     | 1
        36      | 54    | 18
        20      | 50    | 10
        20      | 25    | 5
        252     | 105   | 21
        13000   | 52    | 52
        1       | 1     | 1
    }
}
