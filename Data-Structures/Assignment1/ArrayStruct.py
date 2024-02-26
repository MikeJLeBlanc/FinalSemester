#need this for type support
import array

class data:
    #initialize itself
    def __init__(self, arr_type):
        self.arr_node = array.array(arr_type, [])
    
    #append to the end
    def append(self, value):
        self.arr_node.append(value)
    
    #append to the front of the array
    def prepend(self, value):
        self.arr_node.insert(0, value)
    
    #return the length of the array
    def size(self):
        return len(self.arr_node)
    
    #return the first element of the array
    def head(self):
        return self.arr_node[0]
    
    #return the last element of the array
    def tail(self):
        return self.arr_node[-1]
    
    #returns the element at the index provided
    def index(self, index):
        return self.arr_node[index]
    
    #remove the last element in the array
    def pop(self):
        self.arr_node[-0] = self.arr_node.pop()
    
    #returns true if the item is in the array
    def contains(self, item):
        return item in self.arr_node

    #attempt to find item in this arra
    def find(self, item):
        for index, value in enumerate(self.arr_node):
            if value == item:
                return index, item
            

    #print everything in this array.
    def print(self):
        for node in self.arr_node:
            print(node)
