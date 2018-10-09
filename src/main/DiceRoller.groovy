

class DiceRoller {

    /**
     * Rolls dice according to the input string and returns the number result.
     *
     * @param input
     *      String with tabletop notation, e.g. 1d6, 3d8
     * @return
     *      Sum of roll results as an int
     */
    static int roll(String inputString) {
        String[] input = inputString.split("d")
        int numberOfDie = Integer.valueOf(input[0])
        int numberOfSides = Integer.valueOf(input[1])

        int sum = 0
        numberOfDie.times {
            sum += Die.roll(numberOfSides)
        }

        return sum
    }

    private static class Die {
        static int roll(int numberOfSides) {
            Random random = new Random()
            return random.nextInt(numberOfSides) + 1
        }
    }
}


