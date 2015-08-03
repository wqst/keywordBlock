import unittest
import Parser
import QueryingData
import UserQuerying

class QueryTest(unittest.TestCase):
    
    Parser.Parser()
    
    def testLongestFlight(self):
        key = UserQuerying.longestFlight()
        self.assertEqual(key, 12051)
        
    def testShorestFlight(self):
        key = UserQuerying.shortestFlight()
        self.assertEqual(key, 334)
        
    def testBiggestCity(self):
        key = UserQuerying.biggestCity()
        self.assertEqual(key, 34000000)
        
        