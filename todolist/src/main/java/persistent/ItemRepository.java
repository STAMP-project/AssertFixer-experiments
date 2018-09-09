package persistent;

import java.util.List;
public interface ItemRepository<Item> {
    List<Item> findAll();
    List<Item> findAllDone();
    public Item save(Item item);
}
