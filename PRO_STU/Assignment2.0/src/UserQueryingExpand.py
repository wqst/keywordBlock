import unittest
import Parser
import QueryingData
import UserQuerying

def removeCity(cityName):
    #Check if the city is in the city dictionary
    if cityName in QueryingData.cityDicationary:
        
        cityCode = UserQuerying.nameToCode(cityName)
        continentInfo = QueryingData.cityDicationary[cityName].continent
        #Remove from the cityDicationary
        del QueryingData.cityDicationary[cityName]
        #Remove the city from the take off port
        for route in QueryingData.routeList:
            if route.takeoffPortCode == cityCode:
                UserQuerying.minusHubCity(cityCode)
                QueryingData.routeList.remove(route)
                
        #Remove the city from the land port
        for route in QueryingData.routeList:
            if route.landPortCode == cityCode:
                UserQuerying.minusHubCity(route.takeoffPortCode)
                QueryingData.routeList.remove(route)
                
        
        
        
    else:
        print 'Cannot find ' + cityName 
        
    