fun main() {
    var st1: Student = Student("Abdo", 5, 86.7)
    var st2: Student = Student("Ahmed", 10, 70.3)
    println(st1 == st2)
}

class Student (var name: String, var id: Int, var weight: Double)