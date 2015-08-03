import json
#Saves graph information 
def saveData(cityList,routeList):
    for city in cityList:
        obj = {u"metros":[{"code":city.code,"name":city.name,"country":city.country,"continent" : city.continent,"timezone" : city.timezone ,"coordinates" : city.coordinates ,"population" : city.population, "region": city.region }],u"routes":[]}
        print(json.dumps(obj,indent=8))     
    for route in routeList:    
        obj["routes"].append({"ports":[route.origin,route.dest],"distance":route.distance}) 
        
    JsonDataFile = open("newJson.txt", "w")
    JsonDataFile.write(json.dumps(obj, indent=4, sort_keys=True))
    JsonDataFile.close()   
