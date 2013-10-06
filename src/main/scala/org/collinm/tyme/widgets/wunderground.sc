package org.collinm.tyme.widgets

import net.liftweb.json._

object wunderground {
  val response = """
{
	"response": {
		"version": "0.1"
		,"termsofService": "http://www.wunderground.com/weather/api/d/terms.html"
		,"features": {
		"forecast": 1
		}
	}
		,
	"forecast":{
		"txt_forecast": {
		"date":"2:00 PM PDT",
		"forecastday": [
		{
		"period":0,
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"title":"Saturday",
		"fcttext":"Overcast with rain. High of 64F. Windy. Winds from the South at 15 to 25 mph with gusts to 35 mph. Chance of rain 100% with rainfall amounts near 0.8 in. possible.",
		"fcttext_metric":"Overcast with rain. High of 18C. Windy. Winds from the South at 30 to 40 km/h with gusts to 60 km/h. Chance of rain 100% with rainfall amounts near 21.3 mm possible.",
		"pop":"100"
		}
		,
		{
		"period":1,
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"title":"Saturday Night",
		"fcttext":"Overcast with rain. Low of 54F. Breezy. Winds from the SSW at 15 to 20 mph. Chance of rain 100% with rainfall amounts near 0.6 in. possible.",
		"fcttext_metric":"Overcast with rain. Low of 12C. Windy. Winds from the SSW at 20 to 30 km/h. Chance of rain 100% with rainfall amounts near 14.0 mm possible.",
		"pop":"100"
		}
		,
		{
		"period":2,
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"title":"Sunday",
		"fcttext":"Overcast with rain. High of 61F. Windy. Winds from the South at 20 to 25 mph with gusts to 35 mph. Chance of rain 100%.",
		"fcttext_metric":"Overcast with rain. High of 16C. Windy. Winds from the South at 35 to 40 km/h with gusts to 55 km/h. Chance of rain 100%.",
		"pop":"100"
		}
		,
		{
		"period":3,
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"title":"Sunday Night",
		"fcttext":"Overcast with rain, then rain showers after midnight. Low of 52F. Windy. Winds from the SSW at 30 to 35 mph with gusts to 45 mph. Chance of rain 100% with rainfall amounts near 0.6 in. possible.",
		"fcttext_metric":"Overcast with rain, then rain showers after midnight. Low of 11C. Windy. Winds from the SSW at 50 to 55 km/h with gusts to 70 km/h. Chance of rain 100% with rainfall amounts near 15.0 mm possible.",
		"pop":"100"
		}
		,
		{
		"period":4,
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"title":"Monday",
		"fcttext":"Mostly cloudy with rain showers. High of 59F. Breezy. Winds from the SSW at 15 to 20 mph. Chance of rain 60%.",
		"fcttext_metric":"Mostly cloudy with rain showers. High of 15C. Windy. Winds from the SSW at 25 to 35 km/h. Chance of rain 60%.",
		"pop":"60"
		}
		,
		{
		"period":5,
		"icon":"chancerain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/chancerain.gif",
		"title":"Monday Night",
		"fcttext":"Overcast with a chance of rain. Low of 48F. Winds from the South at 5 to 15 mph. Chance of rain 40%.",
		"fcttext_metric":"Overcast with a chance of rain. Low of 9C. Breezy. Winds from the South at 10 to 25 km/h. Chance of rain 40%.",
		"pop":"40"
		}
		,
		{
		"period":6,
		"icon":"chancetstorms",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/chancetstorms.gif",
		"title":"Tuesday",
		"fcttext":"Partly cloudy with a chance of rain, then a chance of a thunderstorm and rain in the afternoon. High of 61F. Winds from the SSW at 5 to 10 mph. Chance of rain 60%.",
		"fcttext_metric":"Partly cloudy with a chance of rain, then a chance of a thunderstorm and rain in the afternoon. High of 16C. Winds from the SSW at 10 to 15 km/h. Chance of rain 60%.",
		"pop":"60"
		}
		,
		{
		"period":7,
		"icon":"partlycloudy",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/partlycloudy.gif",
		"title":"Tuesday Night",
		"fcttext":"Partly cloudy with a chance of rain. Low of 45F. Winds from the SSE at 5 to 10 mph. Chance of rain 20%.",
		"fcttext_metric":"Partly cloudy with a chance of rain. Low of 7C. Winds from the SSE at 5 to 15 km/h.",
		"pop":"20"
		}
		]
		},
		"simpleforecast": {
		"forecastday": [
		{"date":{
	"epoch":"1380434400",
	"pretty":"11:00 PM PDT on September 28, 2013",
	"day":28,
	"month":9,
	"year":2013,
	"yday":270,
	"hour":23,
	"min":"00",
	"sec":0,
	"isdst":"1",
	"monthname":"September",
	"weekday_short":"Sat",
	"weekday":"Saturday",
	"ampm":"PM",
	"tz_short":"PDT",
	"tz_long":"America/Los_Angeles"
},
		"period":1,
		"high": {
		"fahrenheit":"64",
		"celsius":"18"
		},
		"low": {
		"fahrenheit":"54",
		"celsius":"12"
		},
		"conditions":"Rain",
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"skyicon":"cloudy",
		"pop":100,
		"qpf_allday": {
		"in": 1.53,
		"mm": 38.9
		},
		"qpf_day": {
		"in": 0.84,
		"mm": 21.3
		},
		"qpf_night": {
		"in": 0.55,
		"mm": 14.0
		},
		"snow_allday": {
		"in": 0,
		"cm": 0
		},
		"snow_day": {
		"in": 0,
		"cm": 0
		},
		"snow_night": {
		"in": 0,
		"cm": 0
		},
		"maxwind": {
		"mph": 25,
		"kph": 40,
		"dir": "South",
		"degrees": 180
		},
		"avewind": {
		"mph": 22,
		"kph": 35,
		"dir": "South",
		"degrees": 181
		},
		"avehumidity": 83,
		"maxhumidity": 91,
		"minhumidity": 75
		}
		,
		{"date":{
	"epoch":"1380520800",
	"pretty":"11:00 PM PDT on September 29, 2013",
	"day":29,
	"month":9,
	"year":2013,
	"yday":271,
	"hour":23,
	"min":"00",
	"sec":0,
	"isdst":"1",
	"monthname":"September",
	"weekday_short":"Sun",
	"weekday":"Sunday",
	"ampm":"PM",
	"tz_short":"PDT",
	"tz_long":"America/Los_Angeles"
},
		"period":2,
		"high": {
		"fahrenheit":"61",
		"celsius":"16"
		},
		"low": {
		"fahrenheit":"52",
		"celsius":"11"
		},
		"conditions":"Rain",
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"skyicon":"cloudy",
		"pop":100,
		"qpf_allday": {
		"in": 0.74,
		"mm": 18.8
		},
		"qpf_day": {
		"in": 0.19,
		"mm": 4.8
		},
		"qpf_night": {
		"in": 0.59,
		"mm": 15.0
		},
		"snow_allday": {
		"in": 0,
		"cm": 0
		},
		"snow_day": {
		"in": 0,
		"cm": 0
		},
		"snow_night": {
		"in": 0,
		"cm": 0
		},
		"maxwind": {
		"mph": 25,
		"kph": 40,
		"dir": "South",
		"degrees": 169
		},
		"avewind": {
		"mph": 23,
		"kph": 37,
		"dir": "South",
		"degrees": 174
		},
		"avehumidity": 84,
		"maxhumidity": 90,
		"minhumidity": 70
		}
		,
		{"date":{
	"epoch":"1380607200",
	"pretty":"11:00 PM PDT on September 30, 2013",
	"day":30,
	"month":9,
	"year":2013,
	"yday":272,
	"hour":23,
	"min":"00",
	"sec":0,
	"isdst":"1",
	"monthname":"September",
	"weekday_short":"Mon",
	"weekday":"Monday",
	"ampm":"PM",
	"tz_short":"PDT",
	"tz_long":"America/Los_Angeles"
},
		"period":3,
		"high": {
		"fahrenheit":"59",
		"celsius":"15"
		},
		"low": {
		"fahrenheit":"48",
		"celsius":"9"
		},
		"conditions":"Rain Showers",
		"icon":"rain",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
		"skyicon":"mostlycloudy",
		"pop":60,
		"qpf_allday": {
		"in": 0.31,
		"mm": 7.9
		},
		"qpf_day": {
		"in": 0.19,
		"mm": 4.8
		},
		"qpf_night": {
		"in": 0.04,
		"mm": 1.0
		},
		"snow_allday": {
		"in": 0,
		"cm": 0
		},
		"snow_day": {
		"in": 0,
		"cm": 0
		},
		"snow_night": {
		"in": 0,
		"cm": 0
		},
		"maxwind": {
		"mph": 19,
		"kph": 30,
		"dir": "SW",
		"degrees": 215
		},
		"avewind": {
		"mph": 17,
		"kph": 27,
		"dir": "SSW",
		"degrees": 213
		},
		"avehumidity": 72,
		"maxhumidity": 93,
		"minhumidity": 67
		}
		,
		{"date":{
	"epoch":"1380693600",
	"pretty":"11:00 PM PDT on October 01, 2013",
	"day":1,
	"month":10,
	"year":2013,
	"yday":273,
	"hour":23,
	"min":"00",
	"sec":0,
	"isdst":"1",
	"monthname":"October",
	"weekday_short":"Tue",
	"weekday":"Tuesday",
	"ampm":"PM",
	"tz_short":"PDT",
	"tz_long":"America/Los_Angeles"
},
		"period":4,
		"high": {
		"fahrenheit":"61",
		"celsius":"16"
		},
		"low": {
		"fahrenheit":"45",
		"celsius":"7"
		},
		"conditions":"Chance of a Thunderstorm",
		"icon":"chancetstorms",
		"icon_url":"http://icons-ak.wxug.com/i/c/k/chancetstorms.gif",
		"skyicon":"partlycloudy",
		"pop":60,
		"qpf_allday": {
		"in": 0.22,
		"mm": 5.6
		},
		"qpf_day": {
		"in": 0.15,
		"mm": 3.8
		},
		"qpf_night": {
		"in": 0.10,
		"mm": 2.5
		},
		"snow_allday": {
		"in": 0,
		"cm": 0
		},
		"snow_day": {
		"in": 0,
		"cm": 0
		},
		"snow_night": {
		"in": 0,
		"cm": 0
		},
		"maxwind": {
		"mph": 9,
		"kph": 14,
		"dir": "SSW",
		"degrees": 196
		},
		"avewind": {
		"mph": 7,
		"kph": 11,
		"dir": "SSW",
		"degrees": 197
		},
		"avehumidity": 69,
		"maxhumidity": 84,
		"minhumidity": 66
		}
		]
		}
	}
}"""                                              //> response  : String = "
                                                  //| {
                                                  //| 	"response": {
                                                  //| 		"version": "0.1"
                                                  //| 		,"termsofService": "http://www.wunderground.com/weather/api/d/te
                                                  //| rms.html"
                                                  //| 		,"features": {
                                                  //| 		"forecast": 1
                                                  //| 		}
                                                  //| 	}
                                                  //| 		,
                                                  //| 	"forecast":{
                                                  //| 		"txt_forecast": {
                                                  //| 		"date":"2:00 PM PDT",
                                                  //| 		"forecastday": [
                                                  //| 		{
                                                  //| 		"period":0,
                                                  //| 		"icon":"rain",
                                                  //| 		"icon_url":"http://icons-ak.wxug.com/i/c/k/rain.gif",
                                                  //| 		"title":"Saturday",
                                                  //| 		"fcttext":"Overcast with rain. High of 64F. Windy. Winds from th
                                                  //| e South at 15 to 25 mph with gusts to 35 mph. Chance of rain 100% with rain
                                                  //| fall amounts near 0.8 in. possible.",
                                                  //| 		"fcttext_metric":"Overcast with rain. High of 18C. Windy. Winds 
                                                  //| from the South at 30 to 40 km/h with gusts to 60 km/h. Chance of rain 100% 
                                                  //| with rainfall amounts near 21.3 mm possible.",
                                                  //| 		"pop":"100"
                                                  //| 		}
                                                  //| 		,
                                                  //| 		{
                                                  //| 		"period":1,
                                                  //| 		"icon":"rain",
                                                  //| 		"icon_url":"http://icons-ak.wxug.co
                                                  //| Output exceeds cutoff limit.
  val j = parse(response)                         //> j  : net.liftweb.json.JValue = JObject(List(JField(response,JObject(List(JF
                                                  //| ield(version,JString(0.1)), JField(termsofService,JString(http://www.wunder
                                                  //| ground.com/weather/api/d/terms.html)), JField(features,JObject(List(JField(
                                                  //| forecast,JInt(1)))))))), JField(forecast,JObject(List(JField(txt_forecast,J
                                                  //| Object(List(JField(date,JString(2:00 PM PDT)), JField(forecastday,JArray(Li
                                                  //| st(JObject(List(JField(period,JInt(0)), JField(icon,JString(rain)), JField(
                                                  //| icon_url,JString(http://icons-ak.wxug.com/i/c/k/rain.gif)), JField(title,JS
                                                  //| tring(Saturday)), JField(fcttext,JString(Overcast with rain. High of 64F. W
                                                  //| indy. Winds from the South at 15 to 25 mph with gusts to 35 mph. Chance of 
                                                  //| rain 100% with rainfall amounts near 0.8 in. possible.)), JField(fcttext_me
                                                  //| tric,JString(Overcast with rain. High of 18C. Windy. Winds from the South a
                                                  //| t 30 to 40 km/h with gusts to 60 km/h. Chance of rain 100% with rainfall am
                                                  //| ounts near 21.3 mm poss
                                                  //| Output exceeds cutoff limit.
  val days = j \\ "simpleforecast" \\ "forecastday"
                                                  //> days  : net.liftweb.json.JsonAST.JValue = JArray(List(JObject(List(JField(d
                                                  //| ate,JObject(List(JField(epoch,JString(1380434400)), JField(pretty,JString(1
                                                  //| 1:00 PM PDT on September 28, 2013)), JField(day,JInt(28)), JField(month,JIn
                                                  //| t(9)), JField(year,JInt(2013)), JField(yday,JInt(270)), JField(hour,JInt(23
                                                  //| )), JField(min,JString(00)), JField(sec,JInt(0)), JField(isdst,JString(1)),
                                                  //|  JField(monthname,JString(September)), JField(weekday_short,JString(Sat)), 
                                                  //| JField(weekday,JString(Saturday)), JField(ampm,JString(PM)), JField(tz_shor
                                                  //| t,JString(PDT)), JField(tz_long,JString(America/Los_Angeles))))), JField(pe
                                                  //| riod,JInt(1)), JField(high,JObject(List(JField(fahrenheit,JString(64)), JFi
                                                  //| eld(celsius,JString(18))))), JField(low,JObject(List(JField(fahrenheit,JStr
                                                  //| ing(54)), JField(celsius,JString(12))))), JField(conditions,JString(Rain)),
                                                  //|  JField(icon,JString(rain)), JField(icon_url,JString(http://icons-ak.wxug.c
                                                  //| om/i/c/k/rain.gif)), JF
                                                  //| Output exceeds cutoff limit.
  for (day <- days.values.asInstanceOf[List[Map[String, Any]]]) {
    println(day("date"))                          //> Map(weekday_short -> Sat, epoch -> 1380434400, monthname -> September, tz_l
                                                  //| ong -> America/Los_Angeles, pretty -> 11:00 PM PDT on September 28, 2013, m
                                                  //| in -> 00, year -> 2013, hour -> 23, sec -> 0, isdst -> 1, yday -> 270, week
                                                  //| day -> Saturday, ampm -> PM, day -> 28, month -> 9, tz_short -> PDT)
                                                  //| Map(weekday_short -> Sun, epoch -> 1380520800, monthname -> September, tz_l
                                                  //| ong -> America/Los_Angeles, pretty -> 11:00 PM PDT on September 29, 2013, m
                                                  //| in -> 00, year -> 2013, hour -> 23, sec -> 0, isdst -> 1, yday -> 271, week
                                                  //| day -> Sunday, ampm -> PM, day -> 29, month -> 9, tz_short -> PDT)
                                                  //| Map(weekday_short -> Mon, epoch -> 1380607200, monthname -> September, tz_l
                                                  //| ong -> America/Los_Angeles, pretty -> 11:00 PM PDT on September 30, 2013, m
                                                  //| in -> 00, year -> 2013, hour -> 23, sec -> 0, isdst -> 1, yday -> 272, week
                                                  //| day -> Monday, ampm -> PM, day -> 30, month -> 9, tz_short -> PDT)
                                                  //| Map(weekday_short -> Tue, epoch -> 1380693600
                                                  //| Output exceeds cutoff limit.
  }
}