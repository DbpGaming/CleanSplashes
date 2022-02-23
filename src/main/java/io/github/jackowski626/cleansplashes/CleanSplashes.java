package io.github.jackowski626.cleansplashes;

import io.github.jackowski626.splashesapi.SplashesAPI;
import net.fabricmc.api.ModInitializer;

public class CleanSplashes implements ModInitializer {
    @Override
    public void onInitialize() {
		String[] splashesToAdd = {"Notch <3 ez!", "Made by Notch!", "The Work of Notch!", "110813!", "Sexy!"};
		for (String s : splashesToAdd) {
			SplashesAPI.addSplash(s);
		}
		
		String[] splashesToRemove = {"Black lives matter!", "Be anti-racist!","Learn about allyship!", "Speak OUT against injustice and UP for equality!", "Amplify and listen to BIPOC voices!", "Educate your friends on anti-racism!", "Support the BIPOC community and creators!", "Stand up for equality in your community!"};
		for (String s : splashesToRemove) {
			SplashesAPI.removeSplash(s);
		}
    }
}
