
line="-" * 105 
#Function that gives specific information about the cities  
def specificInfo(cityList,routeList):
    global cityPick
    keepRunning=True
    
    #global keepAsking
    optCityPicked = input("Choose a city: ")
    
    def find_city(cityList, name):
        for city in cityList:
            if city.name == name:
                return city
                    
    #keepAsking=True
    #while(keepAsking):
    for city in cityList:
        if optCityPicked==city.name:
            cityPick = find_city(cityList,city.name)
            print(cityPick.name)
            print("hola")
                #keepAsking=False
                  

    while(keepRunning):                             
        print('+'+line+'+')
        print("1.code")
        print("2.name")
        print("3.country")
        print("4.continent")
        print("5.timezone")
        print("6.coordinates")
        print("7.population")
        print("8.region")
        print("9.Accessible cities")
        print('+'+line+'+')
        
        #hay que preguntar por el nombre de la city y luego por las options 
        optMenuCity = int(input("Input your option: "))
    
        def code():
            print ("The code is: "+cityPick.code)
         
        def name():
            print ("The name is: "+cityPick.name )
         
        def country():
            print ("The country is: "+cityPick.country)
         
        def continent():
            print ("The continent is: "+cityPick.continent )
        
        def timezone():
            print ("The timezone is: "+str(cityPick.timezone) )
        
        def coordinates():
            print ("The coordinates are: "+str(cityPick.coordinates) )
        
        def population():
            print ("The population is: "+str(cityPick.population) )
        
        def region():
            print ("The region is: "+str(cityPick.region) )
            
        def listAccesibleCities():
            routeList_=set(routeList)
            for route in routeList_:  
                if cityPick.code==route.origin or cityPick.code==route.dest:
                        print ("origin: "+route.origin+" destination: "+route.dest+" distance: "+str(route.distance))   
               
        optMenuCityDicc = {
                        1 : code,
                        2 : name,
                        3 : country,
                        4 : continent,
                        5 : timezone,
                        6 : coordinates,
                        7 : population,
                        8 : region,
                        9 : listAccesibleCities,
        }
        optMenuCityDicc[optMenuCity]()
        

       