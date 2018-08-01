[![Build Status](https://travis-ci.org/jasongreely/alexa-sous-chef.svg?branch=master)](https://travis-ci.org/jasongreely/alexa-sous-chef)

# Alexa, cook with me!

## Overview

Sous Chef is an Alexa skill that can search, retrieve, and recite recipes from free online data sources.

You can search by 'category' of food you'd like to cook, as well as specify certain primary ingredients you'd like to 
utilize.

Alexa will then read you the ingredients, confirm your intent to cook, and begin assistance with reading and timing the 
recipe.

### Features
* Robust search service offering several content sources, and category/ingredient specific filters
* Recite ingredient list to ensure you have everything you need
    * Swap ingredients - ask Alexa for substitutions
* Step by step recipe dictation
* Multi-tasking: auto-set timers and alerts when steps have been completed
## Sample Utterances
### Wake
`Alexa, cook with me!`
### Find a recipe
`Alexa, find me vegan recipes using tofu and spinach.`

`Alexa, look for italian recipes using chicken.`
### Substitute ingredients
`Alexa, what's a good substitute for green onions?`

`Alexa, what can I use instead of coriander?`
### Cook!
`Alexa, let's cook the first recipe.`

`Alexa, let's cook the tofu masala`
## Build
`mvn assembly:assembly -DdescriptorId=jar-with-dependencies package`

