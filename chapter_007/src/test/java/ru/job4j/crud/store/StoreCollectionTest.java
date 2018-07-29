package ru.job4j.crud.store;

import ru.job4j.crud.pojo.User;

import java.util.List;

/**
 * @author Yury Matskevich
 */
public class StoreCollectionTest extends StoreTest {
	private Store store;

	@Override
	protected Store getStore() {
		store = MemoryStore.getInstance();
		return store;
	}

	@Override
	protected void settingUpBefore() {
		//
	}

	@Override
	protected void settingUpAfter() {
		List<User> users = store.findAll();
		if (!users.isEmpty()) {
			for (User user : users) {
				store.delete(user.getId());
			}
		}
	}
}
