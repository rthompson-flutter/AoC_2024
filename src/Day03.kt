fun main() {
    val pattern = Regex("""mul\((\d+),(\d+)\)""")

    fun part1(input: List<String>): Int {
        return pattern.findAll(input.joinToString("\n")).map { match ->
            match.groupValues[1].toInt() * match.groupValues[2].toInt()
        }.sum()
    }

    fun part2(input: List<String>): Int {
        val ignorePattern = Regex("""don't\(\).*?do\(\)""", RegexOption.DOT_MATCHES_ALL)
        val cleanInput = input.joinToString("\n").replace(ignorePattern, "")
        return pattern.findAll(cleanInput).map { match ->
            match.groupValues[1].toInt() * match.groupValues[2].toInt()
        }.sum()
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}