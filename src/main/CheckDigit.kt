class CheckDigit {
    /**
     * Prompt: https://www.reddit.com/r/dailyprogrammer/comments/a72sdj/20181217_challenge_370_easy_upc_check_digits/
     */
    fun compute(upc : String) : Int {
        val odds = 3 * sumOdds(upc)
        val evens = sumEvens(upc)
        val m = (odds + evens) % 10
        return when (m) {
            0 -> m
            else -> 10 - m
        }
    }

    private fun sumOdds(upc : String) : Int {
        return 0
    }

    private fun sumEvens(upc : String) : Int {
        return 0
    }
}