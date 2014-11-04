package models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.KeyedEntity

case class Event (
	id: Long,
	name: String,
	date: java.util.Date,
	description: String
) extends KeyedEntity[Long]

object Event {
  import Database.eventsTable
  
  def findAll = inTransaction {
    (from (eventsTable) ( e => select(e))).toList
  }
}