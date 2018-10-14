class GreatestCommonFactor {
    /**
     * Prompt: https://www.coderbyte.com/editor/guest:Division:Java
     */
    fun find(a : Int, b : Int) : Int {
        return when {
            a == 0 || b == 0 -> 0
            a > b -> find(a-b, b)
            a < b -> find (a, b-a)
            else -> a
        }
    }
}