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


# Release

**To be written...**

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
