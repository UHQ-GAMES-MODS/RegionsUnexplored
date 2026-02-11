plugins {
    kotlin("jvm") version "2.1.21"
    id("earth.terrarium.cloche") version "0.18.1"
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
version = "0.6+indev"

cloche {
    targets.all {
        mappings {
            official()
            custom(minecraftVersion.map {
                project.dependencies.create(files("mappings/$it.tiny"))
            })
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
            implementation("com.electronwill.night-config:core:3.8.3")
            implementation("com.electronwill.night-config:toml:3.8.3")
            modImplementation("com.terraformersmc:biolith-neoforge:3.0.10")
        }

        data()

        metadata {
            dependencies {
                dependency {
                    modId = "biolith"
                }
                dependency {
                    modId = "lithostitched"
                }
            }
        }
    }

    val shared21 = common("shared:21.1") {
        //mixins.from(file("src/shared/21.1/main/regions_unexplored.21.1.mixins.json"))
    }

    fabric("fabric:21.1") {
        dependsOn(shared21)
        mixins.from(file("src/fabric/21.1/main/regions_unexplored.fabric.mixins.json"))

        loaderVersion = "0.18.4"
        minecraftVersion = "1.21.1"

        dependencies {
            fabricApi("0.116.8")
            modApi("com.terraformersmc:biolith-fabric:3.0.10")
            modRuntimeOnly("maven.modrinth:world-preview:qc0AtV3T")
            modImplementation("maven.modrinth:lithostitched:1.5.7-fabric-1.21.1")

            modImplementation("com.terraformersmc:modmenu:11.0.3")
        }

        data()
        datagenDirectory = file("src/shared/21.1/main/generated")

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
            entrypoint("client") {
                value = "net.regions_unexplored.client.RegionsUnexploredFabricClient"
            }
            entrypoint("modmenu") {
                value = "net.regions_unexplored.compat.ModMenuIntegration"
            }
        }
    }

    neoforge("neoforge:21.1") {
        dependsOn(shared21)

        mixins.from(file("src/neoforge/21.1/main/regions_unexplored.neoforge.mixins.json"))
        loaderVersion = "21.1.218"
        minecraftVersion = "1.21.1"

        dependencies {
            modApi("com.terraformersmc:biolith-neoforge:3.0.10")
            modImplementation("maven.modrinth:lithostitched:1.5.7-neoforge-1.21.1")
        }

        data()
        datagenDirectory = file("src/shared/21.1/main/generated")

        runs {
            client()
            server()
            data()
        }
    }
}