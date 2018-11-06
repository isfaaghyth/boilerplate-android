package app.isfaaghyth.utildroid;

import app.isfaaghyth.utildroid.util.Global;

public class Main {

    public static void main(String[] args) {
        String option = "--fragment";
        String packageName = "isfa.ganteng.banget";
        String className = "ui.fragment.login";

        switch (option) {
            case "--fragment":
                option = Global.Prefix.INSTANCE.getFRAGMENT();
                break;
            case "--activity":
                option = Global.Prefix.INSTANCE.getACTIVITY();
                break;
        }

        new App(packageName, className)
                .generate(option)
                .mvp()
                .layout();
    }

}
