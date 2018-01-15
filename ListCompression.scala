package edu.knoldus

import org.apache.log4j.Logger

class ListCompression {
  def compress (newList: List[String], updatedList: List[String]): List[String] = {

    newList match {
      case head :: head1 :: tail if head == head1 => compress (head :: tail, updatedList)
      case head :: head1 :: tail if head != head1 => compress (head1 :: tail, updatedList :+ head)
      case Nil => Nil
      case _ => updatedList
    }
  }
}

object Compression {
  def main (args: Array[String]) {

    val log = Logger.getLogger (this.getClass)
    val newObj = new ListCompression
    val str1 = "a"
    val str2 = "a"
    val str3 = "a"
    val str4 = "b"
    val str5 = "b"
    val str6 = "c"
    val str7 = "a"

    val newList = List (str1,str2,str3,str4,str5,str6,str7)
    val updatedList = List ()
    log.info (newObj.compress (newList, updatedList))
  }
}