create schema auction;

CREATE TABLE auction (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 starting_price DECIMAL(19, 2) NOT NULL,
                                 min_bid DECIMAL(19, 2) NOT NULL,
                                 current_bid DECIMAL(19, 2) NOT NULL,
                                 auction_name VARCHAR(255) NOT NULL,
                                 auction_start TIMESTAMP NOT NULL
);

INSERT INTO auction (starting_price, min_bid, current_bid, auction_name, auction_start)
VALUES (200.00, 20.00, 200.00, 'Auction 2', TIMESTAMP '2023-10-02 12:00:00');
