import heapq
import random

class UniqueBidAuction:
    def __init__(self):
        self.bids = []  # Priority queue to store bids
        self.bidder_bids = {}  # Hash table to keep track of bids submitted by each bidder

    def place_bid(self, bidder_id, bid_amount):
        if bid_amount <= 0:
            return "Bid amount must be a positive integer"

        if bidder_id in self.bidder_bids and bid_amount in self.bidder_bids[bidder_id]:
            return "Bidder has already placed this bid"

        heapq.heappush(self.bids, bid_amount)
        if bidder_id not in self.bidder_bids:
            self.bidder_bids[bidder_id] = set()
        self.bidder_bids[bidder_id].add(bid_amount)

        self.process_bids()

        return "Bid placed successfully"

    def process_bids(self):
        # Check for tie
        if len(self.bids) > 1 and self.bids[0] == self.bids[1]:
            min_bid = self.bids[1] + 1
            self.bids = []
            for bidder_bids in self.bidder_bids.values():
                if self.bids:
                    bidder_bids.discard(self.bids[0])
            self.bids = [bid for bid in self.bids if bid >= min_bid]
            heapq.heapify(self.bids)

    def get_winner(self):
        if len(self.bids) == 0:
            return "No winner yet"
        elif len(self.bids) == 1:
            return f"Winner: Bidder with ID {self.get_bidder_id(self.bids[0])} with a bid of {self.bids[0]}"
        else:
            unique_bids = [bid for bid in self.bids if self.bids.count(bid) == 1]
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

# Place 100 random extra bids for testing
for i in range(4, 105):
    bidder_id = random.randint(1, 10)  # Random bidder ID
    bid_amount = random.randint(5, 25)  # Random bid amount between 5 and 25
    print(auction.place_bid(bidder_id, bid_amount))

# Get the winner
print(auction.get_winner())
