package Musicaly.Fade;

import Musicaly.Main;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Fadeout {
    RadioSongPlayer rsp;
    Player p;
    //コンストラクタ
    public Fadeout(){
        this.p = p;

    }
    public static void doIt(RadioSongPlayer rsp,Player p){
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 80);
            }
        },5);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 70);
            }
        },10);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 60);
            }
        },15);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 50);
            }
        },20);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 40);
            }
        },25);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 30);
            }
        },30);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 20);
            }
        },35);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 10);
            }
        },40);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 5);
            }
        },45);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 3);
            }
        },50);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setVolume((byte) 1);
            }
        },55);
        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
            @Override
            public void run() {
                rsp.setPlaying(false);
                rsp.removePlayer(p);
                rsp.destroy();
                Main.song.remove(p);
            }
        },56);

    }
}
