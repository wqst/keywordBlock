#Variable declarations
maxTime=40
maxCost=1000000
maxDistance=55000000

def routeStatistics(routeList):
    print("Route you want to get information about")
    originPicked = raw_input("origin: ")
    destinationPicked = raw_input("destination: ")
    
    notExist=True
    
    # check if that route exist and if it does i give out the information on the cost
    if(notExist):
        for route in routeList:
            if route.origin==originPicked and route.dest == destinationPicked or route.origin==destinationPicked and route.dest == originPicked:
                notExist=False
                cost=int(route.distance*0.35)
                time=int(route.distance/750)
                print("Distance:"+str(route.distance))
                print("Cost:"+str(cost)+"$")
                print("Time:"+str(time)+"h")
                        
    if(notExist):
        print("That route does not exist")
        
def routeTime(time):
    if (time>maxTime):
        return False
    
def routeCost(cost):
    if (cost>maxCost):
        return False
    
def routeDistance(distance):
    if (distance>maxDistance):
        return False