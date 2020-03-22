INSERT INTO AuctionHouse.item_info (description,reserve_price) VaLUES('Rare cup', 10.00);
-- Using below trigger to track bids
Delimiter //
CREATE Trigger insert_bid_after_update
AFTER Update
On AuctionHouse.item_info FOR EACH Row
BEGIN
	INSERT INTO AuctionHouse.bids (item_description,reserve_price,item_id,date_added) VALUES(new.description,new.reserve_price,new.id,current_timestamp());
END //
Delimiter ;