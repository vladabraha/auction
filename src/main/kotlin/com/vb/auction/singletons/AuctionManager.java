package com.vb.auction.singletons;

import com.vb.auction.dto.AuctionDto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuctionManager {
    private static AuctionManager auctionManager;

    private final HashMap<String, Auction> auctions = new HashMap<>();
    private final HashMap<String, String> auctionNames = new HashMap<>();

    private AuctionManager() {
    }

    public static synchronized AuctionManager getAuctionManager() {
        if (auctionManager == null) {
            auctionManager = new AuctionManager();
        }
        return auctionManager;
    }

    public Map<String, Auction> getAuctions() {
        return auctions;
    }

    public Map<String, String> getAuctionsNames() {
        return auctionNames;
    }

    public AuctionDto createAuction(Auction auction) {
        String auctionID = UUID.randomUUID().toString();
        auctions.put(auctionID, auction);
        auctionNames.put(auction.getAuctionName(), auctionID);
        return new AuctionDto(auctionID, auction);
    }
}
