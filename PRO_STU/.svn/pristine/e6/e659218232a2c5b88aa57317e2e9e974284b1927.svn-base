from City import City
from Route import Route
import sys

line="-" * 105 
#Function to edit the route network
def editing(cityList,routeList):
        
        #Functions used afterwards        
        def find_city(cityList, name):
            for city in cityList:
                if city.name == name:
                    return city
            
        def find_route(routeList, origin_, dest_):
            for route in routeList:
                if route.origin==origin_ and route.dest == dest_:
                    return route
                
        def find_routeDelete(code):
            for route in routeList:
                if route.origin==code or route.dest == code:
                    routeList.remove(route)          
                     
        def addCity():
            code = raw_input("Enter code:")
            name = raw_input("name:")
            country =raw_input("country:")
            continent = raw_input("continent:")
            timezone = int(input("timezone:"))
            coordinates = raw_input("coordinates:")
            population = int(input("population:"))
            region = int(input("region:"))
            newCity=City(code, name, country, continent, timezone, coordinates, population, region)
            return newCity
        
        def addRoute():
            origin = raw_input("Enter origin:")
            dest = raw_input("Enter destination:")
            distance =raw_input("Enter distance:")
            newRoute=Route(origin, dest, distance)
            return newRoute
        
        def Dijkstra(cityList, routeList, source, dest):
            visited = {}
            dist = {}
            prev = {}
        
            keys = cityList
        
        # initalize data structures
            for i in range(len(keys)):
                key = keys[i]
                visited[key] = False
                dist[key] = sys.maxint
                prev[key] = None
            
            dist[source] = 0
        
        # perform the algorithm
            for iteration in range(len(keys)):
            # find minimum unvisited vertex
                minimum_key = None
                minimum_dist = sys.maxint
                for i in range(len(keys)):
                    key = keys[i]
                if visited[key] == False and dist[key] < minimum_dist:
                    minimum_key = key
                    minimum_dist = dist[key]
                    
            # if unreachable, return None
            if minimum_key == None:
                return None
            
            # label the vertex
            visited[minimum_key] = True
                
            # for all unlabeled neighbors, update cost and prev
            current_node = cityList[minimum_key]
            neighbors = current_node.get_all_outgoing()
            for i in range(len(neighbors)):
                current = neighbors[i]
                relaxed_weight = dist[minimum_key] + current_node.get_outgoing(current).weight
                if relaxed_weight < dist[current]:
                    dist[current] = relaxed_weight
                    prev[current] = minimum_key
                    
        # recalculate the path
            path = [ dest ]
            while prev[ path[-1] ] != None:
                path.append(prev[ path[-1] ])
            return path[::-1]  
                               
        print('+'+line+'+')
        print("1.Remove city")
        print("2.Remove route")
        print("3.Add city")
        print("4.Add route")
        print("5.Edit existing city")
        print("6.Shortest Path")
        print('+'+line+'+')
        
        editingOpt = int(input("Input your option: "))

        def removeC():
            rCity = raw_input("Which city do you want to remove: ")
            cityPick=find_city(cityList, rCity)
            cityList.remove(cityPick)
            
            #Remove also all its routes
            find_routeDelete(cityPick.code)
        
        def removeR():
            print("Which route do you want to delete")
            origin = raw_input("Which origin: ")
            dest = raw_input("Which destination: ")
            routePick=find_route(routeList, origin, dest)
            routeList.remove(routePick)
 
        def addC():
            print("Which city do you want to add")
            newCity= addCity() 
            cityList.append(newCity)
        
        def addR():
            print("Which route do you want to add")
            newRoute= addRoute() 
            routeList.append(newRoute)
        
        #Since in the assignment it doesn't say what can we edit
        def edit():
            eCityName = raw_input("Name of the city you want to edit:")
            cityPick=find_city(cityList, eCityName)
            print("What do you want to edit")
            print("code")
            edit = raw_input("name")
            if(edit=="name"):
                name = raw_input("New name: ")
                cityPick.name=name
                for route in routeList:
                    if route.origin == eCityName:
                        route.origin = name
                    elif route.dest == eCityName:
                        route.dest = name    
            if(edit=="code"):
                code = raw_input("New code: ")
                cityPick.code=code  
        
        def find_short():
            source = raw_input("source city")
            dest = raw_input("dest city")
            Dijkstra(cityList, routeList, source, dest)
        optMenuStaticDicc = {
                        1 : removeC,
                        2 : removeR,
                        3 : addC,
                        4 : addR,
                        5 : edit,
        }
        optMenuStaticDicc[editingOpt]()