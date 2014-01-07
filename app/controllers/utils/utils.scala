package controllers.utils

/**
 * Date: 12/17/13
*/
package object utils {
  def indicesFromString(str : String) = {
    if (!str.isEmpty){
      str.replace(","," ").trim.split(" ").map(_.toInt).toArray
    } else {
      new Array[Int](0)
    }
  }
}
