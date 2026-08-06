# NextNeko - Cute Neko Plugin

## What is this?

NextNeko is a fun Minecraft plugin that makes Minecraft more interesting! It allows players to become cute neko girls with special abilities and interactive features.

**Simply put:** This plugin adds cute neko characters to your server!

## Quick Start (3 Easy Steps)

### Step 1: Download the Plugin

1. Download the `NextNeko-1.0.0.jar` file
2. Place this file in your server's `plugins` folder

### Step 2: Start the Server

1. Start your Minecraft server normally
2. The plugin will automatically create configuration files

### Step 3: Start Playing

1. In-game, type `/nekoset playername true` to turn a player into a neko
2. Neko players can now use all the fun features!

## What Can Nekos Do? (Awesome Features)

### 🐱 Basic Abilities

- **Night Vision**: Nekos can see clearly in the dark
- **Jump Boost**: Can jump higher
- **Sneak Speed**: Move faster and quieter while sneaking

### 💬 Cute Chat

- Neko chat has special prefixes and suffixes
- Automatically converts normal words into cute neko language
- For example, "hello" might become "meow~ hello"

### 🍖 Special Diet

- Nekos can only eat meat-based foods! No vegetables or fruits
- Supports various cooked and raw meats, fish, seafood, and potions

### 🐾 Claw Attacks

- Nekos have special claw attacks
- Extra damage to mobs
- Has cooldown time, cannot be used continuously

### 🛡️ Leather Armor Bonus

- Wearing leather armor provides speed bonuses
- Each piece of leather armor increases speed
- Multiple armor pieces stack effects

**Simply put:** Leather armor makes nekos run faster!

### 👑 Owner System

- Nekos can have owners
- Special interactions between owners and nekos
- Can heal and help each other
- **Owner Death Effect**: When an owner dies, their nekos also die (configurable)
  - Option to keep neko inventory and experience level

### 🌙 Night Abilities

- Neko abilities become stronger at night
- Peak power at midnight
- Automatically activates, no manual control needed

### 💪 Stress Response

- When neko health is very low
- Automatically gains super strength
- Lasts 1 minute, helps escape danger

### ⚔️ Passive Attack Boost

- Nekos deal slightly higher damage when attacking
- Stronger knockback effect against enemies
- Applies to all weapon types
- Damage and knockback multiplier configurable

**Simply put:** Neko attacks are more powerful and can knock enemies further!

### 🌿 Catnip Effects

- Nekos use catnip items (default uses wheat seeds)
- Gain temporary speed and jump boost
- Effects last for a period of time
- Can modify the items used in configuration file

### 🛡️ Damage Adjustment

- **Fall Damage Immunity**: Nekos don't take damage from falling from heights
- **Other Damage Boost**: Nekos take 1.8x damage from other sources
- Can adjust damage multiplier in configuration file

**Simply put:** Nekos are immune to falling but more vulnerable to attacks!

### 🐾 Mob Repulsion

- **Creeper Repulsion**: Creepers won't explode when encountering nekos, but are repelled
- **Phantom Repulsion**: Phantoms won't attack nekos, but are repelled
- Automatically activates, no manual operation needed

**Simply put:** Creepers and phantoms are afraid of nekos and will automatically avoid them!

### 👁️ Mob Targeting Behavior

- Hostile mobs have increased detection distance for nekos
- Friendly mobs are more attracted to nekos
- Different effects on different types of mobs
- Detection parameters configurable

### 🔔 Player Proximity Notification

- When other players enter a 25-block radius around a neko, the neko receives a title notification
- Shows the names and distances of nearby players
- Can enable/disable the feature with the `/playernotice` command
- Configuration information stored in SQLite database
- Helps nekos be aware of their surroundings

**Simply put:** Nekos receive notifications about nearby players!

### 🧗‍♀️ Climbing Feature

- **Wall Climbing**: Nekos can climb up walls and vertical surfaces
- **Usage**: Use `/climb` command to toggle climbing feature
- **Limitations**: Can only climb near walls, has a limited range of use
- **Auto-disable**: Stops climbing automatically when leaving the wall

**Simply put:** Nekos can climb walls like spiders!

### 🐾 Tail Pull Feature

- **Tail Interaction**: Players can pull nekos' tails
- **Usage**: Use `/pullthetail` command to toggle tail pull feature
- **Interactive Effects**: Pulling tails creates fun interaction effects (damage and heal with cat sounds)
- **Control**: Nekos can choose whether to allow their tails to be pulled

**Simply put:** Players can interact with nekos by pulling their tails!

### 💖 Health Restore Skill

- **Active Skill**: Nekos can use `/health` command to restore health for themselves and their owners
- **Cost**: Consumes hunger points to use
- **Cooldown**: Has a cooldown period between uses
- **Scaling Effect**: The lower the health, the stronger the restoration effect

**Simply put:** Nekos can heal themselves and their owners with this skill!

### 📋 Skills List

- **Command**: `/myskills` - Shows all available skills for nekos
- **Active Skills**: Displays cooldown status and usage information
- **Passive Skills**: Shows status and description
- **Clear Format**: Easy to understand skill information

**Simply put:** Nekos can view all their skills and cooldowns with this command!

### 📋 Placeholder System

- **New Command**: `/nextneko placeholders` - Lists all available NextNeko placeholders
- **Enhanced Compatibility**: Works correctly even without PlaceholderAPI installed
- **Better Error Handling**: Clear error messages when PlaceholderAPI is unavailable
- **Status Display**: Shows registration status for each placeholder

**Simply put:** More reliable placeholder system with improved user experience!

### 🔧 Command System Enhancements

- **Message Localization**: Ensures proper message display in Chinese
- **Improved Stability**: Optimized command execution flow for better code reliability
- **Crash Prevention**: Enhanced error handling mechanisms
- **Language Support**: Better default message fallback system

**Simply put:** More stable commands with correct message display!

### 🌐 Language System Improvements

- **Safe Message Access**: Using SafeMessageUtils for secure message retrieval
- **Fallback System**: Better default messages when translations are missing
- **Consistent Display**: Ensured all command messages show correctly in different language environments

**Simply put:** Enhanced language support with more reliable message handling!

## 🌿 Catnip Detailed Usage Guide

### What is Catnip?

Catnip is a special feature in the NextNeko plugin that allows neko players to use specific items to gain temporary buff effects.

### 🎯 Usage Method

**Basic Operation:**
1. **Must be a Neko Player** - Only players set as nekos can use catnip
2. **Hold Catnip Item** - Default uses wheat seeds (WHEAT_SEEDS)
3. **Right-Click to Use** - Hold the catnip item and right-click to activate the effect

**Specific Steps:**
1. Ensure you are a neko (admin uses `/nekoset yourname true` to set)
2. Obtain wheat seeds (or other configured catnip items)
3. Hold wheat seeds and right-click
4. Immediately gain speed and jump boost effects

### ⚡ Effect Details

**Catnip provides the following buff effects:**
- **Speed Boost** (Speed II) - Significantly increased movement speed
- **Jump Boost** (Jump Boost II) - Greatly enhanced jump height
- **Duration** - Default 60 seconds (can be modified in configuration)

**Effect Characteristics:**
- Effects activate immediately
- Consumes one catnip item
- Has cooldown time, cannot be used continuously
- Only effective for neko players

### ⚙️ Configuration Options

Customize catnip settings in `config.yml`:

```yaml
cat-nip:
  enabled: true           # Enable/disable catnip feature
  item: "WHEAT_SEEDS"     # Catnip item ID (can be changed to other items)
  duration: 60            # Effect duration (seconds)
```

**Modifiable Item Options:**
- Default: `WHEAT_SEEDS` (wheat seeds)
- Can be changed to: `GRASS` (grass), `FERN` (fern), `VINE` (vine), etc.
- Supports any Minecraft item ID

### 💡 Usage Tips

1. **Combat Assistance** - Use during PVP or mob fighting to gain speed and jump advantage
2. **Escape Tool** - Use catnip to quickly escape danger when being chased
3. **Exploration Boost** - Use during long-distance travel to improve movement efficiency
4. **Building Aid** - Jump boost helps with building at heights
5. **Armor Selection** - Wear leather armor to get maximum speed bonus

### 🚫 Limitations

- Only neko players can use
- Requires consumption of catnip items
- Has usage cooldown
- Cannot be used with off-hand items (must be held in main hand)

### 🔄 Synergy with Other Features

- **Night Effects** - Catnip effects work better at night
- **Stress Response** - Better effect when combining with catnip when health is low
- **Armor Bonus** - Speed bonus stacks with leather armor effects

**Important Note:** Right-clicking with catnip in main hand consumes 1 catnip item, off-hand items won't trigger the effect.

## Common Commands (In-Game Usage)

### Interaction Commands (Everyone can use)

- `/pat player` - Gently pat a neko player
- `/lovebite player` - Give a cute love bite
- `/earscratch player` - Scratch someone's ears
- `/purr` - Make purring sounds
- `/hiss player` - Hiss at someone
- `/scratch player` - Scratch someone with claws
- `/attention player` - Attract other players' attention
- `/pullthetail` - Toggle tail pull feature

### Ability Commands (Nekos only)

- `/nightvision` - Enable night vision
- `/jumpboost` - Jump boost
- `/swiftsneak` - Sneak speed
- `/health` - Heal yourself and owner
- `/myskills` - View all skills and cooldowns
- `/playernotice [on|off]` - Enable/disable player proximity notification
- `/climb` - Toggle climbing feature

### Owner System Commands

- `/owner add player` - Request to become someone's owner
- `/owner accept player` - Accept owner request
- `/owner deny player` - Deny owner request
- `/owner remove player` - Remove owner relationship
- `/owner list` - View your owners
- `/owner mylist` - View your nekos
- `/owner forceadd player` - Force add owner relationship (admin only)

### Admin Commands

- `/nextneko reload` - Reload plugin settings
- `/nekoset player true/false` - Set player as neko
- `/nextneko language language` - Switch plugin language
- `/nextneko placeholders` - Display all available NextNeko placeholders

## New Features in Emergency-fix Version

### 📋 Placeholder System Improvements

- **New Command**: `/nextneko placeholders` - Lists all available NextNeko placeholders
- **Enhanced Compatibility**: Works correctly even when PlaceholderAPI is not installed
- **Better Error Handling**: Clear error messages when PlaceholderAPI is unavailable
- **Status Display**: Shows registration status for each placeholder

**Simple Description**: More reliable placeholder system with improved user experience!

### 🔧 Command System Enhancements

- **Message Localization**: Fixed issues to ensure proper message display in Chinese
- **Improved Stability**: Optimized command execution flow for better code reliability
- **Crash Prevention**: Enhanced error handling mechanisms
- **Language Support**: Better default message fallback system

**Simple Description**: More stable commands with correct message display!

### 🌐 Language System Improvements

- **Safe Message Access**: Using SafeMessageUtils for secure message retrieval
- **Fallback System**: Better default messages when translations are missing
- **Consistent Display**: Ensured all command messages show correctly in different language environments

**Simple Description**: Enhanced language support with more reliable message handling!

## Configuration (Optional Settings)

The plugin creates a `config.yml` file on first run, which you can open and modify with a text editor:

### Basic Settings

- `neko-chat`: Enable/disable neko chat effects
- `meat-only`: Whether nekos can only eat meat (potions are allowed)
- `cat-nip`: Catnip effects and duration

### Ability Adjustments

- `claws`: Claw attack damage and cooldown time
- `armor-bonus`: Speed bonus from leather armor
- `night-effects`: Night ability start/end times and night vision refresh interval
- `health-skill`: Healing skill cooldown and cost

### Special Effects

- `cat-nip`: Catnip effects and duration
- `passive-attack-boost`: Attack damage bonus and knockback multiplier
- `armor-bonus`: Leather armor bonus settings
  - `enabled`: Enable/disable armor bonus
  - `leather-bonus`: Leather armor type list
  - `speed-bonus-per-piece`: Speed bonus per armor piece
- `neko-damage-modification`: Neko damage adjustment settings
  - `enabled`: Enable/disable damage adjustment feature
  - `fall-damage-immunity`: Fall damage immunity
  - `other-damage-multiplier`: Other damage increase multiplier
  - `debug`: Debug mode
- `neko-mob-behavior`: Neko mob behavior settings
  - `enabled`: Enable/disable mob behavior feature
  - `creeper-repulsion`: Creeper repulsion feature
  - `phantom-repulsion`: Phantom repulsion feature
  - `debug`: Debug mode
- `mob-targeting`: Mob targeting behavior settings
  - `enabled`: Enable/disable targeting behavior adjustment
  - `distance-increase`: Detection distance increase multiplier
  - `friendly-attraction`: Enable/disable friendly mob attraction
- `owner-death`: Owner death effect settings
  - `feature.enabled`: Enable/disable owner death effect
  - `keep-inventory`: Keep neko inventory
  - `keep-level`: Keep neko experience level
- `night-effects`: Night ability settings
  - `nightvision-duration`: Night vision duration in seconds (default 15), looped at night and removed during the day

## How to Compile the Plugin (For Developers Who Want to Build the Plugin)

If you want to compile the plugin file yourself, you can follow these steps:

#### For Minecraft 1.20.4 (Default Version)

Open command line and enter:
```bash
mvn clean install
```

#### For Minecraft 1.21.4

**Important Note: You need to install Java 21 on your computer first**
Open command line and enter:
```bash
mvn clean install -Ppaper-1.21.4
```

#### Current Limitations

- If your computer uses Java 17, you can only compile the 1.20.4 version
- To compile the 1.21.4 version, you need to install Java 21 first

### PlaceholderAPI Support

NextNeko integrates with PlaceholderAPI and provides the following placeholders (requires PlaceholderAPI plugin to be installed):

| Placeholder | Description |
|-------------|-------------|
| `%nextneko_is_neko%` | Check if player is a neko |
| `%nextneko_humans%` | Get list of non-neko players |
| `%nextneko_nekos%` | Get list of neko players |

Use the `/nextneko placeholders` command to view all available placeholders and their status.

### Technical Implementation of Damage Adjustment Feature

#### Core Classes

- <mcfile name="NekoDamageListener.java" path="src\main\java\org\cneko\nekox\events\NekoDamageListener.java"></mcfile>: Damage handling listener

#### Implementation Logic

1. Listen for `EntityDamageEvent` events
2. Check if the damaged entity is a neko
3. If it's fall damage (`FALL` enum), cancel the damage event
4. If it's other damage, increase the damage by the configured multiplier

#### Testing Methods

- **Fall Test**: Nekos don't take damage when falling from heights, regular players take normal damage
- **Damage Test**: Nekos take 1.8x damage when attacked
- **Configuration Test**: Modify configuration file to verify effects

### Technical Implementation of Mob Repulsion Feature

#### Core Classes

- <mcfile name="NekoMobBehaviorListener.java" path="src\main\java\org\cneko\nekox\events\NekoMobBehaviorListener.java"></mcfile>: Mob behavior listener

#### Implementation Logic

- **Creeper Repulsion**: Listen for `ExplosionPrimeEvent`, cancel explosion and apply reverse thrust
- **Phantom Repulsion**: Listen for `EntityTargetLivingEntityEvent`, cancel attack and apply reverse thrust
- Distance judgment: Effective within 4 blocks
- Configuration-driven, features can be toggled on/off individually

#### Testing Methods

- **Creeper Test**: Creepers won't explode near nekos, regular players experience normal explosions
- **Phantom Test**: Nekos aren't attacked by phantoms at night, regular players are attacked normally
- **Configuration Test**: Modify configuration file to verify repulsion effects

## Frequently Asked Questions

### Q: Which Minecraft versions are supported?
A: Supports 1.20.4 and 1.21.4 versions

### Q: How to turn a player into a neko?
A: Admin types `/nekoset playername true`

### Q: What can nekos do that regular players can't?
A: Night vision, jump boost, sneak speed, special chat, claw attacks, etc.

### Q: What's the purpose of the owner system?
A: Nekos can have owners, owners and nekos can heal each other and have special interactions

### Q: How to modify plugin settings?
A: Edit the `plugins/NextNeko/config.yml` file

### Q: Is Chinese supported?
A: Yes! Type `/nextneko language chinese` to switch to Chinese

## Technical Support

If you encounter problems:
1. Check if Minecraft version matches
2. Confirm plugin file is in correct location
3. Check error messages in server logs
4. Contact plugin developer for help

## Tips

- Nekos are stronger at night, try to be active during nighttime
- Leather armor provides speed bonus to nekos
- Catnip gives temporary speed and jump boost to nekos
- Low health automatically triggers stress response for extra power

---

# NextNeko - 可爱的猫娘插件

## 这是什么？

NextNeko是一个让Minecraft变得更有趣的插件！它可以让玩家变成可爱的猫娘，拥有特殊能力和互动方式。

**简单来说：** 这个插件让你的服务器里出现可爱的猫娘角色！

## 快速开始（3步搞定）

### 第1步：下载插件

1. 下载 `NextNeko-1.0.0.jar` 文件
2. 把这个文件放到你服务器的 `plugins` 文件夹里

### 第2步：启动服务器

1. 正常启动你的Minecraft服务器
2. 插件会自动创建配置文件

### 第3步：开始使用

1. 在游戏里输入 `/nekoset 玩家名字 true` 把玩家变成猫娘
2. 猫娘玩家就可以使用各种有趣的功能啦！

## 猫娘能做什么？（超有趣的功能）

### 🐱 基础能力

- **夜视能力**：猫娘在黑暗中也能看清楚
- **跳跃增强**：可以跳得更高
- **潜行加速**：潜行时移动更快更安静

### 💬 可爱聊天

- 猫娘聊天会有特殊的前缀和后缀
- 自动把普通词语变成可爱的猫娘用语
- 比如"你好"可能变成"喵~你好"

### 🍖 特殊饮食

- 猫娘只能吃肉类食物！不能吃蔬菜水果
- 支持各种肉类食物和药水

### 🐾 爪子攻击

- 猫娘有特殊的爪子攻击
- 对生物造成额外伤害
- 有冷却时间，不能连续使用

### 🛡️ 皮革护甲加成

- 穿着皮革护甲可以获得速度加成
- 每件皮革护甲都能增加速度
- 多件护甲效果叠加

**简单来说：** 皮革护甲让猫娘跑得更快！

### 👑 主人系统

- 猫娘可以认主人
- 主人和猫娘有特殊互动
- 可以互相治疗和帮助
- **主人死亡效应**：当主人死亡时，其猫娘也会死亡（可配置）
  - 可选择是否保留猫娘的物品栏和经验等级

### 🌙 夜间能力

- 晚上猫娘能力会变强
- 午夜时能力达到最强
- 自动生效，不用手动开启

### 💪 应激反应

- 当猫娘生命值很低时
- 会自动获得超强力量
- 持续1分钟，帮助脱离危险

### ⚔️ 被动攻击增强

- 猫娘攻击时造成略微更高的伤害
- 对敌人有更强的击退效果
- 适用于所有武器类型
- 伤害和击退倍数可配置

**简单来说：** 猫娘的攻击更有力，能把敌人打得更远！

### 🌿 猫薄荷效果

- 猫娘使用猫薄荷物品（默认使用小麦种子）
- 获得临时速度和跳跃提升
- 效果持续一段时间
- 可以在配置文件中修改使用的物品

### 🛡️ 伤害调整

- **免疫跌落伤害**：猫娘从高处跌落不会受到伤害
- **其他伤害增强**：猫娘受到的其他伤害变为1.8倍
- 可以在配置文件中调整伤害倍数

**简单来说：** 猫娘不怕摔，但更容易受伤！

### 🐾 生物驱赶

- **苦力怕驱赶**：苦力怕遇到猫娘不会爆炸，而是被驱赶
- **幻翼驱赶**：幻翼不会攻击猫娘，而是被驱赶
- 自动生效，无需手动操作

**简单来说：** 苦力怕和幻翼都怕猫娘，会自动躲开！

### 👁️ 生物目标行为

- 敌对生物对猫娘的检测距离增加
- 友好生物更容易被猫娘吸引
- 对不同类型的生物有不同影响
- 检测参数可配置

### 🔔 玩家接近提醒

- 当其他玩家进入猫娘25格范围内时，猫娘会收到动作栏通知
- 实时显示附近玩家的名称和距离
- 更新频率提高到0.5秒一次，反应更灵敏
- 可通过`/playernotice`命令开启/关闭功能
- 配置信息存储在SQLite数据库中
- 帮助猫娘了解周围环境

**简单来说：** 猫娘会在动作栏中实时收到附近玩家的通知！

### 🧗‍♀️ 爬墙功能

- **爬墙能力**：猫娘可以爬上墙壁和垂直表面
- **使用方法**：使用`/climb`命令开启/关闭爬墙功能
- **限制条件**：只能在墙壁附近攀爬，有一定的使用范围
- **自动关闭**：离开墙壁后自动停止攀爬

**简单来说：** 猫娘可以像蜘蛛一样在墙壁上爬行！

### 🐾 尾巴拉扯功能

- **尾巴拉扯**：玩家可以拉扯猫娘的尾巴
- **使用方法**：使用`/pullthetail`命令开启/关闭尾巴拉扯功能
- **互动效果**：拉扯尾巴会产生有趣的互动效果（造成伤害并立即恢复，播放猫叫声）
- **开关控制**：猫娘可以自主选择是否允许被拉扯尾巴

**简单来说：** 玩家可以和猫娘进行尾巴拉扯的互动！

### 💖 健康恢复技能

- **主动技能**：猫娘可以使用`/health`命令恢复自己和主人的生命值
- **消耗**：使用技能会消耗饱食度
- **冷却**：技能有使用冷却时间
- **效果缩放**：生命值越低，恢复效果越强

**简单来说：** 猫娘可以用这个技能治疗自己和主人！

### 📋 技能列表

- **命令**：`/myskills` - 显示猫娘可用的所有技能
- **主动技能**：显示冷却状态和使用信息
- **被动技能**：显示状态和描述
- **清晰格式**：易于理解的技能信息

**简单来说：** 猫娘可以通过这个命令查看所有技能和冷却时间！

### 📋 占位符系统

- **新命令**：`/nextneko placeholders` - 列出所有可用的NextNeko占位符
- **增强兼容性**：即使未安装PlaceholderAPI也能正常工作
- **更好的错误处理**：PlaceholderAPI不可用时显示清晰的错误信息
- **状态显示**：显示每个占位符的注册状态

**简单来说：** 更可靠的占位符系统，提升用户体验！

### 🔧 命令系统增强

- **消息本地化**：确保中文消息正确显示
- **提高稳定性**：优化命令执行流程，提高代码可靠性
- **防止崩溃**：增强错误处理机制
- **语言支持**：更好的默认消息回退系统

**简单来说：** 更稳定的命令，消息显示正确！

### 🌐 语言系统改进

- **安全消息访问**：使用SafeMessageUtils安全获取消息
- **回退系统**：翻译缺失时提供更好的默认消息
- **一致显示**：确保所有命令消息在不同语言环境下正确显示

**简单来说：** 增强的语言支持，消息处理更可靠！

## 🌿 猫薄荷详细使用指南

### 什么是猫薄荷？

猫薄荷是NextNeko插件中的一个特殊功能，让猫娘玩家使用特定物品获得临时增益效果。

### 🎯 使用方法

**基本操作：**

1. **必须是猫娘玩家** - 只有被设置为猫娘的玩家才能使用猫薄荷
2. **手持猫薄荷物品** - 默认使用小麦种子（WHEAT_SEEDS）
3. **右键使用** - 手持猫薄荷物品右键点击即可激活效果

**具体步骤：**

1. 确保你是猫娘（管理员使用 `/nekoset 你的名字 true` 设置）
2. 获取小麦种子（或其他配置的猫薄荷物品）
3. 手持小麦种子右键点击
4. 立即获得速度和跳跃提升效果

### ⚡ 效果详情

**猫薄荷提供以下增益效果：**

- **速度提升** (Speed II) - 移动速度大幅增加
- **跳跃提升** (Jump Boost II) - 跳跃高度显著提升
- **持续时间** - 默认60秒（可在配置中修改）

**效果特点：**

- 效果立即生效
- 消耗一个猫薄荷物品
- 有冷却时间，不能连续使用
- 只对猫娘玩家有效

### ⚙️ 配置选项

在 `config.yml` 中可以自定义猫薄荷设置：

```yaml
cat-nip:
  enabled: true           # 是否启用猫薄荷功能
  item: "WHEAT_SEEDS"     # 猫薄荷物品ID（可修改为其他物品）
  duration: 60            # 效果持续时间（秒）
```

**可修改的物品选项：**

- 默认：`WHEAT_SEEDS`（小麦种子）
- 可改为：`GRASS`（草）、`FERN`（蕨类）、`VINE`（藤蔓）等
- 支持任何Minecraft物品ID

### 💡 使用技巧

1. **战斗辅助** - 在PVP或打怪时使用，获得速度和跳跃优势
2. **逃跑利器** - 被追击时使用猫薄荷快速脱离危险
3. **探索加速** - 长途旅行时使用，提高移动效率
4. **建筑辅助** - 跳跃提升有助于搭建高处建筑
5. **护甲选择** - 穿皮革护甲可获得最大速度加成

### 🚫 限制条件

- 只有猫娘玩家可以使用
- 需要消耗猫薄荷物品
- 有使用冷却时间
- 副手持物时无法使用（必须主手持物）

### 🔄 与其他功能的配合

- **夜间效果** - 晚上使用猫薄荷效果更佳
- **应激反应** - 生命值低时配合猫薄荷效果更好
- **护甲加成** - 速度加成与皮革护甲效果叠加

**重要提示：** 主手持物右键会消耗1个猫薄荷物品，副手持物不会触发效果。

## 常用命令（游戏内使用）

### 互动命令（所有人都能用）

- `/pat 玩家` - 轻轻拍拍猫娘玩家
- `/lovebite 玩家` - 给个可爱的咬咬
- `/earscratch 玩家` - 挠挠耳朵
- `/purr` - 发出呼噜声
- `/hiss 玩家` - 对别人发出嘶嘶声
- `/scratch 玩家` - 用爪子抓一下
- `/attention 玩家` - 吸引其他玩家的注意
- `/pullthetail` - 开关尾巴拉扯功能

### 能力命令（只有猫娘能用）

- `/nightvision` - 开启夜视
- `/jumpboost` - 跳跃增强
- `/swiftsneak` - 潜行加速
- `/health` - 治疗自己和主人
- `/myskills` - 查看所有技能和冷却时间
- `/playernotice [on|off]` - 开启/关闭玩家接近提醒
- `/climb` - 开关爬墙功能

### 主人系统命令

- `/owner add 玩家` - 请求成为某人的主人
- `/owner accept 玩家` - 接受主人的请求
- `/owner deny 玩家` - 拒绝主人的请求
- `/owner remove 玩家` - 解除主人关系
- `/owner list` - 查看自己的主人
- `/owner mylist` - 查看自己的猫娘
- `/owner forceadd 玩家` - 强制添加主人关系（仅管理员）

### 管理员命令

- `/nextneko reload` - 重新加载插件设置
- `/nekoset 玩家 true/false` - 设置玩家为猫娘
- `/nextneko language 语言` - 切换插件语言
- `/nextneko placeholders` - 显示所有可用的NextNeko占位符

## 配置说明（可选设置）

插件第一次运行时会创建 `config.yml` 文件，你可以用记事本打开修改：

### 基本设置

- `neko-chat`: 开启/关闭猫娘聊天特效
- `meat-only`: 猫娘是否只能吃肉（药水允许饮用）
- `cat-nip`: 猫薄荷的效果和持续时间

### 能力调整

- `claws`: 爪子攻击的伤害和冷却时间
- `armor-bonus`: 皮革护甲提供的速度加成
- `night-effects`: 夜间能力的开始/结束时间和夜视刷新间隔
- `health-skill`: 治疗技能的冷却和消耗

### 特殊效果

- `cat-nip`: 猫薄荷的效果和持续时间
- `passive-attack-boost`: 攻击伤害加成和击退倍数
- `armor-bonus`: 皮革护甲加成设置
  - `enabled`: 是否启用护甲加成
  - `leather-bonus`: 皮革护甲类型列表
  - `speed-bonus-per-piece`: 每件护甲的速度加成
- `neko-damage-modification`: 猫娘伤害调整设置
  - `enabled`: 是否启用伤害调整功能
  - `fall-damage-immunity`: 免疫跌落伤害
  - `other-damage-multiplier`: 其他伤害增加倍数
  - `debug`: 调试模式
- `neko-mob-behavior`: 猫娘生物行为设置
  - `enabled`: 是否启用生物行为功能
  - `creeper-repulsion`: 苦力怕驱赶功能
  - `phantom-repulsion`: 幻翼驱赶功能
  - `debug`: 调试模式
- `mob-targeting`: 生物目标行为设置
  - `enabled`: 是否启用目标行为调整
  - `distance-increase`: 检测距离增加倍数
  - `friendly-attraction`: 是否启用友好生物吸引
- `owner-death`: 主人死亡效应设置
  - `feature.enabled`: 是否启用主人死亡效应
  - `keep-inventory`: 是否保留猫娘物品栏
  - `keep-level`: 是否保留猫娘经验等级
- `night-effects`: 夜间效果设置
  - `nightvision-duration`: 夜视效果持续时间（秒），夜间循环刷新，白天移除
  - `check-interval`: 效果检查间隔（秒）

## 如何编译插件（适合想自己构建插件的开发者）

如果您想要自己编译插件文件，可以按照以下步骤操作：

#### 对于 Minecraft 1.20.4（默认版本）

打开命令行，输入：
```bash
mvn clean install
```

#### 对于 Minecraft 1.21.4

**重要提示：您需要先在电脑上安装 Java 21**
打开命令行，输入：
```bash
mvn clean install -Ppaper-1.21.4
```

#### 当前限制

- 如果您的电脑使用的是 Java 17，您只能编译 1.20.4 版本
- 要编译 1.21.4 版本，您需要先安装 Java 21
