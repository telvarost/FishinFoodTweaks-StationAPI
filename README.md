# FishinFoodTweaks StationAPI for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 adds fish sizes and food tweaks. Special thanks to the BTA community for the suggestions and to PsychedeliCon for the new fish textures!

**If you're looking for modern Minecraft recipes:** https://github.com/telvarost/MostlyModernRecipes-StationAPI

# Fishin' Food Tweaks

You will need ModMenu and GlassConfigAPI if you want to tweak different parts of the mod. See installation instructions below.
* Mod now works on Multiplayer with GlassConfigAPI version 2.0+ used to sync configs!
* Mod has BHCreative creative mode support (adds a tab with unique fish to creative menu)

## List of changes

* Enable random fish sizes to catch fish of different lengths!
  * Every 10 cm of fish provides half a heart of health.
  * When fish is cooked very 5 cm of fish provides half a heart of health.
  * Achievements have also been added for catching small, ocean, and special fish!
* Enable fish healing tooltips to show healing amounts.
  * Enable food tooltips to show healing amounts for other foods as well.
* Enable oceanic fish to catch fish up to 110 cm in length.
  * Default fish sizes will be between 10 cm and 70 cm.
* Enable non-vanilla fish
  * Adds 4 new fish types to the game common, river, sea, and ocean (if ocean is enabled)
* Enable water surface calculations (default true)
  * More water makes bigger fish sizes slightly more likely (less water does the opposite)
  * Size of water surface area affects which non-vanilla fish types can be caught

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/babric/prism-instance
2. Install Java 17 and set the instance to use it: https://adoptium.net/temurin/releases/
3. Add GlassConfigAPI 3.0.2+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
4. Add Glass Networking to the mod folder for the instance: https://modrinth.com/mod/glass-networking
5. Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
6. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
7. Add this mod to the mod folder for the instance: https://github.com/telvarost/FishinFoodTweaks-StationAPI/releases
8. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/FishinFoodTweaks-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
