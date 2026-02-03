//fun main () {
//    displayMessage(:: morning)
//    displayMessage(:: evening)
//}
//fun displayMessage(mes: () -> Unit){
//    mes()
//}
//fun morning (){
//    println("Good morning")
//}
//fun evening (){
//    println("Good evening")
//}
//fun main(){
//    action(5,3, :: sum) // 8
//    action(5,3, :: multiply) // 15
//    action(5,3, :: substract) // 2
//}
//fun action(n1: Int, n2: Int, op: (Int, Int) -> Int){
//    val result = op(n1, n2)
//    println(result)
//}
//fun sum(a: Int, b: Int): Int{
//    return b + a
//}
//fun substract(a: Int, b: Int): Int{
//    return a - b
//}
//fun multiply(a: Int, b: Int) : Int{
//    return a * b
//}
fun selectAction(key: Int): (Int, Int) -> Int{
    return when(key){
        1 -> :: sum
        2 -> :: substract
        3 -> :: multiply
        else -> :: empty

    }
}
fun empty(a: Int, b: Int): Int{
    return 0
}
fun sum(a: Int, b: Int): Int{
    return a + b
}
fun multiply(a: Int, b: Int): Int{
    return a * b
}
fun substract(a: Int, b: Int): Int{
    return a - b
}
fun main(){
    val action1 = selectAction(1)
    println(action1(8,5)) // 13

    val action2 = selectAction(2)
    println(action2(8,5)) // 3
}