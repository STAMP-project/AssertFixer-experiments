package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StoreTest {

    AbstractStore<User> userStore = new UserStore(2);
    AbstractStore<Role> roleStore = new RoleStore(2);
    User user1 = new User("111");
    Base baseRole = new Role("222");
    Role role1 = new Role("333");
    Base baseUser = new User("444");

    /**
     * This part checks User container.
     */
    @Test
    public void whenCreteNewUserStoreViaAbstractThenCreated() {
        userStore.add(user1);
        assertThat(user1.getId(), is(userStore.findById("111").getId()));
    }

    @Test(expected = NullPointerException.class)
    public void whenDeleteUserThenGetNull() {
        userStore.add(user1);
        userStore.delete(user1.getId());
        userStore.findById(user1.getId());
    }

    @Test
    public void whenReplaceUserStoreViaAbstractThenReplaced() {
        userStore.add(user1);
        User user2 = new User("666");
        userStore.replace("111", user2);
        assertThat(user2.getId(), is(userStore.findById("666").getId()));
    }

    /**
     * This part checks Role container.
     */
    @Test
    public void whenCreteNewRoleStoreViaAbstractThenCreated() {
        roleStore.add(role1);
        assertThat(role1.getId(), is(roleStore.findById("333").getId()));
    }

    @Test(expected = NullPointerException.class)
    public void whenDeleteRoleThenGetNull() {
        roleStore.add(role1);
        roleStore.delete(role1.getId());
        roleStore.findById(role1.getId());
    }

    @Test
    public void whenReplaceRoleStoreViaAbstractThenReplaced() {
        roleStore.add(role1);
        Role role2 = new Role("666");
        roleStore.replace("333", role2);
        assertThat(role2.getId(), is(roleStore.findById("666").getId()));
    }

    /**
     * This part checks Class types Exceptions.
     * has deleted with refactoring
     */


}
