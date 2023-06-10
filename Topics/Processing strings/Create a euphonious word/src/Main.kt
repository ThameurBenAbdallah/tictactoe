fun main() {
    val vowels = listOf<Char>('a', 'e', 'i', 'y', 'u', 'o')
    val consonants = ('a'..'z').toMutableList()
    var count = 0
    consonants.removeAll { vowels.contains(it) }

    val str = readln()
    var i = 0
    while (i < str.length - 2) {

        if ((vowels.contains(str[i]) && vowels.contains(str[i + 1]) && vowels.contains(str[i + 2]))
            || (consonants.contains(str[i]) && consonants.contains(str[i + 1]) && consonants.contains(str[i + 2]))) {

            count ++
            i += 2

        }
        else i++


    }

    println(count)
}

