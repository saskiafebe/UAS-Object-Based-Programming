package com.espada;

import java.util.prefs.Preferences;

public class RegistryKey {
   private static Preferences userRoot;
   private Preferences prefs;
 
   public RegistryKey()
   {
      userRoot = Preferences.userRoot();
      prefs = userRoot.node(this.getClass().getName());
   }
   
   public void setKeyString(String key, String value){
       prefs.put(key, value);
   }
   
   public void setKeyBoolean(String key, boolean value){
       prefs.putBoolean(key, value);
   }
   
   public String getKeyString(String key){
       String temp = prefs.get(key, key);
       return temp;
   }
   
   public boolean getKeyBoolean(String key){
       boolean temp = prefs.getBoolean(key, false);
       return temp;
   }
 
}
