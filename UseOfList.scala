package edu.knoldus

import org.apache.log4j.Logger

class UseOfList {

  def rotation (steps: Int, newList: List[String]): List[String] =

    steps match {

      case steps if steps > 0 => newList match {
        case firstElement :: restElements => rotation (steps - 1, restElements ::: List (firstElement))
        case Nil => rotation (steps - 1, Nil)
      }
      case steps if steps < 0 => newList.reverse match {
        case firstElement :: restElements => rotation (steps + 1, firstElement :: restElements.reverse)
        case Nil => rotation (steps + 1, Nil)
      }
      case _ => newList
    }
}

object ListUse {
  val log = Logger.getLogger (this.getClass)
  def main (arg: Array[String]) {

    val newObj = new UseOfList
    val str1 = "a"
    val str2 = "b"
    val str3 = "c"
    val str4 = "d"
    val str5 = "e"
    val str6 = "f"

    val newList = List (str1,str2,str3,str4,str5,str6)
    log.info(newObj.rotation (-1, newList))
  }
}