/**
 * 
 */
package us.tastybento.bskyblock.listeners.flags;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import us.tastybento.bskyblock.BSkyBlock;
import us.tastybento.bskyblock.Settings;
import us.tastybento.bskyblock.api.configuration.WorldSettings;
import us.tastybento.bskyblock.api.user.User;
import us.tastybento.bskyblock.lists.Flags;
import us.tastybento.bskyblock.managers.IslandWorldManager;
import us.tastybento.bskyblock.managers.IslandsManager;
import us.tastybento.bskyblock.util.Util;

/**
 * @author tastybento
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( {BSkyBlock.class, Flags.class, Util.class })
public class IslandRespawnListenerTest {

    private World world;
    private Player player;
    private IslandsManager im;
    private IslandWorldManager iwm;
    private Location safeLocation;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Set up plugin
        BSkyBlock plugin = mock(BSkyBlock.class);
        Whitebox.setInternalState(BSkyBlock.class, "instance", plugin);

        // World
        world = mock(World.class);

        // Settings
        Settings s = mock(Settings.class);
        when(plugin.getSettings()).thenReturn(s);

        // Player
        player = mock(Player.class);
        when(player.getWorld()).thenReturn(world);
        when(player.getUniqueId()).thenReturn(UUID.randomUUID());
        when(player.getLocation()).thenReturn(mock(Location.class));

        // Island World Manager
        iwm = mock(IslandWorldManager.class);
        // All locations are in world by default
        when(iwm.inWorld(Mockito.any())).thenReturn(true);
        when(plugin.getIWM()).thenReturn(iwm);

        PowerMockito.mockStatic(Util.class);
        when(Util.getWorld(Mockito.any())).thenReturn(world);
        
        // World Settings
        WorldSettings ws = mock(WorldSettings.class);
        when(iwm.getWorldSettings(Mockito.any())).thenReturn(ws);
        Map<String, Boolean> worldFlags = new HashMap<>();
        when(ws.getWorldFlags()).thenReturn(worldFlags);

        im = mock(IslandsManager.class);
        when(im.hasIsland(Mockito.any(), Mockito.any(UUID.class))).thenReturn(true);
        when(plugin.getIslands()).thenReturn(im);
        safeLocation = mock(Location.class);
        when(safeLocation.getWorld()).thenReturn(world);
        when(im.getSafeHomeLocation(Mockito.any(), Mockito.any(), Mockito.anyInt())).thenReturn(safeLocation);
        
     // Sometimes use Mockito.withSettings().verboseLogging()
        User.setPlugin(plugin);
        User.getInstance(player);
    }

    /**
     * Test method for {@link us.tastybento.bskyblock.listeners.flags.IslandRespawnListener#onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent)}.
     */
    @Test
    public void testOnPlayerDeath() {
        List<ItemStack> drops = new ArrayList<>();
        PlayerDeathEvent e = new PlayerDeathEvent(player, drops, 0, 0, 0, 0, "");
        new IslandRespawnListener().onPlayerDeath(e);
    }

    /**
     * Test method for {@link us.tastybento.bskyblock.listeners.flags.IslandRespawnListener#onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent)}.
     */
    @Test
    public void testOnPlayerRespawn() {
        // Die
        List<ItemStack> drops = new ArrayList<>();
        PlayerDeathEvent e = new PlayerDeathEvent(player, drops, 0, 0, 0, 0, "");
        IslandRespawnListener l = new IslandRespawnListener();
        l.onPlayerDeath(e);
        Location location = mock(Location.class);
        when(location.getWorld()).thenReturn(world);
        // Has island
        when(im.hasIsland(Mockito.any(), Mockito.any(UUID.class))).thenReturn(true);
        // Respawn
        PlayerRespawnEvent ev = new PlayerRespawnEvent(player, location, false);
        l.onPlayerRespawn(ev);
        assertEquals(safeLocation, ev.getRespawnLocation());
    }
    
    /**
     * Test method for {@link us.tastybento.bskyblock.listeners.flags.IslandRespawnListener#onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent)}.
     */
    @Test
    public void testOnPlayerRespawnWithoutDeath() {
        IslandRespawnListener l = new IslandRespawnListener();
        Location location = mock(Location.class);
        when(location.getWorld()).thenReturn(world);
        // Has island
        when(im.hasIsland(Mockito.any(), Mockito.any(UUID.class))).thenReturn(true);
        // Respawn
        PlayerRespawnEvent ev = new PlayerRespawnEvent(player, location, false);
        l.onPlayerRespawn(ev);
        assertEquals(location, ev.getRespawnLocation());
    }

    
    /**
     * Test method for {@link us.tastybento.bskyblock.listeners.flags.IslandRespawnListener#onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent)}.
     */
    @Test
    public void testOnPlayerRespawnWrongWorld() {
        when(iwm.inWorld(Mockito.any())).thenReturn(false);
        // Die
        List<ItemStack> drops = new ArrayList<>();
        PlayerDeathEvent e = new PlayerDeathEvent(player, drops, 0, 0, 0, 0, "");
        IslandRespawnListener l = new IslandRespawnListener();
        l.onPlayerDeath(e);
        Location location = mock(Location.class);
        when(location.getWorld()).thenReturn(world);
        // Has island
        when(im.hasIsland(Mockito.any(), Mockito.any(UUID.class))).thenReturn(true);
        // Respawn
        PlayerRespawnEvent ev = new PlayerRespawnEvent(player, location, false);
        l.onPlayerRespawn(ev);
        assertEquals(location, ev.getRespawnLocation());
    }
    
    /**
     * Test method for {@link us.tastybento.bskyblock.listeners.flags.IslandRespawnListener#onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent)}.
     */
    @Test
    public void testOnPlayerRespawnFlagNotSet() {
        Flags.ISLAND_RESPAWN.setSetting(world, false);
        // Die
        List<ItemStack> drops = new ArrayList<>();
        PlayerDeathEvent e = new PlayerDeathEvent(player, drops, 0, 0, 0, 0, "");
        IslandRespawnListener l = new IslandRespawnListener();
        l.onPlayerDeath(e);
        Location location = mock(Location.class);
        when(location.getWorld()).thenReturn(world);
        // Has island
        when(im.hasIsland(Mockito.any(), Mockito.any(UUID.class))).thenReturn(true);
        // Respawn
        PlayerRespawnEvent ev = new PlayerRespawnEvent(player, location, false);
        l.onPlayerRespawn(ev);
        assertEquals(location, ev.getRespawnLocation());
    }
}
