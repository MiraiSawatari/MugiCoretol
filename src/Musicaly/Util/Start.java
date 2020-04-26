package Musicaly.Util;

import Musicaly.Main;
import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.model.RepeatMode;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoStereoMode;
import com.xxmicloxx.NoteBlockAPI.songplayer.Fade;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Start {

        //コンストラクタ
        public Start() {




        }
        public void doIt(Song song, Player p, ConfigurationSection cs2){
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
