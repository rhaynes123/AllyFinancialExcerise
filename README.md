# AllyFinancialExcerise
Interview pre-assignment
Please complete this small development exercise on your own – we would like to go over your solution together during your onsite interview. You are welcome to bring your laptop with you to the interview, or publish the code on github or gitlab. If anything is unclear there is no need to contact us for more information – please use your best judgement. You will not be judged on requirements that are unclear. If you are unable to complete the entire exercise, please complete what you can – we can discuss the deltas – the more you can complete, the better.

Please create a simple auction application that:
provides a RESTful (or at least JSON over HTTP) interface
is written using any language, but Java (with Spring) is preferred
contains a simple web UI written using any technology, but preferably an SPA framework such as Angular 2+
uses one or more databases for persistence; Any database(s) can be used; for simplicity an in-memory database such as H2 or a modern NoSQL engine is acceptable. Be prepared to explain your persistence choice(s) and describe how you architected the data tier for scale.
Things to consider:
Testing (Unit, Functional, Integration, Automated, and Performance)
Code quality and structure
Scalability (can your solution easily scale to millions of transactions per day?)
Extensibility (how would you add additional endpoints?)
Modern practices
Cloud/Container friendly (deployment and DevOps pipeline are some examples)
Implement using the following API’s:
For all APIs, please include error handling for scenarios with incorrect or incomplete request data
POST /auctionItems
Example Request Body:
{
	“reservePrice”: 10450.00,
	“item”: {
		“itemId”: “abcd”,
		“description”: “item description”
	}
}

Example Response:
{
	"auctionItemId": "1234"
}

GET /auctionItems
Example Response:
{
	[
{
	“auctionItemId”: “1234”,
	“currentBid”: 0.00,
	“reservePrice”: 10450.00,
	“item”: {
		“itemId”: “abcd”,
		“description”: “item description”
	}
},
{
	“auctionItemId”: “1235”,
	“currentBid”: 2950.00,
	“bidderName”: “ABC Dealership”
“reservePrice”: 2499.00,
	“item”: {
		“itemId”: “efgh”,
		“description”: “another item description”
	}
}
	]
}

GET /auctionItems/{auctionItemId}
Example Response:
{
	“auctionItemId”: “1234”,
	“currentBid”: 0.00,
	“reservePrice”: 10450.00,
	“item”: {
		“itemId”: “abcd”,
		“description”: “item description”
	}
}

POST /bids
Example Request Body:
{
	“auctionItemId”: “1234”,
	“maxAutoBidAmount”: 9500.00,
	“bidderName”: “ABC Dealership”
}

Bid Rules:
If the reserve price has not been met, current bid should be set to the maximum of the current bid and the max auto-bid amount – an exception should be returned letting the bidder know they have not met the reserve.
Once the reserve price has been met, max auto-bid amount becomes the max amount bidder is willing to pay but not necessarily the amount they must pay. As new bids are submitted for an item, bidder with the highest max auto-bid amount must only pay $1.00 more than the next highest bidder. It is important to remember the bid leaders max auto-bid amount in case future bids are submitted for the item. Any time a bidder has been outbid, an event/exception should be broadcast notifying them that they’ve been outbid.
Make sure you keep an audit log of all bidding
