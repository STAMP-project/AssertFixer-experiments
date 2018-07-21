/*

 */
package us.tastybento.bskyblock.listeners.flags;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerTeleportEvent;

import us.tastybento.bskyblock.api.flags.AbstractFlagListener;
import us.tastybento.bskyblock.lists.Flags;

/**
 * Removes mobs when teleporting to an island
 * @author tastybento
 *
 */
public class RemoveMobsListener extends AbstractFlagListener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onUserTeleport(PlayerTeleportEvent e) {
        // Only process if flag is active
        if (getIslands().locationIsOnIsland(e.getPlayer(), e.getTo()) && Flags.REMOVE_MOBS.isSetForWorld(e.getTo().getWorld())) {
            getIslands().clearArea(e.getTo());
        }
    }
}
