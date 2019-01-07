class CheckDigit {
    /**
     * Prompt: https://www.reddit.com/r/dailyprogrammer/comments/a72sdj/20181217_challenge_370_easy_upc_check_digits/
     * Input is 11-digit numeric string, e.g. 03600029145
     */
    fun compute(input : String?) : Int {
        val upc = validate(input)
        val odds = 3 * sumOdds(upc)
        val evens = sumEvens(upc)
        val m = (odds + evens) % 10
        return when (m) {
            0 -> m
            else -> 10 - m
        }
    }

    private fun validate(input : String?) : String {
        return when {
            input == null -> "00000000000"
            input.length >= 11 -> input
            else -> fillMissingDigits(input)
        }
    }

    private fun fillMissingDigits(input : String) : String {
        val missing = 11 - input.length
        var output = input
        for (i in 1..missing) {
            output = "0$output"
        }

        return output
    }

    private fun sumOdds(upc : String) : Int {
        val first = Character.getNumericValue(upc[0])
        val third = Character.getNumericValue(upc[2])
        val fifth = Character.getNumericValue(upc[4])
        val seventh = Character.getNumericValue(upc[6])
        val ninth = Character.getNumericValue(upc[8])
        val eleventh = Character.getNumericValue(upc[10])

        return first + third + fifth + seventh + ninth + eleventh
    }

    private fun sumEvens(upc : String) : Int {
        val second = Character.getNumericValue(upc[1])
        val fourth = Character.getNumericValue(upc[3])
        val sixth = Character.getNumericValue(upc[5])
        val eighth = Character.getNumericValue(upc[7])
        val tenth = Character.getNumericValue(upc[9])

        return second + fourth + sixth + eighth + tenth
    }
}