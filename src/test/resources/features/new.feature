@Regression @smoke
Feature:
  User Story: As a user, I should be able to add link, insert video, mention, quote, add tag in message.

  Background:
    Given the user is on the main page of Activity Stream.

   @WIP2
  Scenario: The user adds mentions into the message
    When the user types into MESSAGE text inputbox
    And the user adds mentions into the message
    And the user clicks SEND button
    Then the user see the message with mentions on Activity Stream

  @WIP
  Scenario: The user can add mentions about only department employees
    When the user types into MESSAGE text inputbox
    And the user clicks Add mention button
    Then the user can add mentions about only department employees.


  Scenario: The user attaches a link to the specified text in message
    When the user types into MESSAGE text inputbox
    And the user attach the link to the text
    And the user clicks SEND button
    Then the user see the message with linked text on Activity Stream


  Scenario: The user adds Quotes into the message
    When the user types into MESSAGE text inputbox
    And the user adds Quote text into the message
    And the user clicks SEND button
    Then the user see the message with Quote text on Activity Stream


  Scenario: The user adds tags into the message
    When the user types into MESSAGE text inputbox
    And the user adds tags into the message
    And the user clicks SEND button
    Then the user see the message with tags on Activity Stream


  Scenario: The user cancels links before sending the message
    When the user types into MESSAGE text inputbox
    And the user attach the link to the text
    And the user cancels link before sending the message
    And the user clicks SEND button
    Then the user see the message without linked text on Activity Stream






#  Scenario: The user inserts Vimeo video into the message
#    When the user types into MESSAGE text inputbox
#    And the user inserts Vimeo video into the message
#    And the user clicks SEND button
#    Then the user see the message with Vimeo video on Activity Stream


#  Scenario Template: User should be able to place order and order seen in web table
#    Given user is already logged in and on order page using "<username>" and "<password>"
#    Examples:
#      | username                      | password |
#      | helpdesk1@cybertekschool.com  | UserUser |
#      | helpdesk2@cybertekschool.com  | UserUser |
#      | marketing1@cybertekschool.com | UserUser |
#      | marketing2@cybertekschool.com | UserUser |
#      | hr1@cybertekschool.com        | UserUser |
#      | hr2@cybertekschool.com        | UserUser |





