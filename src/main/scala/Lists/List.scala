package Lists


sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {


  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  //Exercise: Calculate the product of the elements of the list
  def product(ints: List[Int]): Int = ints match {
    case Nil => 1
    case  Cons(x, xs) => x * product(xs)
  }

  //Excercise: Remove the given element of the list
  def drop[A](list: List[A], n:Int): List[A] = list match {
    case Nil => Nil
    case Cons(_, xs) => if(n == 0) list else drop(xs, n-1)
  }

  //Exercise: Remove the first element of the list
  def tail[A](list: List[A]):List[A] = drop(list, 1)


  //Exercise: Remove elements while condition applies
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if(f(x)) dropWhile(xs)(f) else l
  }

  def setHead[A](list: List[A], n: A):List[A] = Cons(n, list)

  def map[A](l: List[A])(f: A => A):List[A] = ???
  def apply[A](as: A*): List[A] =
    if(as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}

