package collections

import scala.io.Source


object CollectionExcercises {
  def main(args: Array[String]): Unit = {
    val data = Source.fromFile(getClass.getClassLoader.getResource("employee.csv").getPath).getLines().toList.tail
    val employees = data.map(line => {
      val info = line.split(",")
      Employee(
        info(0).toInt,
        info(1),
        info(2),
        info(3),
        info(4),
        info(5),
        info(6).toDouble
      )
    })

    //List the job titles:
    //printJobTitles(employees)

    //Top Salary
    println(s"Top Salary: ${employees.maxBy(e => e.salary)}\n")

    //List top 10 biggest salaries
    printTop10Salaries(employees)

    //List top 10 biggest salaries
    printTop10LowerSalaries(employees)

    //List top 10 biggest womens's salaries
    printTop10WomenSalaries(employees)


  }

  def printJobTitles(employees: List[Employee]) = {
    println("Job Titles:\n")
    val jobTitles = employees
      .map(e => e.jobTitle)
      .distinct
      .sorted
    jobTitles.foreach(jobTitle => println(jobTitle))
    println()
  }

  def printTop10Salaries(employees: List[Employee]) = {
    println("Top 10Salaries:\n")
    employees.sortWith( _.salary > _.salary)
        .slice(0, 10)
      .foreach( e => println(e))
    println()
  }

  def printTop10WomenSalaries(employees: List[Employee]) = {
    println("Top 10 Women Salaries:\n")
    employees
      .filter(e => e.gender=="Female")
      .sortWith( _.salary > _.salary)
      .slice(0, 10)
      .foreach( e => println(e))
    println()
  }

  def printTop10LowerSalaries(employees: List[Employee]) = {
    println("Top 10 Lower Salaries:\n")
    employees.sortWith( _.salary < _.salary)
      .slice(0, 10)
      .foreach( e => println(e))
    println()

  }

}
