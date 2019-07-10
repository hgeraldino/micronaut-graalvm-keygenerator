package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@Controller("/keygen")
public class KeyGeneratorController {

    private final KeyPairGenerator keyPairGenerator;

    private final java.util.Base64.Encoder encoder;

    public KeyGeneratorController(KeyPairGenerator keyPairGenerator) {
        this.keyPairGenerator = keyPairGenerator;
        this.encoder = Base64.getEncoder();
    }

    @Get("/new")
    public Pair<String, String> newKey() {

        KeyPair kp = keyPairGenerator.genKeyPair();
        PrivateKey prvKey = kp.getPrivate();
        PublicKey pubKey = kp.getPublic();

        return Pair.create(encoder.encodeToString(prvKey.getEncoded()),
                encoder.encodeToString(pubKey.getEncoded()));
    }
}
