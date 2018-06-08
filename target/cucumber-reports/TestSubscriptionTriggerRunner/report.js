$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/functionaltests/resources/features/subscriptionTrigger.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Subscription trigger test",
  "description": "",
  "id": "subscription-trigger-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 21,
      "value": "#  I want to use this template for my feature file"
    }
  ],
  "line": 24,
  "name": "Test subscription triggering",
  "description": "",
  "id": "subscription-trigger-test;test-subscription-triggering",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Subscription rest trigger is created",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Subscription mail trigger is created",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Subscription rest authenticated trigger is created",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I send events",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Subscriptions were triggered",
  "keyword": "Then "
});
formatter.match({
  "location": "SubscriptionTriggerSteps.subscription_rest_trigger_is_created()"
});
formatter.result({
  "duration": 988426480,
  "status": "passed"
});
formatter.match({
  "location": "SubscriptionTriggerSteps.subscription_mail_trigger_is_created()"
});
formatter.result({
  "duration": 79402,
  "status": "passed"
});
formatter.match({
  "location": "SubscriptionTriggerSteps.subscription_rest_authenticated_trigger_is_created()"
});
formatter.result({
  "duration": 80024,
  "status": "passed"
});
formatter.match({
  "location": "SubscriptionTriggerSteps.send_events()"
});
formatter.result({
  "duration": 46934,
  "status": "passed"
});
formatter.match({
  "location": "SubscriptionTriggerSteps.check_subscriptions_were_triggered()"
});
formatter.result({
  "duration": 63197,
  "status": "passed"
});
});