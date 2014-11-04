package models

import org.squeryl.KeyedEntity

case class Reservation (
	id: Long,
	event_id: Int,
	user_id: Int
) extends KeyedEntity[Long]