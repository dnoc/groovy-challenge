class GreatestCommonFactor {
    /**
     * Prompt: https://www.coderbyte.com/editor/guest:Division:Java
     */
    fun find(a : Int, b : Int) : Int {
        if (a == 0 || b == 0) {
            return 0
        } else if (a > b) {
            return find(a-b, b)
        } else if (a < b) {
            return find (a, b-a)
        } else {
            return a
        }
    }
}