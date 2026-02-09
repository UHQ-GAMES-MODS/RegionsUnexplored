package net.regions_unexplored.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class RULeavesParticle extends TextureSheetParticle {
    private static final float ACCELERATION_SCALE = 0.0025f;
    private static final int INITIAL_LIFETIME = 300;
    private static final int CURVE_ENDPOINT_TIME = 300;
    private float rotSpeed;
    private int ticksOnGround;
    private final float spinAcceleration;
    private final float windBig;
    private final boolean swirl;
    private final boolean flowAway;
    private final double xaFlowScale;
    private final double zaFlowScale;
    private final double swirlPeriod;

    protected RULeavesParticle(ClientLevel level, double x, double y, double z, SpriteSet sprites, float fallAcceleration, float sideAcceleration, boolean swirl, boolean flowAway, float scale, float startVelocity) {
        super(level, x, y, z);
        this.pickSprite(sprites);
        float size;
        this.rotSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
        this.windBig = sideAcceleration;
        this.swirl = swirl;
        this.flowAway = flowAway;
        this.lifetime = 300;
        this.gravity = fallAcceleration * 1.2f * 0.0025f;
        this.quadSize = size = scale * (this.random.nextBoolean() ? 0.05f : 0.075f);
        this.setSize(size, size);
        this.friction = 1.0f;
        this.yd = -startVelocity;
        float particleRandom = this.random.nextFloat();
        this.xaFlowScale = Math.cos(Math.toRadians(particleRandom * 60.0f)) * (double)this.windBig;
        this.zaFlowScale = Math.sin(Math.toRadians(particleRandom * 60.0f)) * (double)this.windBig;
        this.swirlPeriod = Math.toRadians(1000.0f + particleRandom * 3000.0f);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        }
        if (this.removed) {
            return;
        }
        float aliveTicks = 300 - this.lifetime;
        float relativeAge = Math.min(aliveTicks / 300.0f, 1.0f);
        double xa = 0.0;
        double za = 0.0;
        if (this.flowAway) {
            xa += this.xaFlowScale * Math.pow(relativeAge, 1.25);
            za += this.zaFlowScale * Math.pow(relativeAge, 1.25);
        }
        if (this.swirl) {
            xa += (double)relativeAge * Math.cos((double)relativeAge * this.swirlPeriod) * (double)this.windBig;
            za += (double)relativeAge * Math.sin((double)relativeAge * this.swirlPeriod) * (double)this.windBig;
        }
        this.xd += xa * (double)0.0025f;
        this.zd += za * (double)0.0025f;
        this.yd -= this.gravity;
        this.rotSpeed += this.spinAcceleration / 20.0f;
        this.oRoll = this.roll;
        if (this.onGround || this.lifetime < 299 && (this.xd == 0.0 || this.zd == 0.0)) {
            this.ticksOnGround++;
            if (this.ticksOnGround >= 10) {
                this.alpha = 1f - ((this.ticksOnGround - 10f) / 10f);
                if (this.ticksOnGround >= 20) {
                    this.remove();
                }
            }
        } else {
            this.ticksOnGround = 0;
            this.roll += this.rotSpeed / 20.0f;
            this.move(this.xd, this.yd, this.zd);
        }
        if (this.removed) {
            return;
        }
        this.xd *= this.friction;
        this.yd *= this.friction;
        this.zd *= this.friction;
    }

    public static class Provider<T extends ParticleOptions> implements ParticleProvider<T> {
        private final SpriteSet sprites;
        private final float fallAcceleration;
        private final float sideAcceleration;
        private final boolean swirl;
        private final boolean flowAway;
        private final float scale;
        private final float startVelocity;

        public Provider(SpriteSet sprites, float fallAcceleration, float sideAcceleration, boolean swirl, boolean flowAway, float scale, float startVelocity) {
            this.sprites = sprites;
            this.fallAcceleration = fallAcceleration;
            this.sideAcceleration = sideAcceleration;
            this.swirl = swirl;
            this.flowAway = flowAway;
            this.scale = scale;
            this.startVelocity = startVelocity;
        }

        public static <T extends ParticleOptions> Provider<T> flowing(SpriteSet sprites) {
            return new Provider<>(sprites, 0.25f, 2.0f, false, true, 1.0f, 0.0f);
        }

        public static <T extends ParticleOptions> Provider<T> swirling(SpriteSet sprites) {
            return new Provider<>(sprites, 0.07f, 10.0f, true, false, 2.0f, 0.021f);
        }

        public static <T extends ParticleOptions> Provider<T> large(SpriteSet sprites) {
            return new Provider<>(sprites, 0.12f, 6.0f, true, false, 2.5f, 0.04f);
        }

        public static <T extends ParticleOptions> Provider<T> magnolia(SpriteSet sprites) {
            return new Provider<>(sprites, 0.1f, 4.0f, false, true, 2.0f, 0.03f);
        }

        public static <T extends ParticleOptions> Provider<T> pine(SpriteSet sprites) {
            return new Provider<>(sprites, 0.3f, 3.0f, true, false, 2.0f, 0.0f);
        }

        @Nullable
        @Override
        public Particle createParticle(T options, ClientLevel level, double x, double y, double z, double xAux, double yAux, double zAux) {
            Particle particle = new RULeavesParticle(level, x, y, z, this.sprites, this.fallAcceleration, this.sideAcceleration, this.swirl, this.flowAway, this.scale, this.startVelocity);
            if (options instanceof ColorParticleOption colored) {
                particle.setColor(colored.getRed(), colored.getGreen(), colored.getBlue());
            }
            return particle;
        }
    }
}