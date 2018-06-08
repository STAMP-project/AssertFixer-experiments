$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/functionaltests/resources/features/subscriptionCRUD.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: vasile.baluta@ericsson.com"
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
  "name": "Test Subscription CRUD",
  "description": "",
  "id": "test-subscription-crud",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 23,
  "name": "Create subscription with JSON object using REST API by POST method",
  "description": "",
  "id": "test-subscription-crud;create-subscription-with-json-object-using-rest-api-by-post-method",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "The REST API \"/subscriptions\" is up and running",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I make a POST request with valid \"JSON\" to the  subscription REST API \"/subscriptions\"",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I get response code of 200",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/subscriptions",
      "offset": 14
    }
  ],
  "location": "SubscriptionCRUDSteps.the_REST_API_is_up_and_running(String)"
});
formatter.result({
  "duration": 1831872437,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "JSON",
      "offset": 34
    },
    {
      "val": "/subscriptions",
      "offset": 71
    }
  ],
  "location": "SubscriptionCRUDSteps.i_make_a_POST_request_with_valid_to_the_subscription_REST_API(String,String)"
});
formatter.result({
  "duration": 467662760,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 23
    }
  ],
  "location": "SubscriptionCRUDSteps.i_get_response_code_of(int)"
});
formatter.result({
  "duration": 1463347,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 28,
      "value": "#@tag2"
    }
  ],
  "line": 29,
  "name": "Read subscription using REST API by GET method",
  "description": "",
  "id": "test-subscription-crud;read-subscription-using-rest-api-by-get-method",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "The REST API \"/subscriptions\" is up and running",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I make a GET request with subscription name \"Subscription_Test\" to the  subscription REST API \"/subscriptions/\"",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I get response code of 200 and subscription name \"Subscription_Test\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/subscriptions",
      "offset": 14
    }
  ],
  "location": "SubscriptionCRUDSteps.the_REST_API_is_up_and_running(String)"
});
formatter.result({
  "duration": 150050373,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Subscription_Test",
      "offset": 45
    },
    {
      "val": "/subscriptions/",
      "offset": 95
    }
  ],
  "location": "SubscriptionCRUDSteps.i_make_a_GET_request_with_subscription_name_to_the_subscription_REST_API(String,String)"
});
formatter.result({
  "duration": 58826354,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 23
    },
    {
      "val": "Subscription_Test",
      "offset": 50
    }
  ],
  "location": "SubscriptionCRUDSteps.i_get_response_code_of_and_subscription_name(int,String)"
});
formatter.result({
  "duration": 36536343,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 34,
      "value": "#@tag3"
    }
  ],
  "line": 35,
  "name": "Update subscription using REST API by PUT method and validate updation",
  "description": "",
  "id": "test-subscription-crud;update-subscription-using-rest-api-by-put-method-and-validate-updation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "The REST API \"/subscriptions\" is up and running",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "I make a PUT request with modified notificationType as \"MAIL\" to REST API \"/subscriptions\"",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "I get response code of 200 for successful updation",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "I can validate modified notificationType \"MAIL\" with GET request at \"/subscriptions/Subscription_Test\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "/subscriptions",
      "offset": 14
    }
  ],
  "location": "SubscriptionCRUDSteps.the_REST_API_is_up_and_running(String)"
});
formatter.result({
  "duration": 54523405,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MAIL",
      "offset": 56
    },
    {
      "val": "/subscriptions",
      "offset": 75
    }
  ],
  "location": "SubscriptionCRUDSteps.i_make_a_PUT_request_with_modified_notificationType_as_to_REST_API(String,String)"
});
formatter.result({
  "duration": 780221384,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 23
    }
  ],
  "location": "SubscriptionCRUDSteps.i_get_response_code_of_for_successful_updation(int)"
});
formatter.result({
  "duration": 152532,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MAIL",
      "offset": 42
    },
    {
      "val": "/subscriptions/Subscription_Test",
      "offset": 69
    }
  ],
  "location": "SubscriptionCRUDSteps.i_can_validate_modified_notificationType_with_GET_request_at(String,String)"
});
formatter.result({
  "duration": 63221830,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 41,
      "value": "#@tag4"
    }
  ],
  "line": 42,
  "name": "Delete subscription using REST API by DELETE method and validate deletion",
  "description": "",
  "id": "test-subscription-crud;delete-subscription-using-rest-api-by-delete-method-and-validate-deletion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 43,
  "name": "The REST API \"/subscriptions\" is up and running",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "I make a DELETE request with subscription name \"Subscription_Test\" to the  subscription REST API \"/subscriptions/\"",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "I get response code of 200 for successful delete",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "My GET request with subscription name \"Subscription_Test\" at REST API \"/subscriptions/\" returns empty String \"[]\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "/subscriptions",
      "offset": 14
    }
  ],
  "location": "SubscriptionCRUDSteps.the_REST_API_is_up_and_running(String)"
});
formatter.result({
  "duration": 49468057,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Subscription_Test",
      "offset": 48
    },
    {
      "val": "/subscriptions/",
      "offset": 98
    }
  ],
  "location": "SubscriptionCRUDSteps.i_make_a_DELETE_request_with_subscription_name_to_the_subscription_REST_API(String,String)"
});
formatter.result({
  "duration": 42262316,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 23
    }
  ],
  "location": "SubscriptionCRUDSteps.i_get_response_code_of_for_successful_delete(int)"
});
formatter.result({
  "duration": 3304539,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Subscription_Test",
      "offset": 39
    },
    {
      "val": "/subscriptions/",
      "offset": 71
    },
    {
      "val": "[]",
      "offset": 110
    }
  ],
  "location": "SubscriptionCRUDSteps.my_GET_request_with_subscription_name_at_REST_API_returns_empty_String(String,String,String)"
});
formatter.result({
  "duration": 49090618,
  "status": "passed"
});
});