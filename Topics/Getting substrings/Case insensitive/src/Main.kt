import java.util.*


    fun main() {
        val str1 = readln()
        val str = readln()
        val t = str1.lowercase(Locale.getDefault()) == str.lowercase(Locale.getDefault())
        if (t) println ("true") else println("false")

    }
