package org.collinm.tyme.widgets

import scalaj.http.Http
import net.liftweb.json.{parse, render, compact, JValue}

class WeatherUnderground(key: String, location: String) {
	
    var lastConditions = 0
    var lastForecast = 0
    var lastHourly = 0
    
    val baseUrl = "http://api.wunderground.com/api/"
	val conditionsUrl = baseUrl + key + "/conditions/q/" + location + ".json"
	val forecastUrl = baseUrl + key + "/forecast/q/"+ location + ".json"
	val hourlyUrl = baseUrl + key + "/hourly/q/"+ location + ".json"
	
	def update() = {
        def getJson(url: String): JValue = parse(Http(url).asString)
        
        val condJson = getJson(conditionsUrl)
        var condMap = Map[String, String]()
        condMap = condMap + ("location" -> compact(render(condJson \\ "display_location" \\ "full")),
                             "temp" -> compact(render(condJson \\ "temp_f")),
                             "weather" -> compact(render(condJson \\ "weather")),
                             "humidity" -> compact(render(condJson \\ "relative_humidity")),
                             "wind" -> compact(render(condJson \\ "wind_mph")),
                             "feelslike" -> compact(render(condJson \\ "feelslike_f")),
                             "precip" -> compact(render(condJson \\ "precip_today_in")))
                             
        val forecastJson = getJson(forecastUrl)
        var forecastMap = Map[String, String]()
        //forecastMap = forecastMap + ("" -> compact(render()))
    }
}

object WeatherUnderground {
    def zipLookup(key: String, zip: String) = {
        val url = "http://api.wunderground.com/api/" + key + "/geolookup/q/" + zip + ".json"
        val response = Http(url).asString
    }
}