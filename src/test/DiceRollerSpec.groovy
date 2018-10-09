import DiceRoller.DiceRoller
import spock.lang.Specification

class DiceRollerSpec extends Specification {

    DiceRoller roller = new DiceRoller()

    def "it returns a number"() {
        when:
        int result = roller.roll("3d6")

        then:
        result == 0
    }
}
