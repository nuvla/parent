# Parent Project for Nuvla Clojure(Script) Modules

A parent `project.clj` file to centrally manage repositories and
dependencies for Nuvla Clojure(Script) modules.

## Setup

To build and release this `project.clj` file to
[clojars](https://clojars.org), you must setup your environment
correctly.

First, set the username and password of your clojars account as
environmental variables:

    export CLOJARS_USERNAME=username
    export CLOJARS_PASSWORD=password

These will be used when pushing the artifacts to clojars.  For the
SixSq release account, the username and password are in 1Password.

Non-snapshot releases of artifacts also must be signed with a GPG key
when uploading to clojars.  You must install GPG and then import the
SixSq Release GPG keys.  The public key, private key, and password are
all in 1Password.

For GPG, set the environmental variable:

    export GPG_TTY=$(tty)

This should then allow GPG to prompt for the password for the private
key. If you run into an error like the following:

    gpg: signing failed: Inappropriate ioctl for device

The problem is with the TTY that GPG is trying to use and usually
means that the above environmental variable is not set.

# Release

**Be sure that you've done all of the setup in the previous section!**

To release this to clojars, just run the command:

    lein release :patch

This will bump the patch version of the artifact.

In general, use the following guidelines when choosing how to change
the version:

 - :patch for changes that are strictly backwards-compatible,
   e.g. adding new dependencies
 - :minor for changes that change the versions of existing
   dependencies or delete dependencies
 - :major for major changes such as changing repository definitions

After releasing a new version on clojars, you should update all of the
parent references in the child `project.clj` files. 

# Troubleshooting

Sadly, something's gone wrong.

You'll need to clean up your local repository and potentially the
GitHub repository as well.  Be sure to:

 * Reset your history to remove any changes that Leiningen made in the
   release process.
 * Manually delete the tag that was created.

If any changes were pushed to GitHub, then you'll need to do the same
for the remote repository.

Before trying again, verify that you've performed all the setup. 

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
