from ArrayStruct import data

## Entry into the program, also creating a data structure with type of i will create a structure for integers.
if __name__ == '__main__':
    array = data('i')

    ## Initial append and print test, should execute in this order
    array.append(23)
    array.append(90)
    array.append(34)
    array.append(2)
    array.append(82)
    array.append(1)
    array.print()

    ## Print the head or first number of the array
    print("------- Head (23)-------")
    print(array.head())

    ## Print the tail or last number of the array
    print("------ Tail (1)--------")
    print(array.tail())

    ## print the first number of the array after we prepend a new number
    print("------- Prepend -------")
    array.print()
    print("-- prepend 71 here ---")
    array.prepend(71)
    array.print()

    ## Pop the last number and print.
    print("------ pop (1's gone)--------")
    array.pop()
    array.print()

    ## Print the size of the array.
    print("------- Size -------")
    print(array.size())

    ## Find returns the index and item contained in the array.
    print("------- Finds -------")
    print(array.find(90))
    print(array.find(100))
    print(array.find(21))

    ## prints true if the value is present, prints false if the value is missing from the array.
    print("------ Contains --------")
    print(array.contains(90))
    print(array.contains(1000))

    ## Prints the value at the index provided.
    print("------ Index (34) --------")
    print(array.index(3))


