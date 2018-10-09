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

    def "it always returns false on single item array"() {
        setup:
        int[] array = [0]

        when:
        boolean result = ArrayAddition.isAddable(array)

        then:
        !result
    }

    @Unroll
    def testValidInputs(int[] array, boolean addable) {
        expect:
        ArrayAddition.isAddable(array) == addable

        where:
        array | addable
        [4, 4]                          | true
        [4, 2, 2]                       | true
        [5, 1, 11, 5]                   | true
        [1, 3, 5, 7, 16]                | true
        [20, 5, 5, 5, 10, 5]            | true
        [9, 3, 8, 2, 20, 6]             | true
        [14, 30, 1, 16, 1, 1, 1, 1, 1]  | true
        [1, 3, 5]                       | false
        [10, 100, 20, 20]               | false
        [5, 6, 19, 6, 4]                | false
        [100, 3, 5, 6, 7, 8]            | false
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 1]  | false
    }
}