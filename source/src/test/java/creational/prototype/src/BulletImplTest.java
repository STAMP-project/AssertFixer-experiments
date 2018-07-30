package creational.prototype.src;

import creational.prototype.api.Projectile;
import creational.prototype.src.model.BulletImpl;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class BulletImplTest {

    private final String ref = "ref";
    private final int damage = 10;
    private final Point2D.Double position = new Point2D.Double(35, 54);
    private Projectile projectile;

    @Before
    public void setUp() throws Exception {
        projectile = new BulletImpl(".45", 5, new Point2D.Double(500.0, 123.0));
    }

    @After
    public void tearDown() throws Exception {
        projectile = null;
    }

    @Test
    public void testConfigure() throws Exception {
        Projectile missile = spy(projectile);
        missile.configure(ref, damage, position);
        verify(missile).configure(ref, damage, position);
    }

    @Test
    public void testRef() throws Exception {
        projectile.configure(ref, damage, position);
        Assert.assertEquals(ref, projectile.ref());
    }

    @Test
    public void testDamage() throws Exception {
        projectile.configure(ref, damage, position);
        Assert.assertEquals("not same", (int) damage, (int) projectile.damage());
    }

    @Test
    public void testPosition() throws Exception {
        projectile.configure(ref, damage, position);
        Assert.assertEquals("No Position", position, projectile.position());
    }

    @Test
    public void testUpdate() throws Exception {
        projectile.configure(ref, damage, position);
        Projectile missile = spy(projectile);
        missile.update(position);
        verify(missile).update(position);
    }

    @Test
    public void testClone() throws Exception {
        projectile.configure(ref, damage, position);
        final Projectile clone = projectile.clone();
        final String expected = "creational.prototype.src.model.ProjectileImpl";
        Assert.assertSame(clone.getClass().getName(), expected);
    }
}

