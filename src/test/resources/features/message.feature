@Regression @smoke
Feature:
  User Story: As a user, I should be able to add link, insert video, mention, quote, add tag in message.


  Scenario Outline: The user adds mentions into the message
    Given the user is on the main page of Activity Stream as a "<userType>"
    When the user types into MESSAGE text inputbox
    And the user adds mentions into the message
    And the user clicks SEND button
    Then the user see the message with mentions on Activity Stream
    Examples:
      | userType       |
      | Marketing      |
      | Helpdesk       |
      | Human Resource |


  Scenario Outline: The user can add mentions about only department employees
    Given the user is on the main page of Activity Stream as a "<userType>"
    When the user types into MESSAGE text inputbox
    And the user clicks Add mention button
    Then the user can add mentions about only department employees
    Examples:
      | userType       |
      | Marketing      |
      | Helpdesk       |
      | Human Resource |


  Scenario Outline:  The user attaches a link to the specified text in message
    Given the user is on the main page of Activity Stream as a "<userType>"
    When the user types into MESSAGE text inputbox
    And the user attach the link to the text
    And the user clicks SEND button
    Then the user see the message with linked text on Activity Stream
    Examples:
      | userType       |
      | Marketing      |
      | Helpdesk       |
      | Human Resource |


  Scenario Outline: The user adds Quotes into the message
    Given the user is on the main page of Activity Stream as a "<userType>"
    When the user types into MESSAGE text inputbox
    And the user adds Quote text into the message
    And the user clicks SEND button
    Then the user see the message with Quote text on Activity Stream
    Examples:
      | userType       |
      | Marketing      |
      | Helpdesk       |
      | Human Resource |


  Scenario Outline: The user adds tags into the message
    Given the user is on the main page of Activity Stream as a "<userType>"
    When the user types into MESSAGE text inputbox
    And the user adds tags into the message
    And the user clicks SEND button
    Then the user see the message with tags on Activity Stream
    Examples:
      | userType       |
      | Marketing      |
      | Helpdesk       |
      | Human Resource |

  @WIP
  Scenario Outline: The user cancels links before sending the message
    Given the user is on the main page of Activity Stream as a "<userType>"
    When the user types into MESSAGE text inputbox
    And the user attach the link to the text
    And the user cancels link before sending the message
    And the user clicks SEND button
    Then the user see the message without linked text on Activity Stream
    Examples:
      | userType       |
      | Marketing      |
      | Helpdesk       |
      | Human Resource |






