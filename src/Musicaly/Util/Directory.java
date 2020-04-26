package Musicaly.Util;

import java.io.File;

public class Directory {
    //コンストラクタ
    public Directory() {




    }
    public void setup(){
        File file2 = new File("plugins/musicoretol/musics/");
        if(file2.exists()){

        }else {
            file2.mkdirs();
        }
    }
}
