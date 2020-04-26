package Musicaly.Listener;

import Musicaly.Main;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PauseAdventure implements Listener {
    @EventHandler
    public void onPlayerPauseAdventure(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(Main.song.containsKey(p)){
            RadioSongPlayer rsp = Main.song.get(p);
            rsp.setPlaying(false);
            rsp.removePlayer(p);
            rsp.destroy();
            Main.song.remove(p);
        }

    }
}
