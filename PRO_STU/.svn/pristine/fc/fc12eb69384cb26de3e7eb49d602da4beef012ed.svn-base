def drawMap(routeList):
        paintRoute="";
        noDuplirouteList= set(routeList)
        for route in noDuplirouteList:
            paintRoute+=route.origin+"-"+route.dest+","
        import webbrowser
        webbrowser.open('http://www.gcmap.com/mapui?P='+paintRoute) 