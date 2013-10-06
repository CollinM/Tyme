package org.collinm.tyme.widgets

object weather {
  val wu = new WeatherUnderground("a59fc970617125b8", "98040")
                                                  //> wu  : org.collinm.tyme.widgets.WeatherUnderground = org.collinm.tyme.widgets
                                                  //| .WeatherUnderground@6cb8
  wu.update()                                     //> {
                                                  //|   "response":{
                                                  //|     "version":"0.1",
                                                  //|     "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
                                                  //| 
                                                  //|     "features":{
                                                  //|       "conditions":1
                                                  //|     }
                                                  //|   },
                                                  //|   "current_observation":{
                                                  //|     "image":{
                                                  //|       "url":"http://icons-ak.wxug.com/graphics/wu2/logo_130x80.png",
                                                  //|       "title":"Weather Underground",
                                                  //|       "link":"http://www.wunderground.com"
                                                  //|     },
                                                  //|     "display_location":{
                                                  //|       "full":"Mercer Island, WA",
                                                  //|       "city":"Mercer Island",
                                                  //|       "state":"WA",
                                                  //|       "state_name":"Washington",
                                                  //|       "country":"US",
                                                  //|       "country_iso3166":"US",
                                                  //|       "zip":"98040",
                                                  //|       "magic":"1",
                                                  //|       "wmo":"99999",
                                                  //|       "latitude":"47.56315613",
                                                  //|       "longitude":"-122.22649384",
                                                  //|       "elevation":"89.00000000"
                                                  //|     },
                                                  //|     "observation_location":{
                                                  //|       "full":"Gallagher Hill, Mercer Island, Washington",
                                                  //|       "city":"Gallagher Hill, Mercer Island",
                                                  //|       "state"
                                                  //| Output exceeds cutoff limit.
}