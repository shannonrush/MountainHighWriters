package controllers

import play.api.mvc.{Action, Controller}
import models.Event


object Events extends Controller {
  
  def index = Action { 
    Ok(views.html.events.index(Event.findAll)) 
  }
  
  def show(id: Long) = Action { implicit request =>
    Event.findById(id).map {event =>
      Ok(views.html.events.show(event))
    }.getOrElse(NotFound)
  }
  
  
}