import heapq
import random

class UniqueBidAuction:
    def __init__(self):
        self.bids = []  # Priority queue to store bids
        self.bidder_bids = {}  # Hash table to keep track of bids submitted by each bidder
        self.rounds = 0  # Number of rounds
        self.current_min_bid = 0 # Current minimum bid of round

    def place_bid(self, bidder_id, bid_amount):
        if bid_amount <= 0:
            return "Bid amount must be a positive integer"
        
        if bid_amount <= self.current_min_bid:
            return "Bid amount must be greater than current minimum bid"

        if bidder_id in self.bidder_bids and bid_amount in self.bidder_bids[bidder_id]:
            return "Bidder has already placed this bid"

        heapq.heappush(self.bids, bid_amount) # Push the bid to the priority queue
        if bidder_id not in self.bidder_bids: 
            self.bidder_bids[bidder_id] = set() 
        self.bidder_bids[bidder_id].add(bid_amount) # Add the bid to the bidder's bids set

        self.process_bids()

        return "Bid placed successfully"

    def process_bids(self):
        # Check for tie
        if len(self.bids) > 1 and self.bids[0] == self.bids[1]:
            self.rounds += 1
            if self.rounds <= 20:  # Maximum 20 rounds
                self.current_min_bid = self.bids[1] + 1 # Set the new minimum bid to the tieing bid + 1
                self.bids = []
                for bidder_bids in self.bidder_bids.values():
                    if self.bids: 
                        bidder_bids.discard(self.bids[0]) 
                self.bids = [bid for bid in self.bids if bid >= self.current_min_bid] # Remove bids less than current min bid
                heapq.heapify(self.bids) # Re-heapify the bids
                print(f"Round {self.rounds} started with minimum bid: {self.current_min_bid}")
            else:
                print("Maximum rounds reached. No winner.")
                self.bids = []

    def get_winner(self):
        if len(self.bids) == 0:
            return "No winner yet"
        elif len(self.bids) == 1:
            return f"Winner: Bidder with ID {self.get_bidder_id(self.bids[0])} with a bid of {self.bids[0]}"
        else:
            unique_bids = [bid for bid in self.bids if self.bids.count(bid) == 1]
            if len(unique_bids) == 0:
                return "No unique bid found!"
            if len(unique_bids) == 1:
                return f"Winner: Bidder with ID {self.get_bidder_id(unique_bids[0])} with a bid of {unique_bids[0]}"
            else:
                highest_bid = max(unique_bids)
                return f"Winner: Bidder with ID {self.get_bidder_id(highest_bid)} with a bid of {highest_bid}"

    def get_bidder_id(self, bid_amount):
        for bidder_id, bids in self.bidder_bids.items():
            if bid_amount in bids:
                return bidder_id


# Create an instance of the auction
auction = UniqueBidAuction()

# Place some initial bids
print(auction.place_bid(1, 10))  # Bid placed successfully
print(auction.place_bid(2, 20))  # Bid placed successfully
print(auction.place_bid(3, 15))  # Bid placed successfully

# Place 1000 random extra bids for testing
for i in range(4, 1005):
    bidder_id = random.randint(1, 100)  # Random bidder ID
    bid_amount = random.randint(auction.current_min_bid, auction.current_min_bid + 25)  # Random bid amount between current min bid and 25 over
    print(auction.place_bid(bidder_id, bid_amount))

# Get the winner
print(auction.get_winner())
