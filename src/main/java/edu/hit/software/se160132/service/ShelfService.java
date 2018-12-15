package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.*;

public interface ShelfService {
    Shelf createShelf(String name, String description, Long store);
    GoodsTrans createShelf2Shelf(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType);
    GoodsTrans createShelf2Cart(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType);
    GoodsTrans createCart2Shelf(Long creator, Long goods, Integer amount, Long from, Long to, Long cause, Integer causeType);
    ShelfItem createShelfItem(Long creator, Long goods, Long price, Long shelf);
    Shelf findShelfById(Long id);
    ShelfItem findShelfItemById(Long id);
}
