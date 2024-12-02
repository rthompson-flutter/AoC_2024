import kotlin.math.abs

fun main() {
    fun isSafe(list: List<Int>): Boolean {
        return ((list == list.sorted()) || (list == list.sortedDescending()))
                && (list.windowed(2).all { (first, second) -> abs(first - second) in 1..3 })
    }

    fun part1(input: List<String>): Int {
        var safeReports = 0
        input.forEach { report ->
            val list = report.split(" ").map { it.toInt() }
            if (isSafe(list)) safeReports += 1
        }
        return safeReports

        //their solution
        //return input.count { report ->
        //     isSafe(report.split(" ").map{ it.toInt() })
        //}
    }

    fun part2(input: List<String>): Int {
        var safeReports = 0
        input.forEach { report ->
            val list = report.split(" ").map { it.toInt() }
            if (isSafe(list)) {
                safeReports += 1
            } else {
                var foundSafeRemoval = false
                for (i in list.indices) {
                    val remainingList = list.toMutableList()
                    remainingList.removeAt(i)
                    if (isSafe(remainingList)) {
                        foundSafeRemoval = true
                        break
                    }
                }
                if (foundSafeRemoval) {
                    safeReports += 1
                }
            }
        }
        return safeReports

        //their solution
        //return input.count { report ->
        //        val levels = report.split(" ").map(String::toInt)
        //        isSafe(levels) || levels.indices.any { i ->
        //            isSafe(levels.toMutableList().apply { removeAt(i) })
        //        }
        //    }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}