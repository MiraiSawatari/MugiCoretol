package Musicaly;

import Musicaly.Listener.LeaveMusicaly;
import Musicaly.Listener.PauseAdventure;
import Musicaly.Listener.StartAdventure;
import Musicaly.Listener.WantsMusic;
import Musicaly.Util.Directory;
import Musicaly.Util.LoadSongs;
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
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import net.raidstone.wgevents.events.RegionEnteredEvent;
import net.raidstone.wgevents.events.RegionLeftEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import Musicaly.Commands.Music;
import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin implements Listener {
    public static Main instance;
    public static FileConfiguration config = null;
    public static HashMap<String, Song> songs = new HashMap();
    public static HashMap<Player, RadioSongPlayer> song = new HashMap();



    public void onEnable() {
        // config.ymlが存在しない場合はファイルに出力します。
        Directory dic = new Directory();
        dic.setup();
        saveDefaultConfig();
        config = getConfig();
        instance = this;
        LoadSongs load = new LoadSongs();
        load.doIt();
        getCommand("music").setExecutor(new Music());
        getCommand("music").setTabCompleter(new Musicaly.Tab.Music());
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
        pm.registerEvents(new StartAdventure(), this);
        pm.registerEvents(new PauseAdventure(), this);
        pm.registerEvents(new WantsMusic(), this);
        pm.registerEvents(new LeaveMusicaly(), this);
    }
}