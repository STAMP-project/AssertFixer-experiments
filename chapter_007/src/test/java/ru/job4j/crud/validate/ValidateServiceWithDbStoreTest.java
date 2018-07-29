package ru.job4j.crud.validate;

import ru.job4j.crud.setting.SettingUpDb;
import ru.job4j.crud.store.DbStore;
import ru.job4j.crud.store.Store;

/**
 * @author Yury Matskevich
 */
public class ValidateServiceWithDbStoreTest extends ValidateServiceTest {
	private SettingUpDb settingUpDb = new SettingUpDb();

	@Override
	protected Validate getValidate() {
		return ValidateService.getInstance();
	}

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
