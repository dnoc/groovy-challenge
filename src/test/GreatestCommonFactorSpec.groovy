import spock.lang.Specification

class GreatestCommonFactorSpec extends Specification {
    def gfc = new GreatestCommonFactor()

    def "it returns a number"() {
        given:
        int result = gfc.find()

        expect:
        result == 0
    }
}
