import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)



    var gameState = "         "
    printGameGrid(gameState)


    //var isGameEnded = false
    while (true) {

        var validInput = false
        loop@ while (!validInput) {
            print("Enter your move (row column): ")
            val input = scanner.nextLine().trim().split(" ")
            if (input.size != 2) {
                println("Invalid input! Enter the row and column numbers separated by a space.")
                continue@loop
            }

            val row = input[0].toIntOrNull()
            val col = input[1].toIntOrNull()

            if (row == null || col == null) {
                println("Invalid input! Row and column should be numbers.")
                continue@loop
            }

            if (!isInputValid(row to col)) {
                println("Invalid input! Row and column should be between 1 and 3.")
                continue@loop
            }

            if (isCellOccupied(gameState, row, col)) {
                println("This cell is occupied! Choose another one.")
                continue@loop
            }

            val newGameState = makeMove(gameState, row, col)
            gameState = newGameState
            printGameGrid(newGameState)
            validInput = true
        }
        if (printGameState(gameState))  break


    }

}


fun isCellOccupied(gameState: String, row: Int, col: Int): Boolean {
    val index = (row - 1) * 3 + (col - 1)
    return gameState[index] != ' '
}

fun isInputValid(move: Pair<Int, Int>): Boolean {
    val (row, col) = move
    return row in 1..3 && col in 1..3
}

fun makeMove(gameState: String, row: Int, col: Int): String {
    val index = (row - 1) * 3 + (col - 1)
    return gameState.substring(0, index) + 'X' + gameState.substring(index + 1)
}



fun printGameGrid(gameState: String) {
    println("---------")
    for (i in 0 until 3) {
        print("| ")
        for (j in 0 until 3) {
            val index = i * 3 + j
            val symbol = gameState.getOrNull(index) ?: ' '
            print("$symbol ")
        }
        println("|")
    }
    println("---------")
}

fun printGameState(gameState: String):Boolean {
    val xWins = checkThreeInARow(gameState, 'X')
    val oWins = checkThreeInARow(gameState, 'O')
    val draw = !gameState.contains(' ') && !gameState.contains('_') && !xWins && !oWins
    //val impossible = isGameImpossible(gameState)

    when {
        /*impossible -> {
            println("Impossible")
            return true
        }*/
        xWins -> {
        println("X wins")
            return true
    }
        oWins -> {
            println("O wins")
            return true
        }
        draw -> {
            println("Draw")
            return false
        }

        else -> {

            return false
        }
    }
}

fun checkThreeInARow(gameState: String, symbol: Char): Boolean {
    val rows = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8)
    )

    val cols = arrayOf(
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8)
    )

    val diagonals = arrayOf(
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    for (row in rows) {
        if (row.all { gameState[it] == symbol }) {
            return true
        }
    }

    for (col in cols) {
        if (col.all { gameState[it] == symbol }) {
            return true
        }
    }

    for (diagonal in diagonals) {
        if (diagonal.all { gameState[it] == symbol }) {
            return true
        }
    }

    return false
}

/*fun isGameImpossible(gameState: String): Boolean {
    val xCount = gameState.count { it == 'X' }
    val oCount = gameState.count { it == 'O' }
    val emptyCount = gameState.count { it == ' ' }

    val xWins = checkThreeInARow(gameState, 'X')
    val oWins = checkThreeInARow(gameState, 'O')

    return xWins && oWins || abs(xCount - oCount) >= 2
}
*/



/*
fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the game state: ")
    val gameState = scanner.nextLine().trim()

    printGameGrid(gameState)
    printGameState(gameState)
}

fun printGameGrid(gameState: String) {
    println("---------")
    for (i in 0 until 3) {
        print("| ")
        for (j in 0 until 3) {
            val index = i * 3 + j
            val symbol = gameState.getOrNull(index) ?: ' '
            print("$symbol ")
        }
        println("|")
    }
    println("---------")
}

fun printGameState(gameState: String) {
    val xWins = checkThreeInARow(gameState, 'X')
    val oWins = checkThreeInARow(gameState, 'O')
    val draw = !gameState.contains(' ') && !gameState.contains('_')  && !xWins && !oWins
    val impossible = isGameImpossible(gameState)

    when {
        impossible -> println("Impossible")
        xWins -> println("X wins")
        oWins -> println("O wins")
        draw -> println("Draw")

        else -> println("Game not finished")
    }
}

fun checkThreeInARow(gameState: String, symbol: Char): Boolean {
    val rows = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8)
    )

    val cols = arrayOf(
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8)
    )

    val diagonals = arrayOf(
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    for (row in rows) {
        if (row.all { gameState[it] == symbol }) {
            return true
        }
    }

    for (col in cols) {
        if (col.all { gameState[it] == symbol }) {
            return true
        }
    }

    for (diagonal in diagonals) {
        if (diagonal.all { gameState[it] == symbol }) {
            return true
        }
    }

    return false
}
fun isGameImpossible(gameState: String): Boolean {
    val xCount = gameState.count { it == 'X' }
    val oCount = gameState.count { it == 'O' }
    val emptyCount = gameState.count { it == ' ' }

    val xWins = checkThreeInARow(gameState, 'X')
    val oWins = checkThreeInARow(gameState, 'O')

    return xWins && oWins || abs(xCount - oCount) >= 2
}
*/
