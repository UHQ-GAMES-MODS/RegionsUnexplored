package net.regions_unexplored.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class MycotoxicSporeParticle extends TextureSheetParticle {
    public static MycotoxicSporeParticleProvider provider(SpriteSet spriteSet) {
        return new MycotoxicSporeParticleProvider(spriteSet);
    }

    public static class MycotoxicSporeParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public MycotoxicSporeParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
                                       double zSpeed) {
            return new MycotoxicSporeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }

    private final SpriteSet spriteSet;

    private float angularVelocity;
    private float angularAcceleration;

    protected MycotoxicSporeParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.spriteSet = spriteSet;
        this.setSize(0.2f, 0.2f);
        this.quadSize *= 1.25f;
        this.lifetime = (int) Math.max(1, 90 + (this.random.nextInt(20) - 10));
        this.gravity = -0.075f;
        this.hasPhysics = false;
        this.xd = vx * 10;
        this.yd = vy * 10;
        this.zd = vz * 10;
        this.angularVelocity = 0.000f;
        this.angularAcceleration = 0.000f;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        this.roll += this.angularVelocity;
        this.angularVelocity += this.angularAcceleration;
        if (!this.removed) {
            this.setSprite(this.spriteSet.get((this.age / 10) % 8 + 1, 8));
        }
    }
}

