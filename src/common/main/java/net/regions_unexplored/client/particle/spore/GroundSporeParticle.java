package net.regions_unexplored.client.particle.spore;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class GroundSporeParticle extends TextureSheetParticle {
    protected GroundSporeParticle(ClientLevel level, double x, double y, double z, double xa, double ya, double za, SpriteSet sprites) {
        super(level, x, y, z, xa, ya, za);
        this.pickSprite(sprites);
        float brightness = this.random.nextFloat() * 0.2f;
        this.rCol = brightness;
        this.gCol = brightness * 1.25f + 0.7f;
        this.bCol = brightness * 1.75f + 0.3f;
        this.setSize(0.02f, 0.02f);
        this.quadSize *= this.random.nextFloat() * 0.6f + 0.5f;
        this.xd *= 0.02f;
        this.yd *= 0.02f;
        this.zd *= 0.02f;
        this.lifetime = (int)(20 / ((double)this.random.nextFloat() * 0.8 + 0.2));
    }

    @Override
    public void move(double xa, double ya, double za) {
        this.setBoundingBox(this.getBoundingBox().move(xa, ya, za));
        this.setLocationFromBoundingbox();
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
            return;
        }
        this.move(this.xd, this.yd, this.zd);
        this.xd *= 0.99;
        this.yd *= 0.99;
        this.zd *= 0.99;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType option, ClientLevel level, double x, double y, double z, double xAux, double yAux, double zAux) {
            return new GroundSporeParticle(level, x, y, z, xAux, yAux, zAux, this.sprites);
        }
    }
}
