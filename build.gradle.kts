plugins {
    kotlin("jvm") version "2.1.21"
    id("earth.terrarium.cloche") version "0.17.1"
}

repositories {
    cloche {
        mavenNeoforgedMeta()
        mavenNeoforged()
        mavenForge()
        mavenFabric()
        mavenParchment()
        librariesMinecraft()
        main()
    }
    mavenLocal()
    mavenCentral()
    maven("https://api.modrinth.com/maven")
    maven("https://maven.terraformersmc.com/")
    maven("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/")
}

group = "net.regions_unexplored"
version = "0.5.8"

cloche {
    targets.all {
        mappings {
            official()
            // TODO: Re-enable when Terrablender is removed
            //custom(minecraftVersion.map {
            //    project.dependencies.create(files("mappings/$it.tiny"))
            //})
        }
    }

    metadata {
        modId = "regions_unexplored"
        name = "Regions Unexplored"
        description = "Regions Unexplored is a mod that aims to add new content to the overworld and nether. Currently, adds almost 70 new biomes!"
        license = "All Rights Reserved"
        icon = "pack.png"

        url = "https://modrinth.com/mod/regions-unexplored"
        issues = "https://github.com/UHQ-GAMES-MODS/RegionsUnexplored/issues"
        sources = "https://github.com/UHQ-GAMES-MODS/RegionsUnexplored"

        author("UHQ_Games")
        author("KirboSoftware")
        author("Apollo")
    }

    common {
        mixins.from(file("src/common/main/regions_unexplored.mixins.json"))
        accessWideners.from(file("src/common/main/regions_unexplored.accesswidener"))

        dependencies {
            compileOnly("org.spongepowered:mixin:0.8.5")
            compileOnly("com.github.glitchfiend:TerraBlender-common:1.21.1-4.1.0.8")
            api("fuzs.forgeconfigapiport:forgeconfigapiport-common-neoforgeapi:21.1.6")
        }

        data()

        metadata {
            dependencies {
                dependency {
                    modId = "terrablender"
                }
            }
        }
    }

    fabric {
        mixins.from(file("src/fabric/main/regions_unexplored.fabric.mixins.json"))

        loaderVersion = "0.17.3"
        minecraftVersion = "1.21.1"

        dependencies {
            fabricApi("0.116.1")
            modImplementation("com.github.glitchfiend:TerraBlender-fabric:1.21.1-4.1.0.8")
            modApi("fuzs.forgeconfigapiport:forgeconfigapiport-fabric:21.1.6")
            modImplementation("maven.modrinth:lithostitched:1.5.2-fabric-1.21.1")

            modImplementation("com.terraformersmc:modmenu:11.0.3")
        }

        data()
        datagenDirectory = file("src/common/main/generated")

        includedClient()
        runs {
            client()
            server()
            data()
        }

        metadata {
            entrypoint("main") {
                value = "net.regions_unexplored.RegionsUnexploredFabric"
            }
            entrypoint("terrablender") {
                value = "net.regions_unexplored.RegionsUnexploredFabric"
            }
            entrypoint("client") {
                value = "net.regions_unexplored.client.RegionsUnexploredFabricClient"
            }
            entrypoint("modmenu") {
                value = "net.regions_unexplored.compat.ModMenuIntegration"
            }
        }
    }
    neoforge {
        mixins.from(file("src/neoforge/main/regions_unexplored.neoforge.mixins.json"))
        loaderVersion = "21.1.209"
        minecraftVersion = "1.21.1"

        dependencies {
            modImplementation("com.github.glitchfiend:TerraBlender-neoforge:1.21.1-4.1.0.8")
            modImplementation("maven.modrinth:lithostitched:1.5.2-neoforge-1.21.1")
        }

        data()
        datagenDirectory = file("src/common/main/generated")

        runs {
            client()
            server()
            data()
        }
    }
}