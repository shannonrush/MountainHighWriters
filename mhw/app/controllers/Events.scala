package controllers

import play.api._
import play.api.mvc._
import play.api.mvc.{Action, Controller}
import models.Event
import play.api.data.Forms._
import play.api.data.Form
import play.api.data._
import play.api.i18n.Messages

object Events extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.events.index(Event.findAll)) 
  }
  
  def show(id: Long) = Action { implicit request =>
    Event.findById(id).map {event =>
      Ok(views.html.events.show(event))
    }.getOrElse(NotFound)
  }
  
  private val eventForm: Form[Event] = Form(
    		mapping(
    		    "id" -> optional(longNumber),
    		    "name" -> text,
    		    "date" -> date,
    		    "description" -> text
    		)(Event.apply)(Event.unapply)
 )
  
  def newEvent = Action { implicit request =>
    val form = 
      	if (request2flash.get("error").isDefined)
    	  this.eventForm.bind(request2flash.data)
    	else
    	  this.eventForm
    			  
    Ok(views.html.events.event(form))
  }
  
  def save() = Action { implicit request =>
  	eventForm.bindFromRequest.fold(
        hasErrors = { form =>
         Redirect(routes.Events.newEvent()).flashing(Flash(form.data) +
             ("error" -> Messages("event.validation.errors")))
         },
        success = { newEvent =>
          val event = Event.insert(newEvent)
          Redirect(routes.Events.show(event.id.get)).flashing("success" -> "successful insert")
        }
      )
  }
  


}