package Musicaly.Util;

import Musicaly.Main;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;

public class LoadSongs{
    public void doIt() {
        if(Main.config.contains("songs")) {
            for (String string : Main.config.getConfigurationSection("songs").getKeys(false)) {
                ConfigurationSection cs = Main.config.getConfigurationSection("songs").getConfigurationSection(string);
                String file = cs.getString("path");
                File path = new File(file);
                Song song = NBSDecoder.parse(path);
                Main.songs.put(string, song);
            }
        }
    }
}
