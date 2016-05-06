# Contributing to Minestrappolation 4

## Submitting a Feature Request

You can submit a feature request on the [GitHub Issue Tracker][1] for Minestrappolation.
Please make sure to provide a meaningful title and include the following information in your description:

- Short summary of your feature (block, item, mob, biome, game mechanic, etc.)
- Appearance (Textures, Models, ...)
- General Behaviour (when it does what, if at all)
- Behaviour in edge cases (what happens when the mob is lit on fire, when the block is pushed by a piston)

## Submitting a Bug Report

Bug Reports also belong at the [Issue Tracker][1]. Before submitting an issue, make sure to check if there isn't already
a report about your problem or crash. Once you confirm you are not creating a duplicate, you can create a bug report.
They should consist of the following details

- Summary or detailed description of the bug or glitch
- Expected behaviour
- Steps to reproduce the problem (Crafting a pickaxe, placing a block above a fan, etc.)
- Crash Report (if necessary; found at `.minecraft/crash-reports/crash-....txt`)

## Creating a Pull Request

Before creating a Pull Request, please make sure to read the official
[GitHub Guide about Pull Requests](https://help.github.com/articles/using-pull-requests/) first. Once you have checked
that, you may fork the repository and clone the fork to your local machine. After changing and commiting, create a pull
request for the Minestrappolation 4 repository. We will make sure to review your changes and check them against our
contribution guidelines. If any issues arise, including compilation errors, runtime bugs, style issues or bad commit
messages, we will make sure to notify you and help you find a solution.

## Committing

The commits made to the main repository should follow a particular style to simplify Changelog generation. In general,
the commit header should provide a meaningful summary of the changes.

Examples:
```
Add Dirt Fences
Remove Oceanstone Stairs
Clean up Stonecutter Code
Add Redrock Textures
```

If you find that you cannot summarize all changes in the header or the text gets too long, you should probably consider
splitting your changes into multiple commits (Pull Requests with multiple commits are accepted).

The commit message body should provide more in-depth information about the new feature in a format that is compatible
with the changelog. This means that again, lines should not be too long (max. 80-120 characters) and start with one of
the following characters immediately succeeded by a space.

- **`+`** for Additions.
- **`-`** for Removed Features.
- **`*`** for Bugfixes and Improvements.
- **`!`** for API and library changes (e.g. updating Forge).
- **`#`** for Changes not meant to be included in the Changelog (i.e. internal code changes, cleanups)

The next word should be a verb that describes the type of change in past tense. At the end of a line, a period should be
present, after which an issue ID can be added for reference.

Examples:
```
+ Added Dirt Fence Blocks. #123
* Fixed missing Redrock Textures and Localizations. #32
- Removed Oceanstone Stairs.
# Cleaned up the `TileEntityStonecutter` and `ContainerStonecutter` classes.
```

If a commit closes an issue or pull request, the last line of the message should consist use a `Closes` directive.

Examples:
```
Closes #123
Closes #32
```

## Branches

The branch layout of the repository will usualy look like this:

```
| Release    | Release    | Bugfix Release    | Release
+---master---+--+---------+-------------------+----------
\           /    \                           /
 \--4.3.0--/      \--4.4.0------------------/
```

New features are added to the branch of the current minor release version (`4.`**`3`**`.0`). Bugfixes are made on the
`master` branch.

## Releases

When making a bugfix release or after merging a minor version branch, a release commit must be made. This commit has the
header `Release vM.C.V-M.S.V`, where `M.C.V` stands for the full Minecraft version, and `M.S.V` stands for the version
of Minestrappolation being released.

Examples:
```
Release v1.8.8-4.3.0
Release v1.8.9-4.3.1
Release v1.9.0-5.0.0
```

The release commit must always change the following files:

- `Changelog.md`: Adding all changes, collected from the commits since the last release.
- `version.txt`: Updating the Version Number for online Version Checking as well as the MOTD.
- `build.gradle`: Updating the Version Number.
- `src/main/java/minestrapteam/mods/minestrappolation/lib/MReference.java`: Updating the Version Number used by the Mod.

After these changes, one can run one of the following commands:

    gradle clean build     # When Gradle is installed on either OS
    gradlew clean build    # On Windows
    ./gradlew clean build  # On Mac OS X or *NIX operating systems

The command will generate three JAR files relevant for release in the `build/libs` folder.

- `Minestrappolation-M.C.V-M.S.V.jar` is used by Mod Users and belongs in the `.minecraft/mods` folder. It contains
all assets as well as obfuscated binaries.
- `Minestrappolation-M.C.V-M.S.V-src.jar` contains all assets and the sources for Mod and Addon Developers.
- `Minestrappolation-M.C.V-M.S.V-dev.jar` contains all assets and the de-obfuscated binaries for Mod and Addon Developers.



  [1]: https://github.com/MinestrapTeam/Minestrappolation-4/issues

