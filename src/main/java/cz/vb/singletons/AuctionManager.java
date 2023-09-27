package cz.vb.singletons;

import cz.vb.auction.dto.AuctionDto;
import cz.vb.auction.entity.AuctionEntity;
import cz.vb.auction.repository.AuctionEntityRepository;

import java.util.HashMap;
import java.util.Map;

public class AuctionManager {
    private static AuctionManager auctionManager;

    private final HashMap<String, AuctionEntity> auctions = new HashMap<>();
    private AuctionEntityRepository auctionEntityRepository;
    private final HashMap<String, String> auctionNames = new HashMap<>();

    private AuctionManager() {
    }

    public static synchronized AuctionManager getAuctionManager() {
        if (auctionManager == null) {
            auctionManager = new AuctionManager();
        }
        return auctionManager;
    }

    public Map<String, AuctionEntity> getAuctions() {
        return auctions;
    }

    public Map<String, String> getAuctionsNames() {
        return auctionNames;
    }

    public AuctionEntity createAuction(AuctionDto auctionDto) {
        var auction = new AuctionEntity(auctionDto);
        String id = String.valueOf(auction.getId());
        auctions.put(id, auction);
        auctionNames.put(id, auction.getAuctionName());
        return auction;
    }
}
