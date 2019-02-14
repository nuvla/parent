# Parent POM File for Nuvla Maven Builds

This provides a parent POM file for all of the Nuvla maven builds.
All Nuvla maven project must reference (directly or indirectly) a
consistent, release version of this POM file.  For example,

```xml
<parent>
  <groupId>sixsq.nuvla.parent</groupId>
  <artifactId>pom</artifactId>
  <version>0.0.1</version>
</parent>
```

Normally, this reference appears in the top `pom.xml` file in a
repository.

## Prerequisites

Ensure that the version number in the POM file is updated according to
the semantic versioning rules, taking into account changes since the
last release.

Before releasing a new version of the parent pom file, consider
upgrading all the plugins to the latest versions:

```sh
mvn versions:display-plugin-updates
```

If necessary, upgrade any plugins (or the minimum maven version) and
test that the builds work correctly.

Push any changes you make to the master branch of the repository.

## Release

After pushing all changes, verify that the release will (likely) work:

```sh
mvn release:prepare -DdryRun=true
```

It will interactively ask for version and tags information.  The
defaults are usually correct.

If the above command fails, correct any problems that have been
identified.  If it succeeded, then clean up the generated files:

```sh
mvn release:clean
```

You can then do the real release:

```sh
mvn release:prepare
```

You can add the option `--batch-mode` if the default responses to the
questions were correct. This will push changes and tags into the
GitHub repository.

Finally, do:

```sh
mvn release:perform
```

to finalize the release. This builds the release artifacts and uploads
them to the Nexus repository.

## Copyright

Copyright &copy; 2019, SixSq Sàrl

## License

Licensed under the Apache License, Version 2.0 (the "License"); you
may not use this file except in compliance with the License.  You may
obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied.  See the License for the specific language governing
permissions and limitations under the License.
