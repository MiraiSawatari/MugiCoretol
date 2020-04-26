package Musicaly.Listener;

import Musicaly.Fade.Fadeout;
import Musicaly.Main;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import net.raidstone.wgevents.events.RegionLeftEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class LeaveMusicaly implements Listener {
    @EventHandler
    public void onLeaveMusically(RegionLeftEvent e){
        Player p = Bukkit.getPlayer(e.getUUID());
        String region = e.getRegionName();
        p.sendMessage(region);

        if(Main.config.getConfigurationSection("regions").contains(region)){
            ConfigurationSection cs = Main.config.getConfigurationSection("regions").getConfigurationSection(region);
            String file = cs.getString("song");
            if(Main.song.containsKey(p)) {
                RadioSongPlayer rsp = Main.song.get(p);

Fadeout fade = new Fadeout();
Fadeout.doIt(rsp,p);
            }
        }
    }
}
