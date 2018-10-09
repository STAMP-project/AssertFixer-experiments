package de.terrestris.shogun2.model.token;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import de.terrestris.shogun2.model.User;

/**
 * A {@link Token} instance that has a one-to-one relation to a {@link User}
 * that wants to reset the password.
 *
 * @author Daniel Koch
 * @author Nils Bühner
 */
@Entity
@Table
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PasswordResetToken extends UserToken {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor
     */
    public PasswordResetToken() {
    }

    /**
     * Constructor that uses the default expiration time.
     */
    public PasswordResetToken(User user) {
        super(user);
    }

    /**
     * Constructor that uses the passed values
     */
    public PasswordResetToken(User user, int expirationInMinutes) {
        super(user, expirationInMinutes);
    }

}
