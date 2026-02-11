package net.regions_unexplored.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.util.Mth;

public class FloatingHyacinthParticle extends TextureSheetParticle {
    FloatingHyacinthParticle(ClientLevel level, SpriteSet sprites, double x, double y, double z, double xa, double ya, double za) {
        super(level, x, y - (double)0.125F, z, xa, ya, za);
        this.setSize(0.01F, 0.01F);
        this.pickSprite(sprites);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
        this.lifetime = (int)(16.0F / (this.random.nextFloat() * 0.8 + 0.2));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = -0.01F;
    }

    @Override
    public int getLightColor(float color) {
        return 240;
    }

    @Override
    public void tick() {
        if (this.level.getFluidState(BlockPos.containing(this.x, this.y + 0.25, this.z)).isEmpty()) {
            this.remove();
        }
        super.tick();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<ColorParticleOption> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(ColorParticleOption options, ClientLevel level, double x, double y, double z, double xa, double ya, double za) {
            var particle = new FloatingHyacinthParticle(level, this.sprites, x, y, z, 0.0F, -0.8F, 0.0F);
            particle.lifetime = Mth.randomBetweenInclusive(level.random, 500, 1000);
            particle.scale(2.0f);
            particle.setColor(options.getRed(), options.getGreen(), options.getBlue());
            return particle;
        }
    }
}
