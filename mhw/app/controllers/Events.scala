package controllers

import play.api.mvc.{Action, Controller}
import models.Event


object Events extends Controller {
  def index = Action {
	  val events = Event.findAll
	  Ok(views.html.events.index(events))
  }
  def details(id: Int) = Action { NotImplemented }
  def edit(id: Int) = Action { NotImplemented }
  def update(id: Int) = Action { NotImplemented }
}