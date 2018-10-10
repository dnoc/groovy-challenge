import spock.lang.Specification
import spock.lang.Unroll

class DiceRollerSpec extends Specification {

    def "it returns a number"() {
        when:
        int result = DiceRoller.roll("3d6")

        then:
        result >= 0
    }

    def "it returns 0 on invalid input"(String input, int expected) {
        expect:
        DiceRoller.roll(input) == expected

        where:
        input       | expected
        "jkldsajf"  | 0
        ""          | 0
        null        | 0
        "1234"      | 0
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
        // TODO just doesn't get hit at all
        def die = Mock(Die)
        die.roll() >> 2

        expect:
        DiceRoller.roll(input) == expected

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

    @Unroll
    def testValidInputNumberOfRolls(String input, int rolls) {
        setup:
        // TODO just doesn't get hit at all
        def die = Mock(Die)

        when:
        DiceRoller.roll(input)

        then:
        rolls * die.roll()

        where:
        input   | rolls
        "0d4"   | 0
        "1d4"   | 1
        "2d4"   | 2
        "4d4"   | 4
        "0d6"   | 0
        "1d6"   | 1
        "9d6"   | 9
        "2d8"   | 2
        "100d8" | 100
        "10d10" | 10
        "5d12"  | 5
        "6d20"  | 6
    }
}
