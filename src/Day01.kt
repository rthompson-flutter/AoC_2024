import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.map { line: String ->
            val first = line.substringBefore(" ").trim().toInt()
            val second = line.substringAfter(" ").trim().toInt()
            first to second //left = first block of numbers, right = second block of numbers
        }.unzip() //unpair to create separate number lists for left and right

        //order both lists by smallest to largest
        val sortedLeft = left.sorted()
        val sortedRight = right.sorted()

        //for each line, find the difference (use absolute) and add to total
        var totalDistance = 0
        sortedLeft.forEachIndexed { index, value ->
            val difference = abs(value - sortedRight[index])
            totalDistance += difference
        }

        //their solution
//        val totalDistance = left.sorted().zip(right.sorted()).map { (first, second) ->
//            abs(first - second)
//        }.sum()

        return totalDistance
    }

    fun part2(input: List<String>): Int {
        val (left, right) = input.map { line: String ->
            val first = line.substringBefore(" ").trim().toInt()
            val second = line.substringAfter(" ").trim().toInt()
            first to second //left = first block of numbers, right = second block of numbers
        }.unzip() //unpair to create separate number lists for left and right

        //for each number in the left list, count how many times it appears in the right list
        //multiply the number by the count value and add to similarity score
        var similarityScore = 0
        left.forEach { num ->
            similarityScore += (right.count{ it==num } * num)
        }

        //their solution
//        val similarityScore = left.sumOf { firstColumnItem ->
//        firstColumnItem * right.count{ secondColumnItem -> secondColumnItem == firstColumnItem } }

        return similarityScore
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
