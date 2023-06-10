fun generatePassword(A: Int, B: Int, C: Int, N: Int): String {
    val uppercaseLetters = ('A'..'Z').toList()
    val lowercaseLetters = ('a'..'z').toList()
    val digits = ('0'..'9').toList()

    val passwordChars = mutableListOf<Char>()
    var i = 0
    repeat(A) {

        var newChar = uppercaseLetters[i]
        /*while (passwordChars.lastOrNull() == newChar) {

            newChar = uppercaseLetters.random()
        }*/
        i++
        if (i == uppercaseLetters.size) i = 0
        passwordChars.add(newChar)
    }
    i=0
    repeat(B) {

        var newChar = lowercaseLetters[i]
        /*while (passwordChars.lastOrNull() == newChar) {
            newChar = lowercaseLetters.random()

        }*/
        i++
        if (i == lowercaseLetters.size) i = 0
        passwordChars.add(newChar)
    }
    i=0
    repeat(C) {

        var newChar = digits[i]
        /*while (passwordChars.lastOrNull() == newChar) {
            newChar = digits.random()

        }*/
        i++
        if (i == digits.size) i = 0
        passwordChars.add(newChar)
    }

    val remainingChars = N - (A + B + C)

    val availableChars = mutableListOf<Char>()

    if (A < remainingChars) {
        availableChars.addAll(uppercaseLetters.filterNot { passwordChars.contains(it) })
    }
    if (B < remainingChars) {
        availableChars.addAll(lowercaseLetters.filterNot { passwordChars.contains(it) })
    }
    if (C < remainingChars) {
        availableChars.addAll(digits.filterNot { passwordChars.contains(it) })
    }

    repeat(remainingChars) {
        if (availableChars.isNotEmpty()) {
            var newChar = availableChars.random()
            while (passwordChars.lastOrNull() == newChar) {
                newChar = availableChars.random()
            }
            passwordChars.add(newChar)
        } else {
            var newChar = uppercaseLetters.random()
            while (passwordChars.lastOrNull() == newChar) {
                newChar = uppercaseLetters.random()
            }
            passwordChars.add(newChar)
        }
    }


    return passwordChars.joinToString("")
}

fun main() {

    val input = readlnOrNull() ?: ""
    val (A, B, C, N) = input.split(" ").map { it.toIntOrNull() ?: 0 }

    val password = generatePassword(A, B, C, N)
    println(password)
}
