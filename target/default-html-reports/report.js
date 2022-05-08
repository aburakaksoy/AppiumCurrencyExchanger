$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CurrencyConversion.feature");
formatter.feature({
  "name": "Convert the currency",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The User Converts Euro to CAD",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the User enters \"100\" as amount",
  "keyword": "Given "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.theUserEntersAsAmount(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user picks the \"EUR\" currency as selling type",
  "keyword": "And "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.theUserPicksTheCurrencyAsSellingType(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the User picks the \"CAD\" currency as receiving type",
  "keyword": "And "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.theUserPicksTheCurrencyAsReceivingType(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the User clicks Submit Button",
  "keyword": "When "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.the_User_clicks_Submit_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the User Clicks ok when an alert seen",
  "keyword": "And "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.theUserClicksOkWhenAnAlertSeen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"EUR\" balance reduced to \"900.00\"",
  "keyword": "And "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.theBalanceReducedTo(java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: Verify the balance!! expected:\u003c[900.0]0 EUR\u003e but was:\u003c[899.3]0 EUR\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat paysera.step_definitions.CurrencyExcDefs.theBalanceReducedTo(CurrencyExcDefs.java:163)\r\n\tat ✽.the \"EUR\" balance reduced to \"900.00\"(file:///C:/Users/Abdullah/Downloads/_d98c8a8f40b2003f1ac87e71d3e984f9_IntroToUnitTesting%20(2)/CurrencyExchanger/src/test/resources/features/CurrencyConversion.feature:40)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the \"CAD\" balance should be \"136.19\"",
  "keyword": "Then "
});
formatter.match({
  "location": "paysera.step_definitions.CurrencyExcDefs.theBalanceShouldBe(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});