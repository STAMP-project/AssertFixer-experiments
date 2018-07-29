package ru.job4j.crud.store;

import ru.job4j.crud.setting.SettingUpDb;

/**
 * @author Yury Matskevich
 */
public class DbStoreTest extends StoreTest {
	private SettingUpDb settingUpDb = new SettingUpDb();

	@Override
	protected Store getStore() {
		return DbStore.getInstance();
	}

	@Override
	protected void settingUpBefore() {
		settingUpDb.fillDb();
	}

	@Override
	protected void settingUpAfter() {
		settingUpDb.clearDb();
	}
}
