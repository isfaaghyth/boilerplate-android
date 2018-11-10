package app.isfaaghyth.utildroid;

import app.isfaaghyth.utildroid.util.Global;

public class Main {

    public static void main(String[] args) {
        String option           = args[0];
        String basePackage      = args[1];
        String featurePackage   = args[2];

        switch (option) {
            case "--fragment":
                option = Global.Prefix.INSTANCE.getFRAGMENT();
                break;
            case "--activity":
                option = Global.Prefix.INSTANCE.getACTIVITY();
                break;
        }

        new App(basePackage, featurePackage)
                .generate(option, Global.Ext.INSTANCE.getKt())
                .mvp()
                .layout();
    }

}
