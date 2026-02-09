package net.regions_unexplored.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.regions_unexplored.client.color.RuColors;

public class PrismariteSparkleParticle extends SimpleAnimatedParticle {
    PrismariteSparkleParticle(ClientLevel level, double x, double y, double z, double xa, double ya, double za, SpriteSet sprites) {
        super(level, x, y, z, sprites, 0.1F);
        this.xd = xa;
        this.yd = ya;
        this.zd = za;
        this.quadSize *= 0.75F;
        this.lifetime = 48 + this.random.nextInt(24);
        this.gravity = 0;
        this.setSpriteFromAge(sprites);

        float multiplier = this.random.nextFloat() * 0.5f - 0.2f;
        this.rCol *= multiplier;
        this.gCol *= multiplier;
        this.bCol *= multiplier;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet $$0) {
            this.sprites = $$0;
        }

        public Particle createParticle(SimpleParticleType options, ClientLevel level, double x, double y, double z, double xa, double ya, double za) {
            var particle = new PrismariteSparkleParticle(level, x, y, z, xa, ya, za, this.sprites);
            particle.setAlpha(0.99f);
            int color = RuColors.getRainbowColor(BlockPos.containing(x, y, z));
            particle.setColor(color);
            return particle;
        }
    }
}