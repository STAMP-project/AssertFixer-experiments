# IBS Application 

## Setup

It is recommended that you use JetBrains IntelliJ IDEA as your integrated development environment for contributing to this project.
All the documentation for setup and onboarding is written under the assumption that you are using IntelliJ IDEA. While 
you are free to contribute using whatever tooling you desire it is important to note two things: 

1. Any tooling you use for local development must be invisible and have no footprint in the code base
    1. This includes IDE generated files such as `.project` or `.idea` files/directories etc. Please add any such files to the `.gitignore` before submitting a pull request.
2. All support documentation is written exclusively for IntelliJ IDEA, so choosing to use a different IDE may reduce your support options.
    

## Definition of Done

1. Code Compiles
2. Unit Tests for Feature Units
3. Signoff from two other developers

### Starting A Tomcat Server in IntelliJ

1. Pull project from github in the IDE (file -> new project from Version Control -> git)
2. On the top right next to the run button (looks like a play button) click the empty box (fairly certain that's what it will look like) and it will open up a dropdown that has the option to edit your run configurations
3. After clicking the edit button, click the add button (+ sign) at the top left of the new window
4. Select "...more items..." at the bottom of the new dropdown. scroll down until you find Tomcat Server -> Local and select that
5. Name this run config anything for now. Select the Configure... button, then set your Tomcat base directory to usr/local/Cellar/tomcat/9.0.10/libexec/
6. Hit apply
7. Hit run and the Tomcat server should launch and a new browser should open up
8. In the new browser, add /monitor/health (should look something like localhost:8080/monitor/health). if it's a blank page, then everything is set up correctly

## Modules

- internal
  - aws
  - core
  - experimental
  - testing

## Style Guide

Styles Coming Soon...

###### Copyright 2018, North Vine Engineering