# IBS Architecture Document Version 1.0 

**Revision History**

| Date     | Version | Description                          | Author | 
|----------|---------|--------------------------------------|--------|
| 08-06-18 | 1.0     | Software Architecture Document Draft | T.M    |


**Table of Contents**

1. Introduction
    1. Purpose
    2. Scope
    3. Definitions, Acronyms, and Abbreviations
    4. References
2. Architectural Representation
3. Architectural Goals and Constraints
4. Use-Case View
    1. Architecturally-Significant Use Cases
5. Logical View
    1. Architecture Overview - Package and Subsystem Layering
6. Process View
    1. Processes
    2. Process to Design Elements
    3. Process Model to Design Model Dependencies
    4. Process Model to the Implementation
7. Deployment View
8. Size and Performance
9. Quality

## 1 Introduction

### 1.1 Purpose

This document provides a comprehensive architectural overview of the system, using a number of different architectural views to depict different aspects of the system. It is intended to capture and convey the significant architectural decisions which have been made on the system.

### 1.2 Scope

This Software Architecture Document provides an architectural overview of the Insurance Broker Software(IBS). 

### 1.3 Definitions

See [Glossary]()

### 1.4 References

Applicable References Are

## 2 Architectural Representation

This document presents the architecture as a series of views; use case view, logical view, process view and deployment view. 
There is no separate implementation view described in this document. These are views on an underlying Unified Modeling Language (UML) model developed using Rational Rose.

## 3 Architectural Goals and Constraints

There are some key requirements and system constraints that have a significant bearing on the architecture. They are: 

- Due to the wide array of tooling available for the JVM, the project will be built on the JVM.
- The Kotlin programming language provides object oriented and functional solutions on the JVM, so the primary language of IBS will be Kotlin.
- In order to protect client privacy, data security needs to be the primary security focus
- In order to boost performance for clients communicating outside the web-application, protocol buffers will be used

## 4 Use-Case View

A description of the use-case view of the software architecture. The use case view is important to the selection of 
the set of scenarios and/or use cases that are the focus of an iteration. It describes the set of scenarios and/or
use cases that represent some significant, central functionality. It also describes the set of scenarios and/or use cases 
that have a substantial architectural coverage or that stress or illustrate a specific, delicate point of the architecture.

## 4.1 Architecturally Significant Use Cases

See [UML Diagrams]()

## 5 Logical View

A description of the logical view of the architecture. Describes the most important classes, their organization in service
packages and subsystems, and the organization of these subsystems into layers. Also describes the most important use-case
realizations. Class diagrams may be included to illustrate the relationship between architecturally significant classes,
subsystems, packages, and layers.

### 5.1 Architecture Overview - Package and Subsystem Layering 

See [UML Diagrams]()

## 6 Process View

A description of the process view of the architecture. Describes the processes involved in the system's execution,
their interactions and configurations. Also describes the allocation of objects and classes to tasks.

See [UML Diagrams]()

## 7 Deployment View

A description of the deployment view architecture. Describes the various physical nodes for the most typical platform
configurations.

See [UML Diagrams]()

## 8 Size and Performance

We have not yet landed on a hosting service yet, however the sizing and performance specifications of the cloud hosting
service we employ will have an impact on both the sizing and performance as it relates to concurrent users.

## 9 Quality

The software architecture supports the quality requirements as stipulated in the proposal documentation. The following 
is a summary of some of the requirements for maintaining quality: 

1. Unit Tests - Unit tests are required for every code contribution containing significant units of code 
2. Integration Tests - Integration tests (including component tests) are required for all code contributions containing significant changes/additions to a component
3. End-User Tests - We will be working with real end-users as our QA team. The end users will provide feedback for the following
  1. UX/GX - how well the user experience is expressed through the front end 
  2. Usability - how difficult the software is to use, how intuitive is the design
  3. User Stories - do the features implement methods of expressing the user stories 
  4. Bugs - are there bugs that need to be fixed/addressed
