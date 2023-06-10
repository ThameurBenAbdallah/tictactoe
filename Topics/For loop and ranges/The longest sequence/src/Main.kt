fun main() {
    val n = readlnOrNull()?.toIntOrNull()

    if (n == null || n <= 0) {
        println("Invalid input. Please enter a positive integer for N.")
        return
    }

    val numbers = mutableListOf<Int>()

    repeat(n) {
        val num = readln().toIntOrNull()
        if (num != null) {
            numbers.add(num)
        } else {
            println("Invalid input. Please enter a valid integer.")
            return
        }
    }

    val longestSequenceLength = findLongestNonDescendingSequence(numbers)
    println(longestSequenceLength)
}

fun findLongestNonDescendingSequence(numbers: List<Int>): Int {
    var maxLength = 0
    var currentLength = 0

    for (i in 0 until numbers.size - 1) {
        if (numbers[i] <= numbers[i + 1]) {
            currentLength++
        } else {
            maxLength = maxOf(maxLength, currentLength)
            currentLength = 0
        }
    }

    return maxOf(maxLength, currentLength) + 1
}
