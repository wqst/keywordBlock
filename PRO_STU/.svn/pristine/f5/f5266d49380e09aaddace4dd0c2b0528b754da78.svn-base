import Parser
import UserQuerying

queryString = "1.Type 1 to get all the cities that CSAir flies to.\n2.Type 2 to get special information about a special city.\n3.Type 3 to get statical information about CSAir's route network.\n4.Type 4 to map your route.\n5.Type 5 to Exit."

Parser.Parser()

while True:
    print '-----------------------------------------------------------------------'
    print queryString
    
    n = raw_input("Please choose a number: \n")
    if n.strip() == '1':
        cityList = UserQuerying.getCityList()
        print 'Here is all cities that CSAir flies to...'
        for city in cityList:
            print city
        print '\n'
        
    elif n.strip() == '2':
        cityName = raw_input("Please type querying city name: \n")
        if UserQuerying.getQueryCity(cityName) == False:
            print 'Sorry, CSAir does not fly to ' + cityName
        print '\n'
        
    elif n.strip() == '3':
        UserQuerying.getStaticalInfomation()
        print '\n'
        
    elif n.strip() == '4':
        cityCode1 = raw_input("Please type the first city's code: \n")
        cityCode2 = raw_input("Please type the second city's code: \n")
        if UserQuerying.mapCity(cityCode1.upper(), cityCode2.upper()) == False:
            print "Sorry, the city's code is invalid\n"
        
        
    elif n.strip() == '5':
        break
    
    else:
        print 'Please give a valid input...'
    