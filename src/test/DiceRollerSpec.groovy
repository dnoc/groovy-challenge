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

    @Unroll
    def testValidInputWithMock(String input, int expected) {
        setup:
        GroovyMock(DiceRoller.Die)
        // TODO this mock is failing, may not need cglib
        int numberOfSides
        DiceRoller.Die.roll(numberOfSides) >> 2
        int result = DiceRoller.roll(input)

        expect:
        result == expected

        where:
        input   | expected
        "0d4"   | 0
        "1d4"   | 2
        "2d4"   | 4
        "4d4"   | 8
        "0d6"   | 0
        "1d6"   | 2
        "9d6"   | 18
        "2d8"   | 4
        "100d8" | 200
        "10d10" | 20
        "5d12"  | 10
        "6d20"  | 12
    }
}
