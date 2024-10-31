fun main() {
addTwoNumbers(1,2)
    addTwoNumbersReturn(2,3)
}
fun addTwoNumbers(num1: Int, num2: Int){
    println(num2+num1)
}
fun addTwoNumbersReturn(num1: Int, num2: Int): Int{
    var result: Int = num1+num2
    return result
}