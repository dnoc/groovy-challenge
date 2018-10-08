import spock.lang.*

class ArrayAdditionSpec extends Specification {


    def "it always returns false"() {
        when:
        boolean result = ArrayAddition.run()

        then:
        !result
    }
}