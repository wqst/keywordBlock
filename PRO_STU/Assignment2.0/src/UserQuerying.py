import webbrowser
import QueryingData
import Parser
import pprint

############################################################
def getCityList():
    cityList =[]
    for city in QueryingData.cityDicationary:
        cityList.append(city)
    return cityList
        

def longestFlight():
    currentLongest = 0
    for route in QueryingData.routeList:
        if route.distance > currentLongest:
            currentLongest = route.distance
        
    QueryingData.longestSingleFlight = currentLongest
    return QueryingData.longestSingleFlight

def shortestFlight():
    currentShortest = 10000000
    for route in QueryingData.routeList:
        if route.distance < currentShortest:
            currentShortest = route.distance
            
    QueryingData.shortestSingleFlight = currentShortest
    return QueryingData.shortestSingleFlight

def averageDistance():
    totalDistance = 0
    for route in QueryingData.routeList:
        totalDistance += route.distance
    
    QueryingData.averageDistance = totalDistance/len(QueryingData.routeList)
    return QueryingData.averageDistance
        
def biggestCity():
    currentBiggest = 0
    for cityName, cityInfo in QueryingData.cityDicationary.iteritems():
        if cityInfo.population > currentBiggest :
            currentBiggest = cityInfo.population
            
    QueryingData.biggestCity = currentBiggest
    return QueryingData.biggestCity

def smallestCity():
    currentSmallest = 1000000000
    for cityName, cityInfo in QueryingData.cityDicationary.iteritems():
        if cityInfo.population < currentSmallest:
            currentSmallest = cityInfo.population
        
    QueryingData.smallestCity = currentSmallest
    return QueryingData.smallestCity
    
def averageCitySize():
    totalPopulation = 0
    for cityInfo in QueryingData.cityDicationary.itervalues():
        totalPopulation += cityInfo.population
        
    QueryingData.averageCitySize = totalPopulation/len(QueryingData.cityDicationary)
    return QueryingData.averageCitySize

def getHubCityList():
    currentMax = 0
    hubCityList = []
    for numRoute in QueryingData.hubCity.itervalues():
        if numRoute > currentMax:
            currentMax = numRoute
    
    for cityCode, connections in QueryingData.hubCity.iteritems():
        if connections == currentMax:
            hubCityList.append(codeToName(cityCode))
            
    return hubCityList



def codeToName(cityCode):
    for code, name in QueryingData.codeToName.iteritems():
        if code == cityCode:
            return name
        
def nameToCode(cityName):
    for code, name in QueryingData.codeToName.iteritems():
        if name == cityName:
            return code
        
def stringContinentList(continentList):
    continentString = ""
    for item in continentList:
        continentString = continentString + item + ', '
    return continentString
        
def addHubCity(cityCode):
    if cityCode in QueryingData.hubCity:
        QueryingData.hubCity[cityCode] += 1
    else:
        QueryingData.hubCity[cityCode] = 0
        
def minusHubCity(cityCode):
    QueryingData.hubCity[cityCode] -= 1
                                                        
##########################################################################       
def getFlyToCity(sourceCity):
    sourceCode = nameToCode(sourceCity)

    destinationList = {}
    for route in QueryingData.routeList:
        if route.takeOffPortCode == sourceCode:
            landCode = route.landPortCode
            landCity = codeToName(landCode)
            destinationList[landCity] = route.distance
            
    return destinationList
        
        
def getQueryCity(cityName):
    for city in QueryingData.cityDicationary:
        if cityName == city:
            queryCity = QueryingData.cityDicationary[city]
            print 'Name: ' + queryCity.name
            print 'Code: ' + queryCity.code
            print 'Country: ' + queryCity.country
            print 'Timezone: ' + str(queryCity.timezone)
            print 'Population: ' + str(queryCity.population)
            print 'Region: ' + str(queryCity.region)
            
            coordinatesList = []
            for n, m in queryCity.coordinates.iteritems():
                corString = n + ': ' + str(m)
                coordinatesList.append(corString)
            print coordinatesList
            
            flyToList = getFlyToCity(cityName)
            print '\nFly To Cities and Distance: '
            for flyToCities, distance in flyToList.iteritems():
                print  flyToCities + ': ' + str(distance) + ' miles' 
            return True
    return False
    
                
def getStaticalInfomation():
    print 'The Longest Flight: ' + str(longestFlight()) + ' miles'
    print 'The ShortesFlight: ' + str(shortestFlight()) + ' miles'
    print 'The Average Distance: ' + str(averageDistance()) + ' miles'
    print 'The Biggest City Population: ' + str(biggestCity()) 
    print 'The Smallest City Population: ' + str(smallestCity())
    print 'The Average City Population: ' + str(averageCitySize()) + '\n'
    
    print 'Asia:'
    print stringContinentList(QueryingData.asia)
    print 'Europe:'
    print stringContinentList(QueryingData.europe)
    print 'North America:'
    print stringContinentList(QueryingData.northAmerica)
    print 'South America:'
    print stringContinentList(QueryingData.southAmerica) 
    print 'Africa:'
    print stringContinentList(QueryingData.africa) + '\n'
    
    hubList = getHubCityList()
    print 'Hub Cities: ' 
    for item in hubList:
        print item
        
def mapCity(cityCode1, cityCode2):
    url = "http://www.gcmap.com/mapui?P="
    validCode = True
    url = url + cityCode1 + '-' + cityCode2
    webbrowser.open_new_tab(url)
    return validCode
    
    
    
    
    
    