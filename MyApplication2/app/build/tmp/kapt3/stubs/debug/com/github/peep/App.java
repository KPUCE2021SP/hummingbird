package com.github.peep;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/github/peep/App;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class App extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.github.peep.App.Companion Companion = null;
    public static com.github.peep.MySharedPreferences prefs;
    
    public App() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/github/peep/App$Companion;", "", "()V", "prefs", "Lcom/github/peep/MySharedPreferences;", "getPrefs", "()Lcom/github/peep/MySharedPreferences;", "setPrefs", "(Lcom/github/peep/MySharedPreferences;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.github.peep.MySharedPreferences getPrefs() {
            return null;
        }
        
        public final void setPrefs(@org.jetbrains.annotations.NotNull()
        com.github.peep.MySharedPreferences p0) {
        }
    }
}