package controllers

import play.api.mvc.{Action, Controller}
import models.Event
import play.api.data.Forms._
import play.api.data.Form._
import play.api.data._

object Events extends Controller {
  
  def index = Action { 
    Ok(views.html.events.index(Event.findAll)) 
  }
  
  def show(id: Long) = Action { implicit request =>
    Event.findById(id).map {event =>
      Ok(views.html.events.show(event))
    }.getOrElse(NotFound)
  }
  
  def newEvent = Action {
    val eventForm: Form[Event] = Form(
    		mapping(
    		    "id" -> longNumber,
    		    "name" -> text,
    		    "date" -> date,
    		    "description" -> text
    		)(Event.apply)(Event.unapply)
        )
    Ok(views.html.events.event(eventForm))
  }
  
  def save = Action {
    Ok(views.html.events.index(Event.findAll)) 
  }
  
}