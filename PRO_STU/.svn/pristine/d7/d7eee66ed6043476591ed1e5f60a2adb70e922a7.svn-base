import StatisticalInfo, ListCities, SpecificInfo, DrawMap, Editing, RouteStatistics, JsonSave

#Getting information from the graph
def startMenu(cityList, routeList):
    line="-" * 105 
    lineTop="-" * 40 
    keepRunning=True
    
    while(keepRunning):
 
        print('+'+lineTop+'Text based user interface'+lineTop+'+')
        print('+'+line+'+')
        print('1. Get a list of all the cities that CSAir flies to')
        print('2. Specific information about a specific city in the CSAir route network.')
        print('3. Statistical information about CSAirs route network')
        print('4. Draw Map')
        print('5. Edit route network')
        print('6. Route statistics')
        print('7. Save data')
        print('+'+line+'+')
        
        optMenu = int(input("Input your option: "))
        
        if optMenu==1:          
            #Function that list the cities
            ListCities.listCities(cityList)    
        elif optMenu==2:
            #Function that gives the specific information about the companies flights
            SpecificInfo.specificInfo(cityList,routeList) 
        elif optMenu==3:
            #Function that gives statistical information about flights
            StatisticalInfo.statisticalInfo(cityList,routeList)
        elif optMenu==4:
            #Draws the map of the flights
            DrawMap.drawMap(routeList)
        elif optMenu==5:
            #Edits the graph
            Editing.editing(cityList,routeList)    
        elif optMenu==6:
            #Draws the map of the flights
            RouteStatistics.routeStatistics(routeList)
        elif optMenu==7:
            #Draws the map of the flights
            JsonSave.saveData(cityList,routeList)    

