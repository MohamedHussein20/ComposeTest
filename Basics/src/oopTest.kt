fun main() {

    var st1: Student1 = Student1("Ali", 5, 60.8)
//    st1.name = "Mohamed"
//    st1.id = 5
//    st1.weight = 78.9
    st1.printData()
    var st2: Student1 = Student1("Mohamed", 8, 70.2)
//    st2.name = "Ahmed"
//    st2.id = 10
//    st2.weight = 73.5
    st2.printData()
}
class Student1 constructor(var name: String, var id: Int, var weight: Double){


    fun sayHi(){
        println("Hi")
    }
    fun printData(){
        println("My name is $name, ID: $id, Weight: $weight")
    }
}