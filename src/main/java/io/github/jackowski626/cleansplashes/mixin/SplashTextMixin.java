package io.github.jackowski626.cleansplashes.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
@Mixin(net.minecraft.client.resource.SplashTextResourceSupplier.class)
public class SplashTextMixin {
    @Shadow
    private List<String> splashTexts;

    @Inject(method="apply", at=@At("TAIL"))
    private void test(CallbackInfo info) {
        List<String> politicalBullshit = Stream.of("Black lives matter!", "Be anti-racist!",
                "Learn about allyship!", "Speak OUT against injustice and UP for equality!", "Amplify and listen to BIPOC voices!", "Educate your friends on anti-racism!", "Support the BIPOC community and creators!", "Stand up for equality in your community!").collect(Collectors.toList());
        List<String> newSplashes = new ArrayList<>();
        for (String s : splashTexts) {
            if (!politicalBullshit.contains(s)) {
                newSplashes.add(s);
            }
        }
        splashTexts.clear();
        splashTexts.addAll(newSplashes);
    }
}
