<p align="center">
  <a href="https://www.curseforge.com/minecraft/mc-mods/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&amp;logo=fabric" alt="Requires Fabric API"></a>
  <a href="https://www.curseforge.com/minecraft/mc-mods/dasik-libary"><img src="https://img.shields.io/badge/Requires-Dasik_Library-8A2BE2?style=for-the-badge" alt="Requires Dasik Library"></a>
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&amp;logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

<h2>🚀 Max Elytra Fly Speed</h2>

<blockquote><p><strong>&ldquo;Break the Sound Barrier. Limitless Velocity. Instant Flight.&rdquo;</strong></p></blockquote>

<blockquote><p><strong>1 Jar 1 Version Policy:</strong> I build <strong>1 dedicated JAR for each Minecraft version</strong> (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.<br><br><strong>Dependency Requirement:</strong> For modern Minecraft 26.x releases (26.2, 26.3+), this mod requires both <strong>Fabric API</strong> and <strong>Dasik Library</strong> (<code>v1.8.2+</code>).</p></blockquote>

<p>Every Minecraft player knows the limitation of vanilla Elytra flight: no matter how hard you dive or how many firework rockets you use, you hit an invisible terminal velocity wall. Exploring distant dimensions or traversing tens of thousands of blocks across multiplayer worlds takes agonizingly long, consuming stacks of rockets for sluggish momentum.</p>

<p><strong>Max Elytra Fly Speed</strong> completely removes artificial speed ceilings. Powered by customizable GameRules and dynamic vector physics, it unlocks supersonic Elytra flight, multi-phase rocket boost acceleration, and silky-smooth aerodynamic gliding with zero server-flight kicks!</p>

<p>Part of the <strong>Instant Gratification Collection</strong> &mdash; mods that speed up and enhance vanilla mechanics.</p>

<hr>

<h2>✨ Features</h2>

<p align="center"><strong>🎬 Video Showcase: Supersonic Elytra Flight Demonstration</strong><br><em>Click the thumbnail or button below to watch the feature showcase on YouTube:</em><br><br><iframe src="https://www.youtube.com/embed/Oz8NTfX0YmE?feature=youtu" width="560" height="314" allowfullscreen="allowfullscreen"></iframe><br><br><a href="https://youtu.be/Oz8NTfX0YmE" target="_blank" rel="noopener"> <img src="https://img.shields.io/badge/▶_Watch_Video-Play_on_YouTube-FF0000?style=for-the-badge&amp;logo=youtube&amp;logoColor=white" alt="▶ Play Video on YouTube"> </a></p>

<h3>🏎️ Uncapped Velocity Ceiling</h3>
<ul>
  <li><strong>Configurable Speed Limit:</strong> Clamp your maximum flight speed to any velocity (default: <code>50</code> blocks/sec). Set it to <code>100</code>, <code>200</code>, or even <code>500</code> blocks/sec for breathtaking supersonic travel!</li>
  <li><strong>Smooth Speed Clamping:</strong> Safely scales entity delta movement on the fly without jitter, sudden stops, or camera snapping.</li>
</ul>

<h3>🚀 Dual-Phase Rocket Boost Acceleration</h3>
<p>Vanilla rockets apply a fixed, flat impulse that quickly plateaus. Max Elytra Fly Speed introduces intelligent 2-phase rocket propulsion (<code>RocketBoostHelper</code>):</p>
<ul>
  <li><strong>Phase 1 (Initial Boost):</strong> Delivers snappy, responsive vanilla launch acceleration up to a configurable baseline (default: <code>30</code> blocks/sec).</li>
  <li><strong>Phase 2 (High-Speed Glide Acceleration):</strong> Rocket thrust smoothly accelerates your velocity vector toward your configured maximum speed using proportional vector convergence (<code>elytra_high_speed_acceleration</code>, default: <code>15%</code> per tick).</li>
</ul>

<h3>🪂 Dynamic Aerodynamic Drag Damping</h3>
<ul>
  <li>In vanilla, steep dives bleed speed quickly due to harsh hardcoded aerodynamic drag (<code>0.99</code> horizontal, <code>0.98</code> vertical).</li>
  <li>Max Elytra Fly Speed relaxes aerodynamic drag dynamically at higher speed settings (<code>0.01 / (maxSpeed/50)</code>), allowing steep pitch dives to build up massive kinetic momentum and sustain long-distance high-speed glides without wasting fireworks!</li>
</ul>

<h3>🛡️ Server Flight Kick Tolerance</h3>
<p>Built to operate harmoniously with server movement checks:</p>
<ul>
  <li>Intercepts and scales movement cleanly within native fall-flying physics routines (<code>LivingEntityMixin</code>), preventing false-positive &ldquo;Flying is not enabled on this server&rdquo; kicks during high-speed travel.</li>
</ul>

<h3>🧩 Compatibility &amp; HUD Integration</h3>
<ul>
  <li><strong>Server-Side Compatible:</strong> Works seamlessly on dedicated servers. Clients do not need the mod installed when connecting to a supported server!</li>
  <li><strong>ModMenu &amp; Cloth Config / YACL:</strong> Adjust baseline worldgen defaults directly from the main-menu graphical settings screen.</li>
  <li><strong>Speedometer Synergy:</strong> Pair with Speedometer to watch your true blocks-per-second velocity climb in real time!</li>
</ul>

<hr>

<h2>📊 Quick Reference &amp; Mechanics Matrix</h2>

<table>
  <thead>
    <tr>
      <th>Mechanic / Parameter</th>
      <th>Vanilla Default</th>
      <th>Max Elytra Fly Speed Default</th>
      <th>Range / Limit</th>
      <th>Mathematical Impact</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Max Flight Speed</strong></td>
      <td>~33.5 blocks/sec</td>
      <td><strong><code>50</code> blocks/sec</strong></td>
      <td><code>1</code> to <code>2147483647</code></td>
      <td>Maximum fall-flying velocity ceiling (<code>max_elytra_fly_speed</code>).</td>
    </tr>
    <tr>
      <td><strong>Initial Boost Speed</strong></td>
      <td>Fixed impulse</td>
      <td><strong><code>30</code> blocks/sec</strong></td>
      <td><code>1</code> to <code>2147483647</code></td>
      <td>Speed threshold for snappy launch boost (<code>elytra_initial_boost_speed</code>).</td>
    </tr>
    <tr>
      <td><strong>High Speed Accel</strong></td>
      <td>None (Caps out)</td>
      <td><strong><code>15%</code> per tick</strong></td>
      <td><code>1%</code> to <code>1000%</code></td>
      <td>Convergence rate toward max speed ceiling (<code>elytra_high_speed_acceleration</code>).</td>
    </tr>
    <tr>
      <td><strong>Aerodynamic Drag</strong></td>
      <td>Fixed 0.99H / 0.98V</td>
      <td><strong>Dynamic Scaling</strong></td>
      <td>Auto-calculated</td>
      <td>Damping loss relaxes proportionally (<code>dragLoss / (maxSpeed / 50)</code>).</td>
    </tr>
    <tr>
      <td><strong>Server Movement</strong></td>
      <td>Strict kick checks</td>
      <td><strong>Safe Parity</strong></td>
      <td>Server-friendly</td>
      <td>Operates inside native fall-flying delta movement.</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>🚀 In-Game Commands &amp; Quick Start</h2>

<p>Tune flight parameters on the fly via Minecraft's native <code>/gamerule</code> command with full tab completion:</p>

<pre><code>/gamerule max-elytra-fly-speed:max_elytra_fly_speed &lt;blocks_per_sec&gt;       &rarr; Set maximum flight speed ceiling (e.g. 100, 150)
/gamerule max-elytra-fly-speed:elytra_initial_boost_speed &lt;blocks_per_sec&gt; &rarr; Set threshold for initial snappy rocket boost (e.g. 40)
/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration &lt;percent&gt;    &rarr; Set high-speed acceleration rate (e.g. 20 for 20%/tick)</code></pre>

<hr>

<h2>⚙️ Configuration (Native GameRules)</h2>

<blockquote><p><strong>💡 Config vs. In-Game GameRules:</strong> The global configuration file only defines default values for newly created worlds. In existing worlds, change settings in-game via the <strong>Edit Game Rules</strong> UI screen or the <code>/gamerule</code> command.</p></blockquote>

<table>
  <thead>
    <tr>
      <th>GameRule Name</th>
      <th>Type</th>
      <th>Default</th>
      <th>Valid Range</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>max-elytra-fly-speed:max_elytra_fly_speed</code></td>
      <td><code>Integer</code></td>
      <td><code>50</code></td>
      <td><code>1</code> to <code>2147483647</code></td>
      <td>Maximum velocity of Elytra flight in Blocks/Second.</td>
    </tr>
    <tr>
      <td><code>max-elytra-fly-speed:elytra_initial_boost_speed</code></td>
      <td><code>Integer</code></td>
      <td><code>30</code></td>
      <td><code>1</code> to <code>2147483647</code></td>
      <td>Speed threshold (Blocks/Second) up to which snappy vanilla rocket boost applies.</td>
    </tr>
    <tr>
      <td><code>max-elytra-fly-speed:elytra_high_speed_acceleration</code></td>
      <td><code>Integer</code></td>
      <td><code>15</code></td>
      <td><code>1</code> to <code>1000</code></td>
      <td>High-speed acceleration rate percentage per tick above the initial boost threshold.</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>📖 In-Depth How-To &amp; Flight Playbook</h2>

<h3>1. Drop-In Setup &amp; Baseline Flight</h3>
<ol>
  <li>Install <strong>Fabric API</strong>, <strong>Dasik Library</strong>, and <strong>Max Elytra Fly Speed</strong> into your <code>mods</code> folder.</li>
  <li>Equip your Elytra, jump from a high ledge, and ignite a firework rocket to experience immediate, responsive flight.</li>
</ol>

<h3>2. Live In-Game Speed Adjustment</h3>
<ul>
  <li>Want casual cruising? Leave the default at <code>50</code> blocks/sec.</li>
  <li>Want high-speed transit? Type <code>/gamerule max-elytra-fly-speed:max_elytra_fly_speed 100</code>.</li>
  <li>Want to cross whole continents in seconds? Type <code>/gamerule max-elytra-fly-speed:max_elytra_fly_speed 250</code>. Changes apply immediately to all airborne players!</li>
</ul>

<h3>3. Mastering Multi-Phase Rocket Propulsion</h3>
<ul>
  <li>When launching from the ground, your first rocket kick delivers immediate vanilla thrust up to <code>30</code> blocks/sec.</li>
  <li>While maintaining your flight path, tap 1&ndash;2 additional fireworks to engage Phase 2 proportional acceleration, pulling your character smoothly up to your max speed ceiling.</li>
</ul>

<h3>4. Supersonic Diving &amp; Momentum Gliding</h3>
<ul>
  <li>Pitch your crosshair downward into a steep 45&deg; dive.</li>
  <li>Thanks to dynamic aerodynamic drag reduction, your momentum converts cleanly into forward velocity without bleeding off. Level out toward the horizon to glide at sustained high speeds without using extra fireworks!</li>
</ul>

<h3>5. Server Setup &amp; Chunk Generation Tips</h3>
<ul>
  <li>When configuring high speeds on multiplayer servers (<code>&gt;100 blocks/sec</code>), ensure your server has fast chunk generation or pre-generate terrain (using mods like Chunky) so the landscape keeps up with your supersonic gliders.</li>
</ul>

<hr>

<h2>🧩 Recommended Sister Mods</h2>

<p>If you enjoy <strong>Max Elytra Fly Speed</strong>, these companion mods from the <strong>Instant Gratification</strong> and <strong>Vanilla Outsider</strong> collections plug in seamlessly:</p>

<ul>
  <li>⏱️ <a href="https://www.curseforge.com/minecraft/mc-mods/vo-speedometer"><strong>Speedometer</strong></a>: Display your live velocity in blocks/second on your HUD to track your supersonic flight speeds.</li>
  <li>⚒️ <a href="https://www.curseforge.com/minecraft/mc-mods/instant-gratification-durability-multiplier"><strong>Durability Multiplier</strong></a>: Make your Elytra unbreakable or multiply durability so you never suffer mid-air glider failures.</li>
  <li>📦 <a href="https://www.curseforge.com/minecraft/mc-mods/ig-stack-size-adjuster"><strong>Stack Size Adjuster</strong></a>: Stack firework rockets up to 64 or custom limits so you never run out of propellant.</li>
</ul>

<p><em>Explore the full <a href="https://www.curseforge.com/members/dasikigaijin/projects"><strong>Instant Gratification Collection</strong></a> for more high-convenience enhancements.</em></p>

<hr>

<h2>☕ Support</h2>

<p>If you enjoy the <strong>Instant Gratification Collection</strong>, consider fueling future development!</p>

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&amp;logo=ko-fi&amp;logoColor=white" alt="Ko-fi"></a>
  <a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
  <a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>
</p>

<blockquote><p><strong>🇮🇩 Indonesian Users:</strong> SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!</p></blockquote>

<blockquote><p><strong>Dedicated Server Hosting Partner:</strong><br>Looking for a reliable server to play with friends? Check out <strong>BisectHosting</strong> for 1-click modpack installations, automated backups, and 24/7 dedicated customer support.</p></blockquote>

<hr>

<h2>📜 Credits &amp; Modpack Permissions</h2>

<table>
  <thead>
    <tr>
      <th>Property</th>
      <th>Information</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>Creator / Author</strong></td>
      <td><strong>Dasik</strong> (Rifaditya)</td>
    </tr>
    <tr>
      <td><strong>Collection</strong></td>
      <td><a href="https://www.curseforge.com/members/dasikigaijin/projects">Instant Gratification Collection</a></td>
    </tr>
    <tr>
      <td><strong>License</strong></td>
      <td><a href="https://www.gnu.org/licenses/gpl-3.0.html">GNU General Public License v3.0 (GPLv3)</a></td>
    </tr>
    <tr>
      <td><strong>Source Code</strong></td>
      <td><a href="https://github.com/Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed">GitHub - Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed</a></td>
    </tr>
    <tr>
      <td><strong>Issue Tracker</strong></td>
      <td><a href="https://github.com/Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed/issues">GitHub Issues</a></td>
    </tr>
    <tr>
      <td><strong>Documentation / Wiki</strong></td>
      <td><a href="https://github.com/Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed/wiki">GitHub Wiki</a></td>
    </tr>
  </tbody>
</table>

<blockquote>
  <p><strong>📦 Modpack Permissions &amp; Distribution:</strong><br>
  You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (<strong>CurseForge</strong> or <strong>Modrinth</strong>). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.</p>
  <p><strong>⚖️ License &amp; Fork Guidelines (No Zero-Change Re-uploads):</strong><br>
  This project is open-source under the <strong>GNU GPLv3</strong>. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports&mdash;provided your project remains open-source under GPLv3 with proper attribution.<br>
  <strong>However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.</strong></p>
</blockquote>

<hr>

<p align="center">
  <strong>Made with ❤️ for the Minecraft community</strong><br>
  <em>Part of the Instant Gratification Collection</em>
</p>
