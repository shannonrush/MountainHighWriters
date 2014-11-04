package models

import org.squeryl.KeyedEntity

case class User (
	id: Long,
	first: String,
	last: String
) extends KeyedEntity[Long]