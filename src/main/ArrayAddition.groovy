class ArrayAddition {

    /**
     * Function that returns true if any combination of numbers in the array (excluding the largest number) can be
     * added up to equal the largest number in the array, otherwise false
     *
     * Prompt: https://www.coderbyte.com/editor/guest:Array%20Addition:Java
     */
    static boolean isAddable(int[] array) {
        int length = array.length
        if (length < 2) return false

        Arrays.sort(array)
        int largestVal = array[length-1]

        return findSum(Arrays.copyOfRange(array, 0, length-1), length-1, largestVal)
    }

    private static boolean findSum(int[] array, int length, int sum) {
        if (sum == 0) {
            return true
        }

        if (length == 0 && sum != 0) {
            return false
        }

        return findSum(array, length-1, sum) || findSum(array, length-1, sum-array[length-1])
    }
}
