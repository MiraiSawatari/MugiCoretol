package Musicaly.Listener;

import Musicaly.Main;
import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.model.RepeatMode;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoStereoMode;
import com.xxmicloxx.NoteBlockAPI.songplayer.Fade;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import net.raidstone.wgevents.events.RegionEnteredEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class WantsMusic implements Listener {
    @EventHandler
    public void onWantsMusic(RegionEnteredEvent e){
        Player p = Bukkit.getPlayer(e.getUUID());
        String region = e.getRegionName();
        p.sendMessage(region);

        if(Main.config.getConfigurationSection("regions").contains(region)){
            if(Main.song.containsKey(p)) {
                Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                    @Override
                    public void run() {
                        ConfigurationSection cs = Main.config.getConfigurationSection("regions").getConfigurationSection(region);
                        String file = cs.getString("song");
                        ConfigurationSection cs2 = Main.config.getConfigurationSection("songs").getConfigurationSection(file);

                        Song song = Main.songs.get(file);
                        RadioSongPlayer rsp = new RadioSongPlayer(song);
                        Fade fadeIn = rsp.getFadeIn();
                        fadeIn.setType(FadeType.LINEAR);
                        fadeIn.setFadeDuration(cs2.getInt("fadeIn"));
                        Fade fadeOut = rsp.getFadeOut();
                        fadeOut.setType(FadeType.LINEAR);
                        fadeOut.setFadeDuration(cs2.getInt("fadeOut"));
                        rsp.setChannelMode(new MonoStereoMode());
                        rsp.setCategory(SoundCategory.RECORDS);
                        rsp.addPlayer(p);
                        rsp.setPlaying(true);
                        rsp.setRepeatMode(RepeatMode.ONE);
                        Main.song.put(p, rsp);
                    }
                },59);
            }else {
                ConfigurationSection cs = Main.config.getConfigurationSection("regions").getConfigurationSection(region);
                String file = cs.getString("song");
                ConfigurationSection cs2 = Main.config.getConfigurationSection("songs").getConfigurationSection(file);

                Song song = Main.songs.get(file);
                RadioSongPlayer rsp = new RadioSongPlayer(song);
                Fade fadeIn = rsp.getFadeIn();
                fadeIn.setType(FadeType.LINEAR);
                fadeIn.setFadeDuration(cs2.getInt("fadeIn"));
                Fade fadeOut = rsp.getFadeOut();
                fadeOut.setType(FadeType.LINEAR);
                fadeOut.setFadeDuration(cs2.getInt("fadeOut"));
                rsp.setChannelMode(new MonoStereoMode());
                rsp.setCategory(SoundCategory.RECORDS);
                rsp.addPlayer(p);
                rsp.setPlaying(true);
                rsp.setRepeatMode(RepeatMode.ONE);
                Main.song.put(p, rsp);
            }
        }
    }
}
