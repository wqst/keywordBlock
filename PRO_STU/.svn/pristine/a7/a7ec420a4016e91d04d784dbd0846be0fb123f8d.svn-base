line="-" * 105 

def statisticalInfo(cityList,routeList):
        print('+'+line+'+')
        print("1.longest flight")
        print("2.shortest flight")
        print("3.average distance of all flights")
        print("4.biggest city(by population)")
        print("5.smallest city(by population)")
        print("6.average size(by population) of all cities")
        print("7.continents served, and cities in each one")
        print("8.hub cities(the one that have the more directions)")
        print('+'+line+'+')
        
        hubList=[]
        #hay que preguntar por el nombre de la city y luego por las options 
        optMenuStatic = int(input("Input your option: "))
        
        def find_trip(routeList, distance):
            for route in routeList:
                if route.distance == distance:
                    return route
                
        def find_city(cityList, name):
            for city in cityList:
                if city.name == name:
                    return city
        
        def longest():
            
            longFly=0
            for route in routeList: 
                if(route.distance>longFly):
                    longFly=route.distance
          
            flight=find_trip(routeList,longFly)
            print ("The longest flight is:")
            print ("origin: "+flight.origin+" destination: "+flight.dest+" distance: "+str(flight.distance))        
         
        def shortest():
            shortFly=10000000
            for route in routeList: 
                if(route.distance<shortFly):
                    shortFly=route.distance
          
            flight=find_trip(routeList,shortFly)
            print ("The shortest flight is:")
            print ("origin: "+flight.origin+" destination: "+flight.dest+" distance: "+str(flight.distance))
         
        def averageDist():
            totalDistance=0
            numflights=48
            for route in set(routeList): 
                totalDistance=totalDistance+ route.distance
            print("a")    
            averageDistance=totalDistance/numflights    
            print ("The average distance of all flights is: "+str(averageDistance))
         
        def biggest():
            bigPopulation=0
            for city in cityList: 
                if(city.population>bigPopulation):
                    bigPopulation=city.population
                    
            cityBig=find_city(cityList,bigPopulation)
                    
            print ("The biggest city(by population) is: "+cityBig )
        
        def smallest():
            smallPopulation=1000000000
            for city in cityList: 
                if(city.population<smallPopulation):
                    smallPopulation=city.population
                    
            citySmall=find_city(cityList,smallPopulation)
            print ("The smallest city(by population) is: "+citySmall )
        
        def averageSize():
            totalPopulation=0
            numCities=48
            for city in cityList: 
                totalPopulation+=city.population
            averagePopulation=totalPopulation/numCities
            print ("The average size(by population) of all cities is:"+averagePopulation )
        
        def continents():
            Continents=""
            noDupliCityList= set(cityList)
            for city in noDupliCityList: 
                Continents+=city.continent
            print ("The continents served, and cities in each one are: "+Continents)
        
        def hub():
            print ("The hub cities are\n"+hubList)  
               
        optMenuStaticDicc = {
                        1 : longest,
                        2 : shortest,
                        3 : averageDist,
                        4 : biggest,
                        5 : smallest,
                        6 : averageSize,
                        7 : continents,
                        8 : hub,
        }
        optMenuStaticDicc[optMenuStatic]()
    