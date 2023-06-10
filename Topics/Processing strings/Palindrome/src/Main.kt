fun main() {
    val str = readln()
    var len = str.length
    var isPalindrome = true
    var half = len / 2 -1
    for (i in 0..half){
        if (str[i] != str[str.length - i - 1]) isPalindrome = false
    }

    if (isPalindrome) println("yes") else println("no")
}