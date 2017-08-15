object Trees {
  sealed trait Tree[T]
  case class Leaf[T](value: T) extends Tree[T]
  case class InnerNode[T](value: T, children: Tree[T]) extends Tree[T]
}
