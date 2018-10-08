import spock.lang.*

class ArrayAdditionSpec extends Specification {


    def "it always returns false on empty array"() {
        setup:
        int[] array = new int[0]

        when:
        boolean result = ArrayAddition.isAddable(array)

        then:
        !result
    }

    def "it always returns true on non-empty array"() {
        setup:
        int[] array = [0]

        when:
        boolean result = ArrayAddition.isAddable(array)

        then:
        result
    }
}