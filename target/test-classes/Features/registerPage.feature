Feature: User Registration Process

  Scenario Outline: User registered successfully
    Given User is on the home page
    When User enters credentials "<username>" and "<password>"
    And User enters personal details "<firstname>", "<lastname>", "<email>", "<phone>", "<address1>", "<address2>", "<city>", "<state>", "<pincode>", and "<country>"
    And User enters profile details "<language>", "<pet>", "<list>", and "<banner>"
    Then User is registered successfully
    
  Examples:
      | username | password | firstname | lastname | email | phone | address1 | address2 | city | state | pincode | country | language | pet | list | banner |  
      | user123 | Pass@123 | John | Doe | john.doe@mail.com | 9876543210 | 123 Main St | Apt 4B | New York | NY | 10001.0 | USA | english | FISH | true | true |  
      | aliceW | Alice@99 | Alice | Walker | alice.walker@mail.com | 9234567890 | 456 Elm St | Suite 12 | Chicago | IL | 60601.0 | USA | japanese | DOGS | true | false |  
      | bobM1995 | Bob@2023 | Bob | Marley | bob.marley@mail.com | 9012345678 | 789 Pine Rd | Unit 8A | Houston | TX | 77005.0 | USA | english | REPTILES | false | true |  
      | emma_T | Emma@789 | Emma | Thompson | emma.t@mail.com | 8109876543 | 321 Oak Ave | Floor 3 | Miami | FL | 33101.0 | USA | japanese | CATS | true | true |  
      | rajVerma | Raj@2024 | Raj | Verma | raj.verma@mail.com | 7896541230 | 555 Lotus St | Block C | Mumbai | MH | 400001.0 | India | english | BIRDS | true | false |  
