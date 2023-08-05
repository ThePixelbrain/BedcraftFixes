# BedcraftFixes

A forge mod fixing various bugs in 1.7.10 mods using Mixins. It is a server-side only mod, allowing clients to use
unaltered versions of mods / modpacks. If a mod is not installed, the Mixin will not be loaded.

Requires a 1.7.10 mixin loader like [GTNHMixins](https://github.com/GTNewHorizons/GTNHMixins) or
[UniMixins](https://github.com/LegacyModdingMC/UniMixins).

## How to use
1. Download the lastest version from the [releases](https://github.com/ThePixelbrain/BedcraftFixes/releases)
2. Download a 1.7.10 Mixin Loader like [GTNHMixins](https://github.com/GTNewHorizons/GTNHMixins) or
   [UniMixins](https://github.com/LegacyModdingMC/UniMixins)

## Fixes
- FTBUtilities (v. 1.7.10-1.0.18.3)
  - Fixes `/sethome` going to bed or spawn in certain scenarios (#1)
  - Respect the config value for `max_player_offline_hours` and properly unforce chunks when it exceeds (#4)
