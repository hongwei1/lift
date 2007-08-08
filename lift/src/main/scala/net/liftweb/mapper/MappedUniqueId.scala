package net.liftweb.mapper

/*                                                *\
 (c) 2006-2007 WorldWide Conferencing, LLC
 Distributed under an Apache License
 http://www.apache.org/licenses/LICENSE-2.0
 \*                                                */

import net.liftweb.mapper._
import net.liftweb.util.Helpers._
import net.liftweb.util.Lazy
import net.liftweb.util.Lazy._

class MappedUniqueId[T<:Mapper[T]](owner : T, maxLen: Int) extends MappedString[T](owner, maxLen) {
  override def writePermission_? = false
  private val dv = Lazy(randomString(maxLen))
  override def defaultValue = dv.get
  
  def reset(): T = this(randomString(maxLen))
}
