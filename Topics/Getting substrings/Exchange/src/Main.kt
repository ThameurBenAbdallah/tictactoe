fun main() {
    var s = readln().trim()


    s = s.last() + s.substring(1, s.length-1) + s.first()
    print(s)

}