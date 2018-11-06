package app.isfaaghyth.utildroid;

import app.isfaaghyth.utildroid.util.Global;
import app.isfaaghyth.utildroid.util.Util;

public class Main {

    public static void main(String[] args) {
        String option = "--fragment";
        String basePackage = "isfa.ganteng.banget";
        String appPackage = "ui.fragment.login";

        switch (option) {
            case "--fragment":
                option = Global.Prefix.INSTANCE.getFRAGMENT();
                break;
            case "--activity":
                option = Global.Prefix.INSTANCE.getACTIVITY();
                break;
        }

        new App(basePackage, appPackage)
                .generate(option)
                .mvp()
                .layout();
    }

}
