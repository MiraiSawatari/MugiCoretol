package Musicaly.Listener;

import Musicaly.Main;
import Musicaly.Util.Start;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.model.RepeatMode;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoStereoMode;
import com.xxmicloxx.NoteBlockAPI.songplayer.Fade;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import org.bukkit.event.Listener;

public class StartAdventure implements Listener {
    @EventHandler
    public void onPlayerStartAdventure(PlayerJoinEvent e){
        Player p = e.getPlayer();
        for (ProtectedRegion rg : WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery().getApplicableRegions(BukkitAdapter.adapt(p.getLocation()))) {
            if(Main.config.getConfigurationSection("regions").contains(rg.getId())) {
                ConfigurationSection cs = Main.config.getConfigurationSection("regions").getConfigurationSection(rg.getId());
                String file = cs.getString("song");
                ConfigurationSection cs2 = Main.config.getConfigurationSection("songs").getConfigurationSection(file);
                Song song = Main.songs.get(file);
                Start s = new Start();
                s.doIt(song,p,cs2);
            }
            }
        }

    }

