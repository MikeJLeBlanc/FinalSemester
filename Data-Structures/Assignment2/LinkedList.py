class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class CustomList:
    def __init__(self):
        self.head = None
        self.length = 0

    # These next 2 are needed so we can make this list iterable.
    def __iter__(self):
        self.current = self.head
        return self

    def __next__(self):
        if self.current:
            data = self.current.value
            self.current = self.current.next
            return data
        else:
            raise StopIteration

    # working as intended
    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = new_node
        self.length += 1

    # working as intended
    def prepend(self, value):
        new_node = Node(value)
        new_node.next = self.head
        self.head = new_node
        self.length += 1

    # working as intended
    def insert(self, index, value):
        if index < 0 or index > self.length:
            return None
        if index == 0:
            self.prepend(value)
            return
        if index == self.length:
            self.append(value)
            return
        new_node = Node(value)
        current = self.head
        for i in range(index - 1):
            current = current.next
        new_node.next = current.next
        current.next = new_node
        self.length += 1

    # working as intended
    def removeIndex(self, index):
        if index < 0 or index >= self.length:
            return None
        if index == 0:
            self.head = self.head.next
            self.length -= 1
            return
        current = self.head
        for i in range(index - 1):
            current = current.next
        current.next = current.next.next
        self.length -= 1

    # working as intended
    def removeFirst(self):
        self.head = self.head.next
        self.length -= 1

    # working as intended
    def removeLast(self):
        current = self.head
        while current.next.next:
            current = current.next
        current.next = None
        self.length -= 1

    # working as intended
    def printList(self):
        current = self.head
        while current:
            print(current.value)
            current = current.next

    # working as intended
    def front_back_split(self):
        if self.length < 2:
            return None
        current = self.head
        for i in range(self.length // 2 - 1):
            current = current.next
        second = current.next
        current.next = None
        return self.head, second

# we need to move this outside of the CustomList class so we can add both the lists together. It wasn't liking iterating over itself.
# working as intended
def sort_and_merge(listA, ListB):
    listA = sorted(listA)
    ListB = sorted(ListB)
    listA.extend(ListB)
    return listA
    