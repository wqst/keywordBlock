'''

'''
import json
import urllib2
import QueryingData
import UserQuerying
import CityInfo
import RouteInfo


url = "https://wiki.engr.illinois.edu/download/attachments/220448101/map_data.json?version=1&modificationDate=1360263791000"



def parseCities(data):
    for city in data["metros"]:
        portCity = CityInfo.CityInfo(city["code"], city["name"], city["country"], 
                                    city["continent"], city["timezone"], city["coordinates"], 
                                    city["population"], city["region"])
        #add city to city dictionary
        QueryingData.cityDicationary[city["name"]] = portCity
        QueryingData.codeToName[city["code"]] = city["name"]
        #classic cities based on continent 
        cityToContinent(city["name"], city["continent"])

def parseRoutes(data):
    for route in data["routes"]:
        sourceToDestination = RouteInfo.RouteInfo(route["ports"][0], 
                                           route["ports"][1],
                                           route["distance"])
        
        destinationToSource = RouteInfo.RouteInfo(route["ports"][1],
                                                  route["ports"][0],
                                                  route["distance"])
        
        QueryingData.routeList.append(sourceToDestination)
        QueryingData.routeList.append(destinationToSource)
        
        UserQuerying.addHubCity(route["ports"][0])
        UserQuerying.addHubCity(route["ports"][1])
        
        
def cityToContinent(cityName, continent):
    if continent == 'North America':
        QueryingData.northAmerica.append(cityName)
    elif continent == 'South America':
        QueryingData.southAmerica.append(cityName)
    elif continent == 'Asia':
        QueryingData.asia.append(cityName)
    elif continent == 'Africa':
        QueryingData.africa.append(cityName)
    elif continent == 'Europe':
        QueryingData.europe.append(cityName)
    elif continent == 'Australia':
        QueryingData.australia.append(cityName)

        
class Parser:
    
    myData = open('/Users/wqst/Documents/LiClipse Workspace/tmp/src/csAirData')
    csAirData = json.load(myData)
    parseCities(csAirData)
    parseRoutes(csAirData)
    
    
    
    
    
    