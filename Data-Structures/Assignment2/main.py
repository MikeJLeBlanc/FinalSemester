from LinkedList import CustomList, sort_and_merge

if __name__ == '__main__':
    
    list = CustomList()
    listB = CustomList()
    listC = CustomList()

    listC.append(7)
    listC.append(5)
    listC.append(3)

    listB.append(4)
    listB.append(2)
    listB.append(9)
    listB.append(1)

    list.append(1)
    list.append(2)
    list.append(3)
    list.append(4)
    list.append(5)
    list.prepend(0)
    list.insert(3, 85)

    print("============ appened / prepend / insert =============")
    list.printList()

    
    print("=============== remove at index test ================")
    list.removeIndex(3)
    list.printList()

    print("=============== remove first test ================")
    list.removeFirst()
    list.printList()

    print("=============== remove last test ================")
    list.removeLast()
    list.printList()

    print("=============== front_back_split test ================")
    front, back = list.front_back_split()

    current = front
    while current:
        print(current.value, end=" ")
        current = current.next
    print()

    current = back
    while current:
        print(current.value, end=" ")
        current = current.next
    print()

    print("=============== sort and merge test ================")
    newList = sort_and_merge(listB, listC)
    newList.sort()
    print(newList)