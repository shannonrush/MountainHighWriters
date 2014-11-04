package models

import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._

object Database extends Schema {
  val eventsTable = table[Event]("events")
  val usersTable = table[User]("users")
  val reservationsTable = table[Reservation]("reservations")
  
  on(eventsTable) { e => declare {
    e.id is(autoIncremented)
  }}

  on(usersTable) { u => declare {
    u.id is(autoIncremented)
  }}

  on(reservationsTable) { r => declare {
    r.id is(autoIncremented)
  }}
}