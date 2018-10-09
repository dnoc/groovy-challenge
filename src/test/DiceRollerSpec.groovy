import spock.lang.Specification
import spock.lang.Unroll

class DiceRollerSpec extends Specification {

    def "it returns a number"() {
        when:
        int result = DiceRoller.roll("3d6")

        then:
        result >= 0
    }

    @Unroll
    def testValidInputRange(String input, int lowerRange, int upperRange) {
        setup:
        int result = DiceRoller.roll(input)

        expect:
        result >= lowerRange
        result <= upperRange

        where:
        input   | lowerRange    | upperRange
        "0d4"   | 0             | 0
        "1d4"   | 1             | 4
        "2d4"   | 2             | 8
        "0d6"   | 0             | 0
        "1d6"   | 1             | 6
        "5d6"   | 5             | 30
        "1d8"   | 1             | 8
        "100d8" | 100           | 800
        "1d10"  | 1             | 10
        "1d12"  | 1             | 12
        "1d20"  | 1             | 20
    }
}
