

class DiceRoller {

    /**
     * Rolls dice according to the input string and returns the number result.
     * Prompt: https://www.reddit.com/r/dailyprogrammer/comments/8s0cy1/20180618_challenge_364_easy_create_a_dice_roller/
     *
     * @param input
     *      String with tabletop notation, e.g. 1d6, 3d8
     * @return
     *      Sum of roll results as an int
     */
    static int roll(String inputString) {
        List<Die> dice = getDice(inputString)

        int sum = 0
        for (Die die : dice) {
            sum += die.roll()
        }

        return sum
    }

    private static List<Die> getDice(String inputString) {
        try {
            String[] input = inputString.split("d")
            int numberOfDie = Integer.valueOf(input[0])
            int numberOfSides = Integer.valueOf(input[1])

            List<Die> dice = new ArrayList<>()
            numberOfDie.times {
                dice << new DieImpl(numberOfSides)
            }
            return dice
        } catch (Exception e) {
            return new ArrayList<Die>()
        }
    }
}

interface Die {
    int roll()
}

class DieImpl implements Die {
    int sides
    Random random

    DieImpl(int numberOfSides) {
        sides = numberOfSides
        random = new Random()
    }

    @Override
    int roll() {
        return random.nextInt(sides) + 1
    }
}


