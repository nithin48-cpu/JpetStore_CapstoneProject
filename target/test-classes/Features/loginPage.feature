Feature: Login Feature
  Scenario Outline: User Login 
    Given The user is on the home page
    When User enter the login credentials "<username>" and "<password>"
    Then Validate user login successfully
    Examples: 
      | username | password |  
      | j2ee | j2ee |  
      | raja | 1234567890 |  
      | raj | 1234567890 |  
