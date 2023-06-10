fun main() {
    val a = readln().toInt()
    var min = readln().toInt()
    for (i in 2..a) {

        var b = readln().toInt()
        if (b < min) min = b

    }
    println(min)
}
