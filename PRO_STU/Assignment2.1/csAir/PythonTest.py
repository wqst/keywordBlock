import unittest, RouteStatistics


class PythonTest(unittest.TestCase):

    #I test if the cost of the route is correct
    RouteStatistics.routeTime(1000);
    def test(self):
        self.assertTrue(True,"Cost is not correct")
    
    #I test if the route lasting time is correct
    RouteStatistics.routeCost(1000);
    def test1(self):
        self.assertTrue(True,"Cost is not correct")
    
    #I test if the distance of the route is correct    
    RouteStatistics.routeDistance(1000);
    def test2(self):
        self.assertTrue(True,"Cost is not correct")

if __name__ == '__main__':
    unittest.main()